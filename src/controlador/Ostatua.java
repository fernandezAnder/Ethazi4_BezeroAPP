package controlador;

public abstract  class Ostatua{

	protected int ostatu_id;
	protected String izena;
	protected String herria;
	protected String helbidea;
	protected int posta_kod;
	protected String ostatu_mota;
	protected int gela_kop;
	protected int erreserba_kop;
	
	public Ostatua(int ostatu_id, String izena, String herria, String helbidea, int posta_kod, String ostatu_mota,
			int gela_kop, int erreserba_kop) {
		super();
		this.ostatu_id = ostatu_id;
		this.izena = izena;
		this.herria = herria;
		this.helbidea = helbidea;
		this.posta_kod = posta_kod;
		this.ostatu_mota = ostatu_mota;
		this.gela_kop = gela_kop;
		this.erreserba_kop = erreserba_kop;
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

	public String getHerria() {
		return herria;
	}

	public void setHerria(String herria) {
		this.herria = herria;
	}

	public String getHelbidea() {
		return helbidea;
	}

	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}

	public int getPosta_kod() {
		return posta_kod;
	}

	public void setPosta_kod(int posta_kod) {
		this.posta_kod = posta_kod;
	}

	public String getOstatu_mota() {
		return ostatu_mota;
	}

	public void setOstatu_mota(String ostatu_mota) {
		this.ostatu_mota = ostatu_mota;
	}

	public int getGela_kop() {
		return gela_kop;
	}

	public void setGela_kop(int gela_kop) {
		this.gela_kop = gela_kop;
	}

	public int getErreserba_kop() {
		return erreserba_kop;
	}

	public void setErreserba_kop(int erreserba_kop) {
		this.erreserba_kop = erreserba_kop;
	}
	
}
