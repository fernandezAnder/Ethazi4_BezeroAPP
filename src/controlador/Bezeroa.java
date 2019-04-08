package controlador;

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
	public Bezeroa(String dni, String izena, String abizena, String fecha, String pasahitza) {
		super();
		Dni = dni;
		Izena = izena;
		Abizena = abizena;
		this.pasahitza = pasahitza;
		this.data = data;
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

	@Override
	public String toString() {
		return "Bezeroa [Dni=" + Dni + ", Izena=" + Izena + ", Abizena=" + Abizena + ", pasahitza="
				+ pasahitza + ", data=" + data + "]";
	}

	

	/**
	 * Datu basean bilatzen du bezeroa bertan badago. NaN-ren bidez egiten da
	 * bilaketa.
	 * 
	 * @param Nan
	 * @return
	 */
	

}
