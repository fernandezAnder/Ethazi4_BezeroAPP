package controlador;


import java.io.FileWriter;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;


import modelo.Consultas;
import vista.Amaiera;
import vista.Erregistratu;
import vista.Login;
import vista.Ordainketa;
import vista.ord;
import vista.P1;


public class Metodoak {
	private static String prezio_totala;
	private P1 p1;
	private Erregistratu er1;
	private Login lo1;
	private Ordainketa ord1;
	private Amaiera am1;

///////////////////////////////////////////////////////////////////////////
	
	public void prezio_totala(String prezioa) {
		prezio_totala=prezioa;
	}
///////////////////////////////////////////////////////////////////////////
	public  void lehenengoLehioa() {
		p1.setVisible(true);
	}
	
	

	public void bigarrenLehioa() {
		p1.setVisible(false);
		lo1.setVisible(true);
	}
	
	
	public void bidaliDirua() {
		String diruaString = "";
		System.out.println("AAAAAAAAAAAAAAAAA");
		diruaString=p1.bidalidirus();
		ord1.idatzi(diruaString);
		System.out.println(diruaString);
		
		
	}
	
	public void hirugarrenLehioa() {
		lo1.setVisible(false);
		ord1.setVisible(true);
		String diruaString = "";
		System.out.println("AAAAAAAAAAAAAAAAA");
		diruaString=p1.bidalidirus();
		ord1.idatzi(diruaString);
		System.out.println(diruaString);
	}
	public void amaiera() {
		am1.setVisible(false);
	}
	
	public void erregistratzekoPantailara() {
		lo1.setVisible(false);
		er1.setVisible(true);
		}
	public void recivirReserva() {
		Erreserba erreserba = p1.bidalireserba();
		imprimatuTiketa(erreserba);
	}
	

///////////////////////////////////////////////////////////////////////////
	public boolean konprobatuNegatibo(double zbk) {
		boolean balidatu=false;
		if (zbk>0)
			balidatu=true;
		return balidatu;
	}
	
	public  String kanbioMetodoa(double zbk) {


		double kanbio= zbk;

		int aldatzailea = (int) (kanbio*100); // int-a parentesisen artean dagoena, double-a int-a bihurtzen du
		int itzultzeko = aldatzailea;
		String kanbioa="";
		String pantailaratu="";
		//DEZIMALEN FORMATOA.
		DecimalFormat dezimal = new DecimalFormat("#.00");

		pantailaratu=(" Itzultzeko " + dezimal.format(kanbio) + " eman behar da.\n");
		kanbioa=kanbioa+pantailaratu;
		// para cada moneda
		if (itzultzeko >= 20000) {
			pantailaratu=(" 200�-ko billeteak: " + itzultzeko / 20000+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 20000;
		}
		if (itzultzeko >= 10000) {
			pantailaratu=(" 100�-ko billeteak: " + itzultzeko / 10000+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 10000;
		}
		if (itzultzeko >= 5000) {
			pantailaratu=(" 50�-ko billeteak: " + itzultzeko / 5000+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 5000;
		}
		if (itzultzeko >= 2000) {
			pantailaratu=(" 20�-ko billeteak: " + itzultzeko / 2000+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 2000;
		}
		if (itzultzeko >= 1000) {
			pantailaratu=(" 10�-ko billeteak: " + itzultzeko / 1000+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 1000;
		}
		if (itzultzeko >= 500) {
			pantailaratu=(" 5�-ko billeteak: " + itzultzeko / 500+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 500;
		}
		if (itzultzeko >= 200) {
			pantailaratu=(" 2�-ko txanponak: " + itzultzeko / 200+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 200;
		}
		if (itzultzeko >= 100) {
			pantailaratu=(" 1�-ko txanponak: " + itzultzeko / 100+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 100;
		}
		if (itzultzeko >= 50) {
			pantailaratu=(" 50 zentimoko txanponak: " + itzultzeko / 50+"\n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 50;
		}
		if (itzultzeko >= 20) {
			pantailaratu=(" 20 zentimoko txanponak: " + itzultzeko / 20+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 20;
		}
		if (itzultzeko >= 10) {
			pantailaratu=(" 10 zentimoko txanponak: " + itzultzeko / 10+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 10;
		}
		if (itzultzeko >= 5) {
			pantailaratu=(" 5 zentimoko txanponak: " + itzultzeko / 5+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 5;
		}
		if (itzultzeko >= 2) {
			pantailaratu=(" 2 zentimoko txanponak: " + itzultzeko / 2+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 2;
		}
		if (itzultzeko >= 1) {
			pantailaratu=(" 1 zentimoko txanponak: " + itzultzeko+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = 0;
		}
		return kanbioa;
	}
	public  boolean konprobatuLetra(String zbk) {
		System.out.println(zbk);
		boolean balidatu=false;

		try {
			Double.parseDouble(zbk);
			balidatu = false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			balidatu = true;
		}
		return balidatu;
	}

	public  boolean diruFalta(double zbk,double prezioa) {

		boolean diru_falta=false;
		double preziototala = 0;
		preziototala = (double) (zbk-prezioa);
		if (preziototala<0) {
			diru_falta=true;

		}
		return diru_falta;
	}

///////////////////////////////////////////////////////////////////////////
	public  void imprimatuTiketa(Erreserba r1) {

		String nombre = "tiket.txt";
		try{
			FileWriter fichero = new FileWriter("src\\controlador\\"+nombre);
			fichero.write(r1.toString() + "\r\n");
			fichero.close();

		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
///////////////////////////////////////////////////////////////////////////	
	public  String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public  boolean ateraErabiltzailea(String nan, String pasahitza) {
		boolean erabakia = false;
		ArrayList <Bezeroa> arraybezer = new ArrayList<Bezeroa>();
		arraybezer=modelo.Consultas.ateraErabiltzaileak();
		pasahitza = getMD5(pasahitza);
		for (Bezeroa p : arraybezer) {
			if (p.getDni().equals(nan) && p.getPasahitza().equals(pasahitza)) {
				erabakia = true;
				System.out.println(erabakia);

			}
		}

		return (erabakia);

	}

	

	
	
	
	
	/**
	 * Sexuaren eremua balidatzen du.
	 * 
	 * @param sexua
	 * @return
	 */
	public Boolean balidatuSexua(String sexua) {
		boolean erabakia = true;

		sexua = sexua.toUpperCase();
		String Gizona = "G";
		String Emakumea = "E";
		if (sexua.length() == 1 && sexua.equals(Gizona) || sexua.equals(Emakumea)) {
			

		} else {
			
			erabakia = false;

		}

		return erabakia;
	}
	/**
	 * Pasahitzaren eremua balidatzen du.
	 * 
	 * @param passwd
	 * @param passwd2
	 * @return
	 */


	/**
	 * Abizena balidatzeko metodoa da.
	 * 
	 * @param Abizena
	 * @return
	 */


	/**
	 * Izenaren eremua balidatzen du.
	 * 
	 * @param izena
	 * @return
	 */


	/**
	 * NaN-a balidatzen du.
	 * 
	 * @param zenbakiak
	 * @param letra
	 * @return
	 */
	


	public String KalkulatuLetra(int dni){
		String karaktereak="TRWAGMYFPDXBNJZSQVHLCKE";
		int modulo= dni % 23;
		char letra1 = karaktereak.charAt(modulo);
		String letra = Character.toString(letra1);
		return letra; 
	} 

	public  void bezeroaIgo(Bezeroa bezeroa) {
		Consultas.txertatuBezeroa(bezeroa);
	}

///////////////////////////////////////////////////////////////////////////
	public void setMip1(P1 p1) {
		this.p1 = p1;
	}
	public void setMier1(Erregistratu er1) {
		this.er1 = er1;
	}
	public void setMielo1(Login lo1) {
		this.lo1 = lo1;
	}
	
	
	public void setMiord1(Ordainketa ord1) {
		this.ord1 = ord1;
	}
	
	public void setMiam1(Amaiera am1) {
		this.am1 = am1;
	}
	
}
