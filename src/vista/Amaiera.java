package vista;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.Contador;
import controlador.Metodoak;
/**
 * 
 * @author oier, ander, aintzane
 *
 */
public class Amaiera extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblEskerrikAsko = new JLabel("Eskerrik asko erosteagatik ");
	private JLabel lblZureTxartelaOrain = new JLabel("Zure txartela orain aterako da");
	private JLabel icono = new JLabel();

	private Metodoak metodos;

	public Amaiera() {
		
		
		this.setBounds(275,100,700,600);
		getContentPane().setLayout(null);
		
		//LABEL ESKERRIK ASKO
		lblEskerrikAsko.setFont(new Font("Arial", Font.PLAIN, 46));
		lblEskerrikAsko.setBounds(70, 95, 565, 78);
		getContentPane().add(lblEskerrikAsko);
		
		//LABEL ZURE TXARTELA ORAIN
		lblZureTxartelaOrain.setFont(new Font("Arial", Font.PLAIN, 41));
		lblZureTxartelaOrain.setBounds(70, 198, 555, 45);
		getContentPane().add(lblZureTxartelaOrain);
		
		
		
		icono.setBounds(194, 306, 307, 141);
		getContentPane().add(icono);
		//icono.setIcon(new ImageIcon(Ventana7.class.getResource("/argazkiak/termibus.png")));
//		Metodoak m1 =new Metodoak();
//		if (this.isVisible()) {
//			itxaron(5);
//			m1.amaiera();
//			m1.lehenengoLehioa();
//		}
//			
			
		}
		
	
	
	
	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}
	
	
}
