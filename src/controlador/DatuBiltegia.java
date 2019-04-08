package controlador;

public class DatuBiltegia {
	//DATUAK
	private static Erreserba r1;
	//r1=new Erreserba(1, 0, null, null, null, 0, 0, 0, null, null, 0, null);
	public void erreserbaGorde(int ostatu_id,double prezioa) {
		r1=new Erreserba(1, 0, null, null, null, 0, 0, 0, null, null, 0, null);
		r1.setOstatu_id(ostatu_id);
		r1.setPrezio_totala(prezioa);
		System.out.println(r1);
	}
	public Erreserba erreserbaItzuli() {
		
		return r1;
	}
}
