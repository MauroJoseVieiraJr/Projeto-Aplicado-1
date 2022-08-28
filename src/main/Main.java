package main;

public class Main {

	public static void main(String[] args) {
		Candidato c = new Candidato(1, "Fulano", "PPP", false);
		System.out.println(c.toString());
		
		TipoPesquisa tp = new TipoPesquisa(0, "Induzida");
		System.out.println(tp.toString());
		
		Pesquisa p = new Pesquisa(0, "IBGE", "2022-01-23", "Florianópolis", 43, tp, "Digital");
		System.out.println(p.toString());
		
		Candidato_X_Pesquisa cxp = new Candidato_X_Pesquisa(0, c, p, 123456);
		System.out.println(cxp.toString());
	}

}
