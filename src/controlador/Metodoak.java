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
	private String kod_err1 = "null";
	//private p1cop_copia p1cop;
	private int promozio_id=0;
	
	
	/**
	 * Kodeak datu basetik hartzen du eta ordaintzeko pantailatzen eramaten du
	 * @author taldea 4
	 */
	public void kodea() {
		String kodea="";
		String nana = lo1.ateraNanMd5();
		String [] promozio_array = new String[3];
		promozio_array= Consultas.promozioKod1(nana);
		kodea = promozio_array[0]+"-"+promozio_array[1];
		System.out.println("Kodea: "+kod_err1);
		
		//kodea=kod_err1+"-"+Consultas.promozioKod2(nana);
		ord1.hartu_Kodea(kodea);
		
		
			
		
	}
	
//***************Para que no salga una y otra vez la ventana de login comprobamos logueatutta y asi solo se abre una vez*****
	/**
	 * Logueatu bazaude erakuzten du
	 * @author taldea 4
	 * @return logueatuta
	 */
	public boolean logueatuta(){
		return logueatuta;
	}
	/**
	 * Logueatuta bazaude esaten du
	 * @author taldea 4
	 * @param erabakia
	 */
	public void logueatutabai(boolean erabakia) {
		logueatuta=erabakia;
	}
	/**
	 * Legedia onartuta badago esaten du eta datu bazean idazten du
	 * @author taldea 4
	 */
	public void legediaonartua() {
		Consultas.legediaonartua();
	}
///////////////////////////////////////////////////////////////////////////
	/**
	 * Prezioa metodoen klasera eramaten du
	 * @author taldea 4
	 * @param prezioa
	 */
	public void prezio_totala(String prezioa) {
		prezio_totala=prezioa;
	}
	/**
	 * Ostatu mota metodoen klasera eramaten du
	 * @author taldea 4
	 * @param ostatu
	 */
	public void ostatu_motaHartu(String ostatu) {
		ostatu_mota=ostatu;
	}
	/**
	 * ostatu mota metodoen pantailatik bueltatzen du
	 * @author taldea 4
	 * @return ostatu_mota
	 */
	public String ostatu_motaAtera() {
		return ostatu_mota;
	}
///////////////////////////////////////////////////////////////////////////
	/**
	 * lehenengo pantaila pizten du
	 * @author taldea 4
	 */
	public  void lehenengoLehioa() {
		p1cop.setVisible(true);
		
	}
	/**
	 * Ordaintzeko pantailatik lehenengora bueltatzen da
	 * @author taldea 4
	 */
	public  void lehenengoLehioa2() {
		ord1.setVisible(false);
		p1cop.dispose();
		BezeroAPP ap = new BezeroAPP();
		ap.arrancar();
		
	}
	
	
	/**
	 * Bigarren lehioa hotela pizten du
	 * @author taldea 4
	 */
	public void bigarrenLehioaHotela() {
		p1cop.setVisible(false);
		p2hot.setVisible(true);
	}
	/**
	 * bigarren lehioa apartamentua pizten du
	 * @author taldea 4
	 */
	public void bigarrenLehioaApartamentua() {
		p1cop.setVisible(false);
		p2apart.setVisible(true);
	}
	/**
	 * bigarren lehioa etxea pizten du
	 * @author taldea 4
	 */
	public void bigarrenLehioaEtxea() {
		p1cop.setVisible(false);
		p2etxe.setVisible(true);
	}
	/**
	 * hotela lehioa amatatzen du
	 * @author taldea 4
	 */
	public void lehioaHotelaItxi() {
		p2hot.setVisible(false);
	}
	/**
	 * Lehioa hotela irekitzen du
	 * @author taldea 4
	 */
	public void lehioaHotelaIreki() {
		p2hot.setVisible(true);
	}
	/**
	 * Lehioa apartamentua amatatzen du
	 * @author taldea 4
	 */
	public void lehioaApartamentuaItxi() {
		p2apart.setVisible(false);
	}
	/**
	 * etxea lehioa amatatzen du
	 * @author taldea 4
	 */
	public void lehioaEtxeaItxi() {
		p2etxe.setVisible(false);
	}
	/**
	 * Login lehioa irekitzen du
	 * @author taldea 4
	 */
	public void loginIreki() {
		lo1.setVisible(true);
		
	}
	//**********DENBORALDIA KALKULATZEKO METODOAK********
	/**
	 * Denboraldia kalkulatzen du prezioari gehitzeko
	 * @author taldea 4
	 * @return recargo
	 */
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
				 recargo = 50.00;
			}
		}
		//recargo=Consultas.
		
		return recargo;
		
		
	}
	/**
	 * Datu basetik jaiegunak ateratzen ditu
	 * @author taldea 4
	 * @return jaiegunak
	 */
	public ArrayList<java.sql.Date> jaiegunLista(){
		ArrayList<java.sql.Date> jaiegunak=Consultas.jaiegunLista();
		for (int i=0;i<jaiegunak.size();i++) {
			System.out.println(jaiegunak.get(i));
		}
		return jaiegunak;
	}
	//*****************ERRESERBAREN PREZIOA KALKULATZEKO METODOAK********************
	/**
	 * Ostatu mota hartzen du eta horrekin datu basean begiratzen dut gauzak zenbat balio diren ikusteko
	 * @author taldea 4
	 */
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
		
		
	
		logelakop=p1cop.ateraGelakop();
		egunak=p1cop.diadif();
		
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
		
		prezioa=logelakop*prezioa*egunak+recargo+recargo2;

		
		String diruaString = "";
		
		
		diruaString=Double.toString(prezioa);
		ord1.idatzi(diruaString);		
	}
	
	/**
	 * ostatu mota = apartamentua hartzen du datu basean begiratzen dut gauzak zenbat balio diren ikusteko
	 * @author taldea 4
	 */

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
		
		prezioa=logelakop*prezioa*egunak+recargo+recargo2;

		
		String diruaString = "";
		
		
		diruaString=Double.toString(prezioa);
		ord1.idatzi(diruaString);	
	}
	/**
	 * Ostatu mota etxea hartzen du eta datu basetik informazioa hartzen du etxearen prezioari buruz
	 * @author taldea 4
	 */
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
		
		prezioa=logelakop*prezioa*egunak+recargo+recargo2;

		
		String diruaString = "";
		
		
		diruaString=Double.toString(prezioa);
		ord1.idatzi(diruaString);	
	}
	/**
	 * Hirugarren lehioa irekitzen du
	 * @author taldea 4
	 */
	public void hirugarrenLehioa() {
		lo1.setVisible(false);
		ord1.setVisible(true);
		String diruaString = "";
		
		ord1.idatzi(diruaString);
		System.out.println(diruaString);
	}
	/**
	 * Amaiera lehioa irekitzen du
	 * @author taldea 4
	 */
	public void amaieraIreki() {

		ord1.setVisible(false);
		am1.setVisible(true);

		
		}
	/**
	 * Ordainketa pantaila irekitzen du hotelaren pantailatik
	 * @author taldea 4
	 */
	public void p2hotetoOrdainketa() {
		ord1.setVisible(true);
	}
	/**
	 * Ordainketa pantaila amatatzen du hotelaren pantailatik
	 * @author taldea 4
	 */
	public void p2hotetoOrdainketa2() {
		ord1.setVisible(false);
	}
	/**
	 * amaiera pantaila amatatzen du
	 * @author taldea 4
	 */
	public void agurratop1cop() {
		am1.setVisible(false);
		
		BezeroAPP ap = new BezeroAPP();
		p1cop.dispose();
		ap.arrancar();
		
		}
	/**
	 * Amaiera pantaila bost segundu eta gero amatatzen du
	 * @author taldea 4
	 */
	public void amaiera() {
		itxaron(5);
		am1.setVisible(false);
	}
	/**
	 * erregistratzeko pantaila eta legedia agertarazten du.
	 * @author taldea 4
	 */
	public void erregistratzekoPantailara() {
		lo1.setVisible(false);
		er1.setVisible(true);
		pr.setVisible(true);
		pr.terminos();
		}
	/**
	 * Erregistratzeko pantaila itxi eta datuak ezabatzen ditu
	 * @author taldea 4
	 */
	public void erregistroPantailaItxi() {
		
		er1.dispose();
		er1 = new Erregistratu();
		er1.setVisible(false);
	}
	/**
	 * Erreserba datu basera eramaten du
	 * @author taldea 4
	 */
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
		
		
		Erreserba erreserba =new Erreserba(0, id , getMD5(lo1.ateraNana()), p1cop.ateraData1(), p1cop.ateraData2(), p1cop.ateraPertsonakop(), ord1.prezio_totala(), p1cop.ateraGelakop(), p1cop.ateraPentsio(), p1cop.ateraOheMota(), p1cop.ateraPertsonakop(), tarifa);
		imprimatuTiketa(erreserba);
		Consultas.txertatuErreserba(erreserba);
		
	}
	/**
	 * Erreserba kopurua gehitzen ditu
	 * @author taldea 4
	 */
	public void erreserbaKopGehitu() {
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
		System.out.println(id+" OSTATU ID");
		Consultas.erreserbaKopGehitu(id);
	}
	/**
	 * Erreserba kodea eta jaieguna datu basera bidaltzen ditu
	 * @author taldea 4
	 */
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
	/**
	 * Erregistratu diren berriak dauzkaten kodeak datu basera igotzen du
	 * @author taldea 4
	 */
	public void promozioKodeaErregistroIgo() {
		kod_err1=er1.ateraKodea2();
		
		String zergatia="Erregistratu berria";
		String promozio_kod=kod_err1;
		String nan=getMD5(er1.nanAtera());
		System.out.println("nan atera: "+nan);
		if(!promozio_kod.equalsIgnoreCase("null")) {
		Consultas.Promozioa(zergatia, promozio_kod);
		promozio_id= Consultas.PromozioId();
		
		int prezioa=10;
		Consultas.PromozioaPrezioa(promozio_id, prezioa);
		
		Consultas.bezeroPromozioa(nan, promozio_id);
		if(tarifa.equalsIgnoreCase("Baxua")) {
			Consultas.Promozioa("Denboraldi Baxua", "Temp_baja");
			promozio_id= Consultas.PromozioId();
			
			int prezioa2=15;
			Consultas.PromozioaPrezioa(promozio_id, prezioa2);
			
			Consultas.bezeroPromozioa(nan, promozio_id);
			}
		}
	}
	/**
	 * Hotelaren filtroa
	 * @author taldea 4
	 */
	public void filtroZerbitzuak() {
		ArrayList<Zerbitzuak> zerbitzulist = Consultas.ostatuZerbitzuak();
		for (Zerbitzuak z:zerbitzulist) {
			
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
	/**
	 * Datu basetik filtratutako array apartamentu ateratzen du
	 * @author taldea 4
	 * @return apartamentulista2
	 */
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
	/**
	 * Datu basetik etxeen filtroa emandako datuak bere pantailara eramaten ditu
	 * @author taldea 4
	 */
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
	/**
	 * Bost segundo pantaila amatatzeko metodoa
	 * @author taldea 4
	 * @param segundos
	 */
	public  void itxaron(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
    }  
	/**
	 * Zenbaki bat negatiboa bat da balidatzen du
	 * @param zbk
	 * @return balidatu
	 */
	public boolean konprobatuNegatibo(double zbk) {
		boolean balidatu=false;
		if (zbk>0)
			balidatu=true;
		return balidatu;
	}
	/**
	 * Bzeroari itzuliak emateko metodoa
	 * @param zbk
	 * @return kanbioa
	 */
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
	/**
	 * Letra balidatzeko metodoa
	 * @author taldea 4
	 * @param zbk
	 * @return balidatu
	 */
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
	/**
	 * Faltatzen den dirua kalkulatzen du
	 * @author taldea 4
	 * @param prezioa
	 * @param zbk
	 * @return diru_falta
	 */
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
	/**
	 * Tiketa inprimatzeko metodoa
	 * @author taldea 4
	 * @param r1
	 */
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
	/**
	 * MD5-ra pasatzeko metodoa
	 * @param input
	 * @return hashtext
	 */
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
	

//	public  boolean ateraErabiltzailea(String nan, String pasahitza) {
//		boolean erabakia = false;
//		ArrayList <Bezeroa> arraybezer = new ArrayList<Bezeroa>();
//		arraybezer=modelo.Consultas.ateraErabiltzaileak();
//		nan=getMD5(nan);
//		System.out.println("nananan: "+nan);
//		
//		pasahitza = getMD5(pasahitza);
//		System.out.println("pasahitza: "+pasahitza);
//		for (Bezeroa p : arraybezer) {
//			System.out.println("nan 2 : "+p.getDni());
//			System.out.println("pasahitza 2 : "+p.getPasahitza());
//			if (p.getDni().equals(nan)) {
//				System.out.println("nan berdina");
//				if (p.getPasahitza().equals(pasahitza)){
//					erabakia = true;
//					System.out.println(erabakia);
//				}
//				
//
//			}
//		}
//
//		return (erabakia);
//
//	}
	/**
	 * Datu basetik erabiltzaileak badagoen ala ez komprobatzeko
	 * @param nan
	 * @param pasahitza
	 * @return erabakia
	 */
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
	 * @author taldea 4
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
	 * Zenbakien bitartzen nana-ren letra kalkulatzen du
	 * @author taldea 4
	 * @param dni
	 * @return
	 */
	public String KalkulatuLetra(int dni){
		String karaktereak="TRWAGMYFPDXBNJZSQVHLCKE";
		int modulo= dni % 23;
		char letra1 = karaktereak.charAt(modulo);
		String letra = Character.toString(letra1);
		return letra; 
	} 
	/**
	 * Bezero objektua hartu eta datui basera igotzen du
	 * @author taldea 4
	 * @param bezeroa
	 */
	public  void bezeroaIgo(Bezeroa bezeroa) {
		Consultas.txertatuBezeroa(bezeroa);
	}

///////////////////////////////////////////////////////////////////////////
//	public void setMip1cop(p1cop p1cop) {
//		this.p1cop = p1cop;
//	}
	/**
	 * Hotela pamntailaren erreferentzia
	 * @author taldea 4
	 * @param p2hot
	 */
	public void setMip2hot(P2_hotela p2hot) {
		this.p2hot=p2hot;
	}
	/**
	 * Apartamentua pantailaren erreferentzia
	 * @author taldea 4
	 * @param p2apart
	 */
	public void setMip2apart(P2_apartamentua p2apart) {
		this.p2apart=p2apart;
	}
	/**
	 * Etxea pantailaren erreferentzia
	 * @author taldea 4
	 * @param p2etxe
	 */
	public void setMip2etxe(P2_etxea p2etxe) {
		this.p2etxe=p2etxe;
	}
	/**
	 * Erregistratu pantailaren erreferentzia 
	 * @author taldea 4
	 * @param er1
	 */
	public void setMier1(Erregistratu er1) {
		this.er1 = er1;
	}
	/**
	 * Loginaren pantaila erreferentzia
	 * @author taldea 4
	 * @param lo1
	 */
	public void setMielo1(Login lo1) {
		this.lo1 = lo1;
	}
	
	/**
	 * Ordainketa pantailaren erreferentzia
	 * @author taldea 4
	 * @param ord1
	 */
	public void setMiord1(Ordainketa ord1) {
		this.ord1 = ord1;
	}
	/**
	 * Amaiera pantailaren erreferentzia
	 * @author taldea 4
	 * @param am1
	 */
	public void setMiam1(Amaiera am1) {
		this.am1 = am1;
	}
	/**
	 * Baldintzen pantailaren erreferentzia
	 * @author taldea 4
	 * @param pr
	 */
	public void setBaldintzak(PruebScroll pr) {
		this.pr = pr;
	}
	/**
	 * p1 kopiaren pantailaren erreferentzia
	 * @author taldea 4
	 * @param p1cop
	 */
	public void setp1cop_copia(P1_copia p1cop) {
		this.p1cop = p1cop;
	}
	/**
	 * Promozio id-aren datuak gordetzen ditu
	 * @author taldea 4
	 * @param promozioid
	 */
	public void setPromozioID(int promozioid) {
		promozio_id=promozioid;
	}
	
	


		

	

	
	

	
	
}
