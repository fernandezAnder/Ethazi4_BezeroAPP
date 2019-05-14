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

public class Amaiera2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Amaiera2 frame = new Amaiera2();
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
	public Amaiera2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new MatteBorder(20, 10, 20, 10, (Color) new Color(70, 130, 180)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("ESKERRIK ASKO ");
		label.setFont(new Font("Arial Narrow", Font.BOLD, 44));
		label.setBounds(135, 23, 310, 78);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("BIDAI ON");
		label_1.setFont(new Font("Arial Narrow", Font.BOLD, 44));
		label_1.setBounds(205, 100, 168, 40);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("ERABILTZEAGATIK");
		label_2.setFont(new Font("Arial Narrow", Font.BOLD, 44));
		label_2.setBounds(122, 151, 347, 45);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("ONDO IBILI!");
		label_3.setFont(new Font("Arial Narrow", Font.BOLD, 40));
		label_3.setBounds(188, 191, 201, 78);
		contentPane.add(label_3);
		
		JButton button = new JButton("AMAITU");
		button.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		button.setBackground(new Color(135, 206, 250));
		button.setBounds(42, 280, 509, 144);
		contentPane.add(button);
	}
}
