package controller;

import java.util.List;

import dao.TipoPesquisaDao;
import interfaces.Crud;
import model.TipoPesquisa;

public class TipoPesquisaController implements Crud<TipoPesquisa> {

	@Override
	public void Create(TipoPesquisa t) throws Exception {
		if (t.getId() < 0)
			throw new Exception(ErrorMessages.ID_ERROR);
		
		if (t.getDescricao().length() < 1 || t.getDescricao().length() > 50)
			throw new Exception(ErrorMessages.DESCRIPTION_ERROR);
		
		TipoPesquisaDao.getInstance().Create(t);
		System.out.println("Tipo de Pesquisa " + t.getId() + " criada com sucesso.");
	}

	@Override
	public List<TipoPesquisa> Read() {
		return TipoPesquisaDao.getInstance().Read();
	}

	@Override
	public void Update(TipoPesquisa t) throws Exception {
		TipoPesquisaDao.getInstance().Update(t);
	}

	@Override
	public void Delete(TipoPesquisa t) throws Exception {
		TipoPesquisaDao.getInstance().Delete(t);
	}
}
