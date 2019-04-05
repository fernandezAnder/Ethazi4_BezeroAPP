package controlador;

import java.util.ArrayList;


import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Bezero objektuaren klasea da.
 *
 */
public class Bezeroa {

	private String Dni;
	private String Izena;
	private String Abizena;
	private Date fecha;
	private String pasahitza;
	private String data;

	/**
	 * Lehenengoa. Bezereo objetuaren konstruktorea da.
	 * 
	 * @param dni
	 * @param izena
	 * @param abizena
	 * @param fecha
	 * @param sexua
	 * @param pasahitza
	 */
	public Bezeroa(String dni, String izena, String abizena, Date fecha, String pasahitza) {
		this.Dni = dni;
		this.Izena = izena;
		this.Abizena = abizena;
		this.fecha = fecha;
		this.pasahitza = pasahitza;

	}

	/**
	 * Bigarrena. Bezereo objetuaren konstruktorea da.
	 * 
	 * @param dni
	 * @param izena
	 * @param abizena
	 * @param data
	 * @param sexua
	 * @param pasahitza
	 */
	public Bezeroa(String dni, String izena, String abizena, String data,  String pasahitza) {
		this.Dni = dni;
		this.Izena = izena;
		this.Abizena = abizena;
		this.data = data;
		this.pasahitza = pasahitza;

	}

	/**
	 * Erabiltzailearen informazioa bidaltzen du, return baten bidez.
	 * 
	 * @return
	 */
	

	/**
	 * DNI-ren informazioa bidaltzen du, return baten bidez.
	 * 
	 * @return
	 */
	public String getDni() {
		return Dni;
	}

	/**
	 * DNI-ren balioa eraldatzeko metodoa da.
	 * 
	 * @param dni
	 */
	public void setDni(String dni) {
		Dni = dni;
	}

	/**
	 * Izena-ren informazioa bidaltzen du, return baten bidez.
	 * 
	 * @return
	 */
	public String getIzena() {
		return Izena;
	}

	/**
	 * Izena-ren balioa eraldatzeko metodoa da.
	 * 
	 * @param izena
	 */
	public void setIzena(String izena) {
		Izena = izena;
	}

	/**
	 * Abizena-ren informazioa bidaltzen du, return baten bidez.
	 * 
	 * @return
	 */
	public String getAbizena() {
		return Abizena;
	}

	/**
	 * Abizena-ren balioa eraldatzeko metodoa da.
	 * 
	 * @param abizena
	 */
	public void setAbizena(String abizena) {
		Abizena = abizena;
	}

	/**
	 * Data-ren informazioa bidaltzen du, return baten bidez.
	 * 
	 * @return
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Data-ren balioa eraldatzeko metodoa da.
	 * 
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	

	/**
	 * Pasahitza-ren informazioa bidaltzen du, return baten bidez.
	 * 
	 * @return
	 */
	public String getPasahitza() {
		return pasahitza;
	}

	/**
	 * Pasahitza-ren balioa eraldatzeko metodoa da.
	 * 
	 * @param pasahitza
	 */
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}



	/**
	 * Data-ren informazioa bidaltzen du, return baten bidez.
	 * 
	 * @return
	 */
	public String getData() {
		return data;
	}

	/**
	 * Data-ren balioa eraldatzeko metodoa da.
	 * 
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * Datu basean bilatzen du bezeroa bertan badago. NaN-ren bidez egiten da
	 * bilaketa.
	 * 
	 * @param Nan
	 * @return
	 */
	

}
