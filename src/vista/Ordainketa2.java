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
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Ordainketa2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ordainketa2 frame = new Ordainketa2();
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
	public Ordainketa2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new MatteBorder(20, 10, 20, 10, (Color) new Color(70, 130, 180)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("ORDAINKETA");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial Narrow", Font.BOLD, 37));
		label.setBounds(151, 47, 273, 43);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("ZENBATEKOA :");
		label_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_1.setBounds(56, 101, 162, 34);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("SARTU DIRUA :");
		label_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_2.setBounds(56, 138, 162, 37);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setDisabledTextColor(Color.BLACK);
		textField.setColumns(10);
		textField.setBounds(196, 101, 136, 26);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(196, 146, 136, 26);
		contentPane.add(textField_1);
		
		JButton button = new JButton("ORDAINDU");
		button.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		button.setBounds(363, 146, 162, 26);
		contentPane.add(button);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(196, 389, 135, 26);
		contentPane.add(textField_2);
		
		JButton btnGehituKodea = new JButton("GEHITU KODEA");
		btnGehituKodea.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnGehituKodea.setBounds(363, 389, 162, 26);
		contentPane.add(btnGehituKodea);
		
		JLabel lblKodea = new JLabel("KODEA:");
		lblKodea.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblKodea.setBounds(56, 391, 70, 24);
		contentPane.add(lblKodea);
		
		JLabel label_4 = new JLabel("ITZULIAK :");
		label_4.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_4.setBounds(56, 178, 105, 34);
		contentPane.add(label_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 18));
		textArea.setEditable(false);
		textArea.setBounds(195, 183, 330, 195);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(51, 223, 116, 155);
		contentPane.add(textArea_1);
		
		JButton button_2 = new JButton("ATZERA");
		button_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		button_2.setBounds(56, 466, 116, 43);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("EZEZTATU");
		button_3.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		button_3.setBounds(228, 467, 136, 41);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("AMAITU");
		button_4.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		button_4.setEnabled(false);
		button_4.setBounds(409, 467, 116, 43);
		contentPane.add(button_4);
	}
}
