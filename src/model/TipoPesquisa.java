package model;

public class TipoPesquisa {
	private int id;
	private String descricao;
	
	/**
	 * Cria um tipo de pesquisa para ser utilizado em uma pesquisa.
	 * @param id - Identificador do tipo de pesquisa.
	 * @param descricao - Descrição do tipo de pesquisa.
	 */
	public TipoPesquisa(int id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		String s = "Tipo " + descricao;
		return s;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
