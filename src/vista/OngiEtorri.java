package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class OngiEtorri extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OngiEtorri frame = new OngiEtorri();
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
	public OngiEtorri() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new MatteBorder(20, 10, 20, 10, (Color) new Color(70, 130, 180)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOngiEtorri = new JLabel("ONGI ETORRI");
		lblOngiEtorri.setFont(new Font("Arial Narrow", Font.BOLD, 70));
		lblOngiEtorri.setBounds(82, 49, 397, 141);
		contentPane.add(lblOngiEtorri);
		
		JButton btnNewButton = new JButton("BIDAI ON");
		btnNewButton.setBackground(new Color(70, 130, 180));
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 60));
		btnNewButton.setBounds(93, 246, 368, 150);
		contentPane.add(btnNewButton);
	}
}
