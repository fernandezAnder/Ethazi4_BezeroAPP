package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.toedter.calendar.JDateChooser;

import controlador.Erreserba;
import controlador.Metodoak;
import javafx.scene.control.ComboBox;


public class P1_copia extends JFrame {

	private JPanel contentPane;
	
	
	private int eguna;
	private int hila;
	private int i;
	private  int hila2;
	private int eguna2;
	int id=0;
	private Date date;
	private Date data1;
	private JRadioButton radio_wifi;
	private JRadioButton radio_igerilekua;
	private JRadioButton radio_aire;
	private JRadioButton radio_taberna;
	private JRadioButton radio_spa;
	private JRadioButton radio_aparkalekua;
	private JRadioButton radio_gim;
	private JRadioButton radio_jate;
	private JCheckBox chckbxNewCheckBox;
	
	/*Filtroak eramango dituen aldagaik*/
	//[herria,ostatu_mota,]
	private String herria;
	private String  letra_ostatu;
	private int pertsona_kopurua=0;
	private int  gela_kop=0;
	private String oheMota="";
	private String gela_mota;
	private Double maximoa;
	private Double minimo;
	
	private String hostatu_mota="";
	private JTextField textField= new JTextField();
	private JTextField textField_2= new JTextField();
	private JTextField textField_3= new JTextField();
	private String[] zerrenda= new String[30];
	private String prezioa1="";
	private JComboBox comboBox_1= new JComboBox();
	private JComboBox comboBox_4 = new JComboBox();
	private JComboBox comboBox_gelamota;
	private JLabel lblPais = new JLabel("HERRIA / HIRIA");
	private JDateChooser sartzedata = new JDateChooser();
	private JDateChooser irtetzedata = new JDateChooser();
	private JLabel label_3 = new JLabel("OSTATU MOTA");
	private String fechaComoCadena="";
	private String fechaComoCadena2="";
	private JComboBox preziomin;
	private JComboBox preziomax;
	private JComboBox comboBox_pertsonakop;
	private JLabel lblPertsonaKopurua = new JLabel("PERTSONA KOPURUA");
	private JLabel lblMax = new JLabel("MAX:");
	private JLabel lblMin = new JLabel("MIN:");
	private JLabel lblPrezioa = new JLabel("PREZIOA:");
	private JComboBox comboBox_5 = new JComboBox();
	JLabel lblNewLabel_1 = new JLabel("AUKERATU NAHI DUZUNA");
	
	private String letra;
	
	private int prezioa=0;
	private int ostatu_id=0;
	private String ohe_kops="";
	private int ohe_kop=0;
	private JLabel lblGauakgaua = new JLabel("CHECK-IN");
	String gela_mota2;
	private Metodoak m1;
	//para poder hacer setVisible sin que se joda
	private Metodoak metodos;
	private String precio="";
	private double precioadoubleprecio=0.0;
	private Erreserba erreserba;
	private final JLabel lblGelaKopurua = new JLabel("GELA KOPURUA");
	private final JComboBox comboBox_gelakop = new JComboBox();
	private final JLabel lblOheMota = new JLabel("OHE MOTA");
	private final JComboBox comboBox_ohemota = new JComboBox();
	private final JButton btnAurrera = new JButton("AURRERA");
	
	
	int ostatu_aukera=0;
	private final JLabel lblZerbitzuGehigarriak = new JLabel("ZERBITZU GEHIGARRIAK:");
	private JLabel lblGelaMota;
	
	public P1_copia(ArrayList<String> herriak) {
		rellenar();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 617);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new MatteBorder(20, 10, 20, 10, (Color) new Color(70, 130, 180)));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		lblPais.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblPais.setBounds(34, 117, 120, 40);
		contentPane.add(lblPais);
		

		//JCALENDAR LEHEN DATA
		sartzedata.setBounds(140, 284, 118, 20);
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
		irtetzedata.setBounds(141, 342, 117, 20);
		irtetzedata.setDateFormatString("yyyy-MM-dd");
		getContentPane().add(irtetzedata);
		irtetzedata.setSelectableDateRange(new Date(), null);
		
		irtetzedata.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				irtetzedata.setMinSelectableDate(sartzedata.getDate());
			}
		});
		


		lblGauakgaua.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		lblGauakgaua.setBounds(34, 279, 120, 25);
		contentPane.add(lblGauakgaua);
		
		btnAurrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				
				

				//metodos.bigarrenLehioa();

				precio = textField_2.getText();
				//precioadoubleprecio=Double.parseDouble(precio);
				
				//**************Fechas**********
				//1
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				try {
					 fechaComoCadena = sdf.format(sartzedata.getDate());
						
						//2
						 fechaComoCadena2 = sdf.format(irtetzedata.getDate());
				}catch(Exception m){
					System.out.println(m.getMessage());
				}
				
				
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
//			    String formatoAño1="yyyy";
//			    SimpleDateFormat dateFormataño1 = new SimpleDateFormat(formatoAño1);
//			    int año1=Integer.parseInt(dateFormataño1.format(data1));
				
				data1=sartzedata.getDate();
				
				String formato1="dd";
			    SimpleDateFormat dateFormat = new SimpleDateFormat(formato1);
			    try {
			    	eguna= Integer.parseInt(dateFormat.format(data1));
			    }catch(Exception fecha1) {
			    	System.out.println(fecha1.getMessage());
			    }
			    
			    
			    String formato2="MM";
			    SimpleDateFormat dateFormat2 = new SimpleDateFormat(formato2);
			    try {
			    	hila= Integer.parseInt(dateFormat2.format(data1));
			    }catch(Exception kk) {
			    	System.out.println(kk.getMessage());
			    }
			    
			    
			    //***************IrtetzeData***********
			    
			    Date data2 = irtetzedata.getDate();
				String formato3="dd";
			    SimpleDateFormat dateFormat3 = new SimpleDateFormat(formato3);
			    try {
			    	eguna2= Integer.parseInt(dateFormat3.format(data2));
			    }catch(Exception kk2) {
			    	 
			    }
			    
			    
			    String formato4="MM";
			    SimpleDateFormat dateFormat4 = new SimpleDateFormat(formato4);
			    
			     try {
			    	 hila2= Integer.parseInt(dateFormat4.format(data2));
				    }catch(Exception kk2) {
				    	 
				    }
	
			    String formatourtea="yyyy";
			    
				
				  try {
					  SimpleDateFormat dateformatourtea = new SimpleDateFormat(formatourtea);
					    int urtea=Integer.parseInt(dateformatourtea.format(data1));
						data1=sartzedata.getDate();
					    }catch(Exception kk2) {
					    	 
					    }
				
				

				if(!fechaComoCadena.equalsIgnoreCase("") && !fechaComoCadena2.equalsIgnoreCase("")&& !hostatu_mota.equalsIgnoreCase("") && gela_kop!=0 ) {
					if(eguna-eguna2!=0) {
					if (letra_ostatu.equalsIgnoreCase("H")) {
						letra=letra_ostatu;
						gela_mota2=comboBox_gelamota.getSelectedItem().toString();
						System.out.println(gela_mota2+": gelamota");
						metodos.ostatu_motaHartu(letra);
						metodos.bigarrenLehioaHotela();
						metodos.filtroHotela();
					}else if(letra_ostatu.equalsIgnoreCase("A")) {
						letra=letra_ostatu;
						metodos.ostatu_motaHartu(letra);
						metodos.bigarrenLehioaApartamentua();
						metodos.filtroApartamentua();
					}else if(letra_ostatu.equalsIgnoreCase("E")) {
						letra=letra_ostatu;
						metodos.ostatu_motaHartu(letra);
						metodos.bigarrenLehioaEtxea();
						metodos.filtroEtxea();
						}
					
					}
					
				}
				
				
			}
			
			
		});
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				herria=(String)comboBox_1.getSelectedItem();
			}
		});

		//Combo1

		comboBox_1.setBounds(176, 130, 94, 20);
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
		
		JLabel lblNewLabel = new JLabel("CHECK-OUT");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblNewLabel.setBounds(34, 337, 112, 25);
		contentPane.add(lblNewLabel);




		

//			public void actionPerformed(ActionEvent i) {
//				
//				//String herria = (String) comboBox_1.getSelectedItem();
//			}
//		});
		int cont2=0;
		for( i=0;i<zerrenda.length;i++) {
			if(cont2==0) {
				comboBox_gelakop.addItem("");
				cont2++;
			}
			comboBox_gelakop.addItem(zerrenda[i]);
		}

		lblGelaKopurua.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblGelaKopurua.setBounds(29, 177, 130, 14);
		
		contentPane.add(lblGelaKopurua);
		comboBox_gelakop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kopurua=(String) comboBox_gelakop.getSelectedItem();
				 gela_kop=Integer.parseInt(kopurua);
				 System.out.println(gela_kop);
			}
		});
		comboBox_gelakop.setBounds(221, 177, 49, 20);
		
		contentPane.add(comboBox_gelakop);
		lblOheMota.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblOheMota.setBounds(471, 177, 89, 14);
		
		contentPane.add(lblOheMota);
		comboBox_ohemota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 oheMota=(String) comboBox_ohemota.getSelectedItem();
			}
		});
		comboBox_ohemota.setModel(new DefaultComboBoxModel(new String[] {"", "Banakakoa", "Bikoitza", "Umeena"}));
		comboBox_ohemota.setBounds(607, 176, 94, 20);
		
		contentPane.add(comboBox_ohemota);
		btnAurrera.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnAurrera.setBounds(521, 475, 180, 69);
		
		contentPane.add(btnAurrera);
		
		
		lblPertsonaKopurua.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblPertsonaKopurua.setBounds(29, 222, 171, 25);
		contentPane.add(lblPertsonaKopurua);
		

		comboBox_4.setBounds(104, 244, 36, 20);

		 comboBox_pertsonakop = new JComboBox();
		comboBox_pertsonakop.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8"}));
		comboBox_pertsonakop.setBounds(234, 227, 36, 20);

		contentPane.add(comboBox_pertsonakop);
		
		
		label_3.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		label_3.setBounds(472, 112, 125, 50);
		contentPane.add(label_3);
		
	
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 hostatu_mota=(String) comboBox_5.getSelectedItem();
				 
				 letra_ostatu="";
				if(hostatu_mota.equalsIgnoreCase("Hotela")) {
					
					letra_ostatu="H";
					lblOheMota.setVisible(true);
					comboBox_ohemota.setVisible(true);
					lblPertsonaKopurua.setVisible(true);
					comboBox_pertsonakop.setVisible(true);
					lblGelaMota.setVisible(true);
					comboBox_gelamota.setVisible(true);
				}
				if(hostatu_mota.equalsIgnoreCase("Apartamentua")) {
					
					letra_ostatu="A";
					lblOheMota.setVisible(false);
					comboBox_ohemota.setVisible(false);
					lblPertsonaKopurua.setVisible(false);
					comboBox_pertsonakop.setVisible(false);
					lblGelaMota.setVisible(false);
					comboBox_gelamota.setVisible(false);
					
				}
				if(hostatu_mota.equalsIgnoreCase("Etxea")) {
					letra_ostatu="E";
					lblOheMota.setVisible(false);
					comboBox_ohemota.setVisible(false);
					lblPertsonaKopurua.setVisible(false);
					comboBox_pertsonakop.setVisible(false);
					lblGelaMota.setVisible(false);
					comboBox_gelamota.setVisible(false);
					
				}
			}
		});
		comboBox_5.setBounds(607, 129, 94, 20);
		contentPane.add(comboBox_5);
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"","Hotela", "Apartamentua", "Etxea"}));
		
		
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1.setBounds(232, 32, 222, 41);
		contentPane.add(lblNewLabel_1);
		
		
		lblPrezioa.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblPrezioa.setBounds(471, 279, 66, 25);
		contentPane.add(lblPrezioa);
		
		
		lblMax.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblMax.setBounds(471, 313, 66, 25);
		contentPane.add(lblMax);
		
		
		lblMin.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblMin.setBounds(471, 359, 66, 25);
		contentPane.add(lblMin);
		
		 preziomax = new JComboBox();
		preziomax.setBounds(607, 317, 94, 20);
		contentPane.add(preziomax);
		precio_max();
		 preziomax.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		 maximoa =(Double) preziomax.getSelectedItem();
			 	}
			 });
		
		
		
		 preziomin = new JComboBox();
		 preziomin.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		 minimo = (Double) preziomin.getSelectedItem();
		 	}
		 });
		preziomin.setBounds(607, 363, 94, 20);
		contentPane.add(preziomin);
		precio_min();
		lblZerbitzuGehigarriak.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblZerbitzuGehigarriak.setBounds(39, 404, 180, 25);
		
		contentPane.add(lblZerbitzuGehigarriak);
			/******Radio piscina*****/
		radio_wifi = new JRadioButton("Wifi");
		radio_wifi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radio_wifi.isSelected();
				
			}
		});
		radio_wifi.setBounds(39, 475, 60, 23);
		contentPane.add(radio_wifi);
		radio_wifi.setEnabled(false);
		/******Radio piscina*****/
		 radio_igerilekua = new JRadioButton("Igerilekua");
		 radio_igerilekua.setEnabled(false);
		radio_igerilekua.setBounds(128, 475, 91, 23);
		contentPane.add(radio_igerilekua);
		radio_wifi.setEnabled(false);
		
		 radio_aire = new JRadioButton("Aire Girotua");
		 radio_aire.setEnabled(false);
		radio_aire.setBounds(254, 475, 94, 23);
		contentPane.add(radio_aire);
		
		 radio_taberna = new JRadioButton("Taberna");
		 radio_taberna.setEnabled(false);
		radio_taberna.setBounds(392, 475, 71, 23);
		contentPane.add(radio_taberna);
		
		 radio_spa = new JRadioButton("Spa");
		 radio_spa.setEnabled(false);
		radio_spa.setBounds(39, 521, 60, 23);
		contentPane.add(radio_spa);
		
		 radio_aparkalekua = new JRadioButton("Aparkalekua");
		 radio_aparkalekua.setEnabled(false);
		radio_aparkalekua.setBounds(128, 521, 91, 23);
		contentPane.add(radio_aparkalekua);
		
		 radio_gim = new JRadioButton("Gimnasioa");
		 radio_gim.setEnabled(false);
		radio_gim.setBounds(254, 521, 94, 23);
		contentPane.add(radio_gim);
		
		 radio_jate = new JRadioButton("Jatetxea");
		 radio_jate.setEnabled(false);
		radio_jate.setBounds(392, 521, 71, 23);
		contentPane.add(radio_jate);
		
		 chckbxNewCheckBox = new JCheckBox("");
		 chckbxNewCheckBox.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		if (chckbxNewCheckBox.isSelected()) {
		 		radio_aire.setEnabled(true);
		 		radio_aparkalekua.setEnabled(true);
		 		radio_gim.setEnabled(true);
		 		radio_igerilekua.setEnabled(true);
		 		radio_jate.setEnabled(true);
		 		radio_spa.setEnabled(true);
		 		radio_taberna.setEnabled(true);
		 		radio_wifi.setEnabled(true);
		 		}
		 		else {
		 			radio_aire.setEnabled(false);
			 		radio_aparkalekua.setEnabled(false);
			 		radio_gim.setEnabled(false);
			 		radio_igerilekua.setEnabled(false);
			 		radio_jate.setEnabled(false);
			 		radio_spa.setEnabled(false);
			 		radio_taberna.setEnabled(false);
			 		radio_wifi.setEnabled(false);
		 		}
		 		
		 	}
		 });
		chckbxNewCheckBox.setBounds(232, 404, 26, 23);
		contentPane.add(chckbxNewCheckBox);
		
		lblGelaMota = new JLabel("GELA MOTA");
		lblGelaMota.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblGelaMota.setBounds(471, 227, 89, 14);
		contentPane.add(lblGelaMota);
		
		comboBox_gelamota = new JComboBox();
		
		comboBox_gelamota.setBounds(607, 226, 94, 20);
		contentPane.add(comboBox_gelamota);
		gela_mota();
		comboBox_gelamota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 gela_mota = (String) comboBox_gelamota.getSelectedItem();
				}
		});
		
		
		int cont3=0;
		for(int pertsona=1;pertsona<=10;pertsona++) {
			if(cont3==0) {
				comboBox_pertsonakop.addItem("");
				cont3++;
			}
			
			comboBox_pertsonakop.addItem(pertsona);
		}
		
		comboBox_pertsonakop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String pertsona_kop = comboBox_pertsonakop.getSelectedItem().toString();
				pertsona_kopurua= Integer.parseInt(pertsona_kop);
				}catch(Exception num) {
					System.out.println(num.getMessage());
				}
				
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
	
//	public String bidalidirus() {
//		return precio;
//	}
	
	public String ateraHerria() {
		
		return herria;
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
	public int ohe_kop() {
		return ohe_kop;
	}

	public String ostatua() {
		letra=hostatu_mota;
		return letra;
	}
	
	public int diadif() {
		int dias=0;
		int meses = hila2-hila;
		if(meses==0) {
			dias=eguna2-eguna;
		}
		else {
			meses = 30*meses;
			dias = meses-eguna+eguna2;
		}
		
		return dias;
	}
	public void precio_max() {
		ArrayList<Double> pre_max= new ArrayList<Double>() ;
		pre_max.add(1000.00);
		pre_max.add(900.00);
		pre_max.add(800.00);
		pre_max.add(700.00);
		pre_max.add(600.00);
		pre_max.add(500.00);
		for(int i=0;i<pre_max.size();i++) {
			preziomax.addItem(pre_max.get(i));
		}
	}
	public void precio_min() {
		ArrayList<Double> pre_min= new ArrayList<Double>() ;
		pre_min.add(10.00);
		pre_min.add(20.00);
		pre_min.add(30.00);
		pre_min.add(40.00);
		pre_min.add(80.00);
		pre_min.add(100.00);
		for(int i=0;i<pre_min.size();i++) {
			preziomin.addItem(pre_min.get(i));
		}
	}
	public String gelamota() {
		
		return gela_mota2;
	}
	public void gela_mota() {
		comboBox_gelamota.addItem("");
		comboBox_gelamota.addItem("Suite");
		comboBox_gelamota.addItem("Banakakoa");
		comboBox_gelamota.addItem("Bikoitza");

	}
}
