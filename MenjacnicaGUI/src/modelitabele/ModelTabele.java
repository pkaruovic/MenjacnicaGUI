package modelitabele;

import javax.swing.table.AbstractTableModel;

public class ModelTabele extends AbstractTableModel {
	private String[] nazivKolona = new String[]{"Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"};
	
	@Override
	public String getColumnName(int column) {
		return nazivKolona[column];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return nazivKolona.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
