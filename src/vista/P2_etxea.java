package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Etxea;
import controlador.Metodoak;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class P2_etxea extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Metodoak m1;
	private Metodoak metodos;
	private ArrayList<Etxea> etxelista;
	private JScrollPane scrollPane;


	public P2_etxea() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 588);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 64, 982, 427);
		contentPane.add(scrollPane);
		
		table = new JTable();
//		for (Etxea e:etxelista) {
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{e.getIzena(), e.getOstatu_id(), null, null, null, null, null, null, null, null},
//			},
//		
//			new String[] {
//				"m2", "ostatu_id", "izena", "herria", "helbidea", "postaKod", "ostatu_mota", "gela_kopuru", "erreserba_kopuru", "komun_kop"
//			}
//		));
//		}
//		table.getColumnModel().getColumn(8).setPreferredWidth(107);
//		scrollPane.setViewportView(table);
		
		JLabel lblApartamentuarenInformazioa = new JLabel("ETXEAREN INFORMAZIOA");
		lblApartamentuarenInformazioa.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		lblApartamentuarenInformazioa.setBounds(315, 11, 257, 25);
		contentPane.add(lblApartamentuarenInformazioa);
		
		JButton btnNewButton = new JButton("ATZERA");
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(366, 502, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AURRERA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m1.loginIreki();
				m1.lehioaEtxeaItxi();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton_1.setBounds(518, 502, 98, 23);
		contentPane.add(btnNewButton_1);
		
	}
	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}
	
	public void ateraE(ArrayList<Etxea> etxe){
		etxelista=etxe;
	}
	public void elalal() {
		for (Etxea e:etxelista) {
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{e.getIzena(), e.getOstatu_id(), null, null, null, null, null, null, null, null},
				},
			
				new String[] {
					"m2", "ostatu_id", "izena", "herria", "helbidea", "postaKod", "ostatu_mota", "gela_kopuru", "erreserba_kopuru", "komun_kop"
				}
			));
			}
		
		table.getColumnModel().getColumn(8).setPreferredWidth(107);
		scrollPane.setViewportView(table);
	}
}
