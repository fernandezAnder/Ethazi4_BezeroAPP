package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;

public class P1_frogak extends JFrame {

	private JPanel contentPane;

	private int i;

	private JTextField textField= new JTextField();
	private JTextField Segundocampo= new JTextField() ;
	private JTextField textField_1 = new JTextField();
	private JTextField textField_2= new JTextField();
	private JTextField textField_3= new JTextField();
	private String[] zerrenda= new String[30];
	private String prezioa1="";
	private JComboBox comboBox;
	private JComboBox comboBox_1= new JComboBox();
	private JComboBox<String> comboBox_2 = new JComboBox();
	private JComboBox comboBox_3 = new JComboBox();
	private JLabel lblPais = new JLabel("Herria");
	private JLabel label = new JLabel("Ciudad:");
	private JLabel label_1 = new JLabel("Hotel:");
	private JLabel label_2 = new JLabel("Precio:");
	private JLabel lblHotel = new JLabel("");
	private JLabel lblGauakgaua = new JLabel("Gauak");
	private JButton btnAurrera = new JButton("Aurrera");

	int prezioa=0;
	int ostatu_id=0;
	private JTable table;

	public P1_frogak(ArrayList<controlador.Hotela> hotela) {
		rellenar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 742, 600);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);


		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPais.setBounds(10, 58, 64, 50);
		contentPane.add(lblPais);


		label.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label.setBounds(57, 304, 100, 56);
		contentPane.add(label);


		label_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label_1.setBounds(57, 384, 100, 56);
		contentPane.add(label_1);


		label_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label_2.setBounds(57, 461, 100, 56);
		contentPane.add(label_2);
		//Idazten den eremuak

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBorder(null);
		textField.setColumns(10);
		textField.setBounds(178, 316, 317, 40);
		contentPane.add(textField);




		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(178, 473, 317, 40);

		contentPane.add(textField_2);


		lblHotel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHotel.setBounds(383, 62, 47, 50);
		contentPane.add(lblHotel);




		lblGauakgaua.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGauakgaua.setBounds(596, 62, 54, 50);
		contentPane.add(lblGauakgaua);

		comboBox= new JComboBox();
		comboBox.setBounds(660, 66, 47, 40);
		contentPane.add(comboBox);




		//Combo1

		comboBox_1.setBounds(67, 70, 89, 38);
		contentPane.add(comboBox_1);
		String herr="";
		ArrayList<String>arr = new ArrayList ();
		for( controlador.Hotela p : hotela) {
			if(!arr.contains(p.getHerria())) {
				comboBox_1.addItem(p.getHerria());
				arr.add(p.getHerria());
			}

		}

		//Combo2
		comboBox_2.setBounds(440, 74, 141, 34);
		contentPane.add(comboBox_2);



		Segundocampo.setEditable(false);
		Segundocampo.setBorder(null);
		Segundocampo.setColumns(10);
		Segundocampo.setBounds(178, 392, 317, 40);
		contentPane.add(Segundocampo);






		textField_1.setEditable(false);
		textField_1.setBorder(null);
		textField_1.setColumns(10);
		textField_1.setBounds(178, 392, 317, 40);
		contentPane.add(textField_1);


		comboBox_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent i) {
				comboBox_2.setModel(new DefaultComboBoxModel());
				textField.setText((String) comboBox_1.getSelectedItem());
				String herria = (String) comboBox_1.getSelectedItem();

				for(controlador.Hotela p : hotela) {
					if (herria.equalsIgnoreCase(p.getHerria())) {
						ostatu_id=p.getOstatu_id();
						comboBox_2.addItem(p.getIzena());
						Segundocampo.removeAll();
					}

				}
			}
		});

		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	  
				Segundocampo.setText(comboBox_2.getSelectedItem().toString());
				textField_1.setText(comboBox_2.getSelectedItem().toString());
			}
		});
		for( i=0;i<zerrenda.length;i++) {
			comboBox.addItem(zerrenda[i]);
		}
		comboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		btnAurrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAurrera.setBounds(464, 527, 89, 23);
		contentPane.add(btnAurrera);
		
		JLabel lblMota = new JLabel("Mota");
		lblMota.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMota.setBounds(197, 67, 46, 38);
		contentPane.add(lblMota);
		
		
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Apartamentua", "Hotela", "Etxea"}));
		comboBox_3.setBounds(258, 68, 100, 40);
		contentPane.add(comboBox_3);
		
		
		comboBox_3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent i) {
				lblHotel.setText((String) comboBox_3.getSelectedItem());				
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
