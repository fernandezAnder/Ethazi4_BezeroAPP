package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controlador.Metodoak;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private boolean youshouldnotpass;
	private String pasahitza;
	private String Nan;

	/**
	 * LOGIN frame-aren kodea da.
	 */
	public Login() {
		getContentPane().setBackground(UIManager.getColor("Button.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		getContentPane().setLayout(null);
		// Login textua.
		JLabel lbllogin = new JLabel("LOGIN");
		lbllogin.setFont(new Font("Arial Black", Font.PLAIN, 70));
		lbllogin.setBounds(157, 25, 248, 92);
		getContentPane().add(lbllogin);

		// PASAHITZAREN LETRAK ETA TEXTFIELD
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 30));
		lblPasahitza.setBounds(90, 210, 150, 32);
		getContentPane().add(lblPasahitza);
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Source Sans Pro Black", Font.ITALIC, 30));
		passwordField.setBounds(252, 210, 229, 32);
		getContentPane().add(passwordField);

		// ERABILTZAILEAREN LETRAK ETA TEXTFIEL
		JLabel lblErabiltzaile = new JLabel("Erabiltzaile:");
		lblErabiltzaile.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 30));
		lblErabiltzaile.setBounds(63, 155, 167, 26);
		getContentPane().add(lblErabiltzaile);

		textField = new JTextField();
		textField.setFont(new Font("Source Sans Pro Semibold", Font.ITALIC, 30));
		textField.setBounds(252, 152, 229, 32);
		getContentPane().add(textField);
		textField.setColumns(10);

		// SARTU BOTOIAREN KODEA
		JButton btnSartu = new JButton("SARTU");
		btnSartu.setFont(new Font("Source Sans Pro Semibold", Font.ITALIC, 15));
		btnSartu.setBounds(83, 282, 176, 32);
		getContentPane().add(btnSartu);

		JButton btnLogueatu = new JButton("ERREGISTRATU");
		btnLogueatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Erregistratu ventana2b= new Erregistratu();
				ventana2b.setVisible(true);
				
			}
		});
		btnLogueatu.setFont(new Font("Source Code Pro Black", Font.BOLD, 15));
		btnLogueatu.setBounds(309, 281, 176, 32);
		getContentPane().add(btnLogueatu);
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// botoiaren kodea
				System.out.println("LOGIN BOTOIA");
				logindatuak();
				youshouldnotpass = Metodoak.ateraErabiltzailea(Nan, pasahitza);
				if (youshouldnotpass == true) {
					Metodoak.hirugarrenLehioa();

				}
				System.out.println(youshouldnotpass);
			}
		});
	}

	/**
	 * Eremuan jartzen diren datuak hartu eta bariableetan esertzen ditu.
	 */
	private void logindatuak() {
		pasahitza = new String(passwordField.getPassword());
		Nan = new String(textField.getText());
		System.out.println("pasahitza: " + pasahitza);
		System.out.println("erabiltzaile: " + Nan);
	}

	
	/**
	 * Return baten bide NaN-a bidaltzen du.
	 * @return
	 */
	

}
