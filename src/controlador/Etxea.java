package controlador;

public class Etxea extends Ostatua {

	private int komun_kop;
	private int m2;
	private int etxe_kod;
	
	public Etxea(int ostatu_id, String izena, String herria, String helbidea, int posta_kod, String ostatu_mota,
			int gela_kop, int erreserba_kop, int komun_kop, int m2, int etxe_kod) {
		super(ostatu_id, izena, herria, helbidea, posta_kod, ostatu_mota, gela_kop, erreserba_kop);
		this.komun_kop = komun_kop;
		this.m2 = m2;
		this.etxe_kod = etxe_kod;
	}

	public int getKomun_kop() {
		return komun_kop;
	}

	public void setKomun_kop(int komun_kop) {
		this.komun_kop = komun_kop;
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	public int getEtxe_kod() {
		return etxe_kod;
	}

	public void setEtxe_kod(int etxe_kod) {
		this.etxe_kod = etxe_kod;
	}

	@Override
	public String toString() {
		return "Etxea [komun_kop=" + komun_kop + ", m2=" + m2 + ", etxe_kod=" + etxe_kod + ", ostatu_id=" + ostatu_id
				+ ", izena=" + izena + ", herria=" + herria + ", helbidea=" + helbidea + ", posta_kod=" + posta_kod
				+ ", ostatu_mota=" + ostatu_mota + ", gela_kop=" + gela_kop + ", erreserba_kop=" + erreserba_kop + "]";
	}

	
	
}
