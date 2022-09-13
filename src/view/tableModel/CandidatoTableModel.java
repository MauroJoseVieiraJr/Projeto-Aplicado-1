package view.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import model.Candidato;

public class CandidatoTableModel extends AbstractTableModel {
	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;
	private static final int COL_PARTIDO = 2;
	private static final int COL_FICHA_LIMPA = 3;
	
	private List<Candidato> contents;
	
	public CandidatoTableModel(List<Candidato> list) {
		this.contents = new ArrayList<Candidato>(list);
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
		Candidato c = contents.get(rowIndex);
		
		if(columnIndex == COL_ID)
			return c.getId();
		
		if(columnIndex == COL_NOME)
			return c.getNome();
		
		if(columnIndex == COL_PARTIDO)
			return c.getPartido();
		
		if(columnIndex == COL_FICHA_LIMPA)
			return c.isFichaLimpa();
		
		return null;
	}
	
	public String getColumnName (int column) {
		if(column == COL_ID)
			return "ID";
		
		if(column == COL_NOME)
			return "Nome";
		
		if(column == COL_PARTIDO)
			return "Partido";
		
		if(column == COL_FICHA_LIMPA)
			return "Ficha Limpa";
		
		return null;
	}

	public Candidato getContents(int row) {
		return contents.get(row);
	}
}
