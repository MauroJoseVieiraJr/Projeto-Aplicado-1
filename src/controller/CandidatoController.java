package controller;

import java.sql.SQLException;
import java.util.List;

import dao.CandidatoDao;
import interfaces.Crud;
import model.Candidato;

public class CandidatoController implements Crud<Candidato> {

	@Override
	public void Create(Candidato t) throws Exception {
		if (t.getId() < 0)
			throw new Exception(ErrorMessages.ID_ERROR);
		
		if (t.getNome().length() < 1 || t.getNome().length() > 50)
			throw new Exception(ErrorMessages.NAME_ERROR);
		
		if (t.getPartido().length() < 1 || t.getPartido().length() > 50)
			throw new Exception(ErrorMessages.PARTY_ERROR);
		
		CandidatoDao.getInstance().Create(t);
	}

	@Override
	public List<Candidato> Read() throws SQLException {
		return CandidatoDao.getInstance().Read();
	}

	@Override
	public void Update(Candidato t) throws Exception {
		if (t.getNome().length() < 1 || t.getNome().length() > 50)
			throw new Exception(ErrorMessages.NAME_ERROR);
		
		if (t.getPartido().length() < 1 || t.getPartido().length() > 50)
			throw new Exception(ErrorMessages.PARTY_ERROR);
		
		CandidatoDao.getInstance().Update(t);
	}

	@Override
	public void Delete(int id) throws Exception {
		CandidatoDao.getInstance().Delete(id);
	}
	
	public Candidato Find(int id) throws Exception {
		return CandidatoDao.getInstance().Find(id);
	}
}
