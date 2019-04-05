package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Metodoak;

public class P1 extends JFrame {

	private JPanel contentPane;

	private int i;

	private JTextField textField;
	private JTextField Segundocampo;
	private JTextField textField_1 = new JTextField();
	private JTextField textField_2;
	private JTextField textField_3;
	String[] zerrenda= new String[30];
	String prezioa1="";
	private JComboBox comboBox;
	private JComboBox comboBox_1= new JComboBox();
	JComboBox<String> comboBox_2 = new JComboBox();
	JLabel lblPais = new JLabel("Ciudad");
	JLabel label = new JLabel("Ciudad:");
	JLabel label_1 = new JLabel("Hotel:");
	JLabel label_2 = new JLabel("Precio:");
	JLabel lblHotel = new JLabel("Hotel");
	JLabel lblGauakgaua = new JLabel("Gauak(80/Gaua)");
	JButton btnAurrera = new JButton("Aurrera");

	public P1(ArrayList<controlador.Hotela> hotela) {
		rellenar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// JMenu nora = new JMenu ("Nora");
		// Linea Bakoitza haren kodearekin klik egiterakoan(NORA):
		//Espainia = new JMenuItem(Espana);



		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPais.setBounds(20, 70, 100, 50);
		contentPane.add(lblPais);


		label.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label.setBounds(57, 304, 100, 56);
		contentPane.add(label);


		label_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label_1.setBounds(57, 384, 100, 56);
		contentPane.add(label_1);


		label_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label_2.setBounds(57, 461, 100, 56);
		contentPane.add(label_2);
		//Idazten den eremuak

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBorder(null);
		textField.setColumns(10);
		textField.setBounds(178, 316, 317, 40);
		contentPane.add(textField);




		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(178, 473, 317, 40);
		contentPane.add(textField_2);


		lblHotel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHotel.setBounds(212, 70, 100, 50);
		contentPane.add(lblHotel);




		lblGauakgaua.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGauakgaua.setBounds(397, 70, 141, 50);
		contentPane.add(lblGauakgaua);

		comboBox= new JComboBox();
		comboBox.setBounds(426, 125, 58, 56);
		contentPane.add(comboBox);


		btnAurrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Metodoak m1 = new Metodoak();
				m1.bigarrenLehioa(prezioa1);

			}
		});
		btnAurrera.setBounds(464, 527, 89, 23);
		contentPane.add(btnAurrera);
		//Combo1

		

		comboBox_1.setBounds(20, 143, 82, 20);
		contentPane.add(comboBox_1);
		String herr="";
		ArrayList<String>arr = new ArrayList ();
		for( controlador.Hotela p : hotela) {
			if(!arr.contains(p.getHerria())) {
				comboBox_1.addItem(p.getHerria());
				arr.add(p.getHerria());
			}
			
		}

		//Combo2



		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(212, 143, 89, 20);
		contentPane.add(comboBox_2);

		
		
		Segundocampo = new JTextField();
		Segundocampo.setEditable(false);
		Segundocampo.setBorder(null);
		Segundocampo.setColumns(10);
		Segundocampo.setBounds(178, 392, 317, 40);
		contentPane.add(Segundocampo);
		
		
		


		
		textField_1.setEditable(false);
		textField_1.setBorder(null);
		textField_1.setColumns(10);
		textField_1.setBounds(178, 392, 317, 40);
		contentPane.add(textField_1);




		comboBox_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent i) {
				comboBox_2.setModel(new DefaultComboBoxModel());
				textField.setText((String) comboBox_1.getSelectedItem());
				String herria = (String) comboBox_1.getSelectedItem();

				
				

				for(controlador.Hotela p : hotela) {
					if (herria.equalsIgnoreCase(p.getHerria())) {
						comboBox_2.addItem(p.getIzena());
						Segundocampo.removeAll();
					}

				}
			}
		});



		



		comboBox_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				  
				  Segundocampo.setText(comboBox_2.getSelectedItem().toString());
				
				


				
				textField_1.setText(comboBox_2.getSelectedItem().toString());



			}
		});
		for( i=0;i<zerrenda.length;i++) {

			comboBox.addItem(zerrenda[i]);

		}
		comboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int prezioa=0;

				int dia=Integer.valueOf(comboBox.getSelectedItem().toString());
				prezioa = 80*dia;

				prezioa1=Integer.toString(prezioa);

				textField_2.setText(prezioa1);

			}
		});

	}

	public void rellenar() {
		String zenb="";

		for(int i=0;i<zerrenda.length;i++) {
			zenb=Integer.toString(i+1);
			zerrenda[i]=zenb;
		}
	}
}
