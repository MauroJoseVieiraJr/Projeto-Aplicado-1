package dao;

import java.util.ArrayList;
import java.util.List;

import interfaces.Crud;
import model.TipoPesquisa;

public class TipoPesquisaDao implements Crud<TipoPesquisa> {
	
	private static TipoPesquisaDao instance;
	private List<TipoPesquisa> tipoPesquisaList = new ArrayList<>();
	
	public static TipoPesquisaDao getInstance() {
		if (instance == null)
			instance = new TipoPesquisaDao();
		return instance;
	}

	@Override
	public void Create(TipoPesquisa t) throws Exception {
		tipoPesquisaList.add(t);
	}

	@Override
	public List<TipoPesquisa> Read() {
		return tipoPesquisaList;
	}

	@Override
	public void Update(TipoPesquisa t) throws Exception {
		tipoPesquisaList.set(t.getId(), t);
	}

	@Override
	public void Delete(TipoPesquisa t) throws Exception {
		tipoPesquisaList.remove(t.getId());
	}

}
