package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import interfaces.Crud;
import model.Candidato;
import model.CandidatoXPesquisa;
import model.Pesquisa;
import util.ConnectionUtil;

public class CandidatoXPesquisaDao implements Crud<CandidatoXPesquisa> {

	private static CandidatoXPesquisaDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static CandidatoXPesquisaDao getInstance() {
		if (instance == null)
			instance = new CandidatoXPesquisaDao();
		return instance;
	}
	
	@Override
	public void Create(CandidatoXPesquisa t) throws SQLException {
		int candidato = t.getCandidato().getId();
		int pesquisa = t.getPesquisa().getId();
		int votos = t.getVotos();
		
		String values = "values ('" + candidato + "', '" + pesquisa + "', " + votos + ")";
		String sql = "insert into candidato_x_pesquisa (candidato, pesquisa, votos) " + values;
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();
	}

	@Override
	public List<CandidatoXPesquisa> Read() throws Exception {
		List<CandidatoXPesquisa> list = new ArrayList<>();
		
		CandidatoDao cd = new CandidatoDao();
		PesquisaDao pd = new PesquisaDao();
		
		String sql = "select * from candidato_x_pesquisa";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		// O while não está otimizado, pode demorar uma eternidade para executar
		while(rs.next()) {
			int id = rs.getInt("id");
			Candidato candidato = cd.Find(rs.getInt("candidato")); // Gambi
			Pesquisa pesquisa = pd.Find(rs.getInt("pesquisa")); // Arra
			int votos = (int) rs.getFloat("votos"); // Erro meu, a bagaça tá em float no banco de dados
			
			CandidatoXPesquisa c = new CandidatoXPesquisa(id, candidato, pesquisa, votos);
			list.add(c);
		}
		
		return list;
	}

	@Override
	public void Update(CandidatoXPesquisa t) throws SQLException {
		int id = t.getId();
		int candidato = t.getCandidato().getId();
		int pesquisa = t.getPesquisa().getId();
		int votos = t.getVotos();
		
		String values = "candidato = '" + candidato + "', pesquisa = '" + pesquisa + "', votos = " + votos;
		String where = " where id = " + id;
		String sql = "update candidato_x_pesquisa set " + values + where;
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.executeUpdate();
	}

	@Override
	public void Delete(int id) throws SQLException {
		String where = "where id = " + id;
		String sql = "delete from candidato_x_pesquisa " + where;
				
		PreparedStatement ps = con.prepareStatement(sql);
		ps.executeUpdate();
	}
}
