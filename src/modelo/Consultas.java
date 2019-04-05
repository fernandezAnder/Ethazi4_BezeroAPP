package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import controlador.*;

public class Consultas {

	public static ArrayList <Hotela> hotelendatuak() {

		ArrayList <Hotela> hotelenlista = new ArrayList<Hotela>();
		PreparedStatement s=null;
		Connection konexioa=Conexion.getConexion();

		try {
			s = konexioa.prepareStatement("select * from hotelak");
			ResultSet rs = s.executeQuery();
			int izarkop=0;
			String izena="";
			String herria="";
			String helbidea="";
			int postaKod=0;
			String ostatu_mota="";
			int gela_kop=0;
			int tarifa_gehigarria=0;
			int erreserba_kop=0;
			while (rs.next()) {
				izarkop=(rs.getInt(1));
				izena=(rs.getString(3));
				herria=(rs.getString(4));
				helbidea=(rs.getString(5));
				postaKod=(rs.getInt(6));
				ostatu_mota=(rs.getString(7));
				gela_kop=(rs.getInt(8));
				tarifa_gehigarria=(rs.getInt(9));
				erreserba_kop=(rs.getInt(10));

				Hotela h1= new Hotela(izarkop,izena,herria,helbidea,postaKod,ostatu_mota,gela_kop,tarifa_gehigarria,erreserba_kop);
				hotelenlista.add(h1);
			}

		}catch(Exception e) {e.getMessage();
		System.out.println(e.getMessage());
		}
		return hotelenlista;
	}



}
