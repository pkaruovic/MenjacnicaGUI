package menjacnica.gui;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GUIKontroler {
	private static MenjacnicaGUI glavniProzor;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new MenjacnicaGUI();
					glavniProzor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static String otvori(){
		try {
			JFileChooser fc = new JFileChooser();
			int povratnaVrednost = fc.showOpenDialog(glavniProzor);
			
			if(povratnaVrednost == fc.APPROVE_OPTION){
				return "Ucitan fajl: " + fc.getSelectedFile().getAbsolutePath()+ " \n";
			}
				return "";
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(glavniProzor, e.getMessage(),"Greska",JOptionPane.ERROR_MESSAGE);
			return "";
		}
	}
	
	public static String sacuvaj(){
		try {
			JFileChooser fc = new JFileChooser();
			int povratnaVretnost = fc.showSaveDialog(glavniProzor);
			
			if(povratnaVretnost == fc.APPROVE_OPTION){
				return "Sacuvan je fajl: " + fc.getSelectedFile().getAbsolutePath() + " \n";
			}
			return "";
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(glavniProzor, e.getMessage(),"Greska",JOptionPane.ERROR_MESSAGE);
			return "";
		}
	}

	public static void ugasiProgram(){
		int povratnaVrednost = JOptionPane.showConfirmDialog(glavniProzor, "Da li zelite da izadjete iz programa?","Iskljuci",JOptionPane.YES_NO_CANCEL_OPTION);
		
		if(povratnaVrednost == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	
	public static void prikaziPodatkeOAutoru(){
		JOptionPane.showMessageDialog(glavniProzor, "Ime i prezime: Petar Karuovic\n Datum rodjenja: 12.11.1995.\n Mesto rodjenja: Leskovac\n Zanimanje: Student", "About", JOptionPane.NO_OPTION);
	}
	
	public static void dodaj(String sifra, String naziv, String prodajniKurs, String kupovniKurs, String srednjiKurs, String skraceniNaziv){
		glavniProzor.upisiUStatus("Dodat je novi kurs sa atributima: " + sifra + " " + naziv + " " + prodajniKurs + " " + kupovniKurs + " " + srednjiKurs + " " + skraceniNaziv); 
	}
	
	public static void napraviProzorZaNoviKurs(){
		DodajKursGUI dodajKurs = new DodajKursGUI();
		dodajKurs.setVisible(true);
		dodajKurs.setLocationRelativeTo(null);
	}
}
