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
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LogIn2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn2 frame = new LogIn2();
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
	public LogIn2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new MatteBorder(20, 10, 20, 10, (Color) new Color(70, 130, 180)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("LOG IN");
		label.setFont(new Font("Arial Narrow", Font.BOLD, 40));
		label.setBounds(222, 37, 123, 92);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("ERABILTZAILEA");
		label_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		label_1.setBounds(89, 140, 134, 26);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("PASAHITZA");
		label_2.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		label_2.setBounds(89, 201, 90, 32);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.ITALIC, 30));
		textField.setColumns(10);
		textField.setBounds(222, 140, 229, 32);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.ITALIC, 30));
		passwordField.setBounds(222, 201, 229, 32);
		contentPane.add(passwordField);
		
		JButton button = new JButton("SARTU");
		button.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		button.setBounds(89, 325, 150, 32);
		contentPane.add(button);
		
		JButton button_1 = new JButton("ERREGISTRATU");
		button_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		button_1.setBounds(275, 325, 176, 32);
		contentPane.add(button_1);
	}

}
