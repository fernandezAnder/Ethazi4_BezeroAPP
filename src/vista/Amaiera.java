package vista;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.Contador;
import controlador.Metodoak;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Color;
/**
 * 
 * @author oier, ander, aintzane
 *
 */
public class Amaiera extends JFrame {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	private JLabel lblEskerrikAsko = new JLabel("ESKERRIK ASKO ");
	private JLabel lblZureTxartelaOrain = new JLabel("ERABILTZEAGATIK");

	private Metodoak metodos;
	private final JButton btnAmaitu = new JButton("AMAITU");
	private final JLabel lblNewLabel_1 = new JLabel("BIDAI ON");

	public Amaiera() {
		getContentPane().setBackground(new Color(135, 206, 250));
		setBackground(new Color(135, 206, 250));
		
		
		this.setBounds(275,100,700,600);
		getContentPane().setLayout(null);
		
		//LABEL ESKERRIK ASKO
		lblEskerrikAsko.setFont(new Font("Arial Narrow", Font.BOLD, 44));
		lblEskerrikAsko.setBounds(152, 52, 421, 78);
		getContentPane().add(lblEskerrikAsko);
		
		//LABEL ZURE TXARTELA ORAIN
		lblZureTxartelaOrain.setFont(new Font("Arial Narrow", Font.BOLD, 44));
		lblZureTxartelaOrain.setBounds(120, 216, 441, 45);
		getContentPane().add(lblZureTxartelaOrain);
		btnAmaitu.setBackground(new Color(135, 206, 250));
		btnAmaitu.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnAmaitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			        try {
			            TimeUnit.SECONDS.sleep(5);
			        } catch (InterruptedException e1) {
			            e1.printStackTrace();
			        }
			    
			metodos.agurratoP1();
			}
		});
		btnAmaitu.setBounds(169, 397, 347, 89);
		
		getContentPane().add(btnAmaitu);
		
		JLabel lblNewLabel = new JLabel("ONDO IBILI!");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 40));
		lblNewLabel.setBounds(232, 272, 242, 78);
		getContentPane().add(lblNewLabel);
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 44));
		lblNewLabel_1.setBounds(245, 141, 297, 40);
		
		getContentPane().add(lblNewLabel_1);
		//icono.setIcon(new ImageIcon(Ventana7.class.getResource("/argazkiak/termibus.png")));

//		Metodoak m1 =new Metodoak();
//		if (this.isVisible()) {
//			itxaron(5);
//			m1.amaiera();
//			m1.lehenengoLehioa();
//		}
//			
			
		}
		//Metodoak m1 =new Metodoak();
//		if (this.isVisible()) {
//			Contador contador = new Contador();
//			
//			contador.run();
//			
//			
//		}

	
	
	
	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}
}
