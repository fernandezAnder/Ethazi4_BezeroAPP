package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Metodoak;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.ScrollPane;

import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.DropMode;

public class Baldintzak extends JFrame {

	private JPanel contentPane;
	private Metodoak metodos;
	private JCheckBox chckbxNewCheckBox;
	private JTextArea textArea  = new JTextArea(140,140); ;
	private JScrollPane scroll;
	private JScrollBar scrollBar;
	
	
	private int cont=1;

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Baldintzak()  {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JButton btnNewButton = new JButton("ONARTU");
		btnNewButton.setBounds(262, 219, 110, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxNewCheckBox.isSelected()) {
					dispose();
				}
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		contentPane.add(btnNewButton);
		
		 chckbxNewCheckBox = new JCheckBox("Baldintzak onartzen ditut");
		 chckbxNewCheckBox.setBounds(33, 222, 169, 30);
		chckbxNewCheckBox.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		contentPane.add(chckbxNewCheckBox);

		textArea.setForeground(Color.MAGENTA);
		textArea.setBounds(1, 1, -2, 184);
		contentPane.add(textArea,BorderLayout.CENTER);
		
		scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 0, 0);
		contentPane.add(scroll);
		

		
		JLabel lblNewLabel = new JLabel("BALDINTZAK ETA KONDIZIOAK");
		lblNewLabel.setBounds(90, 21, 261, 14);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		scrollBar = new JScrollBar();
		scrollBar.setBounds(315, 51, 17, 157);
		contentPane.add(scrollBar);
		
		
		
	}
	
	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}
	public void terminos() {
		try {
			File archivo = new File("src\\controlador\\terminos_condiciones.txt");
			BufferedReader leer = new BufferedReader(new FileReader(archivo));
			String linea = leer.readLine();
			while(cont<=101) {
				
				System.out.println(linea);
				textArea.append(linea+"\n");
				linea = leer.readLine();
				cont++;
			}
			
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
	}
}
