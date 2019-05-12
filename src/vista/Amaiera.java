package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controlador.Metodoak;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class Amaiera extends JFrame {

	private JPanel contentPane;
	private Metodoak metodos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Amaiera frame = new Amaiera();
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
	public Amaiera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new MatteBorder(20, 10, 20, 10, (Color) new Color(70, 130, 180)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ESKERRIK ASKO");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 40));
		lblNewLabel.setBounds(139, 80, 320, 79);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BIDAI ON");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 40));
		lblNewLabel_1.setBounds(204, 158, 159, 56);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ERABILTZEAGATIK");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.BOLD, 40));
		lblNewLabel_2.setBounds(127, 219, 342, 79);
		contentPane.add(lblNewLabel_2);
	}

	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}

}
