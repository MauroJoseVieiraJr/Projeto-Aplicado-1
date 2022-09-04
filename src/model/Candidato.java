package model;

public class Candidato {
	private int id;
	private String nome;
	private String partido;
	private boolean fichaLimpa;
	
	/**
	 * Cria um candidato de um determinado partido, ficha limpa ou não.
	 * @param id - Número do candidato, deve ser único.
	 * @param nome - Nome do candidato.
	 * @param partido - Partido e/ou coligação do candidato.
	 * @param fichaLimpa -  Determina se o candidato é ficha limpa ou não.
	 */
	public Candidato(int id, String nome, String partido, boolean fichaLimpa) {
		super();
		this.id = id;
		this.nome = nome;
		this.partido = partido;
		this.fichaLimpa = fichaLimpa;
	}
	
	@Override
	public String toString() {
		String s = "Candidato. ID: " + id + ", Nome: " + nome + ", Partido: " + partido + ", Ficha Limpa: " +
					fichaLimpa + ".";
		return s;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public boolean isFichaLimpa() {
		return fichaLimpa;
	}

	public void setFichaLimpa(boolean fichaLimpa) {
		this.fichaLimpa = fichaLimpa;
	}
	
	

}
