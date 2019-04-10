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
	
	private JLabel lblEskerrikAsko = new JLabel("Eskerrik asko erosteagatik ");
	private JLabel lblZureTxartelaOrain = new JLabel("Zure txartela orain aterako da");

	private Metodoak metodos;
	private final JButton btnAmaitu = new JButton("Amaitu");

	public Amaiera() {
		
		
		this.setBounds(275,100,700,600);
		getContentPane().setLayout(null);
		
		//LABEL ESKERRIK ASKO
		lblEskerrikAsko.setFont(new Font("Arial", Font.PLAIN, 46));
		lblEskerrikAsko.setBounds(71, 95, 565, 78);
		getContentPane().add(lblEskerrikAsko);
		
		//LABEL ZURE TXARTELA ORAIN
		lblZureTxartelaOrain.setFont(new Font("Arial", Font.PLAIN, 41));
		lblZureTxartelaOrain.setBounds(70, 198, 555, 45);
		getContentPane().add(lblZureTxartelaOrain);
		btnAmaitu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
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
		btnAmaitu.setBounds(193, 367, 323, 72);
		
		getContentPane().add(btnAmaitu);
		//icono.setIcon(new ImageIcon(Ventana7.class.getResource("/argazkiak/termibus.png")));
		//Metodoak m1 =new Metodoak();
//		if (this.isVisible()) {
//			Contador contador = new Contador();
//			
//			contador.run();
//			
//			
//		}
		
	}
	
	
	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}
}
