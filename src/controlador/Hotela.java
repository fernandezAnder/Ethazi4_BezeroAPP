package controlador;

public class Hotela {

	private int izarkop;
	private String izena;
	private String herria;
	private String helbidea;
	private int postaKod;
	private String ostatu_mota;
	private int gela_kop;
	private int tarifa_gehigarria;
	private int erreserba_kop;
	
	public Hotela(int izarkop, String izena, String herria, String helbidea, int postaKod, String ostatu_mota,
			int gela_kop, int tarifa_gehigarria, int erreserba_kop) {
		super();
		this.izarkop = izarkop;
		this.izena = izena;
		this.herria = herria;
		this.helbidea = helbidea;
		this.postaKod = postaKod;
		this.ostatu_mota = ostatu_mota;
		this.gela_kop = gela_kop;
		this.tarifa_gehigarria = tarifa_gehigarria;
		this.erreserba_kop = erreserba_kop;
	
	
	}

	public int getIzarkop() {
		return izarkop;
	}

	public void setIzarkop(int izarkop) {
		this.izarkop = izarkop;
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

	public int getPostaKod() {
		return postaKod;
	}

	public void setPostaKod(int postaKod) {
		this.postaKod = postaKod;
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

	public int getTarifa_gehigarria() {
		return tarifa_gehigarria;
	}

	public void setTarifa_gehigarria(int tarifa_gehigarria) {
		this.tarifa_gehigarria = tarifa_gehigarria;
	}

	public int getErreserba_kop() {
		return erreserba_kop;
	}

	public void setErreserba_kop(int erreserba_kop) {
		this.erreserba_kop = erreserba_kop;
		
	}
	@Override
	public String toString() {
		return "Hotela [izarkop=" + izarkop + ", izena=" + izena + ", herria=" + herria + ", helbidea=" + helbidea
				+ ", postaKod=" + postaKod + ", ostatu_mota=" + ostatu_mota + ", gela_kop=" + gela_kop
				+ ", tarifa_gehigarria=" + tarifa_gehigarria + ", erreserba_kop=" + erreserba_kop + "]";
	}
}
