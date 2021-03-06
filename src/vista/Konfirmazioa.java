package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Font;

public class Konfirmazioa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Konfirmazioa frame = new Konfirmazioa();
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
	public Konfirmazioa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setForeground(new Color(0, 204, 255));
		contentPane.setBorder(new MatteBorder(20, 10, 20, 10, (Color) new Color(70, 130, 180)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(58, 122, 460, 203);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("ATZERA");
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton.setBounds(58, 371, 110, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EZEZTATU");
		btnNewButton_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton_1.setBounds(224, 371, 128, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("AURRERA");
		btnNewButton_2.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton_2.setBounds(414, 371, 113, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("HAU DA ZURE AUKERA");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblNewLabel.setBounds(196, 60, 156, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ZERBAIT ALDATU NAHI DUZU?");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblNewLabel_1.setBounds(183, 97, 199, 14);
		contentPane.add(lblNewLabel_1);
	}
}
