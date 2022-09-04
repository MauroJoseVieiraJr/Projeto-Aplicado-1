package dao;

import java.util.ArrayList;
import java.util.List;

import interfaces.Crud;
import model.CandidatoXPesquisa;

public class CandidatoXPesquisaDao implements Crud<CandidatoXPesquisa> {

	private static CandidatoXPesquisaDao instance;
	private List<CandidatoXPesquisa> candidatoXPesquisaList = new ArrayList<>();
	
	public static CandidatoXPesquisaDao getInstance() {
		if (instance == null)
			instance = new CandidatoXPesquisaDao();
		return instance;
	}
	
	@Override
	public void Create(CandidatoXPesquisa t) throws Exception {
		candidatoXPesquisaList.add(t);
	}

	@Override
	public List<CandidatoXPesquisa> Read() {
		return candidatoXPesquisaList;
	}

	@Override
	public void Update(CandidatoXPesquisa t) throws Exception {
		candidatoXPesquisaList.set(t.getId(), t);
	}

	@Override
	public void Delete(CandidatoXPesquisa t) throws Exception {
		candidatoXPesquisaList.remove(t.getId());
	}

}
