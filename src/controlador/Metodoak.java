package controlador;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.FileWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Modelo.Bezeroa;
import modelo.Conexion;
import vista.*;


public class Metodoak {
	public static void lehenengoLehioa() {
		ArrayList<Hotela> hotela=new ArrayList();
		hotela=modelo.Consultas.hotelendatuak();
		P1 lehenengo = new P1(hotela);
		lehenengo.setVisible(true);
	}


	public static void bigarrenLehioa(String prezioa) {
		Ventana6 ventana6= new Ventana6(prezioa);
		ventana6.setVisible(true);
	}
	
	
	public static void logueatzekoPantailara() {
		LOGUEATU L1 = new LOGUEATU();
		L1.setVisible(true);
	}



	public static boolean konprobatuNegatibo(double zbk) {
		boolean balidatu=false;
		if (zbk>0)
			balidatu=true;
		return balidatu;
	}
	
	
	
	public static String kanbioMetodoa(double zbk) {


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
	public static boolean konprobatuLetra(String zbk) {
		boolean balidatu=false;

		try {
			Double.parseDouble(zbk);
			balidatu = false;
		} catch (NumberFormatException letra) {
			balidatu = true;
		}
		return balidatu;
	}

	public static boolean diruFalta(double zbk,double prezioa) {

		boolean diru_falta=false;
		double preziototala = 0;
		preziototala = (double) (zbk-prezioa);
		if (preziototala<0) {
			diru_falta=true;

		}
		return diru_falta;
	}


	public static void imprimatuTiketa(Erreserba r1) {

		String nombre = "tiket.txt";
		try{
			FileWriter fichero = new FileWriter("src\\controlador\\"+nombre);
			fichero.write(r1.toString() + "\r\n");
			fichero.close();

		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static String getMD5(String input) {
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
	public static boolean ateraErabiltzailea(String nan, String pasahitza) {
		boolean erabakia = false;
		ArrayList <Bezeroa> arraybezer = new ArrayList<Bezeroa>();
		arraybezer=modelo.Consultas.ateraErabiltzaileak();
		pasahitza = getMD5(pasahitza);
		for (Bezeroa p : arraybezer) {
			if (p.getDni().equals(nan) && p.getPasahitza().equals(pasahitza)) {
				erabakia = true;

			}
		}

		return (erabakia);

	}
	
	
	/*Metodos para validar el insert de registrarse empezando por coger los datos*/
	public void balidatuInsert(String zenbakiak, String letra, String Izena, String Abizena, String sexua,
			String passwd1, String passwd2) {

		int kontagailua = 0;
		int kontagailua2 = 0;
		Boolean NAN;
		Boolean IZENA;
		Boolean ABIZENA;
		Boolean PASAHITZAK;
		Boolean SEXUA;
		Boolean Txertatu;
		ArrayList<String> gordedatuak = new ArrayList();
		ArrayList<String> pasahitzak = new ArrayList();
		String Nan;
		String data;

		System.out.println(zenbakiak);
		System.out.println(letra);
		NAN = balidatuNan(zenbakiak, letra);
		System.out.println("Nan balidatzean " + NAN);
		Izena = nirelogueatu.balidatuIzena();
		System.out.println(Izena);
		IZENA = balidatuIzena(Izena);
		Abizena = nirelogueatu.balidatuAbizena();
		ABIZENA = balidatuAbizena(Abizena);
		System.out.println(ABIZENA);
		pasahitzak = nirelogueatu.balidatuPasahitza();
		for (String p : pasahitzak) {
			if (kontagailua2 == 0) {
				passwd1 = p;
			}
			if (kontagailua2 == 1) {
				passwd2 = p;
			}
			kontagailua2++;
		}
		System.out.println(passwd1);
		System.out.println(passwd2);
		PASAHITZAK = balidatuPasahitzak(passwd1, passwd2);
		// sexua= LOGUEATU.erakutsiSexua();
		System.out.println(sexua);
		SEXUA = balidatuSexua(sexua);
		sexua = sexua.toUpperCase();
		data = nirelogueatu.ateradata();
		System.out.println(data);

		if (NAN == true && IZENA == true && ABIZENA == true && PASAHITZAK == true && SEXUA == true
				&& data.length() != 0) {

			Nan = zenbakiak + letra;
			Txertatu = Bezeroa.konprobatuDatuBasea(Nan);
			if (Txertatu == true) {
				Metodoak.balidatuLogina("Bazaude datu basean");
			}

			else {
				Metodoak.youshouldpass();

				/*
				 * Bezeroa bezeroa = new Bezeroa(Nan,Izena,Abizena,data,sexua,passwd1);
				 * 
				 * Bezeroa.txertatuBezeroa( bezeroa);
				 */
				System.out.println("Te estas registrando");
			}

		}

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
	public boolean balidatuPasahitzak(String passwd, String passwd2) {
		Boolean erabakia = false;
		if (!passwd.equals(passwd2)) {
			nirelogueatu.erakutsiErrorea5("Pasahitzak ezberdinak");
			erabakia = false;
		}

		else {

			for (int i = 0; i < passwd.length(); i++) {
				if (Character.isUpperCase(passwd.charAt(i))) {
					erabakia = true;
				}

			}
			if (passwd.length() > 50) {
				erabakia = false;
			}
			if (erabakia == false) {
				nirelogueatu.erakutsiErrorea5("Karaktere bat gutxienez larria eta n<50");
			}
			if (erabakia == true) {
				nirelogueatu.erakutsiErrorea5("ONDO");
			}
		}

		return erabakia;
	}

	/**
	 * Abizena balidatzeko metodoa da.
	 * 
	 * @param Abizena
	 * @return
	 */
	public Boolean balidatuAbizena(String Abizena) {
		Boolean erabakia = true;
		try {
			char lehena = Abizena.charAt(0);
			if (Abizena.length() < 100) {
				if (!Character.isUpperCase(lehena)) {
					nirelogueatu.erakutsiErrorea4("Lehengo letra mayuscula ");
					erabakia = false;

				} else {
					nirelogueatu.erakutsiErrorea4("ONDO");

				}

			} else {
				nirelogueatu.erakutsiErrorea4("Letra gehiegi");
				erabakia = false;

			}

		} catch (Exception e) {
			erabakia = false;
			nirelogueatu.erakutsiErrorea4("Eremu hutsa");

		}
		return erabakia;

	}

	/**
	 * Izenaren eremua balidatzen du.
	 * 
	 * @param izena
	 * @return
	 */
	public Boolean balidatuIzena(String izena) {
		Boolean erabakia = true;
		try {
			char lehena = izena.charAt(0);
			if (izena.length() < 50) {
				if (!Character.isUpperCase(lehena)) {
					nirelogueatu.erakutsiErrorea3("Lehengo letra mayuscula ");
					erabakia = false;

				} else {
					nirelogueatu.erakutsiErrorea3("ONDO");

				}

			} else {
				nirelogueatu.erakutsiErrorea3("Letra gehiegi");
				erabakia = false;

			}
		} catch (Exception e) {
			nirelogueatu.erakutsiErrorea3("Eremu Hutsa");
			erabakia = false;

		}

		return erabakia;
	}

	/**
	 * NaN-a balidatzen du.
	 * 
	 * @param zenbakiak
	 * @param letra
	 * @return
	 */
	public Boolean balidatuNan(String zenbakiak, String letra) {
		Boolean erabakia = true;
		int nanzenbakiak = 0;
		char ateraletra;
		char caracter = ' ';
		boolean znbkia = false;
		String juegoCaracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
		int modulo;
		boolean chr = false;
		if (zenbakiak.length() != 8 || letra.length() != 1) {
			erabakia = false;
			nirelogueatu.erakutsiErrorea("Zenbaki edo letra gehiegi/gutxiegi sartu duzu");
		}
		if (zenbakiak.length() == 8 && letra.length() == 1) {
			try {
				nanzenbakiak = Integer.parseInt(zenbakiak);
				znbkia = true;

			} catch (Exception e) {
				erabakia = false;
				
			}

			try {
				int numero = Integer.parseInt(letra);
				

			} catch (Exception e) {
				chr = true;
				letra = letra.toUpperCase();
				caracter = letra.charAt(0);
			}
		}
		if (znbkia == true && chr == true) {
			modulo = nanzenbakiak % 23;
			ateraletra = juegoCaracteres.charAt(modulo);
			String comparador1 = Character.toString(caracter);
			String comparador2 = Character.toString(ateraletra);

			if (comparador1.equals(comparador2)) {
				erabakia = true;
				
			} else {
				
			}
		}
		return erabakia;

	}

}
