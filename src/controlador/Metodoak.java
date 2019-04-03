package controlador;

import vista.P1;
import vista.P2;

public class Metodoak {
	public static void lehenengoLehioa() {
		P1 lehenengo = new P1();
		lehenengo.setVisible(true);
	}
	
	public static void bigarrenLehioa(String prezioa) {
		P1 lehenengo = new P1();
		lehenengo.setVisible(false);
		lehenengo.dispose();
		P2 bigarrena= new P2(prezioa);
		bigarrena.setVisible(true);
	}
}
