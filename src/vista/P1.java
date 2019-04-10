package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	int id=0;

	private JTextField textField= new JTextField();
	private JTextField Segundocampo= new JTextField() ;
	private JTextField textField_2= new JTextField();
	private JTextField textField_3= new JTextField();
	private String[] zerrenda= new String[30];
	private String prezioa1="";
	private JComboBox comboBox_1= new JComboBox();
	private JComboBox<String> comboBox_2 = new JComboBox();
	private JLabel lblPais = new JLabel("HERRIA / HIRIA");
	private JLabel label = new JLabel("Ciudad:");
	private JLabel label_1 = new JLabel("Hotel:");
	private JLabel label_2 = new JLabel("Precio:");
	private JDateChooser sartzedata = new JDateChooser();
	private JDateChooser irtetzedata = new JDateChooser();
	private int pertsona_kopurua=0;
	private String fechaComoCadena;
	private String fechaComoCadena2;
	private int  gela_kop;
	private String oheMota;
	private String  letra_ostatu;
	private String hostatu_mota;
	int prezioa=0;
	int ostatu_id=0;


	private JLabel lblHotel = new JLabel("Hotelak");
	private JLabel lblGauakgaua = new JLabel("CHECK-IN");

	private Metodoak m1;
	//para poder hacer setVisible sin que se joda
	private Metodoak metodos;
	private String precio="";
	private double precioadoubleprecio=0.0;
	private Erreserba erreserba;
	private final JLabel lblGelaKopurua = new JLabel("GELA KOPURUA");
	private final JComboBox comboBox = new JComboBox();
	private final JLabel lblOheMota = new JLabel("OHE MOTA");
	private final JComboBox comboBox_3 = new JComboBox();
	private final JButton btnAurrera = new JButton("AURRERA");
	
	

	
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
		sartzedata.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String formato = sartzedata.getDateFormatString();
				System.out.println(formato);
				Date date = sartzedata.getDate();
				SimpleDateFormat sdf = new SimpleDateFormat(formato);
				
			}
		});

		//JCALENDAR LEHEN DATA
		sartzedata.setBounds(104, 191, 118, 20);
		sartzedata.setDateFormatString("yyyy-MM-dd");
		getContentPane().add(sartzedata);
		sartzedata.setSelectableDateRange(new Date(), null);
		
		
		//JCALENDAR BIGARREN DATA
		irtetzedata.setBounds(401, 191, 117, 20);
		irtetzedata.setDateFormatString("yyyy-MM-dd");
		getContentPane().add(irtetzedata);
		irtetzedata.setSelectableDateRange(new Date(), null);
		
		
		


		lblGauakgaua.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		lblGauakgaua.setBounds(18, 191, 68, 25);
		contentPane.add(lblGauakgaua);
		
		btnAurrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodos.bigarrenLehioa();
				precio = textField_2.getText();
				//precioadoubleprecio=Double.parseDouble(precio);
				
				//**************Fechas**********
				//1
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				String fechaComoCadena = sdf.format(sartzedata.getDate());
				
				//2
				String fechaComoCadena2 = sdf.format(irtetzedata.getDate());
				

				
				
				
				
				
				for(Hotela p : hotela) {
					System.out.println(textField.getText());
					if(p.getHerria().equalsIgnoreCase(textField.getText())) {
						id=p.getOstatu_id();
						
					}
				}
				
				
				
			}
		});

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
		//comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Hotela", "Apartamentua", "Etxea"}));

		//Combo2
		comboBox_2.setBounds(406, 87, 89, 20);
		contentPane.add(comboBox_2);



		Segundocampo.setEditable(false);
		Segundocampo.setBorder(null);
		Segundocampo.setColumns(10);
		Segundocampo.setBounds(178, 367, 317, 40);
		contentPane.add(Segundocampo);
		
		JLabel lblNewLabel = new JLabel("CHECK-OUT");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblNewLabel.setBounds(266, 186, 89, 25);
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
		lblGelaKopurua.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblGelaKopurua.setBounds(18, 141, 112, 14);
		
		contentPane.add(lblGelaKopurua);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 gela_kop=(int) comboBox.getSelectedItem();
			}
		});
		comboBox.setBounds(140, 140, 28, 20);
		
		contentPane.add(comboBox);
		lblOheMota.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblOheMota.setBounds(282, 143, 82, 14);
		
		contentPane.add(lblOheMota);
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 oheMota=(String) comboBox_3.getSelectedItem();
			}
		});
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Banakakoa", "Bikoitza", "Umeena"}));
		comboBox_3.setBounds(406, 140, 89, 20);
		
		contentPane.add(comboBox_3);
		btnAurrera.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnAurrera.setBounds(406, 489, 112, 39);
		
		contentPane.add(btnAurrera);
		
		JLabel lblPertsonaKopurua = new JLabel("Pertsona Kopurua");
		lblPertsonaKopurua.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPertsonaKopurua.setBounds(18, 239, 68, 25);
		contentPane.add(lblPertsonaKopurua);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(104, 244, 36, 20);
		contentPane.add(comboBox_4);
		
		JLabel label_3 = new JLabel("OSTATU MOTA");
		label_3.setFont(new Font("Dialog", Font.BOLD, 16));
		label_3.setBounds(255, 222, 100, 50);
		contentPane.add(label_3);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 hostatu_mota=(String) comboBox_5.getSelectedItem();
				 letra_ostatu="";
				if(hostatu_mota.equalsIgnoreCase("Hotela")) {
					letra_ostatu="H";
				}
				if(hostatu_mota.equalsIgnoreCase("Apartamentua")) {
					letra_ostatu="A";
				}
				if(hostatu_mota.equalsIgnoreCase("Etxea")) {
					letra_ostatu="E";
				}
			}
		});
		comboBox_5.setBounds(401, 244, 94, 20);
		contentPane.add(comboBox_5);
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"","Hotela", "Apartamentua", "Etxea"}));

		
		
		for(int pertsona=1;pertsona<=10;pertsona++) {
			comboBox_4.addItem(pertsona);
		}
		
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	  
				pertsona_kopurua=(int) comboBox_4.getSelectedItem();
				
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
	
	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}
	
	public String bidalidirus() {
		return precio;
	}
	
	
	public int bidaliId() {
		return id;
	}
	public String  ateraData1() {
		return  fechaComoCadena;
	}
	public String  ateraData2() {
		return  fechaComoCadena2;
		
	}
	public int  ateraPertsonakop() {
		return  pertsona_kopurua;
		
	}
	public int  ateraGelakop() {
		return  gela_kop;
		
	}
	public String ateraOheMota() {
		return oheMota;
	}
	public String ateraPentsio() {
		return letra_ostatu;
	}
}
