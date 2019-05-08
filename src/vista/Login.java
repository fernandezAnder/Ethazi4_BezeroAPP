package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controlador.Metodoak;
import modelo.Consultas;
import java.awt.Color;

public class Login extends JFrame {

	
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private boolean youshouldnotpass;
	private String pasahitza;
	private String Nan;
	private String nana;
	private JLabel lblNewLabel;
	private Metodoak metodos;
	private JTextField txtCodigo;

	/**
	 * LOGIN frame-aren kodea da.
	 */
	public Login() {
		getContentPane().setBackground(new Color(135, 206, 235));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 500);
		getContentPane().setLayout(null);
		// Login textua.
		JLabel lbllogin = new JLabel("LOG IN");
		lbllogin.setFont(new Font("Arial Narrow", Font.BOLD, 40));
		lbllogin.setBounds(217, 32, 170, 92);
		getContentPane().add(lbllogin);

		// PASAHITZAREN LETRAK ETA TEXTFIELD
		JLabel lblPasahitza = new JLabel("PASAHITZA");
		lblPasahitza.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblPasahitza.setBounds(127, 210, 90, 32);
		getContentPane().add(lblPasahitza);
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Source Sans Pro Black", Font.ITALIC, 30));
		passwordField.setBounds(252, 210, 229, 32);
		getContentPane().add(passwordField);

		// ERABILTZAILEAREN LETRAK ETA TEXTFIEL
		JLabel lblErabiltzaile = new JLabel("ERABILTZAILEA");
		lblErabiltzaile.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblErabiltzaile.setBounds(90, 152, 134, 26);
		getContentPane().add(lblErabiltzaile);

		textField = new JTextField();
		textField.setFont(new Font("Source Sans Pro Semibold", Font.ITALIC, 30));
		textField.setBounds(252, 152, 229, 32);
		getContentPane().add(textField);
		textField.setColumns(10);

		// SARTU BOTOIAREN KODEA
		JButton btnSartu = new JButton("SARTU");
		btnSartu.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnSartu.setBounds(90, 362, 150, 32);
		getContentPane().add(btnSartu);

		JButton btnLogueatu = new JButton("ERREGISTRATU");
		btnLogueatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				metodos.erregistratzekoPantailara();
				
				}
		});
		btnLogueatu.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnLogueatu.setBounds(305, 361, 176, 32);
		getContentPane().add(btnLogueatu);
		
		 lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(109, 418, 201, 14);
		getContentPane().add(lblNewLabel);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setEditable(false);
		txtCodigo.setText("Codigo promocional por estar registrado: JCK");
		txtCodigo.setBounds(90, 418, 314, 32);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// botoiaren kodea
				System.out.println("LOGIN BOTOIA");
				logindatuak();
				youshouldnotpass = metodos.ateraErabiltzailea(Nan, pasahitza);
				if (youshouldnotpass == true) {
					metodos.hirugarrenLehioa();
					 nana = textField.getText();
				 
					 metodos.logueatutabai(true);
					 
					 if (metodos.ostatu_motaAtera().equalsIgnoreCase("H")) {
						 metodos.bidaliDirua();
						}else if(metodos.ostatu_motaAtera().equalsIgnoreCase("A")) {
							
						metodos.bidaliDiruaApartamentua();
						}else if(metodos.ostatu_motaAtera().equalsIgnoreCase("E")) {
							
						metodos.bidaliDiruaEtxea();
							}

				}
				else {
					
					lblNewLabel.setText("Login edo pasahitza errorea");
				}
				System.out.println(youshouldnotpass);
			}
		});
	}

	/**
	 * Eremuan jartzen diren datuak hartu eta bariableetan esertzen ditu.
	 * 
	 */
	private void logindatuak() {
		pasahitza = new String(passwordField.getPassword());
		Nan = new String(textField.getText());
		System.out.println("pasahitza: " + pasahitza);
		System.out.println("erabiltzaile: " + Nan);
	}

	
	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}
	public String ateraNana() {
		return  nana;
	}
}
