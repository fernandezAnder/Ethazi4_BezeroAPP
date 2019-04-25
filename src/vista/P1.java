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
import javax.swing.border.MatteBorder;


public class P1 extends JFrame {

	private JPanel contentPane;
	
	
	private int eguna;
	private int hila;
	private int i;
	private  int hila2;
	private int eguna2;
	int id=0;
	private Date date;
	private Date data1;
	private JTextField textField= new JTextField();
	private JTextField textField_2= new JTextField();
	private JTextField textField_3= new JTextField();
	private String[] zerrenda= new String[30];
	private String prezioa1="";
	private JComboBox comboBox_1= new JComboBox();
	private JComboBox comboBox_4 = new JComboBox();
	private JLabel lblPais = new JLabel("HERRIA / HIRIA");
	private JDateChooser sartzedata = new JDateChooser();
	private JDateChooser irtetzedata = new JDateChooser();
	private int pertsona_kopurua=0;
	private String fechaComoCadena="";
	private String fechaComoCadena2="";
	private int  gela_kop=0;
	private String oheMota="";
	private String  letra_ostatu;
	private String hostatu_mota="";
	private int prezioa=0;
	private int ostatu_id=0;
	private String ohe_kops="";
	private int ohe_kop=0;
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
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new MatteBorder(20, 10, 20, 10, (Color) new Color(70, 130, 180)));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		lblPais.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblPais.setBounds(34, 117, 112, 40);
		contentPane.add(lblPais);
		

		//JCALENDAR LEHEN DATA
		sartzedata.setBounds(112, 284, 118, 20);
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
		irtetzedata.setBounds(425, 284, 117, 20);
		irtetzedata.setDateFormatString("yyyy-MM-dd");
		getContentPane().add(irtetzedata);
		irtetzedata.setSelectableDateRange(new Date(), null);
		
		irtetzedata.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				irtetzedata.setMinSelectableDate(sartzedata.getDate());
			}
		});
		


		lblGauakgaua.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		lblGauakgaua.setBounds(34, 284, 68, 25);
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
//			    String formatoAño1="yyyy";
//			    SimpleDateFormat dateFormataño1 = new SimpleDateFormat(formatoAño1);
//			    int año1=Integer.parseInt(dateFormataño1.format(data1));
				
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
			     eguna2= Integer.parseInt(dateFormat3.format(data2));
			    
			    String formato4="MM";
			    SimpleDateFormat dateFormat4 = new SimpleDateFormat(formato4);
			     hila2= Integer.parseInt(dateFormat4.format(data2));
	
			    String formatourtea="yyyy";
			    SimpleDateFormat dateformatourtea = new SimpleDateFormat(formatourtea);
			    int urtea=Integer.parseInt(dateformatourtea.format(data1));
				data1=sartzedata.getDate();
				
				

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
						metodos.filtroEtxea();
						}
					
					}
					
				}
				
				
			}
			
		});

		//Combo1

		comboBox_1.setBounds(148, 129, 82, 20);
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
		lblNewLabel.setBounds(326, 284, 89, 25);
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
		lblGelaKopurua.setBounds(34, 177, 112, 14);
		
		contentPane.add(lblGelaKopurua);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kopurua=(String) comboBox.getSelectedItem();
				 gela_kop=Integer.parseInt(kopurua);
				 System.out.println(gela_kop);
			}
		});
		comboBox.setBounds(181, 176, 49, 20);
		
		contentPane.add(comboBox);
		lblOheMota.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblOheMota.setBounds(326, 177, 82, 14);
		
		contentPane.add(lblOheMota);
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 oheMota=(String) comboBox_3.getSelectedItem();
			}
		});
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"", "Banakakoa", "Bikoitza", "Umeena"}));
		comboBox_3.setBounds(453, 171, 89, 20);
		
		contentPane.add(comboBox_3);
		btnAurrera.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnAurrera.setBounds(430, 381, 112, 39);
		
		contentPane.add(btnAurrera);
		
		JLabel lblPertsonaKopurua = new JLabel("PERTSONA KOPURUA");
		lblPertsonaKopurua.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblPertsonaKopurua.setBounds(34, 222, 147, 25);
		contentPane.add(lblPertsonaKopurua);
		

		comboBox_4.setBounds(104, 244, 36, 20);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8"}));
		comboBox_4.setBounds(194, 226, 36, 20);

		contentPane.add(comboBox_4);
		
		JLabel label_3 = new JLabel("OSTATU MOTA");
		label_3.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		label_3.setBounds(326, 112, 100, 50);
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
		comboBox_5.setBounds(448, 129, 94, 20);
		contentPane.add(comboBox_5);
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"","Hotela", "Apartamentua", "Etxea"}));
		
		JLabel lblNewLabel_1 = new JLabel("AUKERATU NAHI DUZUNA");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1.setBounds(174, 34, 217, 41);
		contentPane.add(lblNewLabel_1);

		
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
				String pertsona_kop = comboBox_4.getSelectedItem().toString();
				pertsona_kopurua= Integer.parseInt(pertsona_kop);
				
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
}
