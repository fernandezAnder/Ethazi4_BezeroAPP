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

	
	
}
