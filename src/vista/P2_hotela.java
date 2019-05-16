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
import javax.swing.border.MatteBorder;

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
	private JLabel lblApartamentuarenInformazioa = new JLabel("HOTELAREN INFORMAZIOA");
	private JButton btnNewButton = new JButton("ATZERA");
	private JButton btnNewButton_1 = new JButton("AURRERA");
	
	
	public  P2_hotela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 645);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new MatteBorder(20, 10, 20, 10, (Color) new Color(70, 130, 180)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 64, 905, 427);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.getTableHeader().setReorderingAllowed(false) ;
		
		table.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		
		
		lblApartamentuarenInformazioa.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		lblApartamentuarenInformazioa.setBounds(315, 28, 336, 25);
		contentPane.add(lblApartamentuarenInformazioa);
		
		
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				metodos.lehioaHotelaItxi();
				metodos.lehenengoLehioa();
				
			}
		});
		btnNewButton.setBounds(357, 502, 98, 23);
		contentPane.add(btnNewButton);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				try{
				int numero=table.getSelectedRow();
				Hotela hotela2 = hotelak.get(numero);
				if(hotela2.getErreserba_kop()==100) {
					 lblNewLabel.setText("Hotela Beteta");
				}
				
				else {
					id=hotela2.getOstatu_id();
					System.out.println("2");
					 //ohekopurua = hotela2.getGela_kop();
					if(metodos.logueatuta==false && id!=0) {
						System.out.println("HOLA KARAKOLA");
						metodos.lehioaHotelaItxi();
						System.out.println("preeeee kaixo");
						metodos.loginIreki();
					}
					else {
						System.out.println("3jyhfjyh");
						if(id!=0) {
						metodos.lehioaHotelaItxi();
						metodos.p2hotetoOrdainketa();
						metodos.bidaliDirua();
						}
					}
					
				}
				System.out.println("es: "+hotela2);
				
				
				}catch(Exception i) {
					 lblNewLabel.setText("Aukeratu Hotela");

					System.out.println(i.getMessage());
					
				}
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton_1.setBounds(518, 502, 118, 23);
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

		String[]columnas= {
				"izarkop", "ostatu_id", "izena", "herria", "helbidea", "postaKod", "ostatu_mota", "gela_kopuru", "erreserba_kopuru","ospea","mota","prezioa"
			};
		DefaultTableModel t1= new DefaultTableModel(){

		    public boolean isCellEditable(int rowIndex,int columnIndex){return false;}

		};

		table.setModel(t1);
		System.out.println(hotelak.size());
		table.setModel(t1);
		 t1.addColumn("izarkop");
		 t1.addColumn("ostatu_id");
		 t1.addColumn("izena");
		 t1.addColumn("herria");
		 t1.addColumn("helbidea");
		 t1.addColumn("postaKod");
		 t1.addColumn("ostatu_mota");
		 t1.addColumn("gela_kopuru");
		 t1.addColumn("erreserba_kopuru");
		 t1.addColumn("ospea");
		 t1.addColumn("mota");
		 t1.addColumn("prezioa");
		for (Hotela e:hotelak) {
					System.out.println(e);
					columnas[0]=Integer.toString(e.getIzarkop());
					columnas[1]=Integer.toString(e.getOstatu_id());
					columnas[2]=e.getIzena();
					columnas[3]=e.getHerria();
					columnas[4]=e.getHelbidea();
					columnas[5]=Integer.toString(e.getPosta_kod());
					columnas[6]=e.getOstatu_mota();
					columnas[7]=Integer.toString( e.getGela_kop());
					columnas[8]=Integer.toString(e.getErreserba_kop());
					columnas[9]=Integer.toString(e.getOspea());
					columnas[10]=e.getMota();
					columnas[11]=Double.toString(e.getPrezioa());
					t1.addRow(columnas);	
			}	

		table.getColumnModel().getColumn(0).setPreferredWidth(77);
		table.getColumnModel().getColumn(10).setPreferredWidth(107);
		scrollPane.setViewportView(table);
		
			
			

//		boolean isCellEditable(int rowIndex, int vColIndex) {
//            return false;
//        }; //return false: Desabilitar edici�n de celdas.
// 
//			

	}
	
	
	public int eramanaId() {
		return id;
	}
}
