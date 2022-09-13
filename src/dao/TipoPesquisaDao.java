package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import interfaces.Crud;
import model.TipoPesquisa;
import util.ConnectionUtil;

public class TipoPesquisaDao implements Crud<TipoPesquisa> {
	
	private static TipoPesquisaDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static TipoPesquisaDao getInstance() {
		if (instance == null)
			instance = new TipoPesquisaDao();
		return instance;
	}

	@Override
	public void Create(TipoPesquisa t) throws SQLException {
		String descricao = t.getDescricao();
		
		String values = "values ('" + descricao + "')";
		String sql = "insert into tipopesquisa (descricao) " + values;
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();
	}

	@Override
	public List<TipoPesquisa> Read() throws SQLException {
		List<TipoPesquisa> list = new ArrayList<>();
		
		String sql = "select * from tipopesquisa";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String descricao = rs.getString("descricao");
			
			TipoPesquisa tp = new TipoPesquisa(id, descricao);
			list.add(tp);
		}
		
		Collections.sort(list, (a, b) -> a.getId() < b.getId() ? -1 : 1);
		
		return list;
	}

	@Override
	public void Update(TipoPesquisa t) throws SQLException {
		int id = t.getId();
		String descricao = t.getDescricao();
		
		String values = "descricao = '" + descricao + "'";
		String where = " where id = " + id;
		String sql = "update tipopesquisa set " + values + where;
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.executeUpdate();
	}

	@Override
	public void Delete(int id) throws SQLException {
		String where = "where id = " + id;
		String sql = "delete from tipopesquisa " + where;
				
		PreparedStatement ps = con.prepareStatement(sql);
		ps.executeUpdate();
	}
	
	public TipoPesquisa Find(int id) throws Exception {
		TipoPesquisa tp = new TipoPesquisa(0, null);
		
		String where = " where id = " + id;
		String sql = "select * from tipopesquisa" + where;
		
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		if(rs.next()) {
			int i = rs.getInt("id");
			String desc = rs.getString("descricao");
			
			tp = new TipoPesquisa(i, desc);
			return tp;
		} else {
			return null;
		}
	}
}
