package view.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.CandidatoXPesquisa;

public class CandidatoXPesquisaTableModel extends AbstractTableModel {
	private static final int COL_ID = 0;
	private static final int COL_CANDIDATO = 1;
	private static final int COL_PESQUISA = 2;
	private static final int COL_VOTOS = 3;
	
	private List<CandidatoXPesquisa> contents;
	
	public CandidatoXPesquisaTableModel(List<CandidatoXPesquisa> list) {
		this.contents = new ArrayList<CandidatoXPesquisa>(list);
	}
	
	@Override
	public int getRowCount() {
		return contents.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CandidatoXPesquisa cxp = contents.get(rowIndex);
		
		if(columnIndex == COL_ID)
			return cxp.getId();
		
		if(columnIndex == COL_CANDIDATO) {
			String s = cxp.getCandidato().getId() + " " + cxp.getCandidato().getNome();
			return s;
		}
		
		if(columnIndex == COL_PESQUISA) {
			String s = cxp.getPesquisa().getId() + " " + cxp.getPesquisa().getInstituto();
			return s;
		}
		
		if(columnIndex == COL_VOTOS)
			return cxp.getVotos();
		
		return null;
	}
	
	public String getColumnName (int column) {
		if(column == COL_ID)
			return "ID";
		
		if(column == COL_CANDIDATO)
			return "Candidato";
		
		if(column == COL_PESQUISA)
			return "Pesquisa";
		
		if(column == COL_VOTOS)
			return "Quantidade de Votos";
		
		return null;
	}

	public CandidatoXPesquisa getContents(int row) {
		return contents.get(row);
	}
}