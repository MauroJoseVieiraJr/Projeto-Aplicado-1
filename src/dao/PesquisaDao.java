package dao;

import java.util.ArrayList;
import java.util.List;

import interfaces.Crud;
import model.Pesquisa;

public class PesquisaDao implements Crud<Pesquisa> {

	private static PesquisaDao instance;
	private List<Pesquisa> pesquisaList = new ArrayList<>();
	
	public static PesquisaDao getInstance() {
		if (instance == null)
			instance = new PesquisaDao();
		return instance;
	}
	
	@Override
	public void Create(Pesquisa t) throws Exception {
		pesquisaList.add(t);
	}

	@Override
	public List<Pesquisa> Read() {
		return pesquisaList;
	}

	@Override
	public void Update(Pesquisa t) throws Exception {
		pesquisaList.set(t.getId(), t);
	}

	@Override
	public void Delete(Pesquisa t) throws Exception {
		pesquisaList.remove(t.getId());
	}

}
