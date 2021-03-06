package controlador;

public class Etxea extends Ostatua {

	private int komun_kop;
	private double m2;
	private int ospea;
	
	private double prezioa;
	public Etxea(double m2,int ostatu_id, String izena, String herria, String helbidea, int posta_kod, String ostatu_mota,
			int gela_kop, int erreserba_kop,int ospea, int komun_kop,double prezioa ) {
		super(ostatu_id, izena, herria, helbidea, posta_kod, ostatu_mota, gela_kop, erreserba_kop);
		this.komun_kop = komun_kop;
		this.m2 = m2;
		this.prezioa=prezioa;
		this.ospea=ospea;
	}

	public int getKomun_kop() {
		return komun_kop;
	}

	public void setKomun_kop(int komun_kop) {
		this.komun_kop = komun_kop;
	}

	public double getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}



	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public void setM2(double m2) {
		this.m2 = m2;
	}
	

	public int getOspea() {
		return ospea;
	}

	public void setOspea(int ospea) {
		this.ospea = ospea;
	}

	@Override
	public String toString() {
		return "Etxea [komun_kop=" + komun_kop + ", m2=" + m2 + ", ostatu_id=" + ostatu_id
				+ ", izena=" + izena + ", herria=" + herria + ", helbidea=" + helbidea + ", posta_kod=" + posta_kod
				+ ", ostatu_mota=" + ostatu_mota + ", gela_kop=" + gela_kop + ", erreserba_kop=" + erreserba_kop + "]";
	}

	
	
}
