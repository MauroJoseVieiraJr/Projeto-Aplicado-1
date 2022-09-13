package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import interfaces.Crud;
import model.Candidato;
import util.ConnectionUtil;

public class CandidatoDao implements Crud<Candidato> {

	private static CandidatoDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static CandidatoDao getInstance() {
		if (instance == null)
			instance = new CandidatoDao();
		return instance;
	}
	
	@Override
	public void Create(Candidato t) throws SQLException {
		String nome = t.getNome();
		String partido = t.getPartido();
		boolean fichaLimpa = t.isFichaLimpa();
		
		String values = "values ('" + nome + "', '" + partido + "', " + fichaLimpa + ")";
		String sql = "insert into candidato (nome, partido, ficha_limpa) " + values;
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();
	}

	@Override
	public List<Candidato> Read() throws SQLException {
		List<Candidato> list = new ArrayList<>();
		
		String sql = "select * from candidato";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String partido = rs.getString("partido");
			boolean fichaLimpa = rs.getBoolean("ficha_limpa");
			
			Candidato c = new Candidato(id, nome, partido, fichaLimpa);
			list.add(c);
		}
		
		Collections.sort(list, (a, b) -> a.getId() < b.getId() ? -1 : 1);
		
		return list;
	}

	@Override
	public void Update(Candidato t) throws SQLException {
		int id = t.getId();
		String nome = t.getNome();
		String partido = t.getPartido();
		boolean fichaLimpa = t.isFichaLimpa();
		
		String values = "nome = '" + nome + "', partido = '" + partido + "', ficha_limpa = " + fichaLimpa;
		String where = " where id = " + id;
		String sql = "update candidato set " + values + where;
		
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
	
	public Candidato Find(int id) throws Exception {
		Candidato c = new Candidato(0, null, null, false);
		
		String where = " where id = " + id;
		String sql = "select * from candidato" + where;
		
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		if(rs.next()) {
			int i = rs.getInt("id");
			String nome = rs.getString("nome");
			String partido = rs.getString("partido");
			boolean fichaLimpa = rs.getBoolean("ficha_limpa");
			
			c = new Candidato(i, nome, partido, fichaLimpa);
			return c;
		} else {
			return null;
		}
	}
}
