package vista;

	
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Metodoak;

public class Amaiera extends JFrame {

	private JPanel contentPane;
	private Metodoak metodos;

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	private JLabel lblEskerrikAsko = new JLabel("ESKERRIK ASKO ");
	private JLabel lblZureTxartelaOrain = new JLabel("ERABILTZEAGATIK");


	private final JButton btnAmaitu = new JButton("AMAITU");
	private final JLabel lblNewLabel_1 = new JLabel("BIDAI ON");

	public Amaiera() {
		
		getContentPane().setBackground(new Color(135, 206, 250));
		setBackground(new Color(135, 206, 250));
		
		
		this.setBounds(275,100,700,600);
		getContentPane().setLayout(null);
		
		//LABEL ESKERRIK ASKO
		lblEskerrikAsko.setFont(new Font("Arial Narrow", Font.BOLD, 44));
		lblEskerrikAsko.setBounds(154, 50, 388, 78);
		getContentPane().add(lblEskerrikAsko);
		
		//LABEL ZURE TXARTELA ORAIN
		lblZureTxartelaOrain.setFont(new Font("Arial Narrow", Font.BOLD, 44));
		lblZureTxartelaOrain.setBounds(154, 216, 413, 45);
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
			    
			metodos.agurratop1cop();
			}
		});
		btnAmaitu.setBounds(169, 397, 347, 89);
		
		getContentPane().add(btnAmaitu);
		
		JLabel lblNewLabel = new JLabel("ONDO IBILI!");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 40));
		lblNewLabel.setBounds(234, 272, 280, 78);
		getContentPane().add(lblNewLabel);
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 44));
		lblNewLabel_1.setBounds(234, 139, 232, 40);
		
		getContentPane().add(lblNewLabel_1);
	}
		//icono.setIcon(new ImageIcon(Ventana7.class.getResource("/argazkiak/termibus.png")));


	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}


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


/*Timer t = null;

public NewJFrame() {
initComponents();
t = new Timer(5000, this);
t.start();
}

@Override
public void actionPerformed(ActionEvent e) {
if(e.getSource() == t){
dispose();
}
}
} */

	
	
	


