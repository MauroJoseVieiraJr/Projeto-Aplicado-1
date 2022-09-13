package view.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Pesquisa;

public class PesquisaTableModel extends AbstractTableModel {
	private static final int COL_ID = 0;
	private static final int COL_INSTITUTO = 1;
	private static final int COL_DATA_PESQUISA = 2;
	private static final int COL_LOCAL_PESQUISA = 3;
	private static final int COL_MEDIA_IDADE = 4;
	private static final int COL_TIPO_PESQUISA = 5;
	private static final int COL_FORMATO = 6;
	
	
	private List<Pesquisa> contents;
	
	public PesquisaTableModel(List<Pesquisa> list) {
		this.contents = new ArrayList<Pesquisa>(list);
	}
	
	@Override
	public int getRowCount() {
		return contents.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pesquisa p = contents.get(rowIndex);
		
		if(columnIndex == COL_ID)
			return p.getId();
		
		if(columnIndex == COL_INSTITUTO)
			return p.getInstituto();
		
		if(columnIndex == COL_DATA_PESQUISA)
			return p.getData();
		
		if(columnIndex == COL_LOCAL_PESQUISA)
			return p.getLocal();
		
		if(columnIndex == COL_MEDIA_IDADE)
			return p.getMediaIdade();
		
		if(columnIndex == COL_TIPO_PESQUISA)
			return p.getTipo().getDescricao();
		
		if(columnIndex == COL_FORMATO)
			return p.getFormato();
		
		return null;
	}
	
	public String getColumnName (int column) {
		if(column == COL_ID)
			return "ID";
		
		if(column == COL_INSTITUTO)
			return "Instituto";
		
		if(column == COL_DATA_PESQUISA)
			return "Data da Pesquisa";
		
		if(column == COL_LOCAL_PESQUISA)
			return "Local";
		
		if(column == COL_MEDIA_IDADE)
			return "Média de idade";
		
		if(column == COL_TIPO_PESQUISA)
			return "Tipo de Pesquisa";
		
		if(column == COL_FORMATO)
			return "Formato de Pesquisa";
		
		return null;
	}

	public Pesquisa getContents(int row) {
		return contents.get(row);
	}
}
