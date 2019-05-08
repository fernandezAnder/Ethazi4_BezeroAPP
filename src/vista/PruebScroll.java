package vista;

 import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

 import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

 import controlador.Metodoak;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

 public class PruebScroll extends JFrame {

 	private JPanel contentPane;
	private JTextArea jt;
	private Metodoak metodos;

 	/**
	 * Launch the application.
	 */


 	/**
	 * Create the frame.
	 */
	public PruebScroll() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 contentPane.setLayout(null);

 		 jt = new JTextArea(10,10);
		 jt.setEditable(false);
		 jt.setBounds(26, -101, 572, 305);
		contentPane.add(jt,BorderLayout.CENTER);
		JScrollPane sc = new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sc.setBounds(55, 65, 524, 391);
		contentPane.add(sc);

 		JCheckBox Aceptar = new JCheckBox("Aceptar");
		Aceptar.setBounds(98, 20, 97, 23);
		contentPane.add(Aceptar);

 		JButton btnNewButton = new JButton("Aurrera");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Aceptar.isSelected()) {
					dispose();
				}
			}
		});
		btnNewButton.setBounds(302, 20, 104, 23);
		contentPane.add(btnNewButton);





 	}

 	public void terminos() {
		int cont=0;
		try {
			File archivo = new File("src\\controlador\\terminos_condiciones.txt");
			BufferedReader leer = new BufferedReader(new FileReader(archivo));
			String linea = leer.readLine();
			while(cont<=101) {

 				System.out.println(linea);
				jt.append(linea+"\n");
				linea = leer.readLine();
				cont++;
			}

 			}catch(Exception e){
				System.out.println(e.getMessage());
			}
	}
	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}
}