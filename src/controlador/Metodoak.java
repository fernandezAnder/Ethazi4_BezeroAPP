package controlador;


import java.io.FileWriter;




import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import javafx.scene.control.ComboBox;
import modelo.Consultas;
import vista.*;


public class Metodoak {
	private static String prezio_totala;
	private String ostatu_mota;
	private P1_copia p1cop;
	private P2_apartamentua p2apart;
	private P2_etxea p2etxe;
	private P2_hotela p2hot;
	private Erregistratu er1;
	private Login lo1;
	private Ordainketa ord1;
	private Amaiera am1;
	Timer timer = new Timer();
	public boolean logueatuta=false;
	private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	private String tarifa = "Baxua";
	private PruebScroll pr;
	private String kod_err1;
	//private p1cop_copia p1cop;
	
	
	
	
	public void kodea() {
		String kodea;
		System.out.println("1. "+kod_err1);
		kodea=kod_err1 +"-"+lo1.kodea_eraman();
		System.out.println("4. "+kodea);
		if(tarifa.equalsIgnoreCase("Baxua")) {
			kodea=kodea+"-"+"Temp_baja";
		}
		ord1.hartu_Kodea(kodea);
		
		
			
		
	}
	
//***************Para que no salga una y otra vez la ventana de login comprobamos logueatutta y asi solo se abre una vez*****
	public boolean logueatuta(){
		return logueatuta;
	}
	public void logueatutabai(boolean erabakia) {
		logueatuta=erabakia;
	}
	public void legediaonartua() {
		Consultas.legediaonartua();
	}
///////////////////////////////////////////////////////////////////////////
	
	public void prezio_totala(String prezioa) {
		prezio_totala=prezioa;
	}
	public void ostatu_motaHartu(String ostatu) {
		ostatu_mota=ostatu;
	}
	public String ostatu_motaAtera() {
		return ostatu_mota;
	}
///////////////////////////////////////////////////////////////////////////
	public  void lehenengoLehioa() {
		p1cop.setVisible(true);
		
	}
	public  void lehenengoLehioa2() {
		ord1.setVisible(false);
		p1cop.dispose();
		BezeroAPP ap = new BezeroAPP();
		ap.arrancar();
		
	}
	
	

	public void bigarrenLehioaHotela() {
		p1cop.setVisible(false);
		p2hot.setVisible(true);
	}
	public void bigarrenLehioaApartamentua() {
		p1cop.setVisible(false);
		p2apart.setVisible(true);
	}
	public void bigarrenLehioaEtxea() {
		p1cop.setVisible(false);
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
		System.out.println("kaixo");
		lo1.setVisible(true);
		
	}
	//**********DENBORALDIA KALKULATZEKO METODOAK********
	public double denboraldiaKalkulatu() {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd/");
		Date date1p1cop = null;
		double recargo = 0.0;
		boolean esfestivo=false;
		try {
		 date1p1cop = (Date) formato.parse(p1cop.ateraData1());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		int eguna1=0;
		int hilabetea1=0;
		int urtea1=0;
		int eguna2=date1p1cop.getDay();
		int hilabetea2=date1p1cop.getMonth();
		int urtea2=date1p1cop.getYear();
		Date data;
		ArrayList <Date> datak =  new ArrayList();
		//datak = Consultas.ateraData();
		for(int i=0;i<datak.size();i++) {
			data=datak.get(i);
			eguna1=data.getDay();
			hilabetea1=data.getMonth();
			urtea1=data.getYear();
			if(eguna1==eguna2 && hilabetea1==hilabetea2 && urtea1==urtea2) {
				 esfestivo = true;
			}
		}
		//recargo=Consultas.
		
		return recargo;
		
		
	}
	public ArrayList<java.sql.Date> jaiegunLista(){
		ArrayList<java.sql.Date> jaiegunak=Consultas.jaiegunLista();
		for (int i=0;i<jaiegunak.size();i++) {
			System.out.println(jaiegunak.get(i));
		}
		return jaiegunak;
	}
	//*****************ERRESERBAREN PREZIOA KALKULATZEKO METODOAK********************
	public void bidaliDirua(){
		
		String data1=p1cop.ateraData1();
		String data2=p1cop.ateraData2();
		int numero1=0;
		int numero2=0;
		
		
		String [] datak=data1.split("/");
		numero1=Integer.valueOf(datak[1]);
		
		String [] datak2=data2.split("/");
		numero2=Integer.valueOf(datak2[1]);	
		
		double recargo=0.0;
		double recargo2=0.0;
		

		int egunak=0;
		int logelakop=0;
		double prezioa =0.0;
		int hilabeteak=0;
		String gelamota=p1cop.gelamota();
		if (gelamota.equals("Suite")) {
			prezioa=Consultas.logelaPrezioaSuite(p2hot.eramanaId());
		}else if(gelamota.equals("Bikoitza")) {
			prezioa=Consultas.logelaPrezioaBikoitza(p2hot.eramanaId());
		}else if (gelamota.equals("Banakakoa")) {
			prezioa=Consultas.logelaPrezioaBanakakoa(p2hot.eramanaId());
		}
		
		System.out.println("PrezioOOOAAAAA: "+prezioa);
	
		logelakop=p1cop.ateraGelakop();
		egunak=p1cop.diadif();
		System.out.println(numero1);
		System.out.println(numero2);
		ArrayList<java.sql.Date> jaiegunak= Consultas.jaiegunLista();
		for (java.sql.Date jaiak :jaiegunak) {
			
			
			if (jaiak.equals(data1)|| jaiak.equals(data2)) {
				recargo2=50;				
			}
			try {
				if(jaiak.after(format.parse(data1))) {
					if(jaiak.before(format.parse(data2))) {
						recargo2=50;
					}
}
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		}
		// denboraldi altua: 5,6,9,10
		if(numero1==1 || numero1==2 || numero1==3 || numero1==4 || numero1==7 || numero1==8|| numero1==11 || numero1==12 || numero2==1 || numero2==2 || numero2==3 || numero2==4 || numero2==7 || numero2==8|| numero2==11 || numero2==12 ) {
					recargo=50.0;
					tarifa = "Altua";
					
		}
		System.out.println("logelakop "+logelakop);
		System.out.println("prezioa: "+prezioa);
		System.out.println("egunak "+egunak);
		System.out.println("recargo1: "+recargo);
		System.out.println("recargo2: "+recargo2);
		prezioa=logelakop*prezioa*egunak+recargo+recargo2;

		
		String diruaString = "";
		
		System.out.println("Dias "+egunak);
		diruaString=Double.toString(prezioa);
		ord1.idatzi(diruaString);		
	}


	public void bidaliDiruaApartamentua() {

		String data1=p1cop.ateraData1();
		String data2=p1cop.ateraData2();
		int numero1=0;
		int numero2=0;
		
		String [] datak=data1.split("/");
		numero1=Integer.valueOf(datak[1]);
		
		String [] datak2=data2.split("/");
		numero2=Integer.valueOf(datak2[1]);	
		
		double recargo=0.0;
		double recargo2=0.0;
		

		int egunak=0;
		int logelakop=0;
		double prezioa =0.0;
		int hilabeteak=0;
		prezioa = Consultas.logela_prezioaEtxeApart(p2apart.bidaliId());
	
		logelakop=p1cop.ateraGelakop();
		egunak=p1cop.diadif();
		System.out.println(numero1);
		System.out.println(numero2);
		ArrayList<java.sql.Date> jaiegunak= Consultas.jaiegunLista();
		for (java.sql.Date jaiak :jaiegunak) {
			
			
			if (jaiak.equals(data1)|| jaiak.equals(data2)) {
				recargo2=50;				
			}
			try {
				if(jaiak.after(format.parse(data1))) {
					if(jaiak.before(format.parse(data2))) {
						recargo2=50;
					}
}
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		}
		// denboraldi altua: 5,6,9,10
		if(numero1==1 || numero1==2 || numero1==3 || numero1==4 || numero1==7 || numero1==8|| numero1==11 || numero1==12 || numero2==1 || numero2==2 || numero2==3 || numero2==4 || numero2==7 || numero2==8|| numero2==11 || numero2==12 ) {
					recargo=50.0;
					tarifa = "Altua";
		}
		System.out.println("logelakop "+logelakop);
		System.out.println("prezioa: "+prezioa);
		System.out.println("egunak "+egunak);
		System.out.println("recargo1: "+recargo);
		System.out.println("recargo2: "+recargo2);
		prezioa=logelakop*prezioa*egunak+recargo+recargo2;

		
		String diruaString = "";
		
		System.out.println("Dias "+egunak);
		diruaString=Double.toString(prezioa);
		ord1.idatzi(diruaString);	
	}
	public void bidaliDiruaEtxea() {

		String data1=p1cop.ateraData1();
		String data2=p1cop.ateraData2();
		int numero1=0;
		int numero2=0;
		
		String [] datak=data1.split("/");
		numero1=Integer.valueOf(datak[1]);
		
		String [] datak2=data2.split("/");
		numero2=Integer.valueOf(datak2[1]);	
		
		double recargo=0.0;
		double recargo2=0.0;
		

		int egunak=0;
		int logelakop=0;
		double prezioa =0.0;
		int hilabeteak=0;
		prezioa = Consultas.logela_prezioaEtxeApart(p2etxe.eramanaId());
	
		logelakop=p1cop.ateraGelakop();
		egunak=p1cop.diadif();
		System.out.println(numero1);
		System.out.println(numero2);
		ArrayList<java.sql.Date> jaiegunak= Consultas.jaiegunLista();
		for (java.sql.Date jaiak :jaiegunak) {
			
			
			if (jaiak.equals(data1)|| jaiak.equals(data2)) {
				recargo2=50;				
			}
			try {
				if(jaiak.after(format.parse(data1))) {
					if(jaiak.before(format.parse(data2))) {
						recargo2=50;
					}
}
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		}
		// denboraldi altua: 5,6,9,10
		if(numero1==1 || numero1==2 || numero1==3 || numero1==4 || numero1==7 || numero1==8|| numero1==11 || numero1==12 || numero2==1 || numero2==2 || numero2==3 || numero2==4 || numero2==7 || numero2==8|| numero2==11 || numero2==12 ) {
					recargo=50.0;
					tarifa = "Altua";
		}
		System.out.println("logelakop "+logelakop);
		System.out.println("prezioa: "+prezioa);
		System.out.println("egunak "+egunak);
		System.out.println("recargo1: "+recargo);
		System.out.println("recargo2: "+recargo2);
		prezioa=logelakop*prezioa*egunak+recargo+recargo2;

		
		String diruaString = "";
		
		System.out.println("Dias "+egunak);
		diruaString=Double.toString(prezioa);
		ord1.idatzi(diruaString);	
	}
	public void hirugarrenLehioa() {
		lo1.setVisible(false);
		ord1.setVisible(true);
		String diruaString = "";
		
		ord1.idatzi(diruaString);
		System.out.println(diruaString);
	}
	public void amaieraIreki() {

		ord1.setVisible(false);
		am1.setVisible(true);

		amaiera();
		p1cop.dispose();
		BezeroAPP ap = new BezeroAPP();
		ap.arrancar();
		}
	public void p2hotetoOrdainketa() {
		ord1.setVisible(true);
	}
	public void p2hotetoOrdainketa2() {
		ord1.setVisible(false);
	}
	
	public void agurratop1cop() {
		am1.setVisible(false);
		
		
		
		}
	public void amaiera() {
		itxaron(5);
		am1.setVisible(false);
	}
	
	public void erregistratzekoPantailara() {
		lo1.setVisible(false);
		er1.setVisible(true);
		pr.setVisible(true);
		pr.terminos();
		}
	public void erregistroPantailaItxi() {
		kod_err1=er1.ateraKodea2();
		er1.dispose();
		er1 = new Erregistratu();
		er1.setVisible(false);
	}
	public void recivirReserva() {
		int id =0;
		String caracter = ostatu_motaAtera();
		if(caracter.equalsIgnoreCase("H")) {
			id =p2hot.eramanaId();
		}
		if(caracter.equalsIgnoreCase("A")) {
			id = p2apart.bidaliId();			}
		if(caracter.equalsIgnoreCase("E")) {
			id = p2etxe.eramanaId();
		}
		String data1 = p1cop.ateraData1();
		System.out.println(data1);
		System.out.println(p1cop.ateraData1());
		Erreserba erreserba =new Erreserba(0, id , getMD5(lo1.ateraNana()), p1cop.ateraData1(), p1cop.ateraData2(), p1cop.ateraPertsonakop(), ord1.prezio_totala(), p1cop.ateraGelakop(), p1cop.ateraPentsio(), p1cop.ateraOheMota(), p1cop.ateraPertsonakop(), tarifa);
		imprimatuTiketa(erreserba);
		Consultas.txertatuErreserba(erreserba);
		System.out.println(erreserba);
	}
	public void erreserbaJaiegunBete() {
		ArrayList<java.sql.Date> jaiegunak= Consultas.jaiegunLista();
		int jaiegun_kod=0;
		int erreserba_kod=Consultas.erreserbaKod();
		
		for (int i=0;i<jaiegunak.size();i++) {
			String data=jaiegunak.get(i).toString();
			if(data.equals(p1cop.ateraData1())) {
				System.out.println("lo hace");
				jaiegun_kod=i+1;
			}
		if (erreserba_kod>1) {
			erreserba_kod=erreserba_kod+1;
		}
		System.out.println("jaiegun kod "+jaiegun_kod);
		System.out.println("erreserba kod"+erreserba_kod);
		if(jaiegun_kod>0) {
		Consultas.erreserbaJaiegunaIgo(erreserba_kod, jaiegun_kod);
		}
		}
	}
	
	public void filtroHotela() {
		String herria=p1cop.ateraHerria();
		ArrayList<Hotela> hotelenlista= new ArrayList<Hotela>();
		ArrayList<Hotela> hotelenlistaFiltro= new ArrayList<Hotela>();

		String gelamota=p1cop.gelamota();
		if (gelamota.equals("Suite")) {
			hotelenlista=Consultas.hotelendatuakSuite();	
		}else if(gelamota.equals("Bikoitza")) {
			hotelenlista=Consultas.hotelendatuakBikoitza();
		}else if (gelamota.equals("Banakakoa")) {
			hotelenlista=Consultas.hotelendatuakBanakakoa();
		}
		
		
		for (Hotela p:hotelenlista) {
			if (p.getHerria().equalsIgnoreCase(herria)){
				hotelenlistaFiltro.add(p);
			}
		}
		
		p2hot.prno(hotelenlistaFiltro);
		p2hot.filtroHoteltA();
		
	}
	public ArrayList<Apartamentua> filtroApartamentua() {
		String herria=p1cop.ateraHerria();
		ArrayList<Apartamentua> apartamentulista= new ArrayList<Apartamentua>();
		apartamentulista=Consultas.apartamentuDatuak();
		ArrayList<Apartamentua> apartamentulista2= new ArrayList<Apartamentua>();
		for (Apartamentua p:apartamentulista) {
			if (p.getHerria().equalsIgnoreCase(herria)){
				apartamentulista2.add(p);
			}
		}
		p2apart.ateraA(apartamentulista2);
		p2apart.filtroapart();
		return apartamentulista2;
	}
	public void filtroEtxea() {
		String herria=p1cop.ateraHerria();
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
		String euro = " \u20AC";
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
			pantailaratu=(" 200"+euro+"-ko billeteak: " + itzultzeko / 20000+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 20000;
		}
		if (itzultzeko >= 10000) {
			pantailaratu=(" 100"+euro+"-ko billeteak: " + itzultzeko / 10000+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 10000;
		}
		if (itzultzeko >= 5000) {
			pantailaratu=(" 50"+euro+"-ko billeteak: " + itzultzeko / 5000+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 5000;
		}
		if (itzultzeko >= 2000) {
			pantailaratu=(" 20"+euro+"-ko billeteak: " + itzultzeko / 2000+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 2000;
		}
		if (itzultzeko >= 1000) {
			pantailaratu=(" 10"+euro+"-ko billeteak: " + itzultzeko / 1000+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 1000;
		}
		if (itzultzeko >= 500) {
			pantailaratu=(" 5"+euro+"-ko billeteak: " + itzultzeko / 500+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 500;
		}
		if (itzultzeko >= 200) {
			pantailaratu=(" 2"+euro+"-ko txanponak: " + itzultzeko / 200+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 200;
		}
		if (itzultzeko >= 100) {
			pantailaratu=(" 1"+euro+"-ko txanponak: " + itzultzeko / 100+" \n");
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
			
			if (p.getDni().equals(nan) && p.getPasahitza().equals(pasahitza)){
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
//	public void setMip1cop(p1cop p1cop) {
//		this.p1cop = p1cop;
//	}
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
	
	public void setBaldintzak(PruebScroll pr) {
		this.pr = pr;
	}
	
	public void setp1cop_copia(P1_copia p1cop) {
		this.p1cop = p1cop;
	}
	
	
	
	


		

	

	
	

	
	
}
