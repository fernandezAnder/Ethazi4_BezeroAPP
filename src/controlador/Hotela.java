package controlador;

public class Hotela extends Ostatua {

	private int izarkop;
	private String mota;
	private double prezioa;
	private int ospea;
	public Hotela( int izarkop,int ostatu_id, String izena, String herria, String helbidea, int posta_kod, String ostatu_mota,
			int gela_kop, int erreserba_kop,int ospea,String mota, double prezioa) {
		super(ostatu_id, izena, herria, helbidea, posta_kod, ostatu_mota, gela_kop, erreserba_kop);
		this.izarkop = izarkop;
		this.mota=mota;
		this.prezioa=prezioa;
		this.ospea=ospea;
	}

	public int getIzarkop() {
		return izarkop;
	}

	public void setIzarkop(int izarkop) {
		this.izarkop = izarkop;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public int getOspea() {
		return ospea;
	}

	public void setOspea(int ospea) {
		this.ospea = ospea;
	}

	@Override
	public String toString() {
		return "Hotela [izarkop=" + izarkop + ", ostatu_id=" + ostatu_id + ", izena=" + izena + ", herria=" + herria
				+ ", helbidea=" + helbidea + ", posta_kod=" + posta_kod + ", ostatu_mota=" + ostatu_mota + ", gela_kop="
				+ gela_kop + ", erreserba_kop=" + erreserba_kop + "]";
		}


	@Override
	public int getOstatu_id() {
		// TODO Auto-generated method stub
		return super.getOstatu_id();
	}

	@Override
	public void setOstatu_id(int ostatu_id) {
		// TODO Auto-generated method stub
		super.setOstatu_id(ostatu_id);
	}

	@Override
	public String getIzena() {
		// TODO Auto-generated method stub
		return super.getIzena();
	}

	@Override
	public void setIzena(String izena) {
		// TODO Auto-generated method stub
		super.setIzena(izena);
	}

	@Override
	public String getHerria() {
		// TODO Auto-generated method stub
		return super.getHerria();
	}

	@Override
	public void setHerria(String herria) {
		// TODO Auto-generated method stub
		super.setHerria(herria);
	}

	@Override
	public String getHelbidea() {
		// TODO Auto-generated method stub
		return super.getHelbidea();
	}

	@Override
	public void setHelbidea(String helbidea) {
		// TODO Auto-generated method stub
		super.setHelbidea(helbidea);
	}

	@Override
	public int getPosta_kod() {
		// TODO Auto-generated method stub
		return super.getPosta_kod();
	}

	@Override
	public void setPosta_kod(int posta_kod) {
		// TODO Auto-generated method stub
		super.setPosta_kod(posta_kod);
	}

	@Override
	public String getOstatu_mota() {
		// TODO Auto-generated method stub
		return super.getOstatu_mota();
	}

	@Override
	public void setOstatu_mota(String ostatu_mota) {
		// TODO Auto-generated method stub
		super.setOstatu_mota(ostatu_mota);
	}

	@Override
	public int getGela_kop() {
		// TODO Auto-generated method stub
		return super.getGela_kop();
	}

	@Override
	public void setGela_kop(int gela_kop) {
		// TODO Auto-generated method stub
		super.setGela_kop(gela_kop);
	}

	@Override
	public int getErreserba_kop() {
		// TODO Auto-generated method stub
		return super.getErreserba_kop();
	}

	@Override
	public void setErreserba_kop(int erreserba_kop) {
		// TODO Auto-generated method stub
		super.setErreserba_kop(erreserba_kop);
	}
	
	
	

}
