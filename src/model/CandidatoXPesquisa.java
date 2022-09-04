package model;

public class CandidatoXPesquisa {
	private int id;
	private Candidato candidato;
	private Pesquisa pesquisa;
	private int votos;
	
	/**
	 * Gera uma relação de um candidato em uma pesquisa.
	 * @param id - Identificador da relação.
	 * @param candidato - Candidato a ser relacionado à pesquisa.
	 * @param pesquisa - Pesquisa que será analisada.
	 * @param votos - Quantia de votos do candidato na pesquisa.
	 */
	public CandidatoXPesquisa(int id, Candidato candidato, Pesquisa pesquisa, int votos) {
		super();
		this.id = id;
		this.candidato = candidato;
		this.pesquisa = pesquisa;
		this.votos = votos;
	}
	
	@Override
	public String toString() {
		String s = "Candidato X Pesquisa. ID: " + id + 
				"\n-Candidato: " + candidato.getNome() + ", Partido: " + candidato.getPartido() +
				".\n-Pesquisa: " + pesquisa .getId()+ ", Instituto: " + pesquisa.getInstituto() +
				", Data da pesquisa: " + pesquisa.getData() + 
				".\n-->Total de votos: " + votos;
		return s;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Candidato getCandidato() {
		return candidato;
	}
	
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	public Pesquisa getPesquisa() {
		return pesquisa;
	}
	
	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	public int getVotos() {
		return votos;
	}
	
	public void setVotos(int votos) {
		this.votos = votos;
	}
}
