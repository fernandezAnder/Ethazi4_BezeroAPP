package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class Baldintzak extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Baldintzak frame = new Baldintzak();
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
	public Baldintzak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ONARTU");
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton.setBounds(314, 219, 110, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ATZERA");
		btnNewButton_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton_1.setBounds(10, 220, 97, 31);
		contentPane.add(btnNewButton_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Baldintzak onartzen ditut");
		chckbxNewCheckBox.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		chckbxNewCheckBox.setBounds(138, 219, 141, 30);
		contentPane.add(chckbxNewCheckBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 51, 414, 157);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("BALDINTZAK ETA KONDIZIOAK");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel.setBounds(90, 21, 261, 14);
		contentPane.add(lblNewLabel);
	}
}
