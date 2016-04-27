package menjacnica.kurs;

import java.util.ArrayList;

public class Menjacnica {
	private ArrayList<Kurs> kursevi;
	
	public Menjacnica() {
		kursevi = new ArrayList<Kurs>();
	}
	
	public void dodajKurs(Kurs k){
		if(k == null)
			return;
		
		kursevi.add(k);
	}

	public ArrayList<Kurs> getKursevi() {
		return kursevi;
	}

	public void setKursevi(ArrayList<Kurs> kursevi) {
		this.kursevi = kursevi;
	}
	
	
}
