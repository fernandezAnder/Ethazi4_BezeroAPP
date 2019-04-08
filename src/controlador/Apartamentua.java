package controlador;

public class Apartamentua extends Ostatua {

	private int solairua;
	private int apartamentu_kod;
	
	public Apartamentua(int ostatu_id, String izena, String herria, String helbidea, int posta_kod, String ostatu_mota,
			int gela_kop, int erreserba_kop, int solairua, int apartamentu_kod) {
		super(ostatu_id, izena, herria, helbidea, posta_kod, ostatu_mota, gela_kop, erreserba_kop);
		this.solairua = solairua;
		this.apartamentu_kod = apartamentu_kod;
	}

	public int getSolairua() {
		return solairua;
	}

	public void setSolairua(int solairua) {
		this.solairua = solairua;
	}

	public int getApartamentu_kod() {
		return apartamentu_kod;
	}

	public void setApartamentu_kod(int apartamentu_kod) {
		this.apartamentu_kod = apartamentu_kod;
	}

	@Override
	public String toString() {
		return "Apartamentua [solairua=" + solairua + ", apartamentu_kod=" + apartamentu_kod + ", ostatu_id="
				+ ostatu_id + ", izena=" + izena + ", herria=" + herria + ", helbidea=" + helbidea + ", posta_kod="
				+ posta_kod + ", ostatu_mota=" + ostatu_mota + ", gela_kop=" + gela_kop + ", erreserba_kop="
				+ erreserba_kop + "]";
	}
	
	
}
