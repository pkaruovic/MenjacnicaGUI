package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textKupovniKurs;
	private JTextField textProdajniKurs;
	private JComboBox comboValuta;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textIznos;
	private JRadioButton rdbtnKupovina;
	private JRadioButton rdbtnProdaja;
	private JSlider slider;
	private JButton brnIzvrsiZamenu;
	private JButton btnOdustani;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					IzvrsiZamenuGUI frame = new IzvrsiZamenuGUI();
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
	public IzvrsiZamenuGUI() {
		setResizable(false);
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTextKupovniKurs());
		contentPane.add(getTextProdajniKurs());
		contentPane.add(getComboValuta());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getTextIznos());
		contentPane.add(getRdbtnKupovina());
		contentPane.add(getRdbtnProdaja());
		contentPane.add(getSlider());
		contentPane.add(getBrnIzvrsiZamenu());
		contentPane.add(getBtnOdustani());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Kupovni kurs");
			lblNewLabel.setBounds(10, 11, 109, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Prodajni kurs");
			lblNewLabel_1.setBounds(228, 11, 105, 14);
		}
		return lblNewLabel_1;
	}
	private JTextField getTextKupovniKurs() {
		if (textKupovniKurs == null) {
			textKupovniKurs = new JTextField();
			textKupovniKurs.setEditable(false);
			textKupovniKurs.setBounds(10, 36, 109, 20);
			textKupovniKurs.setColumns(10);
		}
		return textKupovniKurs;
	}
	private JTextField getTextProdajniKurs() {
		if (textProdajniKurs == null) {
			textProdajniKurs = new JTextField();
			textProdajniKurs.setEditable(false);
			textProdajniKurs.setBounds(228, 36, 109, 20);
			textProdajniKurs.setColumns(10);
		}
		return textProdajniKurs;
	}
	private JComboBox getComboValuta() {
		if (comboValuta == null) {
			comboValuta = new JComboBox();
			comboValuta.setPreferredSize(new Dimension(6, 20));
			comboValuta.setBounds(129, 36, 86, 20);
			comboValuta.addItem("EUR");
			comboValuta.addItem("USD");
			comboValuta.addItem("CHF");
		}
		return comboValuta;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Iznos");
			lblNewLabel_2.setBounds(10, 67, 109, 14);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Vrsta transakcije");
			lblNewLabel_3.setBounds(228, 67, 105, 14);
		}
		return lblNewLabel_3;
	}
	private JTextField getTextIznos() {
		if (textIznos == null) {
			textIznos = new JTextField();
			textIznos.setBounds(10, 89, 109, 20);
			textIznos.setColumns(10);
		}
		return textIznos;
	}
	private JRadioButton getRdbtnKupovina() {
		if (rdbtnKupovina == null) {
			rdbtnKupovina = new JRadioButton("Kupovina");
			buttonGroup.add(rdbtnKupovina);
			rdbtnKupovina.setBounds(228, 88, 109, 23);
		}
		return rdbtnKupovina;
	}
	private JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja");
			buttonGroup.add(rdbtnProdaja);
			rdbtnProdaja.setBounds(228, 114, 109, 23);
		}
		return rdbtnProdaja;
	}
	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					upisiUtxtIznos();
				}
			});
			slider.setBounds(10, 144, 323, 38);
			slider.setMaximum(100);
			slider.setMinimum(0);
			slider.setMajorTickSpacing(10);
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
		}
		return slider;
	}
	private JButton getBrnIzvrsiZamenu() {
		if (brnIzvrsiZamenu == null) {
			brnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			brnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.izvrsiZamenu(vratiString());
				}
			});
			brnIzvrsiZamenu.setPreferredSize(new Dimension(105, 23));
			brnIzvrsiZamenu.setBounds(10, 193, 120, 23);
		}
		return brnIzvrsiZamenu;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnOdustani.setBounds(213, 193, 120, 23);
		}
		return btnOdustani;
	}
	
	public void upisiUtxtIznos(){
		textIznos.setText(slider.getValue() + "");
	}

	public String vratiString(){
		if(rdbtnKupovina.isSelected()){
			return comboValuta.getSelectedItem() + " " + textIznos.getText() + " " + rdbtnKupovina.getText();
		}else if(rdbtnProdaja.isSelected()){
			return comboValuta.getSelectedItem() + " " + textIznos.getText() + " " + rdbtnProdaja.getText();
		}else
			return "";
	}
}
