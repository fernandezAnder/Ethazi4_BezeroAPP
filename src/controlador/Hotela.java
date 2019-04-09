package controlador;

public class Hotela extends Ostatua {

	private int izarkop;

	public Hotela(int ostatu_id, String izena, String herria, String helbidea, int posta_kod, String ostatu_mota,
			int gela_kop, int erreserba_kop, int izarkop) {
		super(ostatu_id, izena, herria, helbidea, posta_kod, ostatu_mota, gela_kop, erreserba_kop);
		this.izarkop = izarkop;
	}

	public int getIzarkop() {
		return izarkop;
	}

	public void setIzarkop(int izarkop) {
		this.izarkop = izarkop;
	}

	@Override
	public String toString() {
		return "Hotela [izarkop=" + izarkop + ", ostatu_id=" + ostatu_id + ", izena=" + izena + ", herria=" + herria
				+ ", helbidea=" + helbidea + ", posta_kod=" + posta_kod + ", ostatu_mota=" + ostatu_mota + ", gela_kop="
				+ gela_kop + ", erreserba_kop=" + erreserba_kop + "]";
		}

	/* (non-Javadoc)
	 * @see controlador.Ostatua#getOstatu_id()
	 */
	@Override
	public int getOstatu_id() {
		// TODO Auto-generated method stub
		return super.getOstatu_id();
	}
	
	

}
