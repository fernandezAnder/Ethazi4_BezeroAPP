package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Apartamentua;
import controlador.Etxea;
import controlador.Metodoak;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class P2_apartamentua extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Metodoak m1;
	private Metodoak metodos;
	private ArrayList<Apartamentua> apartlista;
	private JLabel lblApartamentuarenInformazioa = new JLabel("APARTAMENTUAREN INFORMAZIOA");
	private JButton btnNewButton = new JButton("ATZERA");
	private JButton btnNewButton_1 = new JButton("AURRERA");
	private JLabel lblNewLabel;
	private int id=0;
	private JScrollPane scrollPane;


	public P2_apartamentua() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 588);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 62, 982, 427);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		
		
		scrollPane.setViewportView(table);
		
		lblApartamentuarenInformazioa.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		lblApartamentuarenInformazioa.setBounds(270, 11, 346, 25);
		contentPane.add(lblApartamentuarenInformazioa);
		
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(366, 502, 89, 23);
		contentPane.add(btnNewButton);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				int numero=table.getSelectedRow();
				Apartamentua apart2 = apartlista.get(numero);
				if(apart2.getErreserba_kop()==100) {
					 lblNewLabel.setText("Etxea Beteta");
				}
				else {
					id=apart2.getOstatu_id();
			
					if(metodos.logueatuta==false && id!=0) {
						metodos.lehioaApartamentuaItxi();
						metodos.loginIreki();
					}
					else {
						if(id!=0) {
						metodos.lehioaApartamentuaItxi();
						metodos.p2hotetoOrdainketa();
						metodos.bidaliDirua();
						}
					}
					
				}
				
				
				
				}catch(Exception i) {
					 lblNewLabel.setText("Aukeratu Apartamentua");

					System.out.println(i.getMessage());
					
				}
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton_1.setBounds(518, 502, 98, 23);
		contentPane.add(btnNewButton_1);
	}
	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}
	public void ateraA(ArrayList<Apartamentua> apart){
		apartlista=apart;
		for (Apartamentua e:apart) {
			System.out.println(e);
		}
	}
	public void filtroapart() {
		
		String[]columnas= {
				"m2", "ostatu_id", "izena", "herria", "helbidea", "postaKod", "ostatu_mota", "gela_kopuru", "erreserba_kopuru","komun_kop"
			};
		DefaultTableModel t1= new DefaultTableModel(){

		    public boolean isCellEditable(int rowIndex,int columnIndex){return false;}

		};

		JTable tabla = new JTable (t1);
		table.setModel(t1);
				

		 t1.addColumn("m2");
		 t1.addColumn("ostatu_id");
		 t1.addColumn("izena");
		 t1.addColumn("herria");
		 t1.addColumn("helbidea");
		 t1.addColumn("postaKod");
		 t1.addColumn("ostatu_mota");
		 t1.addColumn("gela_kopuru");
		 t1.addColumn("erreserba_kopuru");
		 t1.addColumn("komun_kop");
		for (Apartamentua e:apartlista) {
					
					columnas[0]=Integer.toString(e.getSolairua());
					columnas[1]=Integer.toString(e.getOstatu_id());
					columnas[2]=e.getIzena();
					columnas[3]=e.getHerria();
					columnas[4]=e.getHelbidea();
					columnas[5]=Integer.toString(e.getPosta_kod());
					columnas[6]=e.getOstatu_mota();
					columnas[7]=Integer.toString( e.getGela_kop());
					columnas[8]=Integer.toString(e.getErreserba_kop());
					t1.addRow(columnas);	
			}	

		table.getColumnModel().getColumn(0).setPreferredWidth(77);
		table.getColumnModel().getColumn(9).setPreferredWidth(107);
		//scrollPane.setViewportView(table);
	}
	
	public int bidaliId() {
		return id;
	}
}
