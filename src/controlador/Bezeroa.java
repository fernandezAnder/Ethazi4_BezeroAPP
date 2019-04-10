package controlador;

import javax.swing.JTextField;

/**
 * Bezero objektuaren klasea da.
 *
 */
public class Bezeroa {

	private String Dni;
	private String Izena;
	private String Abizena;
	private String pasahitza;
	private String data;
	/**
	 * Bigarrena. Bezereo objetuaren konstruktorea da.
	 * 
	 * @param dni
	 * @param izena
	 * @param abizena
	 * @param sexua
	 * @param pasahitza
	 */
	public Bezeroa(String Dni, String Izena, String Abizena, String pasahitza, String data) {
		super();
		this.Dni = Dni;
		this.Izena = Izena;
		this.Abizena = Abizena;
		this.pasahitza = pasahitza;
		this.data = data;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return Dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		Dni = dni;
	}

	/**
	 * @return the izena
	 */
	public String getIzena() {
		return Izena;
	}

	/**
	 * @param izena the izena to set
	 */
	public void setIzena(String izena) {
		Izena = izena;
	}

	/**
	 * @return the abizena
	 */
	public String getAbizena() {
		return Abizena;
	}

	/**
	 * @param abizena the abizena to set
	 */
	public void setAbizena(String abizena) {
		Abizena = abizena;
	}

	/**
	 * @return the pasahitza
	 */
	public String getPasahitza() {
		return pasahitza;
	}

	/**
	 * @param pasahitza the pasahitza to set
	 */
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Bezeroa [Dni=" + Dni + ", Izena=" + Izena + ", Abizena=" + Abizena + ", pasahitza=" + pasahitza
				+ ", data=" + data + "]";
	}



	
	
	

}
