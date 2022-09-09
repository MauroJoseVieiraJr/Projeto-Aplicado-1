package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import interfaces.Crud;
import model.Pesquisa;
import model.TipoPesquisa;
import util.ConnectionUtil;

public class PesquisaDao implements Crud<Pesquisa> {

	private static PesquisaDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static PesquisaDao getInstance() {
		if (instance == null)
			instance = new PesquisaDao();
		return instance;
	}
	
	@Override
	public void Create(Pesquisa t) throws SQLException {
		String instituto = t.getInstituto();
		String data = t.getData();
		String local = t.getLocal();
		int media = t.getMediaIdade();
		int tipo = t.getTipo().getId();
		String formato = t.getFormato();
		
		String parameters = "(instituto, data_pesquisa, local_pesquisa, media_idade, tipo, formato) ";
		String values = "values ('" + instituto + "', '" + data + "', '" + local + "', " + media + ", " + tipo + ", '" + formato + "')";
		String sql = "insert into pesquisa " + parameters + values;
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();
	}

	@Override
	public List<Pesquisa> Read() throws SQLException {
		List<Pesquisa> list = new ArrayList<>();
		
		String sql = "select * from pesquisa";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String instituto = rs.getString("instituto");
			String data = rs.getDate("data_pesquisa").toString();
			String local = rs.getString("local_pesquisa");
			int media = rs.getInt("media_idade");
			int tipo = rs.getInt("tipo");
			String formato = rs.getString("formato");
			
			TipoPesquisa tp = TipoPesquisaDao.getInstance().Read().get(tipo);
						
			Pesquisa p = new Pesquisa(id, instituto, data, local, media, tp, formato);
			list.add(p);
		}
		
		return list;
	}

	@Override
	public void Update(Pesquisa t) throws SQLException {
		int id = t.getId();
		String instituto = t.getInstituto();
		String data = t.getData();
		String local = t.getLocal();
		int media = t.getMediaIdade();
		int tipo = t.getTipo().getId();
		String formato = t.getFormato();
		
		String values = "instituto = '" + instituto + "', data_pesquisa = '" + data + "', local_pesquisa = '" + local + 
						"', media_idade = " + media + ", tipo = " + tipo + ", formato = '" + formato + "'";
		String where = " where id = " + id;
		String sql = "update pesquisa set " + values + where;
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.executeUpdate();
	}

	@Override
	public void Delete(int id) throws SQLException {
		String where = "where id = " + id;
		String sql = "delete from candidato " + where;
				
		PreparedStatement ps = con.prepareStatement(sql);
		ps.executeUpdate();
	}
	
	public Pesquisa Find(int id) throws Exception {
		Pesquisa p = new Pesquisa(0, null, null, null, 0, null, null);
		
		String where = " where id = " + id;
		String sql = "select * from pesquisa" + where;
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		if(rs.next()) {
			int i = rs.getInt("id");
			String instituto = rs.getString("instituto");
			String data = rs.getDate("data_pesquisa").toString();
			String local = rs.getString("local_pesquisa");
			int media = rs.getInt("media_idade");
			int tipo = rs.getInt("tipo");
			String formato = rs.getString("formato");
			
			TipoPesquisa tp = TipoPesquisaDao.getInstance().Read().get(tipo);
						
			p = new Pesquisa(i, instituto, data, local, media, tp, formato);
			return p;
		} else {
			return null;
		}
	}
}
