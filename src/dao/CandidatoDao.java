package dao;

import java.util.ArrayList;
import java.util.List;

import interfaces.Crud;
import model.Candidato;

public class CandidatoDao implements Crud<Candidato> {

	private static CandidatoDao instance;
	private List<Candidato> candidatoList = new ArrayList<>();
	
	public static CandidatoDao getInstance() {
		if (instance == null)
			instance = new CandidatoDao();
		return instance;
	}
	
	@Override
	public void Create(Candidato t) {
		candidatoList.add(t);
	}

	@Override
	public List<Candidato> Read() {
		return candidatoList;
	}

	@Override
	public void Update(Candidato t) {
		candidatoList.set(t.getId(), t);
	}

	@Override
	public void Delete(Candidato t) {
		candidatoList.remove(t.getId());
	}

}
