package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Metodoak;
import javax.swing.JTextField;

public class Fin extends JFrame {

	private JPanel contentPane;
	private JLabel lblEskerrikAsko = new JLabel("Eskerrik asko erosteagatik ");
	private JLabel lblZureTxartelaOrain = new JLabel("Zure txartela orain aterako da");
	private Metodoak metodos;
	private final JTextField txtWqdewfwefewfweffffffffff = new JTextField();
	

	/**
	 * Create the frame.
	 */
	public Fin()  {
		txtWqdewfwefewfweffffffffff.setBounds(162, 54, 517, 20);
		txtWqdewfwefewfweffffffffff.setText("wqdewfwefewfweffffffffff");
		txtWqdewfwefewfweffffffffff.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(275,100,700,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
				contentPane.setLayout(null);
		
		//LABEL ESKERRIK ASKO
				lblEskerrikAsko.setFont(new Font("Arial", Font.PLAIN, 46));
				lblEskerrikAsko.setBounds(70, 95, 565, 78);
				getContentPane().add(lblEskerrikAsko);
				
				//LABEL ZURE TXARTELA ORAIN
				lblZureTxartelaOrain.setFont(new Font("Arial", Font.PLAIN, 41));
				lblZureTxartelaOrain.setBounds(70, 198, 555, 45);
				getContentPane().add(lblZureTxartelaOrain);
				
				contentPane.add(txtWqdewfwefewfweffffffffff);
		
		
		
		
		
		
	}
	
	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}
	
	

}
