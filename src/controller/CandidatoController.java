package controller;

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
		System.out.println("Candidato " + t.getId() + ", " + t.getNome() + " criado com sucesso.");
	}

	@Override
	public List<Candidato> Read() {
		return CandidatoDao.getInstance().Read();
	}

	@Override
	public void Update(Candidato t) throws Exception {
		CandidatoDao.getInstance().Update(t);
	}

	@Override
	public void Delete(Candidato t) throws Exception {
		CandidatoDao.getInstance().Delete(t);
	}

}
