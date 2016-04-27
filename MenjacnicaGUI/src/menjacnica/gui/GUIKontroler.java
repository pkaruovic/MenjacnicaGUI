package menjacnica.gui;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import menjacnica.kurs.Kurs;
import menjacnica.kurs.Menjacnica;

public class GUIKontroler {
	private static MenjacnicaGUI glavniProzor;
	private static Menjacnica menjacnica;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menjacnica = new Menjacnica();
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
		Kurs k = new Kurs(sifra, naziv, Double.parseDouble(prodajniKurs.trim()), Double.parseDouble(kupovniKurs.trim()), Double.parseDouble(srednjiKurs.trim()), skraceniNaziv);
		dodajKursUMenjacnicu(k);
		glavniProzor.osveziTabelu(vratiKurseve());
	}
	
	public static void izbrisi(){
		try {
			int pozicija = glavniProzor.vratiSelektovanRed();
			
			if(pozicija == -1){
				JOptionPane.showMessageDialog(glavniProzor, "Izaberite red koji zelite da izbrisete", "Greska", JOptionPane.ERROR_MESSAGE);
				return;
			}
			int povratnaVrednost = JOptionPane.showConfirmDialog(glavniProzor, "Da li ste sigurni da zelite da izbrisete selektovani red?", "Upozorenje",JOptionPane.YES_NO_OPTION);
			
			if(povratnaVrednost == JOptionPane.YES_OPTION){
				izbrisiKursIzMenjacnice(pozicija);
				glavniProzor.osveziTabelu(vratiKurseve());
				glavniProzor.upisiUStatus("Izbrisan je red sa indeksom: " + pozicija + "!");
			}
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(glavniProzor, "Doslo je do greske prilikom brisanja!" + e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static ArrayList<Kurs> vratiKurseve(){
		return menjacnica.getKursevi();
	}
	
	public static void dodajKursUMenjacnicu(Kurs k){
		menjacnica.dodajKurs(k);	
	}
	
	public static void izbrisiKursIzMenjacnice(int pozicija){
		menjacnica.izbrisiKurs(pozicija);
	}
	
	public static void napraviProzorZaNoviKurs(){
		DodajKursGUI dodajKurs = new DodajKursGUI();
		dodajKurs.setVisible(true);
		dodajKurs.setLocationRelativeTo(null);
	}
	
	public static void napraviProzorZaZamenu(){
		IzvrsiZamenuGUI prozorZaZamenu = new IzvrsiZamenuGUI();
		prozorZaZamenu.setVisible(true);
		prozorZaZamenu.setLocationRelativeTo(null);
	}

	public static void izvrsiZamenu(String s) {
		if(!s.isEmpty())
			glavniProzor.upisiUStatus("Izvrsena zamena: " + s);	
	}
}
