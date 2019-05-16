package controlador;

public class Apartamentua extends Ostatua {

	private int solairua;
	private int m2;
	private int komun_kop;
	private double prezioa;
	private int ospea;
	
	public Apartamentua( int m2,int solairua, int ostatu_id, String izena, 
						String herria, String helbidea, int posta_kod, String ostatu_mota,
							int gela_kop, int erreserba_kop,int ospea,int komun_kop,double prezioa) {
		super(ostatu_id, izena, herria, helbidea, posta_kod, ostatu_mota, gela_kop, erreserba_kop);
		this.solairua = solairua;
		this.m2=m2;
		this.komun_kop=komun_kop;
		this.prezioa=prezioa;
		this.ospea=ospea;
	}

	public int getSolairua() {
		return solairua;
	}

	public void setSolairua(int solairua) {
		this.solairua = solairua;
	}

	

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	public int getKomun_kop() {
		return komun_kop;
	}

	public void setKomun_kop(int komun_kop) {
		this.komun_kop = komun_kop;
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

	@Override
	public String toString() {
		return "Apartamentua [solairua=" + solairua +", ostatu_id="+ ostatu_id 
				+ ", izena=" + izena + ", herria=" + herria + ", helbidea=" + helbidea + ", posta_kod="
				+ posta_kod + ", ostatu_mota=" + ostatu_mota + ", gela_kop=" + gela_kop + ", erreserba_kop="
				+ erreserba_kop + "]";
	}
	
	
}
