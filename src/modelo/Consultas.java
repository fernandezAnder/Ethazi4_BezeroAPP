package modelo;

import java.sql.Connection;
import java.sql.Date;
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
	public static ArrayList<Bezeroa> ateraErabiltzaileak() {
		Connection conexion = modelo.Conexion.getConexion();
		ArrayList<Bezeroa> Arraybezero = new ArrayList<Bezeroa>();
		String dni = "";
		String izena = "";
		String abizena = "";
		Date jaiotze;
		String sexu;
		String pasahitza = "";
		try {
			Statement s = conexion.createStatement();
			String query = "select * from cliente";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				dni = rs.getString(1);
				izena = rs.getString(2);
				abizena = rs.getString(3);
				jaiotze = rs.getDate(4);
				sexu = rs.getString(5);
				pasahitza = rs.getString(6);
				Bezeroa bezero = new Bezeroa(dni, izena, abizena, jaiotze, pasahitza);
				Arraybezero.add(bezero);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return (Arraybezero);
	}
	public static void txertatuBezeroa(Bezeroa bezeroa) {
		Connection conexion = modelo.Conexion.getConexion();
		try {
			PreparedStatement s = (PreparedStatement) conexion.prepareStatement(
					"INSERT INTO `cliente` (`DNI`, `Nombre`, `Apellidos`, `Fecha_nac`, `Contraseña`)"
							+ " VALUES(?, ?, ?, ?, ?)");
			s.setString(1, bezeroa.getDni());
			s.setString(2, bezeroa.getIzena());
			s.setString(3, bezeroa.getAbizena());
			s.setString(4, bezeroa.getData());
			s.setString(6, bezeroa.getPasahitza());

			s.executeUpdate();
			s.close();

		} catch (Exception e) {
			e.getMessage();
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
