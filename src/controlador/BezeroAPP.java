package controlador;
import java.util.ArrayList;

import modelo.*;
public class BezeroAPP {
	
	public static void main(String[] args) {
		
		Conexion k1 = new Conexion();
		Metodoak.lehenengoLehioa();
		
		
		ArrayList <Hotela> hotelak= new ArrayList<Hotela>();
		hotelak= Consultas.hotelendatuak();
		
		for(int i=0;i<hotelak.size();i++) {
			System.out.println(hotelak.get(i));
		}
		
	}
	
	
	
}
