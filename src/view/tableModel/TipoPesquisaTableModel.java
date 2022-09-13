package view.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.TipoPesquisa;

public class TipoPesquisaTableModel extends AbstractTableModel {
	private static final int COL_ID = 0;
	private static final int COL_DESCRICAO = 1;
	
	private List<TipoPesquisa> contents;
	
	public TipoPesquisaTableModel(List<TipoPesquisa> list) {
		this.contents = new ArrayList<TipoPesquisa>(list);
	}
	
	@Override
	public int getRowCount() {
		return contents.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TipoPesquisa tp = contents.get(rowIndex);
		
		if(columnIndex == COL_ID)
			return tp.getId();
		
		if(columnIndex == COL_DESCRICAO)
			return tp.getDescricao();
		
		return null;
	}
	
	public String getColumnName (int column) {
		if(column == COL_ID)
			return "ID";
		
		if(column == COL_DESCRICAO)
			return "Descrição";
		
		return null;
	}

	public TipoPesquisa getContents(int row) {
		return contents.get(row);
	}
}
