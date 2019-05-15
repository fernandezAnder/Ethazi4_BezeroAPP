package controlador;

public class Zerbitzuak {
	int ostatu_id;
	String izena;
	int zerbitzu_kod;
	public Zerbitzuak(int ostatu_id, String izena, int zerbitzu_kod) {
		super();
		this.ostatu_id = ostatu_id;
		this.izena = izena;
		this.zerbitzu_kod = zerbitzu_kod;
	}
	public int getOstatu_id() {
		return ostatu_id;
	}
	public void setOstatu_id(int ostatu_id) {
		this.ostatu_id = ostatu_id;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public int getZerbitzu_kod() {
		return zerbitzu_kod;
	}
	public void setZerbitzu_kod(int zerbitzu_kod) {
		this.zerbitzu_kod = zerbitzu_kod;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Zerbitzuak [ostatu_id=%s, izena=%s, zerbitzu_kod=%s]", ostatu_id, izena, zerbitzu_kod);
	}
	
}
