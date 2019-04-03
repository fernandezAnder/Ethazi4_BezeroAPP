package vista;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class P1 extends JFrame {

	private JPanel contentPane;
	private JMenuItem Espainia;
	private JMenuItem Frantzia;
	private JMenuBar Hotela;
	private JMenuItem G1 ;
	private int i;
	private String España="Bilbao";
	private String Francia="Paris";
	private String H1="NH";
	private String H2="Hilton";
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String[] zerrenda= new String[30];
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P1 frame = new P1();
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
	public P1() {
		rellenar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// JMenuBar ezartzeko kodea
				JMenuBar ibilbideaktermi = new JMenuBar();
				ibilbideaktermi.setBounds(20, 125, 100, 40);
				// Hemen aplikatuko diren elementuen kodea
				// lineak:
				JMenu nondiknora = new JMenu("Procedencia");
				// JMenu nora = new JMenu ("Nora");
				// Linea Bakoitza haren kodearekin klik egiterakoan(NORA):
				Espainia = new JMenuItem(España);
				Espainia.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent plentzia1) {
						textField.setText(España);
					}
				});
				JMenuItem Frantzia = new JMenuItem(Francia);
				Frantzia.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent Frantzia) {
						
						textField.setText(Francia);
					}
				});
				

				// NORA item jartzeko kodea:
				nondiknora.add(Espainia);
				nondiknora.add(Frantzia);
				
				// Barrara ezarriko ditugu lineak:
				ibilbideaktermi.add(nondiknora);
				// ibilbideaktermi.add(nora);

				// Kode hau ezarriko du, JPanel-ean
				getContentPane().add(ibilbideaktermi);
				
				
				
				
				
				// JMenuBar ezartzeko kodea
				 Hotela = new JMenuBar();
				 Hotela.setFont(new Font("Segoe UI", Font.PLAIN, 17));
				Hotela.setBounds(212, 125, 100, 40);
				Hotela.setEnabled(false);
				// Hemen aplikatuko diren elementuen kodea
				// lineak:
				JMenu HotelMenu = new JMenu("Hotel");
				// JMenu nora = new JMenu ("Nora");
				// Linea Bakoitza haren kodearekin klik egiterakoan(NORA):
				JMenuItem h1 = new JMenuItem(H1);
				h1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent h1) {
						textField_1.setText(H1);
					}
				});
				JMenuItem h2 = new JMenuItem(H2);
				h2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent h2) {
						textField_1.setText(H2);
					}
				});
				

				// NORA item jartzeko kodea:
				HotelMenu.add(h1);
				HotelMenu.add(h2);
				
				// Barrara ezarriko ditugu lineak:
				Hotela.add(HotelMenu);
				// ibilbideaktermi.add(nora);

				// Kode hau ezarriko du, JPanel-ean
				getContentPane().add(Hotela);
				
				
					
				
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				JLabel lblPais = new JLabel("Ciudad");
				lblPais.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblPais.setBounds(20, 70, 100, 50);
				contentPane.add(lblPais);
				
				JLabel label = new JLabel("Ciudad:");
				label.setFont(new Font("Tahoma", Font.PLAIN, 21));
				label.setBounds(57, 304, 100, 56);
				contentPane.add(label);
				
				JLabel label_1 = new JLabel("Hotel:");
				label_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
				label_1.setBounds(57, 384, 100, 56);
				contentPane.add(label_1);
				
				JLabel label_2 = new JLabel("Precio:");
				label_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
				label_2.setBounds(57, 461, 100, 56);
				contentPane.add(label_2);
				//Idazten den eremuak
				
				textField = new JTextField();
				textField.setEditable(false);
				textField.setColumns(10);
				textField.setBounds(178, 316, 317, 40);
				contentPane.add(textField);
				
				textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setColumns(10);
				textField_1.setBounds(178, 392, 317, 40);
				contentPane.add(textField_1);
				
				textField_2 = new JTextField();
				textField_2.setEditable(false);
				textField_2.setColumns(10);
				textField_2.setBounds(178, 473, 317, 40);
				contentPane.add(textField_2);
				
				JLabel lblHotel = new JLabel("Hotel");
				lblHotel.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblHotel.setBounds(212, 70, 100, 50);
				contentPane.add(lblHotel);
				
				
				
				JLabel lblGauakgaua = new JLabel("Gauak(80/Gaua)");
				lblGauakgaua.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblGauakgaua.setBounds(397, 70, 141, 50);
				contentPane.add(lblGauakgaua);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(426, 125, 58, 56);
				contentPane.add(comboBox);
				for( i=0;i<zerrenda.length;i++) {
					
					comboBox.addItem(zerrenda[i]);
					
				}
				comboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int prezioa=0;
						String prezioa1;
						int dia=Integer.valueOf(comboBox.getSelectedItem().toString());
						prezioa = 80*dia;
						
						prezioa1=Integer.toString(prezioa);
						
						textField_2.setText(prezioa1);
					}
				});
				
				
				
		
		
	}
	
	public void rellenar() {
		String zenb="";
	
		for(int i=0;i<zerrenda.length;i++) {
			zenb=Integer.toString(i+1);
			zerrenda[i]=zenb;
		}
	}
}
