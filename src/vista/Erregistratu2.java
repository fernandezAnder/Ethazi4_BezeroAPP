package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Erregistratu2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Erregistratu2 frame = new Erregistratu2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Erregistratu2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new MatteBorder(20, 10, 20, 10, (Color) new Color(70, 130, 180)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("SARTU ZURE DATUAK");
		label.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		label.setBounds(131, 29, 278, 37);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("IZENA");
		label_2.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		label_2.setBounds(66, 111, 63, 28);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(159, 111, 109, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(159, 150, 109, 28);
		contentPane.add(textField_1);
		
		JLabel label_3 = new JLabel("ABIZENA");
		label_3.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		label_3.setBounds(66, 150, 92, 28);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("JAIOTZE DATA");
		label_4.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		label_4.setBounds(293, 111, 116, 28);
		contentPane.add(label_4);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setVerifyInputWhenFocusTarget(false);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(400, 111, 122, 28);
		contentPane.add(dateChooser);
		
		JLabel label_1 = new JLabel("DATU PERTSONALAK  --------------------------------------------------------------------------------------------------");
		label_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		label_1.setBounds(66, 78, 552, 22);
		contentPane.add(label_1);
		
		JLabel label_5 = new JLabel("ERABILTZAILE DATUAK  ------------------------------------------------------------------------------------------------\r\n");
		label_5.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		label_5.setBounds(66, 189, 552, 22);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("NAN");
		label_6.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		label_6.setBounds(66, 222, 40, 28);
		contentPane.add(label_6);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(159, 222, 109, 28);
		contentPane.add(textField_2);
		
		JLabel label_7 = new JLabel("LETRA");
		label_7.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		label_7.setBounds(293, 222, 63, 28);
		contentPane.add(label_7);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(355, 222, 32, 28);
		contentPane.add(textField_3);
		
		JLabel label_8 = new JLabel("PASAHITZA");
		label_8.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		label_8.setBounds(66, 261, 92, 28);
		contentPane.add(label_8);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(159, 261, 170, 28);
		contentPane.add(passwordField);
		
		JButton button = new JButton("EZEZTATU");
		button.setFont(new Font("Dialog", Font.BOLD, 16));
		button.setBounds(66, 361, 122, 44);
		contentPane.add(button);
		
		JButton button_1 = new JButton("BALIDATU");
		button_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		button_1.setBounds(235, 361, 128, 44);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("JARRAITU");
		button_2.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		button_2.setEnabled(false);
		button_2.setBounds(407, 361, 115, 44);
		contentPane.add(button_2);
	}
}
