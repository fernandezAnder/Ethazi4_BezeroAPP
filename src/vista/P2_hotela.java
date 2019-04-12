package vista;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controlador.Etxea;
import controlador.Hotela;
import controlador.Metodoak;
import javafx.scene.control.ComboBox;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class P2_hotela extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	private Metodoak m1;
	private Metodoak metodos;
	private ArrayList<Hotela> hotelak;
	private int id=0;
	private int ohekopurua=0;
	private JComboBox comboBox_1;
	private int contador=0;
	private JLabel lblNewLabel;
	
	
	public  P2_hotela() {
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
		
		table.setFont(new Font("Arial Narrow", Font.BOLD, 11));

//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null, null, null, null, null},
//			},
//			new String[] {
//				"izarkop", "ostatu_id", "izena", "herria", "helbidea", "postaKod", "ostatu_mota", "gela_kopuru", "erreserba_kopuru"
//			}
//		));
//		
//		table.getColumnModel().getColumn(0).setPreferredWidth(77);
//		table.getColumnModel().getColumn(8).setPreferredWidth(107);

//		String[]columnas= {
//				"izarkop", "ostatu_id", "izena", "herria", "helbidea", "postaKod", "ostatu_mota", "gela_kopuru", "erreserba_kopuru"
//			};
		//DefaultTableModel t1= new DefaultTableModel(columnas, 10);
//		DefaultTableModel t1= new DefaultTableModel(columnas.length,10){
//
//		    public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
//
//		};
//
//		JTable tabla = new JTable (t1);
//		table.setModel(t1);
		
		
			
			
		
//		table.getColumnModel().getColumn(0).setPreferredWidth(77);
//		table.getColumnModel().getColumn(8).setPreferredWidth(107);
//		scrollPane.setViewportView(table);
		
		JLabel lblApartamentuarenInformazioa = new JLabel("HOTELAREN INFORMAZIOA");
		lblApartamentuarenInformazioa.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		lblApartamentuarenInformazioa.setBounds(315, 11, 336, 25);
		contentPane.add(lblApartamentuarenInformazioa);
		
		JButton btnNewButton = new JButton("ATZERA");
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				metodos.lehioaHotelaItxi();
				metodos.lehenengoLehioa();
				
			}
		});
		btnNewButton.setBounds(366, 502, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AURRERA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				int numero=table.getSelectedRow();
				Hotela hotela2 = hotelak.get(numero);
				if(hotela2.getErreserba_kop()==100) {
					 lblNewLabel.setText("Hotela Beteta");
				}
				else {
					id=hotela2.getOstatu_id();
					 //ohekopurua = hotela2.getGela_kop();
					if(metodos.logueatuta==false && id!=0) {
						metodos.lehioaHotelaItxi();
						metodos.loginIreki();
					}
					else {
						if(id!=0) {
						metodos.lehioaHotelaItxi();
						metodos.p2hotetoOrdainketa();
						metodos.bidaliDirua();
						}
					}
					
				}
				System.out.println(hotela2);
				
				
				}catch(Exception i) {
					 lblNewLabel.setText("Aukeratu Hotela");

					System.out.println(i.getMessage());
					
				}
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton_1.setBounds(518, 502, 98, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(45, 509, 290, 14);
		contentPane.add(lblNewLabel);
		
		
		
		
	}
	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}
	public void prno(ArrayList<Hotela> hotelenlistaFiltro) {
		hotelak=hotelenlistaFiltro;
		
	}
	public void filtroHoteltA() {
//		DefaultTableModel t1 = new DefaultTableModel();
		String[]columnas= {
				"izarkop", "ostatu_id", "izena", "herria", "helbidea", "postaKod", "ostatu_mota", "gela_kopuru", "erreserba_kopuru"
			};
		DefaultTableModel t1= new DefaultTableModel(){

		    public boolean isCellEditable(int rowIndex,int columnIndex){return false;}

		};

		JTable tabla = new JTable (t1);
		table.setModel(t1);
		System.out.println(hotelak.size());
		table.setModel(t1);
		
//		 String[] columnas={
//				"izarkop", "ostatu_id", "izena", "herria", "helbidea", "postaKod", "ostatu_mota", "gela_kopuru", "erreserba_kopuru"
//		};
		 t1.addColumn("izarkop");
		 t1.addColumn("ostatu_id");
		 t1.addColumn("izena");
		 t1.addColumn("herria");
		 t1.addColumn("helbidea");
		 t1.addColumn("postaKod");
		 t1.addColumn("ostatu_mota");
		 t1.addColumn("gela_kopuru");
		 t1.addColumn("erreserba_kopuru");
		for (Hotela e:hotelak) {
					
					columnas[0]=Integer.toString(e.getIzarkop());
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
		table.getColumnModel().getColumn(8).setPreferredWidth(107);
		scrollPane.setViewportView(table);
			
			
	}
	
	
	public int eramanaId() {
		return id;
	}
}
