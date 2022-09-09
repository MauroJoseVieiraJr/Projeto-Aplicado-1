package controller;

import java.util.List;

import dao.CandidatoXPesquisaDao;
import interfaces.Crud;
import model.CandidatoXPesquisa;

public class CandidatoXPesquisaController implements Crud<CandidatoXPesquisa> {

	@Override
	public void Create(CandidatoXPesquisa t) throws Exception {
		if (t.getId() < 0)
			throw new Exception(ErrorMessages.ID_ERROR);
		
		if (t.getVotos() < 0)
			throw new Exception(ErrorMessages.VOTE_ERROR);
		
		CandidatoXPesquisaDao.getInstance().Create(t);
		System.out.println("Candidato X Pesquisa " + t.getId() + " criado com sucesso.");
	}

	@Override
	public List<CandidatoXPesquisa> Read() throws Exception {
		return CandidatoXPesquisaDao.getInstance().Read();
	}

	@Override
	public void Update(CandidatoXPesquisa t) throws Exception {
		if (t.getVotos() < 0)
			throw new Exception(ErrorMessages.VOTE_ERROR);
		
		CandidatoXPesquisaDao.getInstance().Update(t);
		System.out.println("Candidato X Pesquisa " + t.getId() + " atualizado.");
	}

	@Override
	public void Delete(int id) throws Exception {
		CandidatoXPesquisaDao.getInstance().Delete(id);
	}

}
