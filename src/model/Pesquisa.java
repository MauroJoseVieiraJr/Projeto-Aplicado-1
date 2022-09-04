package model;

public class Pesquisa {
	private int id;
	private String instituto;
	private String data;
	private String local;
	private int mediaIdade;
	private TipoPesquisa tipo;
	private String formato;
	
	/**
	 * Cria uma pesquisa pertencente a um instituto, realzada em uma determinada data e local, tem a m�dia de idade dos
	 * participantes, tem um determinado tipo e formato.
	 * @param id - n�mero de identifica��o �nico.
	 * @param instituto - Nome do instituto.
	 * @param data - Data da realiza��o da pesquisa, formato AAAA-MM-DD.
	 * @param local - Lugar de realiza��o da pesquisa.
	 * @param mediaIdade - M�dia das idades dos participantes.
	 * @param tipo - Tipo de pesquisa.
	 * @param formato - Formato da pesquisa.
	 */
	public Pesquisa(int id, String instituto, String data, String local, int mediaIdade, TipoPesquisa tipo,
			String formato) {
		super();
		this.id = id;
		this.instituto = instituto;
		this.data = data;
		this.local = local;
		this.mediaIdade = mediaIdade;
		this.tipo = tipo;
		this.formato = formato;
	}
	
	@Override
	public String toString() {
		String s = "Pesquisa. ID: " + id + ", Instituto: " + instituto + ", Data: " + data +
					", Local: " + local + ", M�dia de idades: " + mediaIdade + ", Tipo de Pesquisa: " + tipo.toString() +
					", Formato: " + formato;
		return s;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getInstituto() {
		return instituto;
	}
	
	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public int getMediaIdade() {
		return mediaIdade;
	}
	
	public void setMediaIdade(int mediaIdade) {
		this.mediaIdade = mediaIdade;
	}
	
	public TipoPesquisa getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoPesquisa tipo) {
		this.tipo = tipo;
	}
	
	public String getFormato() {
		return formato;
	}
	
	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	
}
