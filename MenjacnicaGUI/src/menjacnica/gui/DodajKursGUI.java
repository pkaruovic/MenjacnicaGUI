package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textSifra;
	private JTextField textNaziv;
	private JLabel lblProdajniKurs;
	private JTextField textProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField textKupovniKurs;
	private JLabel lblSrednjiKurs;
	private JTextField textSrednjiKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField textSkraceniNaziv;
	private JButton btnDodaj;
	private JButton btnOdustani;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DodajKursGUI frame = new DodajKursGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public DodajKursGUI() {
		setResizable(false);
		setTitle("Dodaj kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 341, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getLblNewLabel_1());
			panel.add(getTextSifra());
			panel.add(getTextNaziv());
			panel.add(getLblProdajniKurs());
			panel.add(getTextProdajniKurs());
			panel.add(getLblKupovniKurs());
			panel.add(getTextKupovniKurs());
			panel.add(getLblSrednjiKurs());
			panel.add(getTextSrednjiKurs());
			panel.add(getLblSkraceniNaziv());
			panel.add(getTextSkraceniNaziv());
			panel.add(getBtnDodaj());
			panel.add(getBtnOdustani());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sifra");
			lblNewLabel.setBounds(20, 11, 130, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Naziv");
			lblNewLabel_1.setBounds(168, 11, 130, 14);
		}
		return lblNewLabel_1;
	}
	private JTextField getTextSifra() {
		if (textSifra == null) {
			textSifra = new JTextField();
			textSifra.setBounds(20, 36, 130, 20);
			textSifra.setColumns(10);
		}
		return textSifra;
	}
	private JTextField getTextNaziv() {
		if (textNaziv == null) {
			textNaziv = new JTextField();
			textNaziv.setBounds(168, 36, 130, 20);
			textNaziv.setColumns(10);
		}
		return textNaziv;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(20, 67, 130, 14);
		}
		return lblProdajniKurs;
	}
	private JTextField getTextProdajniKurs() {
		if (textProdajniKurs == null) {
			textProdajniKurs = new JTextField();
			textProdajniKurs.setColumns(10);
			textProdajniKurs.setBounds(20, 92, 130, 20);
		}
		return textProdajniKurs;
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setBounds(168, 67, 130, 14);
		}
		return lblKupovniKurs;
	}
	private JTextField getTextKupovniKurs() {
		if (textKupovniKurs == null) {
			textKupovniKurs = new JTextField();
			textKupovniKurs.setColumns(10);
			textKupovniKurs.setBounds(168, 92, 130, 20);
		}
		return textKupovniKurs;
	}
	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji kurs");
			lblSrednjiKurs.setBounds(20, 123, 130, 14);
		}
		return lblSrednjiKurs;
	}
	private JTextField getTextSrednjiKurs() {
		if (textSrednjiKurs == null) {
			textSrednjiKurs = new JTextField();
			textSrednjiKurs.setColumns(10);
			textSrednjiKurs.setBounds(20, 148, 130, 20);
		}
		return textSrednjiKurs;
	}
	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skraceni naziv");
			lblSkraceniNaziv.setBounds(168, 123, 130, 14);
		}
		return lblSkraceniNaziv;
	}
	private JTextField getTextSkraceniNaziv() {
		if (textSkraceniNaziv == null) {
			textSkraceniNaziv = new JTextField();
			textSkraceniNaziv.setColumns(10);
			textSkraceniNaziv.setBounds(168, 148, 130, 20);
		}
		return textSkraceniNaziv;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.dodaj(textSifra.getText(), textNaziv.getText(), textProdajniKurs.getText(), textKupovniKurs.getText(), textSrednjiKurs.getText(), textSkraceniNaziv.getText());	
				}
			});
			btnDodaj.setBounds(20, 195, 130, 23);
		}
		return btnDodaj;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnOdustani.setBounds(168, 195, 130, 23);
		}
		return btnOdustani;
	}
}
