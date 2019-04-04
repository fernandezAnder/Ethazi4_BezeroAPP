package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.*;
public class Ventana6 extends JFrame {


	private static final long serialVersionUID = 1L;
	private JLabel lblOrdainketa = new JLabel("Ordainketa :");
	private JLabel lblSartuDirua = new JLabel("Sartu Dirua :");
	private JLabel lblItzuliak = new JLabel("Itzuliak :");
	private JButton btnAmaitu = new JButton("Amaitu");
	private JTextField dirua= new JTextField();
	private JButton btnEzeztatu = new JButton("Ezeztatu");
	private JButton btnAtzera = new JButton("Atzera");
	private JButton btnOrdaindu = new JButton("Ordaindu");
	private JTextArea Itzuliak = new JTextArea();
	private JLabel lblOrdaintzeko = new JLabel("");
	private JLabel lblOrdainketa_Tituloa = new JLabel("ORDAINKETA");

	
	private double preziototala=0;
	private ArrayList<Double> preziotot = new ArrayList<Double>();
	private double prezioa;
	private double prezio2 = 0;
	
	private int erreserba_kod=1234;
	private int ostatu_id=234;
	private String bezero_nan="12345678Z";
	private String sartze_data="04-04-2019";
	private String irtetze_data="10-04-2019";
	private int pertsona_kop=2;
	private double prezio_totala=500;
	private int erreserba_gela_kop=1;
	private String pentsio_mota="OSOA";
	private String ohe_mota="BIKOITZA";
	private int ohe_kop=1;
	private String tarifa_denboraldia="OPORRAK";

	public Ventana6(String prezioa1) {
		
		prezioa=Integer.parseInt(prezioa1);
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
				dispose();
				Erreserba r1= new Erreserba(erreserba_kod, ostatu_id, bezero_nan,
						sartze_data, irtetze_data, pertsona_kop, prezio_totala, 
						erreserba_gela_kop, pentsio_mota, ohe_mota, ohe_kop, tarifa_denboraldia);
				Metodoak.imprimatuTiketa(r1);
				Contador contador = new Contador();
				contador.start();
				
			}
		});
		getContentPane().add(btnAmaitu);

		//TEXTUA SARTZEKO DIRUA
		dirua = new JTextField();
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
				dispose();
				Metodoak.lehenengoLehioa();
				
			}
		});
		getContentPane().add(btnEzeztatu);
		btnAtzera.setBounds(176, 467, 105, 43);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				Metodoak.lehenengoLehioa();
				
			}
		});
		btnAtzera.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(btnAtzera);
		btnOrdaindu.setBounds(470, 151, 141, 37);
		//Arraylistari prezioa sartu
		preziotot.add(prezioa);
		//ORDAINDU BOTOIA
		btnOrdaindu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Prezioa Arraylistean sartzen da


				String ordaindu=(String) dirua.getText();//Sartutako diru kantitatea testu moduan gordeko da

				//KONPROBATU LETRA
				boolean letra=Metodoak.konprobatuLetra(ordaindu);
				String mezua="";

				if (letra==false) {
					double zbk= Double.parseDouble(ordaindu);//Zenbaki formatura pasatzen da


					//KONPROBATU ZENBAKI NEGATIBOA
					boolean zenbakia=Metodoak.konprobatuNegatibo(zbk);
					if (zenbakia==true){ 
						System.out.println(preziotot.get(preziotot.size()-1));

						prezio2 = preziotot.get(preziotot.size()-1);
						preziototala = (double)prezio2-zbk;
						boolean diru_falta=Metodoak.diruFalta(zbk, prezio2);
						//KONPROBATU DIRU FALTA
						if (diru_falta==true){
							preziotot.add(preziototala);
							mezua=(preziotot.get(preziotot.size()-1)+" € falta zaizkizu");
							Itzuliak.setText(mezua);	
							btnAtzera.setEnabled(false);
							btnAmaitu.setEnabled(false);

						}else {
							if (preziototala<0) {

								preziototala=preziototala*(-1);
								String kanbioak=Metodoak.kanbioMetodoa(preziototala);
								Itzuliak.setText(kanbioak);
								btnAmaitu.setEnabled(true);
								btnEzeztatu.setEnabled(false);
								btnAtzera.setEnabled(false);
								btnOrdaindu.setEnabled(false);
								dirua.setEditable(false);
							}else if(preziototala==0) {
								mezua="Eskerrik asko erosteagatik";
								Itzuliak.setText(mezua);
								btnAmaitu.setEnabled(true);
								btnEzeztatu.setEnabled(false);
								btnAtzera.setEnabled(false);
								btnOrdaindu.setEnabled(false);
								dirua.setEditable(false);
							}
						}
					}

				}
				dirua.setText("");	
			}
		});
		btnOrdaindu.setFont(new Font("Arial", Font.PLAIN, 20));

		getContentPane().add(btnOrdaindu);
		Itzuliak.setFont(new Font("Arial", Font.PLAIN, 18));

		Itzuliak.setBounds(231, 244, 380, 195);
		getContentPane().add(Itzuliak);
		Itzuliak.setEditable(false);
		String ordaintzeko = String.valueOf(prezioa);
		lblOrdaintzeko.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdaintzeko.setText(ordaintzeko);
		lblOrdaintzeko.setFont(new Font("Arial", Font.PLAIN, 18));
		lblOrdaintzeko.setBounds(274, 112, 52, 30);
		getContentPane().add(lblOrdaintzeko);
		
		lblOrdainketa_Tituloa.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdainketa_Tituloa.setFont(new Font("Arial", Font.BOLD, 37));
		lblOrdainketa_Tituloa.setBounds(223, 41, 273, 43);
		getContentPane().add(lblOrdainketa_Tituloa);

	}
}