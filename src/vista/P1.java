package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
	
	
	private int eguna;
	private int hila;
	private int i;
	int id=0;
	private Date date;
	private Date data1;
	private JTextField textField= new JTextField();
	private JTextField Segundocampo= new JTextField() ;
	private JTextField textField_2= new JTextField();
	private JTextField textField_3= new JTextField();
	private String[] zerrenda= new String[30];
	private String prezioa1="";
	private JComboBox comboBox_1= new JComboBox();
	private JLabel lblPais = new JLabel("HERRIA / HIRIA");
	private JLabel label = new JLabel("Ciudad:");
	private JLabel label_1 = new JLabel("Hotel:");
	private JLabel label_2 = new JLabel("Precio:");
	private JDateChooser sartzedata = new JDateChooser();
	private JDateChooser irtetzedata = new JDateChooser();
	private int pertsona_kopurua=0;
	private String fechaComoCadena="";
	private String fechaComoCadena2="";
	private int  gela_kop=0;
	private String oheMota="";
	private String  letra_ostatu;
	private String hostatu_mota="";
	int prezioa=0;
	int ostatu_id=0;
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
	
	String herria;
	int ostatu_aukera=0;
	
	public P1(ArrayList<String> herriak) {
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
		

		//JCALENDAR LEHEN DATA
		sartzedata.setBounds(104, 191, 118, 20);
		sartzedata.setDateFormatString("yyyy-MM-dd");
		getContentPane().add(sartzedata);
		sartzedata.setSelectableDateRange(new Date(), null);
		
		
		sartzedata.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String formato = sartzedata.getDateFormatString();
				System.out.println(formato);
				 date = sartzedata.getDate();
				SimpleDateFormat sdf = new SimpleDateFormat(formato);
				
			}
		});
		
		
		//JCALENDAR BIGARREN DATA
		irtetzedata.setBounds(401, 191, 117, 20);
		irtetzedata.setDateFormatString("yyyy-MM-dd");
		getContentPane().add(irtetzedata);
		irtetzedata.setSelectableDateRange(new Date(), null);
		
		irtetzedata.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				irtetzedata.setMinSelectableDate(sartzedata.getDate());
			}
		});
		


		lblGauakgaua.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		lblGauakgaua.setBounds(18, 191, 68, 25);
		contentPane.add(lblGauakgaua);
		
		btnAurrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				herria=(String)comboBox_1.getSelectedItem();
				
				
				

				//metodos.bigarrenLehioa();

				precio = textField_2.getText();
				//precioadoubleprecio=Double.parseDouble(precio);
				
				//**************Fechas**********
				//1
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				 fechaComoCadena = sdf.format(sartzedata.getDate());
				
				//2
				 fechaComoCadena2 = sdf.format(irtetzedata.getDate());
				
				System.out.println(fechaComoCadena);
				System.out.println(fechaComoCadena2);


				
				
				
				
				
//				for(Hotela p : hotela) {
//					System.out.println(textField.getText());
//					if(p.getHerria().equalsIgnoreCase(textField.getText())) {
//						id=p.getOstatu_id();
//						
//					}
//				}
				
				//*******************SARTZEDATA*********
				data1=sartzedata.getDate();
				String formato1="dd";
			    SimpleDateFormat dateFormat = new SimpleDateFormat(formato1);
			    eguna= Integer.parseInt(dateFormat.format(data1));
			    
			    String formato2="MM";
			    SimpleDateFormat dateFormat2 = new SimpleDateFormat(formato2);
			    hila= Integer.parseInt(dateFormat2.format(data1));
			    
			    //***************IrtetzeData***********
			    
			    Date data2 = irtetzedata.getDate();
				String formato3="dd";
			    SimpleDateFormat dateFormat3 = new SimpleDateFormat(formato3);
			    int eguna2= Integer.parseInt(dateFormat3.format(data2));
			    
			    String formato4="MM";
			    SimpleDateFormat dateFormat4 = new SimpleDateFormat(formato4);
			    int hila2= Integer.parseInt(dateFormat4.format(data2));
			    
			    
				

				if(!fechaComoCadena.equalsIgnoreCase("") && !fechaComoCadena2.equalsIgnoreCase("")&& !hostatu_mota.equalsIgnoreCase("") && gela_kop!=0 && !oheMota.equalsIgnoreCase("") && pertsona_kopurua!=0) {
					if(eguna-eguna2!=0) {
					if (letra_ostatu.equalsIgnoreCase("H")) {
						
						metodos.bigarrenLehioaHotela();
						metodos.filtroHotela();
					}else if(letra_ostatu.equalsIgnoreCase("A")) {
						
						metodos.bigarrenLehioaApartamentua();
						metodos.filtroApartamentua();
					}else if(letra_ostatu.equalsIgnoreCase("E")) {
						
						metodos.bigarrenLehioaEtxea();
						metodos.filtroEtxea();}
					
					}
					
				}
				
				
			}
			
		});

		//Combo1

		comboBox_1.setBounds(140, 87, 82, 20);
		contentPane.add(comboBox_1);
		String herr="";
		int cont=0;
		ArrayList<String>arr = new ArrayList ();
		for( int i=0;i<herriak.size();i++) {
			if(cont==0) {
				comboBox_1.addItem("");
				cont++;
			}
			comboBox_1.addItem(herriak.get(i));

		}



		Segundocampo.setEditable(false);
		Segundocampo.setBorder(null);
		Segundocampo.setColumns(10);
		Segundocampo.setBounds(178, 367, 317, 40);
		contentPane.add(Segundocampo);
		
		JLabel lblNewLabel = new JLabel("CHECK-OUT");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblNewLabel.setBounds(266, 186, 89, 25);
		contentPane.add(lblNewLabel);




		

//			public void actionPerformed(ActionEvent i) {
//				
//				//String herria = (String) comboBox_1.getSelectedItem();
//			}
//		});
		int cont2=0;
		for( i=0;i<zerrenda.length;i++) {
			if(cont2==0) {
				comboBox.addItem("");
				cont2++;
			}
			comboBox.addItem(zerrenda[i]);
		}

		lblGelaKopurua.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblGelaKopurua.setBounds(18, 141, 112, 14);
		
		contentPane.add(lblGelaKopurua);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kopurua=(String) comboBox.getSelectedItem();
				 gela_kop=Integer.parseInt(kopurua);
				 System.out.println(gela_kop);
			}
		});
		comboBox.setBounds(140, 140, 49, 20);
		
		contentPane.add(comboBox);
		lblOheMota.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblOheMota.setBounds(282, 143, 82, 14);
		
		contentPane.add(lblOheMota);
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 oheMota=(String) comboBox_3.getSelectedItem();
			}
		});
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"","Banakakoa", "Bikoitza", "Umeena"}));
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
		label_3.setBounds(282, 70, 100, 50);
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
		comboBox_5.setBounds(401, 88, 94, 20);
		contentPane.add(comboBox_5);
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"","Hotela", "Apartamentua", "Etxea"}));

		
		int cont3=0;
		for(int pertsona=1;pertsona<=10;pertsona++) {
			if(cont3==0) {
				comboBox_4.addItem("");
				cont3++;
			}
			
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
	
	public String ateraHerria() {
		
		return herria;
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
