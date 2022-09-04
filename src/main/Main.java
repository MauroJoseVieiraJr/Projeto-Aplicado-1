package main;

import controller.*;
import model.*;

public class Main {

	public static void main(String[] args) throws Exception {
		CandidatoController cController = new CandidatoController();
		PesquisaController pController = new PesquisaController();
		CandidatoXPesquisaController cxpController = new CandidatoXPesquisaController();
		TipoPesquisaController tpController = new TipoPesquisaController();
		
		// ------------------------------------------------------------
		Candidato c1 = new Candidato(0, "Fulano", "PPP", false);
		Candidato c2 = new Candidato(1, "Beltrano", "QQQ", true);
		Candidato c3 = new Candidato(2, "Ciclano", "RRR", false);
		Candidato c4 = new Candidato(3, "Beltrano", "QQQ", false);
		Candidato c5 = new Candidato(4, "Alguém", "PPP", true);
		
		cController.Create(c1);
		cController.Create(c2);
		cController.Create(c3);
		cController.Create(c4);
		cController.Create(c5);
		System.out.println();
		
		for (Candidato c : cController.Read())
			System.out.println(c.toString());
		System.out.println();
		
		c1.setPartido("QQQ");
		cController.Update(c1);
		
		for (Candidato c : cController.Read())
			System.out.println(c.toString());
		System.out.println();
		
		cController.Delete(c1);
		
		for (Candidato c : cController.Read())
			System.out.println(c.toString());
		System.out.println("\n------------------------------------------------------------");

		// ------------------------------------------------------------
		TipoPesquisa tp1 = new TipoPesquisa(0, "Induzida");
		TipoPesquisa tp2 = new TipoPesquisa(1, "Livre");
		
		tpController.Create(tp1);
		tpController.Create(tp2);
		System.out.println();
		
		for (TipoPesquisa tp : tpController.Read())
			System.out.println(tp.toString());
		System.out.println();
		
		tp1.setDescricao("Questionário");
		tpController.Update(tp1);
		
		for (TipoPesquisa tp : tpController.Read())
			System.out.println(tp.toString());
		System.out.println();
		
		tpController.Delete(tp2);
		
		for (TipoPesquisa tp : tpController.Read())
			System.out.println(tp.toString());
		System.out.println("\n------------------------------------------------------------");
		
		// ------------------------------------------------------------
		final TipoPesquisa tp = tpController.Read().get(0); // Só por conveniência mesmo.
		
		Pesquisa p1 = new Pesquisa(0, "IBGE", "2022-01-23", "Florianópolis", 43, tp, "Digital");
		Pesquisa p2 = new Pesquisa(1, "IBAMA", "2022-05-09", "Blumenau", 56, tp, "Pessoal");
		Pesquisa p3 = new Pesquisa(2, "IGP", "2022-03-04", "Joinville", 29, tp, "Digital");
		Pesquisa p4 = new Pesquisa(3, "IBGE", "2022-02-27", "Florianópolis", 22, tp, "PortaPorta");
		
		pController.Create(p1);
		pController.Create(p2);
		pController.Create(p3);
		pController.Create(p4);
		System.out.println();
		
		for (Pesquisa p : pController.Read())
			System.out.println(p.toString());
		System.out.println();
		
		p1.setFormato("Questnário");
		pController.Update(p1);
		
		for (Pesquisa p : pController.Read())
			System.out.println(p.toString());
		System.out.println();
		
		pController.Delete(p2);
		
		for (Pesquisa p : pController.Read())
			System.out.println(p.toString());
		System.out.println("\n------------------------------------------------------------");
		
		// ------------------------------------------------------------
		final Pesquisa pex1 = pController.Read().get(0);
		final Pesquisa pex2 = pController.Read().get(1);
		
		final Candidato cex1 = cController.Read().get(0);
		final Candidato cex2 = cController.Read().get(1);
		
		CandidatoXPesquisa cxp1 = new CandidatoXPesquisa(0, cex1, pex1, 123456);
		CandidatoXPesquisa cxp2 = new CandidatoXPesquisa(1, cex1, pex2, 789012);
		CandidatoXPesquisa cxp3 = new CandidatoXPesquisa(2, cex2, pex2, 333333);
		
		cxpController.Create(cxp1);
		cxpController.Create(cxp2);
		cxpController.Create(cxp3);
		System.out.println();
		
		for (CandidatoXPesquisa cxp : cxpController.Read())
			System.out.println(cxp.toString());
		System.out.println();
		
		cxp3.setVotos(111111);
		cxpController.Update(cxp3);
		
		for (CandidatoXPesquisa cxp : cxpController.Read())
			System.out.println(cxp.toString());
		System.out.println();
		
		cxpController.Delete(cxp2);
		
		for (CandidatoXPesquisa cxp : cxpController.Read())
			System.out.println(cxp.toString());
		System.out.println("\n------------------------------------------------------------");
	}

}
