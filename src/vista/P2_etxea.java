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
import controlador.Hotela;
import controlador.Metodoak;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Externalizable;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class P2_etxea extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Metodoak m1;
	private Metodoak metodos;
	private ArrayList<Etxea> etxelista;
	private JScrollPane scrollPane;
	private JLabel lblApartamentuarenInformazioa = new JLabel("ETXEAREN INFORMAZIOA");
	private JButton btnNewButton = new JButton("ATZERA");
	private JButton btnNewButton_1 = new JButton("AURRERA");
	private JLabel lblNewLabel;
	private int id=0;
	
	public P2_etxea() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 588);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new MatteBorder(20, 10, 20, 10, (Color) new Color(70, 130, 180)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 64, 905, 427);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.getTableHeader().setReorderingAllowed(false) ;




		scrollPane.setViewportView(table);

		
		
		lblApartamentuarenInformazioa.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		lblApartamentuarenInformazioa.setBounds(315, 28, 318, 25);
		contentPane.add(lblApartamentuarenInformazioa);
		
		
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				metodos.lehioaEtxeaItxi();
				metodos.lehenengoLehioa();
			}
		});
		btnNewButton.setBounds(357, 502, 98, 23);
		contentPane.add(btnNewButton);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				int numero=table.getSelectedRow();
				Etxea etxea2 = etxelista.get(numero);
//				if(etxea2.getErreserba_kop()==100) {
//					 lblNewLabel.setText("Etxea Beteta");
//				}
//				else {
					id=etxea2.getOstatu_id();
					System.out.println("IDDDDDD"+id);
					 //ohekopurua = hotela2.getGela_kop();
					if(metodos.logueatuta==false && id!=0) {
						System.err.println("asfjksdhkj  1");
						metodos.lehioaEtxeaItxi();
						metodos.loginIreki();
						//metodos.bidaliDiruaEtxea();
					}
					else {
						if(id!=0) {
						System.out.println("alsknfakn 2");
						metodos.lehioaEtxeaItxi();
						metodos.p2hotetoOrdainketa();
						metodos.bidaliDiruaEtxea();
						}
//					}
					
				}
				System.out.println(etxea2);
				
				
				}catch(Exception i) {
					 lblNewLabel.setText("Aukeratu Etxea");

					System.out.println(i.getMessage());
					
				}
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton_1.setBounds(518, 502, 115, 23);
		contentPane.add(btnNewButton_1);
		
	}
	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}
	
	public void ateraE(ArrayList<Etxea> etxe){
		etxelista=etxe;
		for (Etxea e:etxe) {
			System.out.println(e);
		}
	}
	public void filtroetxea() {
		
		String[]columnas= {
				"m2", "ostatu_id", "izena", "herria", "helbidea", "postaKod", "ostatu_mota", "gela_kopuru", "erreserba_kopuru","ospea","komun_kop","prezioa"
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
		 t1.addColumn("ospea");
		 t1.addColumn("komun_kop");
		 t1.addColumn("prezioa");
		for (Etxea e:etxelista) {
			
					columnas[0]=Double.toString(e.getM2());
					columnas[1]=Integer.toString(e.getOstatu_id());
					columnas[2]=e.getIzena();
					columnas[3]=e.getHerria();
					columnas[4]=e.getHelbidea();
					columnas[5]=Integer.toString(e.getPosta_kod());
					columnas[6]=e.getOstatu_mota();
					columnas[7]=Integer.toString( e.getGela_kop());
					columnas[8]=Integer.toString(e.getErreserba_kop());
					columnas[9]=Integer.toString(e.getOspea());
					columnas[10]=Integer.toString(e.getKomun_kop());
					columnas[11]=Double.toString(e.getPrezioa());
					t1.addRow(columnas);	
			}	

		table.getColumnModel().getColumn(0).setPreferredWidth(77);
		table.getColumnModel().getColumn(9).setPreferredWidth(107);
		scrollPane.setViewportView(table);
	}
	
	
	public int eramanaId() {
		return id;
	}
}
