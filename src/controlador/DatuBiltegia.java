package controlador;

public class DatuBiltegia {
	//DATUAK
	Erreserba r1= new Erreserba(0, 0, null, null, null, 0, 0, 0, null, null, 0, null);
	public void erreserbaGorde(Erreserba erreserba) {
		r1=erreserba;
	}
	public Erreserba erreserbaItzuli() {
		return r1;
	}
}
