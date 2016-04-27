package modelitabele;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import menjacnica.kurs.Kurs;

public class ModelTabele extends AbstractTableModel {
	private String[] nazivKolona = new String[]{"Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"};
	private ArrayList<Kurs> podaci;
	
	public ModelTabele(ArrayList<Kurs> podaci) {
		if(podaci == null){
			this.podaci = new ArrayList<Kurs>();
			return;
		}
		
		this.podaci = podaci;
	}
	
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
		return podaci.size();
	}

	@Override
	public Object getValueAt(int red, int kolona) {
		Kurs k = podaci.get(red);
		
		switch(kolona){
		case 0:
			return k.getSifra();
		case 1:
			return k.getNaziv();
		case 2:
			return k.getProdajniKurs();
		case 3:
			return k.getKupovniKurs();
		case 4:
			return k.getSrednjiKurs();
		case 5:
			return k.getSkraceniNaziv();
		}
		return null;
	}

	public void osveziPodatke(ArrayList<Kurs> podaci){
		if(podaci == null)
			return;
		this.podaci = podaci;
		fireTableDataChanged();
	}
}
