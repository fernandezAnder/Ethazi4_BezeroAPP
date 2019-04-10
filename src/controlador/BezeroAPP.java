package controlador;
import java.util.ArrayList;

import modelo.Conexion;
import modelo.Consultas;
import vista.Amaiera;
import vista.Erregistratu;
import vista.Login;
import vista.Ordainketa;
import vista.ord;
import vista.P1;
public class BezeroAPP {
	private P1 p1;
	private Metodoak m1;
	private Login lo1;
	private Erregistratu er1;
	private Ordainketa ord1;
	private Amaiera am1;
	
	
	
	public static void main(String[] args) {
		Conexion k1 = new Conexion();
		BezeroAPP bz = new BezeroAPP();
		bz.arrancar();
		
		
		
		
		
		
		
		
	}
	
	
	public void arrancar() {
		ArrayList <Hotela> hotelak= new ArrayList<Hotela>();
		hotelak= Consultas.hotelendatuak();
		p1 = new P1(hotelak);
		m1 = new Metodoak();
		er1 = new Erregistratu();
		lo1 = new Login();
		ord1 = new Ordainketa();
		am1 = new Amaiera();
		
		
		
		
		
		
		
		
		for(int i=0;i<hotelak.size();i++) {
			System.out.println(hotelak.get(i));
		}
		
		 
		
		 //DE LA VENTANA A METODOS
		 p1.misMetodos(m1);
		 lo1.misMetodos(m1);
		 er1.misMetodos(m1);
		 ord1.misMetodos(m1);
		 am1.misMetodos(m1);
		
		 //DE METODOS  A LAS VENTANAS
		 m1.setMip1(p1);
		 m1.setMielo1(lo1);
		 m1.setMier1(er1);
		 m1.setMiord1(ord1);
		 m1.setMiam1(am1);
		 
		 
		 
		 p1.setVisible(true);
		
		 
		 
		 
	}
	
	
	
}
