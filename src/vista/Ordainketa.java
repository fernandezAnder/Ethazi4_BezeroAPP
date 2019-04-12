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
	private JLabel lblOrdainketa = new JLabel("Ordainketa :");
	private JLabel lblSartuDirua = new JLabel("Sartu Dirua :");
	private JLabel lblItzuliak = new JLabel("Itzuliak :");
	private JButton btnAmaitu = new JButton("Amaitu");
	private JTextField dirua= new JTextField();
	private JButton btnEzeztatu = new JButton("Ezeztatu");
	private JButton btnAtzera = new JButton("Atzera");
	private JButton btnOrdaindu = new JButton("Ordaindu");
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
	
	int kont1=0;
	int kont2=0;
	double dirufalta;
	/**
	 * Create the frame.
	 */
	public Ordainketa() {


		this.setBounds(275,100,700,600);
		getContentPane().setLayout(null);
		lblOrdainketa.setBounds(90, 106, 162, 34);

		//LABEL ORDAINKETA
		lblOrdainketa.setFont(new Font("Arial", Font.BOLD, 25));
		getContentPane().add(lblOrdainketa);
		lblSartuDirua.setBounds(90, 151, 162, 37);

		//LABEL SARTU DIRUA
		lblSartuDirua.setFont(new Font("Arial", Font.BOLD, 24));
		getContentPane().add(lblSartuDirua);
		lblItzuliak.setBounds(135, 199, 105, 34);


		//LABEL ITZULIAK
		lblItzuliak.setFont(new Font("Arial", Font.BOLD, 24));
		getContentPane().add(lblItzuliak);
		btnAmaitu.setEnabled(false);
		btnAmaitu.setBounds(514, 467, 97, 43);

		//BOTOIA AMAITU
		btnAmaitu.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAmaitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				metodos.recivirReserva();
				
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
		dirua.setBounds(262, 161, 136, 26);
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
		btnEzeztatu.setBounds(339, 468, 112, 41);

		btnEzeztatu.setFont(new Font("Arial", Font.PLAIN, 18));
		btnEzeztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodos.lehenengoLehioa2();

			}
		});
		getContentPane().add(btnEzeztatu);
		btnAtzera.setBounds(176, 467, 105, 43);

		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodos.lehioaHotelaIreki();
				metodos.p2hotetoOrdainketa2();

			}
		});
		btnAtzera.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(btnAtzera);
		btnOrdaindu.setBounds(470, 151, 141, 37);
		//Arraylistari prezioa sartu

		
		
		//ORDAINDU BOTOIA
		btnOrdaindu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				precio=textField.getText();
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
					
						mezua=dirufalta+" � falta zaizkizu";
						Itzuliak.setText(mezua);	
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
		
		btnOrdaindu.setFont(new Font("Arial", Font.PLAIN, 20));

		getContentPane().add(btnOrdaindu);
		Itzuliak.setFont(new Font("Arial", Font.PLAIN, 18));

		Itzuliak.setBounds(231, 244, 380, 195);
		getContentPane().add(Itzuliak);
		Itzuliak.setEditable(false);
		String ordaintzeko = String.valueOf(prezioa);

		lblOrdainketa_Tituloa.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdainketa_Tituloa.setFont(new Font("Arial", Font.BOLD, 37));
		lblOrdainketa_Tituloa.setBounds(223, 41, 273, 43);
		getContentPane().add(lblOrdainketa_Tituloa);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setDisabledTextColor(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setForeground(Color.BLACK);
		textField.setText("120");
		textField.setColumns(10);
		textField.setBounds(262, 118, 136, 26);
		getContentPane().add(textField);
		textField.setEditable(false);
		textField.setEnabled(false);






}






























public void misMetodos(Metodoak metodos) {
	this.metodos=metodos;
}
public void idatzi(String textua) {
	textField.setText(textua);
}
}
