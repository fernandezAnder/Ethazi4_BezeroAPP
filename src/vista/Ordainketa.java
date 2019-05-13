package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Contador;

import controlador.DatuBiltegia;
import controlador.Erreserba;

import controlador.Metodoak;
import java.awt.Color;

public class Ordainketa extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane=new JPanel();
	private JLabel lblOrdainketa = new JLabel("ZENBATEKOA :");
	private JLabel lblSartuDirua = new JLabel("SARTU DIRUA :");
	private JLabel lblItzuliak = new JLabel("ITZULIAK :");
	private JButton btnAmaitu = new JButton("AMAITU");
	private JTextField dirua= new JTextField();
	private JButton btnEzeztatu = new JButton("EZEZTATU");
	private JButton btnAtzera = new JButton("ATZERA");
	private JButton btnOrdaindu = new JButton("ORDAINDU");
	private JTextArea Itzuliak = new JTextArea();
	private JLabel lblOrdainketa_Tituloa = new JLabel("ORDAINKETA");
	private static double preziototala=1;
	private ArrayList<Double> preziotot = new ArrayList<Double>();
	private double prezioa=0;
	private double prezio2 = 0;
	private Metodoak metodos;
	private String precio="0";
	private int precioo=0;
	private JTextField textField;
	private boolean descuento;
	private JTextArea textArea ;
	private String katea;
	private String[] parts;
	private String zergatia;
	private String kod_promozioa;
	
	int kont1=0;
	int kont2=0;
	private double dirufalta=0.0;
	private final JTextField textField_1 = new JTextField();
	private String kodigo;
	/**
	 * Create the frame.
	 */
	public Ordainketa() {
		textField_1.setBounds(263, 207, 135, 20);
		textField_1.setColumns(10);
		getContentPane().setBackground(new Color(135, 206, 250));
		getContentPane().setForeground(Color.CYAN);


		this.setBounds(275,100,700,600);
		getContentPane().setLayout(null);
		lblOrdainketa.setBounds(90, 106, 162, 34);

		//LABEL ORDAINKETA
		lblOrdainketa.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		getContentPane().add(lblOrdainketa);
		lblSartuDirua.setBounds(90, 151, 162, 37);

		//LABEL SARTU DIRUA
		lblSartuDirua.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		getContentPane().add(lblSartuDirua);
		lblItzuliak.setBounds(69, 238, 105, 34);


		//LABEL ITZULIAK
		lblItzuliak.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		getContentPane().add(lblItzuliak);
		btnAmaitu.setEnabled(false);
		btnAmaitu.setBounds(514, 467, 116, 43);

		//BOTOIA AMAITU
		btnAmaitu.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnAmaitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				metodos.recivirReserva();
				metodos.erreserbaJaiegunBete();
//				Contador contador = new Contador();
//				contador.start();
				metodos.amaieraIreki();
				


			}
		});
		getContentPane().add(btnAmaitu);




		//TEXTUA SARTZEKO DIRUA
		dirua = new JTextField();
		dirua.setHorizontalAlignment(SwingConstants.CENTER);
		dirua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dirua.setBounds(262, 157, 136, 26);
		dirua.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				if(dirua.getText().length()>=10) {
					evt.consume();	

				}
				char validar =evt.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					evt.consume();	

				}
			}
		});
		getContentPane().add(dirua);
		dirua.setColumns(10);
		btnEzeztatu.setBounds(325, 468, 136, 41);

		btnEzeztatu.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnEzeztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodos.lehenengoLehioa2();

			}
		});
		getContentPane().add(btnEzeztatu);
		btnAtzera.setBounds(165, 467, 116, 43);

		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
//				metodos.lehioaHotelaIreki();
//				metodos.p2hotetoOrdainketa2();
				
			String letra = metodos.ostatu_motaAtera();
			System.out.println(letra);
				
					if (metodos.ostatu_motaAtera().equalsIgnoreCase("H")) {
						
						metodos.bigarrenLehioaHotela();
						metodos.filtroHotela();
					}else if(metodos.ostatu_motaAtera().equalsIgnoreCase("A")) {
						
						metodos.bigarrenLehioaApartamentua();
						metodos.filtroApartamentua();
					}else if(metodos.ostatu_motaAtera().equalsIgnoreCase("E")) {
						
						metodos.bigarrenLehioaEtxea();
						metodos.filtroEtxea();
						}
					
					
					
				}

			
		});
		btnAtzera.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		getContentPane().add(btnAtzera);
		btnOrdaindu.setBounds(408, 151, 162, 37);
		//Arraylistari prezioa sartu

		
		
		//ORDAINDU BOTOIA
		btnOrdaindu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				precio=textField.getText();
				String euro = " \u20AC";
				System.out.println("preziototla "+preziototala);
				prezioa=Double.parseDouble(precio);
				String ordaindu=dirua.getText();//Sartutako diru kantitatea testu moduan gordeko da
				
				//KONPROBATU LETRA
				boolean letra=metodos.konprobatuLetra(ordaindu);
				String mezua="";
				if (letra==false) {
					double zbk= Double.parseDouble(ordaindu);//Zenbaki formatura pasatzen da

					//KONPROBATU ZENBAKI NEGATIBOA
					boolean zenbakia=metodos.konprobatuNegatibo(zbk);
					if (zenbakia==false) {
						System.out.println("Zenbakia negatiboa da.");
					}else {
						
						//KONPROBATU DIRU FALTA
						if (kont1==0) {
							preziototala=prezioa;
							kont1++;
						}else {
							
						}
						
					boolean diru_falta=metodos.diruFalta(preziototala,zbk);
					if (diru_falta==true){
					
						if (kont2==0) {
						preziototala=prezioa-zbk;
						dirufalta=(zbk-prezioa)*(-1);
						kont2++;
					
						}else {
						dirufalta=(zbk-preziototala)*(-1);
						preziototala=preziototala-zbk;
						
						
						
						
						}

						double din = dirufalta;
						mandarDirus(din);
						mezua=dirufalta+euro+" falta zaizkizu";
						Itzuliak.setText(mezua);
						
						//textField.setText(dirufalta.);       
						btnAtzera.setEnabled(false);
						btnAmaitu.setEnabled(false);
						
						

					}else {	
						double kanbioa=zbk-preziototala;
						if (kanbioa>0) {
							
							//preziototala=preziototala*(-1);
							String kanbioak=metodos.kanbioMetodoa(kanbioa);
							Itzuliak.setText(kanbioak);
							btnAmaitu.setEnabled(true);
							btnEzeztatu.setEnabled(false);
							btnAtzera.setEnabled(false);
							btnOrdaindu.setEnabled(false);
							dirua.setEditable(false);
							diru_falta=false;
						}else if(kanbioa==0) {
							mezua="Eskerrik asko erosteagatik";
							Itzuliak.setText(mezua);
							btnAmaitu.setEnabled(true);
							btnEzeztatu.setEnabled(false);
							btnAtzera.setEnabled(false);
							btnOrdaindu.setEnabled(false);
							dirua.setEditable(false);
							diru_falta=false;
						}
					
					
				}

			
				}dirua.setText("");	
		} }
	});
		btnOrdaindu.setFont(new Font("Arial Narrow", Font.BOLD, 20));

		getContentPane().add(btnOrdaindu);
		Itzuliak.setFont(new Font("Arial", Font.PLAIN, 18));

		Itzuliak.setBounds(176, 244, 435, 195);
		getContentPane().add(Itzuliak);
		Itzuliak.setEditable(false);
		String ordaintzeko = String.valueOf(prezioa);

		lblOrdainketa_Tituloa.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdainketa_Tituloa.setFont(new Font("Arial Narrow", Font.BOLD, 37));
		lblOrdainketa_Tituloa.setBounds(223, 41, 273, 43);
		getContentPane().add(lblOrdainketa_Tituloa);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setDisabledTextColor(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBounds(262, 111, 136, 26);
		getContentPane().add(textField);
		textField.setEditable(false);
		textField.setEnabled(false);
		
		getContentPane().add(textField_1);
		
		JLabel lblKodea = new JLabel("Kodea");
		lblKodea.setBounds(315, 194, 46, 14);
		getContentPane().add(lblKodea);
		
		JButton btnNewButton = new JButton("Gehitu kodea");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kodigo = textField_1.getText();
				String ordaindu=textField.getText();
				double zbk= Double.parseDouble(ordaindu);
				
				if(parts.length==3) {
					if(kodigo.equalsIgnoreCase(parts[0])) {
						double descontua=zbk*0.1;
						zbk=zbk-descontua;
						mandarDirus(zbk);
						btnNewButton.setEnabled(false);
						textField_1.setEditable(false);
						 zergatia = "Erregistratu Berria";
						 kod_promozioa = textField_1.getText();
						
					}
					if(kodigo.equalsIgnoreCase(parts[1])) {
						double descontua=zbk*0.05;
						zbk=zbk-descontua;
						zergatia = "Logueatuta";
						 kod_promozioa = textField_1.getText();
						
					}
					if(kodigo.equalsIgnoreCase(parts[2])) {
						double descontua=zbk*0.15;
						zbk=zbk-descontua;
						mandarDirus(zbk);
						btnNewButton.setEnabled(false);
						textField_1.setEditable(false);
						zergatia = "Denboraldi Baxua";
						 kod_promozioa = textField_1.getText();
						}
					}
				
				if(parts.length==2) {
					if(kodigo.equalsIgnoreCase(parts[0])) {
						double descontua=zbk*0.05;
						zbk=zbk-descontua;
						mandarDirus(zbk);
						btnNewButton.setEnabled(false);
						textField_1.setEditable(false);
						if(parts[1].equalsIgnoreCase("Temp_Baja")) {
							zergatia = "Logueatuta";
							kod_promozioa = textField_1.getText();
							}
						else {
							zergatia = "Erregistratu Berria";
							kod_promozioa = textField_1.getText();
							}
						
						}
					if(kodigo.equalsIgnoreCase(parts[1])) {
						double descontua=zbk*0.15;
						zbk=zbk-descontua;
						mandarDirus(zbk);
						btnNewButton.setEnabled(false);
						textField_1.setEditable(false);
						if(kodigo.equalsIgnoreCase("Temp_baja")) {
							zergatia = "Denboraldi Baxua";
							kod_promozioa = textField_1.getText();
						}
						else {
						zergatia = "Erregistratu Berria";
						kod_promozioa = textField_1.getText();
						}
					
					}
				}
				if(parts.length==1) {
					if(kodigo.equalsIgnoreCase(parts[0])) {
						double descontua=zbk*0.05;
						zbk=zbk-descontua;
						mandarDirus(zbk);
						btnNewButton.setEnabled(false);
						textField_1.setEditable(false);
						zergatia = "Logueatuta";
						kod_promozioa = textField_1.getText();
						}
					
					
				}
			}
				
				
					
					
					
					
				
			
		});
		btnNewButton.setBounds(408, 210, 136, 23);
		getContentPane().add(btnNewButton);
		
		 textArea = new JTextArea();
		textArea.setBounds(24, 284, 116, 155);
		getContentPane().add(textArea);
	}

































public double prezio_totala() {
	return prezioa;
}
public void mandarDirus (double dirusa) {
	String dirua = Double.toString(dirusa);
	textField.setText(dirua);
}



public void misMetodos(Metodoak metodos) {
	this.metodos=metodos;
}
public void idatzi(String textua) {
	textField.setText(textua);
	}
	public void KargatuKodeak(ArrayList <String> kodigoak) {
		
		for(int i =0;i<kodigoak.size();i++) {
			textArea.setText(kodigoak.get(i));
		}
	}
	
	public void hartu_Kodea(String kodea) {
		 katea = kodea;
		 String textarea = "";
		 System.out.println("LLgemaos a la ultima: "+katea);
		  parts = katea.split("-");
		 for(int i=0;i<parts.length;i++) {
			 if(i==0){
			 if(!parts[0].equalsIgnoreCase("null")) {
				 textarea=parts[0]+" %10 Deskotua"+"\n";
				 textArea.setText(textarea);
			 }}
			 if(i==1) {
				 if(!parts[0].equalsIgnoreCase("null")) {
					 textarea=textarea+"\n"+parts[1]+" %5 Deskotua";
					 textArea.setText(textarea);
				 }
				 else {
					 textarea=parts[1]+" %5 Deskotua";
					 textArea.setText(textarea);
				 }
			 }
			 
			 if(i==2) {
			 if(parts[2].equalsIgnoreCase("Temp_baja")) {
				 textarea=textarea+"\n"+parts[2]+" %15 Deskotua";
			 	 textArea.setText(textarea);}}
		 		 
		 	}
		 
		 
	}
			}
	

