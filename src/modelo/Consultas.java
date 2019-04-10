package modelo;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			int ostatu_id=0;
			String izena="";
			String herria="";
			String helbidea="";
			int postaKod=0;
			String ostatu_mota="";
			int gela_kop=0;
			int erreserba_kop=0;
			while (rs.next()) {
				izarkop=(rs.getInt(1));
				ostatu_id=(rs.getInt(2));
				izena=(rs.getString(3));
				herria=(rs.getString(4));
				helbidea=(rs.getString(5));
				postaKod=(rs.getInt(6));
				ostatu_mota=(rs.getString(7));
				gela_kop=(rs.getInt(8));
				erreserba_kop=(rs.getInt(9));

				Hotela h1= new Hotela(izarkop,ostatu_id,izena,herria,helbidea,postaKod,ostatu_mota,gela_kop,erreserba_kop);
				hotelenlista.add(h1);
			}

		}catch(Exception e) {e.getMessage();
		System.out.println(e.getMessage());
		}
		return hotelenlista;
	}
	public static ArrayList<Bezeroa> ateraErabiltzaileak() {
		Connection conexion = modelo.Conexion.getConexion();
		ArrayList<Bezeroa> Arraybezero = new ArrayList<Bezeroa>();
		String dni = "";
		String izena = "";
		String abizena = "";
		String jaiotze;
		String pasahitza = "";
		try {
			Statement s = conexion.createStatement();
			String query = "select * from bezeroa";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				dni = rs.getString(1);
				izena = rs.getString(2);
				abizena = rs.getString(3);
				jaiotze = rs.getString(4);
				pasahitza = rs.getString(5);
				Bezeroa bezero = new Bezeroa(dni, izena, abizena, pasahitza,jaiotze);
				Arraybezero.add(bezero);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return (Arraybezero);
	}
	public static void txertatuBezeroa(Bezeroa bezeroa) {
		Connection conexion = modelo.Conexion.getConexion();
		System.out.println(bezeroa);
		try {
			PreparedStatement s = (PreparedStatement) conexion.prepareStatement(
					"INSERT INTO `bezeroa` (`nan`, `izena`, `abizenak`, `jaiotze_data`, `pasahitza`)"
							+ " VALUES(?, ?, ?, ?, ?)");
			s.setString(1, bezeroa.getDni());
			s.setString(2, bezeroa.getIzena());
			s.setString(3, bezeroa.getAbizena());
			s.setString(4, bezeroa.getData());
			s.setString(5, bezeroa.getPasahitza());

			s.executeUpdate();
			s.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public static void txertatuErreserba(Erreserba e1) {
		Connection conexion = modelo.Conexion.getConexion();
		System.out.println(e1);
		try {
			PreparedStatement s = (PreparedStatement) conexion.prepareStatement(
					"INSERT INTO `bezeroa` (`nan`, `izena`, `abizenak`, `jaiotze_data`, `pasahitza`)"
							+ " VALUES(?, ?, ?, ?, ?)");
			
			s.setInt(2,e1.getOstatu_id());
			s.setString(3, e1.getBezero_nan());
			s.setInt(4, e1.getPertsona_kop());
			s.setDouble(5,e1.getPrezio_totala() );
			s.setInt(6,e1.getErreserba_gela_kop() );
			s.setString(7, e1.getPentsio_mota());
			
			s.executeUpdate();
			s.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public static boolean konprobatuDatuBasea(String Nan) {
		Connection conexion = modelo.Conexion.getConexion();
		ArrayList<Bezeroa> Arraybezero = new ArrayList<Bezeroa>();
		String dni = "";
		boolean erabakia = false;

		try {
			Statement s = conexion.createStatement();
			String query = "select * from cliente";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				dni = rs.getString(1);
				if (dni.equals(Nan)) {
					erabakia = true;
					break;
				}

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return erabakia;
	}



}
