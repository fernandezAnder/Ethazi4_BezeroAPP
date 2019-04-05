package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Controlador.koordinatzaile;
import Modelo.Bezeroa;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class LOGUEATU extends JFrame {
	/**
	 * LOGUEATU Jframe-aren bariableak dira.
	 */
	private JButton btnKonprobatuParametroak;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_8;
	private JButton btnLogin;
	private JTextField textField_3;
	private JLabel lblNewLabel_7;
	private JDateChooser lehendata;

	private String izena;
	private String data;
	private JLabel lblNewLabel_9;
	private JLabel lblErregistratu;

	/**
	 * LOGUEATU Jframe-aren kodea da.
	 */
	public LOGUEATU() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nan:");
		lblNewLabel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(88, 128, 58, 20);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Source Sans Pro Black", Font.ITALIC, 13));

		textField.setBounds(141, 128, 254, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 15));
		lblIzena.setBounds(88, 196, 42, 17);
		contentPane.add(lblIzena);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Source Sans Pro Black", Font.BOLD | Font.ITALIC, 13));
		izena = textField_1.getText();
		textField_1.setColumns(10);
		textField_1.setBounds(141, 194, 254, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(141, 264, 254, 20);
		contentPane.add(textField_2);

		JLabel lblAbizena = new JLabel("Abizena:");
		lblAbizena.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 15));
		lblAbizena.setBounds(68, 264, 63, 20);
		contentPane.add(lblAbizena);

		JLabel lblNewLabel_1 = new JLabel("Pasahitza:");
		lblNewLabel_1.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(61, 322, 81, 17);
		contentPane.add(lblNewLabel_1);

		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 15));
		lblPasahitza.setBounds(61, 370, 72, 17);
		contentPane.add(lblPasahitza);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Source Sans Pro Black", Font.BOLD, 15));
		btnLogin.setEnabled(false);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bezeroa bezeroa = new Bezeroa(textField.getText() + textField_5.getText().toUpperCase(),
						textField_1.getText(), textField_2.getText(), data, textField_3.getText().toUpperCase(),
						getMD5(passwordField.getText()));
				Bezeroa.txertatuBezeroa(bezeroa);
				micoordinador.logueatzekoBotoiak();

			}
		});
		btnLogin.setBounds(358, 426, 89, 23);
		contentPane.add(btnLogin);

		JButton btnKonprobatuParametroak = new JButton("Konprobatu \r\n\r\n");
		btnKonprobatuParametroak.setFont(new Font("Dialog", Font.BOLD, 15));
		btnKonprobatuParametroak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				micoordinador.balidatuInsert(textField.getText(), textField_5.getText(), textField_1.getText(),
						textField_2.getText(), textField_3.getText(), passwordField.getText(),
						passwordField_1.getText());
			}
		});
		btnKonprobatuParametroak.setBounds(172, 426, 131, 23);
		contentPane.add(btnKonprobatuParametroak);
		lehendata = new JDateChooser();
		lehendata.getCalendarButton().setBounds(97, 0, 21, 20);

		// lehenengo data
		lehendata.setBounds(399, 264, 118, 20);
		lehendata.setDateFormatString("dd-MM-yyyy");
		getContentPane().add(lehendata);
		lehendata.setLayout(null);

		JLabel lblLetra = new JLabel("Letra:");
		lblLetra.setBounds(407, 130, 63, 17);
		contentPane.add(lblLetra);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Source Sans Pro Black", Font.ITALIC, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(482, 128, 35, 20);
		contentPane.add(textField_5);

		lblNewLabel_2 = new JLabel("");

		lblNewLabel_2.setBounds(141, 153, 254, 28);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(407, 153, 110, 14);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(141, 227, 254, 14);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(141, 293, 190, 14);
		contentPane.add(lblNewLabel_5);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Source Sans Pro Black", Font.BOLD, 13));
		passwordField.setBounds(141, 320, 254, 20);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Source Sans Pro Black", Font.BOLD, 13));
		passwordField_1.setBounds(141, 368, 254, 20);
		contentPane.add(passwordField_1);

		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(141, 343, 254, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblSexua = new JLabel("Sexua(G/E):");
		lblSexua.setBounds(407, 197, 72, 14);
		contentPane.add(lblSexua);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Source Sans Pro Black", Font.ITALIC, 13));
		textField_3.setBounds(491, 194, 21, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(409, 227, 125, 20);
		contentPane.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(409, 297, 118, 14);
		contentPane.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(141, 401, 329, 14);
		contentPane.add(lblNewLabel_9);

		lblErregistratu = new JLabel("ERREGISTRATU");
		lblErregistratu.setFont(new Font("Source Sans Pro Black", Font.BOLD | Font.ITALIC, 40));
		lblErregistratu.setBounds(157, 26, 304, 79);
		contentPane.add(lblErregistratu);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				micoordinador.logueatzekoBotoiak();
			}
		});
		btnAtzera.setFont(new Font("Dialog", Font.BOLD, 15));
		btnAtzera.setBounds(57, 428, 89, 23);
		contentPane.add(btnAtzera);
	}

	/**
	 * Nan-a bidaltzen du return baten bidez. Nan-a Arraylist baten konposatutua
	 * dago.
	 * 
	 * @return
	 */
	public ArrayList<String> balidatudni() {
		ArrayList<String> nan = new ArrayList<>();
		nan.add(textField.getText());
		nan.add(textField_5.getText());
		return nan;
	}

	/**
	 * Koordinatzailearen setterra da, hau da eraldatzeko. Dena ondo koordinatzeko.
	 * 
	 * @param micoordinador
	 */
	public void setcoordinador(koordinatzaile micoordinador) {
		this.micoordinador = micoordinador;
	}

	/**
	 * String bat hartuz label-an esertzen du.
	 * 
	 * @param katea
	 */
	public void erakutsiErrorea(String katea) {
		lblNewLabel_2.setText(katea);
	}

	/**
	 * String bat hartuz label-an esertzen du.
	 * 
	 * @param katea
	 */
	public void erakutsiErrorea2(String katea) {
		lblNewLabel_3.setText(katea);
	}

	/**
	 * TetxField-en informazioa hartu eta return baten bidez bidaltzen du.
	 * 
	 * @return
	 */
	public String balidatuIzena() {
		izena = textField_1.getText();
		return izena;
	}

	/**
	 * String bat hartuz label-an esertzen du.
	 * 
	 * @param katea
	 */
	public void erakutsiErrorea3(String katea) {
		lblNewLabel_4.setText(katea);
	}

	/**
	 * TetxField-en informazioa hartu eta return baten bidez bidaltzen du.
	 * 
	 * @return
	 */
	public String balidatuAbizena() {
		String abizena = textField_2.getText();
		return abizena;
	}

	/**
	 * String bat hartuz label-an esertzen du.
	 * 
	 * @param katea
	 */
	public void erakutsiErrorea4(String katea) {
		lblNewLabel_5.setText(katea);
	}

	/**
	 * Pasahitza bidaltzen du return baten bidez. Pasahitza Arraylist baten
	 * konposatutua dago.
	 * 
	 * @return
	 */
	public ArrayList<String> balidatuPasahitza() {
		String passwd1 = "";
		String passwd2 = "";
		ArrayList<String> pasahitzak = new ArrayList<String>();
		passwd1 = passwordField.getText();
		passwd2 = passwordField_1.getText();
		pasahitzak.add(passwd1);
		pasahitzak.add(passwd2);
		return pasahitzak;

	}

	/**
	 * String bat hartuz label-an esertzen du.
	 * 
	 * @param katea
	 */
	public void erakutsiErrorea5(String katea) {
		lblNewLabel_6.setText(katea);
	}

	/**
	 * Login egiteko botoia pantailaratzen du, horrela erabilgarria egiteko.
	 */
	public void erakutsiBotoia() {
		btnLogin.setEnabled(true);
	}

	/**
	 * String bat hartuz label-an esertzen du.
	 * 
	 * @return sexua
	 */
	public String erakutsiSexua() {
		String sexua = "";
		sexua = textField_3.getText();
		return sexua;
	}

	/**
	 * String bat hartuz label-an esertzen du.
	 * 
	 * @param sexua
	 */
	public void balidatuSexua(String sexua) {
		lblNewLabel_7.setText(sexua);
	}

	/**
	 * Data hartu eta bidaltzen du return bezala.
	 * 
	 * @return
	 */
	public String ateradata() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			data = sdf.format(lehendata.getDate());
			lblNewLabel_8.setText("Ondo");
		} catch (Exception e) {
			System.out.println("Ez duzu data sartu");
			data = "";

		}
		return data;
	}

	/**
	 * String bat hartuz label-an esertzen du.
	 * 
	 * @param textua
	 */
	public void balidatuLogina(String textua) {
		lblNewLabel_9.setText(textua);
	}

	/**
	 * String bat hartuz label-an esertzen du.
	 * 
	 *  
	 */
	public void youshouldpass() {
		btnLogin.setEnabled(true);
	}

	/**
	 * String bat hartzen du eta katea MD5-ekin enkriptatzen du.
	 * 
	 * @param input
	 * @return
	 */
	
}
