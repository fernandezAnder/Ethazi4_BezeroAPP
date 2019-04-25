package controlador;


import java.io.FileWriter;




import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.control.ComboBox;
import modelo.Consultas;
import vista.*;


public class Metodoak {
	private static String prezio_totala;
	private P1 p1;
	private P2_apartamentua p2apart;
	private P2_etxea p2etxe;
	private P2_hotela p2hot;
	private Erregistratu er1;
	private Login lo1;
	private Ordainketa ord1;
	private Amaiera am1;
	Timer timer = new Timer();
	public boolean logueatuta=false;
	
	
//***************Para que no salga una y otra vez la ventana de login comprobamos logueatutta y asi solo se abre una vez*****
	public boolean logueatuta(){
		return logueatuta;
	}
	public void logueatutabai(boolean erabakia) {
		logueatuta=erabakia;
	}

///////////////////////////////////////////////////////////////////////////
	
	public void prezio_totala(String prezioa) {
		prezio_totala=prezioa;
	}
///////////////////////////////////////////////////////////////////////////
	public  void lehenengoLehioa() {
		p1.setVisible(true);
		
	}
	public  void lehenengoLehioa2() {
		ord1.setVisible(false);
		p1.dispose();
		BezeroAPP ap = new BezeroAPP();
		ap.arrancar();
		
	}
	
	

	public void bigarrenLehioaHotela() {
		p1.setVisible(false);
		p2hot.setVisible(true);
	}
	public void bigarrenLehioaApartamentua() {
		p1.setVisible(false);
		p2apart.setVisible(true);
	}
	public void bigarrenLehioaEtxea() {
		p1.setVisible(false);
		p2etxe.setVisible(true);
	}
	public void lehioaHotelaItxi() {
		p2hot.setVisible(false);
	}
	public void lehioaHotelaIreki() {
		p2hot.setVisible(true);
	}
	public void lehioaApartamentuaItxi() {
		p2apart.setVisible(false);
	}
	public void lehioaEtxeaItxi() {
		p2etxe.setVisible(false);
	}
	
	public void loginIreki() {
		lo1.setVisible(true);
	}
	public void bidaliDirua() {
		String data1=p1.ateraData1();
		String data2=p1.ateraData2();
		int egunak=0;
		int logelakop=0;
		double prezioa =0.0;
		int hilabeteak=0;
		prezioa = Consultas.logela_prezioa(p2hot.eramanaId());
		logelakop=p1.ateraGelakop();
		egunak=p1.diadif();
		
		
		prezioa=logelakop*prezioa*egunak;

		
		String diruaString = "";
		
		
		System.out.println("precio "+prezioa);
		System.out.println("Dias "+egunak);
		System.out.println(logelakop);
		diruaString=Double.toString(prezioa);
		ord1.idatzi(diruaString);
		System.out.println(diruaString);
		
		
	}
	
	public void hirugarrenLehioa() {
		lo1.setVisible(false);
		ord1.setVisible(true);
		String diruaString = "";
		System.out.println("AAAAAAAAAAAAAAAAA");
		ord1.idatzi(diruaString);
		System.out.println(diruaString);
	}
	public void amaieraIreki() {

		ord1.setVisible(false);
		am1.setVisible(true);

		amaiera();
		p1.dispose();
		BezeroAPP ap = new BezeroAPP();
		ap.arrancar();
		}
	public void p2hotetoOrdainketa() {
		ord1.setVisible(true);
	}
	public void p2hotetoOrdainketa2() {
		ord1.setVisible(false);
	}
	
	public void agurratoP1() {
		am1.setVisible(false);
		
		
		
		}
	public void amaiera() {
		itxaron(5);
		am1.setVisible(false);
	}
	
	public void erregistratzekoPantailara() {
		lo1.setVisible(false);
		er1.setVisible(true);
		}
	public void erregistroPantailaItxi() {
		er1.setVisible(false);
	}
	public void recivirReserva() {
		String data1 = p1.ateraData1();
		System.out.println(data1);
		System.out.println(p1.ateraData1());
		Erreserba erreserba =new Erreserba(0, p2hot.eramanaId(), lo1.ateraNana(), p1.ateraData1(), p1.ateraData2(), p1.ateraPertsonakop(), ord1.prezio_totala(), p1.ateraGelakop(), p1.ateraPentsio(), p1.ateraOheMota(), p1.ateraPertsonakop(), null);
		imprimatuTiketa(erreserba);
		Consultas.txertatuErreserba(erreserba);
		System.out.println(erreserba);
	}
	
	public void filtroHotela() {
		String herria=p1.ateraHerria();
		ArrayList<Hotela> hotelenlista= new ArrayList<Hotela>();
		ArrayList<Hotela> hotelenlistaFiltro= new ArrayList<Hotela>();
		hotelenlista=Consultas.hotelendatuak();
		for (Hotela p:hotelenlista) {
			if (p.getHerria().equalsIgnoreCase(herria)){
				hotelenlistaFiltro.add(p);
			}
		}
		
		p2hot.prno(hotelenlistaFiltro);
		p2hot.filtroHoteltA();
		
	}
	public ArrayList<Apartamentua> filtroApartamentua() {
		String herria=p1.ateraHerria();
		ArrayList<Apartamentua> apartamentulista= new ArrayList<Apartamentua>();
		apartamentulista=Consultas.apartamentuDatuak();
		ArrayList<Apartamentua> apartamentulista2= new ArrayList<Apartamentua>();
		for (Apartamentua p:apartamentulista2) {
			if (p.getHerria().equalsIgnoreCase(herria)){
				apartamentulista2.add(p);
			}
		}
		
		return apartamentulista2;
	}
	public void filtroEtxea() {
		String herria=p1.ateraHerria();
		ArrayList<Etxea> etxelista=new ArrayList<Etxea>();
		etxelista=Consultas.etxeDatuak();
		ArrayList<Etxea> etxelista2=new ArrayList<Etxea>();
		
		for (Etxea p:etxelista) {
			
			if (p.getHerria().equalsIgnoreCase(herria)){
				etxelista2.add(p);
			}
		}
		p2etxe.ateraE(etxelista2);
		p2etxe.filtroetxea();
	}
			
			
			
		
	
	

///////////////////////////////////////////////////////////////////////////
	public static void itxaron(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
        System.out.println("BUKATU DA");
    }  
	
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

	public static boolean diruFalta(double prezioa,double zbk) {

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

		System.out.println(r1);
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
	public void setMip2hot(P2_hotela p2hot) {
		this.p2hot=p2hot;
	}
	public void setMip2apart(P2_apartamentua p2apart) {
		this.p2apart=p2apart;
	}
	public void setMip2etxe(P2_etxea p2etxe) {
		this.p2etxe=p2etxe;
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
