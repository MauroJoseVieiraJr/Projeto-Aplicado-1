package controller;

import java.sql.SQLException;
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
	}

	@Override
	public List<TipoPesquisa> Read() throws SQLException {
		return TipoPesquisaDao.getInstance().Read();
	}

	@Override
	public void Update(TipoPesquisa t) throws Exception {
		if (t.getDescricao().length() < 1 || t.getDescricao().length() > 50)
			throw new Exception(ErrorMessages.DESCRIPTION_ERROR);
		
		TipoPesquisaDao.getInstance().Update(t);
	}

	@Override
	public void Delete(int id) throws Exception {
		TipoPesquisaDao.getInstance().Delete(id);
	}
	
	public TipoPesquisa Find(int id) throws Exception {
		return TipoPesquisaDao.getInstance().Find(id);
	}
}
