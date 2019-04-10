package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controlador.*;


import controlador.Erreserba;
import controlador.Hotela;
import controlador.Metodoak;
import java.awt.Color;


public class P1 extends JFrame {

	private JPanel contentPane;

	private int i;

	private JTextField textField= new JTextField();
	private JTextField Segundocampo= new JTextField() ;
	private JTextField textField_2= new JTextField();
	private JTextField textField_3= new JTextField();
	private String[] zerrenda= new String[30];
	private String prezioa1="";
	private JComboBox comboBox;
	private JComboBox comboBox_1= new JComboBox();
	private JComboBox<String> comboBox_2 = new JComboBox();
	private JLabel lblPais = new JLabel("HERRIA / HIRIA");
	private JLabel label = new JLabel("Ciudad:");
	private JLabel label_1 = new JLabel("Hotel:");
	private JLabel label_2 = new JLabel("Precio:");
	private JDateChooser sartzedata = new JDateChooser();
	private JDateChooser irtetzedata = new JDateChooser();


	int prezioa=0;
	int ostatu_id=0;


	private JLabel lblHotel = new JLabel("OSTATU MOTA");
	private JLabel lblGauakgaua = new JLabel("CHECK-IN");
	private JButton btnAurrera = new JButton("AURRERA");

	private Metodoak m1;
	//para poder hacer setVisible sin que se joda
	private Metodoak metodos;
	private String precio="";
	private double precioadoubleprecio=0.0;
	private Erreserba erreserba;
	
	

	
	public P1(ArrayList<controlador.Hotela> hotela) {
		rellenar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);


		lblPais.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblPais.setBounds(18, 75, 112, 40);
		contentPane.add(lblPais);


		label.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label.setBounds(57, 304, 100, 56);
		contentPane.add(label);


		label_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label_1.setBounds(57, 355, 100, 56);
		contentPane.add(label_1);


		label_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label_2.setBounds(57, 406, 100, 56);
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


		textField_2.setBounds(178, 418, 317, 40);
		

		contentPane.add(textField_2);


		lblHotel.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblHotel.setBounds(282, 70, 100, 50);
		contentPane.add(lblHotel);

		//JCALENDAR LEHEN DATA
		sartzedata.setBounds(264, 131, 118, 20);
		sartzedata.setDateFormatString("yyyy-MM-dd");
		getContentPane().add(sartzedata);
		sartzedata.setSelectableDateRange(new Date(), null);
		
		
		//JCALENDAR BIGARREN DATA
		irtetzedata.setBounds(396, 131, 117, 20);
		irtetzedata.setVerifyInputWhenFocusTarget(false);
		irtetzedata.setVisible(false);
		irtetzedata.setDateFormatString("yyyy-MM-dd");	
		getContentPane().add(irtetzedata);
		irtetzedata.getDate();
		irtetzedata.cleanup();
		irtetzedata.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 irtetzedata.setMinSelectableDate( sartzedata.getDate());
			}
		});



		lblGauakgaua.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		lblGauakgaua.setBounds(18, 186, 68, 25);
		contentPane.add(lblGauakgaua);

		comboBox= new JComboBox();
		comboBox.setBounds(99, 189, 58, 23);
		contentPane.add(comboBox);

		btnAurrera.setFont(new Font("Arial Narrow", Font.BOLD, 16));



		btnAurrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodos.bigarrenLehioa();
				int id=0;
				precio = textField_2.getText();
				precioadoubleprecio=Double.parseDouble(precio);
				
				for(Hotela p : hotela) {
					System.out.println(textField.getText());
					if(p.getHerria().equalsIgnoreCase(textField.getText())) {
						id=p.getOstatu_id();
						
					}
				}
				
				erreserba = new Erreserba(1, id, null, null, null, 0, precioadoubleprecio, 0, null, null, 0, null);
				System.out.println(erreserba);
			}
		});
		btnAurrera.setBounds(443, 511, 106, 27);
		contentPane.add(btnAurrera);
		

		//Combo1

		comboBox_1.setBounds(140, 87, 82, 20);
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
		comboBox_2.setBounds(406, 87, 89, 20);
		contentPane.add(comboBox_2);



		Segundocampo.setEditable(false);
		Segundocampo.setBorder(null);
		Segundocampo.setColumns(10);
		Segundocampo.setBounds(178, 367, 317, 40);
		contentPane.add(Segundocampo);










		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(324, 188, 58, 25);
		contentPane.add(comboBox_3);
		
		JLabel lblNewLabel = new JLabel("CHECK-OUT");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblNewLabel.setBounds(225, 186, 89, 25);
		contentPane.add(lblNewLabel);


		comboBox_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent i) {
				comboBox_2.setModel(new DefaultComboBoxModel());
				textField.setText((String) comboBox_1.getSelectedItem());
				String herria = (String) comboBox_1.getSelectedItem();

				for(controlador.Hotela p : hotela) {
					if (herria.equalsIgnoreCase(p.getHerria())) {
						ostatu_id=p.getOstatu_id();
						comboBox_2.addItem(p.getIzena());
						Segundocampo.removeAll();
					}

				}
			}
		});

		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	  
				Segundocampo.setText(comboBox_2.getSelectedItem().toString());
				textField.setText(comboBox_2.getSelectedItem().toString());
			}
		});
		for( i=0;i<zerrenda.length;i++) {
			comboBox.addItem(zerrenda[i]);
		}
		comboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {


				int dia=Integer.valueOf(comboBox.getSelectedItem().toString());
				prezioa = 80*dia;

				prezioa1=Integer.toString(prezioa);

				textField_2.setText(prezioa1);

				//Metodoak.prezio_totala(prezioa1);
			}

		});
		
		btnAurrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				//Metodoak.bigarrenLehioa();
				//Erreserba r1= new Erreserba(1,ostatu_id,null,null,null,0,prezioa,0,null,null,0,null);
				DatuBiltegia db1=new DatuBiltegia();
				db1.erreserbaGorde(ostatu_id,prezioa);
			}
		});
		btnAurrera.setBounds(464, 527, 89, 23);
		contentPane.add(btnAurrera);
		
	}

	public void rellenar() {
		String zenb="";

		for(int i=0;i<zerrenda.length;i++) {
			zenb=Integer.toString(i+1);
			zerrenda[i]=zenb;
		}
	}
	
	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}
	
	public String bidalidirus() {
		return precio;
	}
	public Erreserba bidalireserba() {
		return erreserba;
	}
}
