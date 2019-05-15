package modelo;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controlador.*;


public class Consultas {

	Metodoak metodos;
	public static ArrayList<String> herriakAtera(){
		
		ArrayList<String> herrilista= new ArrayList<String>();
		PreparedStatement s=null;
		Connection konexioa=Conexion.getConexion();

		try {
			s = konexioa.prepareStatement("select DISTINCT herria from ostatu");
			ResultSet rs = s.executeQuery();
		
			String herria="";
			
			while (rs.next()) {
				herria=(rs.getString(1));

				herrilista.add(herria);
			}

		}catch(Exception e) {e.getMessage();
		System.out.println(e.getMessage());
		}
		return herrilista;
	}
	
	public static ArrayList <Hotela> hotelendatuakBanakakoa() {

		ArrayList <Hotela> hotelenlista = new ArrayList<Hotela>();
		PreparedStatement s=null;
		Connection konexioa=Conexion.getConexion();

		try {
			s = konexioa.prepareStatement("select * from hotelak_banakakoa");
			ResultSet rs = s.executeQuery();
			int izarkop=0;
			int ostatu_id=0;
			String izena="";
			String herria="";
			String helbidea="";
			int postaKod=0;
			String ostatu_mota="";
			int gela_kop=0;
			int erreserba_kop=0;
			String mota="";
			double prezioa=0;
			while (rs.next()) {
				izarkop=(rs.getInt(1));
				ostatu_id=(rs.getInt(2));
				izena=(rs.getString(3));
				herria=(rs.getString(4));
				helbidea=(rs.getString(5));
				postaKod=(rs.getInt(6));
				ostatu_mota=(rs.getString(7));
				gela_kop=(rs.getInt(8));
				erreserba_kop=(rs.getInt(9));
				mota=rs.getString(10);
				prezioa=rs.getDouble(11);

				Hotela h1= new Hotela(izarkop,ostatu_id,izena,herria,helbidea,postaKod,ostatu_mota,gela_kop,erreserba_kop,mota,prezioa);
				hotelenlista.add(h1);
			}

		}catch(Exception e) {e.getMessage();
		System.out.println(e.getMessage());
		}
		return hotelenlista;
		
	}
	public static ArrayList <Hotela> hotelendatuakBikoitza() {

		ArrayList <Hotela> hotelenlista = new ArrayList<Hotela>();
		PreparedStatement s=null;
		Connection konexioa=Conexion.getConexion();

		try {
			s = konexioa.prepareStatement("select * from hotelak_bikoitza");
			ResultSet rs = s.executeQuery();
			int izarkop=0;
			int ostatu_id=0;
			String izena="";
			String herria="";
			String helbidea="";
			int postaKod=0;
			String ostatu_mota="";
			int gela_kop=0;
			int erreserba_kop=0;
			String mota="";
			double prezioa=0;
			while (rs.next()) {
				izarkop=(rs.getInt(1));
				ostatu_id=(rs.getInt(2));
				izena=(rs.getString(3));
				herria=(rs.getString(4));
				helbidea=(rs.getString(5));
				postaKod=(rs.getInt(6));
				ostatu_mota=(rs.getString(7));
				gela_kop=(rs.getInt(8));
				erreserba_kop=(rs.getInt(9));
				mota=rs.getString(10);
				prezioa=rs.getDouble(11);

				Hotela h1= new Hotela(izarkop,ostatu_id,izena,herria,helbidea,postaKod,ostatu_mota,gela_kop,erreserba_kop,mota,prezioa);
				hotelenlista.add(h1);
			}

		}catch(Exception e) {e.getMessage();
		System.out.println(e.getMessage());
		}
		return hotelenlista;
	}
	public static ArrayList <Hotela> hotelendatuakSuite() {

		ArrayList <Hotela> hotelenlista = new ArrayList<Hotela>();
		PreparedStatement s=null;
		Connection konexioa=Conexion.getConexion();

		try {
			s = konexioa.prepareStatement("select * from hotelak_suite");
			ResultSet rs = s.executeQuery();
			int izarkop=0;
			int ostatu_id=0;
			String izena="";
			String herria="";
			String helbidea="";
			int postaKod=0;
			String ostatu_mota="";
			int gela_kop=0;
			int erreserba_kop=0;
			String mota="";
			double prezioa=0;
			while (rs.next()) {
				izarkop=(rs.getInt(1));
				ostatu_id=(rs.getInt(2));
				izena=(rs.getString(3));
				herria=(rs.getString(4));
				helbidea=(rs.getString(5));
				postaKod=(rs.getInt(6));
				ostatu_mota=(rs.getString(7));
				gela_kop=(rs.getInt(8));
				erreserba_kop=(rs.getInt(9));
				mota=rs.getString(10);
				prezioa=rs.getDouble(11);

				Hotela h1= new Hotela(izarkop,ostatu_id,izena,herria,helbidea,postaKod,ostatu_mota,gela_kop,erreserba_kop,mota,prezioa);
				hotelenlista.add(h1);
			}

		}catch(Exception e) {e.getMessage();
		System.out.println(e.getMessage());
		}
		return hotelenlista;
	}
	
	public static ArrayList <Apartamentua> apartamentuDatuak() {

		ArrayList <Apartamentua> apartamentulista = new ArrayList<Apartamentua>();
		PreparedStatement s=null;
		Connection konexioa=Conexion.getConexion();

		try {
			s = konexioa.prepareStatement("select * from apartamentuak");
			ResultSet rs = s.executeQuery();
			int m2;
			int solairua;
			int ostatu_id;
			String izena;
			String herria;
			String helbidea;
			int postaKod;
			String ostatu_mota;
			int gela_kopuru;
			int erreserba_kopuru;
			int komun_kop;
			double prezioa;

			while (rs.next()) {
				m2= rs.getInt(1);
				solairua=rs.getInt(2);
				ostatu_id=rs.getInt(3);
				izena=rs.getString(4);
				herria=rs.getString(5);
				helbidea=rs.getString(6);
				postaKod=rs.getInt(7);
				ostatu_mota=rs.getString(8);
				gela_kopuru=rs.getInt(9);
				erreserba_kopuru=rs.getInt(10);
				komun_kop=rs.getInt(11);
				prezioa=rs.getDouble(12);
				Apartamentua a1= new Apartamentua(m2,solairua, ostatu_id, izena,herria, helbidea, postaKod,ostatu_mota, gela_kopuru, erreserba_kopuru,komun_kop,prezioa);
				apartamentulista.add(a1);
			}

		}catch(Exception e) {e.getMessage();
		System.out.println(e.getMessage());
		}
		return apartamentulista;
	}
	public static ArrayList <Etxea> etxeDatuak() {

		ArrayList <Etxea> etxelista = new ArrayList<Etxea>();
		PreparedStatement s=null;
		Connection konexioa=Conexion.getConexion();

		try {
			s = konexioa.prepareStatement("SELECT * FROM `etxeak` WHERE ostatu_mota like 'E'");
			ResultSet rs = s.executeQuery();
			double m2=0; 
			int ostatu_id=0;
			String izena="";
			String herria="";
			String helbidea="";
			int posta_kod=0;
			String ostatu_mota="";			
			int gela_kop=0;
			int erreserba_kop=0;
			int komun_kop = 0;
			double prezioa;
			
			while (rs.next()) {
				m2=rs.getDouble(1); 
				ostatu_id=rs.getInt(2);
				izena=rs.getString(3);
				herria=rs.getString(4);
				helbidea=rs.getString(5);
				posta_kod=rs.getInt(6);
				ostatu_mota=rs.getString(7);			
				gela_kop=rs.getInt(8);
				erreserba_kop=rs.getInt(9);
				komun_kop = rs.getInt(10);
				prezioa= rs.getDouble(11);
				Etxea e1 = new Etxea(m2, ostatu_id, izena, herria, helbidea, posta_kod, ostatu_mota,gela_kop, erreserba_kop, komun_kop,prezioa);
				
				etxelista.add(e1);
				
			}

		}catch(Exception e) {e.getMessage();
		System.out.println(e.getMessage());
		}
		return etxelista;
	}
	public static void erreserbaKopGehitu(int ostatu_id) {
		Connection conexion = modelo.Conexion.getConexion();
		
		int erreserba_kop=0;
		try {
			Statement s = conexion.createStatement();
			String query = ("SELECT ostatu.erreserba_kopuru FROM ostatu WHERE ostatu_id ="+ostatu_id);
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				erreserba_kop=rs.getInt(1);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		erreserba_kop=erreserba_kop+1;
		try {
			PreparedStatement s = (PreparedStatement) conexion.prepareStatement(
					"UPDATE `ostatu` SET `erreserba_kopuru`="+erreserba_kop+" WHERE ostatu_id="+ostatu_id);
				
			s.executeUpdate();
			s.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
	}
	public static String[] promozioKod1(String nan) {
		Connection conexion = modelo.Conexion.getConexion();
		String [] promozio_kod=new String[3];
		int kont =0;
		try {
			Statement s = conexion.createStatement();
			String query = ("SELECT promozioa.promozio_kodea FROM promozioa, bezeroa, bezeroa_promozioa\r\n" + 
					"WHERE bezeroa.nan = bezeroa_promozioa.bezeroa_nan AND\r\n" + 
					"bezeroa_promozioa.promozio_id = promozioa.promozio_id\r\n" + 
					"AND bezeroa.nan like '"+nan+"'");
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				promozio_kod[kont]=rs.getString(1);
				kont++;
			}

		} catch (SQLException e) {
			System.out.println("Kod errorea1 "+e.getMessage());
		}
		return promozio_kod;
	}
	public static String promozioKod2(String nan) {
		Connection conexion = modelo.Conexion.getConexion();
		String promozio_kod="";
		try {
			Statement s = conexion.createStatement();
			String query = ("SELECT promozioa.promozio_kodea FROM promozioa, bezeroa, bezeroa_promozioa\r\n" + 
					"WHERE bezeroa.nan = bezeroa_promozioa.bezeroa_nan AND\r\n" + 
					"bezeroa_promozioa.promozio_id = promozioa.promozio_id\r\n" + 
					"AND bezeroa.nan like '"+nan+"'");
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				promozio_kod=rs.getString(2);
			}

		} catch (SQLException e) {
			System.out.println("Kod errorea2 "+e.getMessage());
		}
		return promozio_kod;
	}
	public static ArrayList<Bezeroa> ateraErabiltzaileak() {
		Connection conexion = modelo.Conexion.getConexion();
		ArrayList<Bezeroa> Arraybezero = new ArrayList<Bezeroa>();
		String dni = "";
		String izena = "";
		String abizena = "";
		String jaiotze;
		String pasahitza = "";
		try {
			Statement s = conexion.createStatement();
			String query = "select * from bezeroa";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				dni = rs.getString(1);
				izena = rs.getString(2);
				abizena = rs.getString(3);
				jaiotze = rs.getString(4);
				pasahitza = rs.getString(5);
				Bezeroa bezero = new Bezeroa(dni, izena, abizena, pasahitza,jaiotze);
				Arraybezero.add(bezero);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return (Arraybezero);
	}
	public static ArrayList<java.sql.Date>jaiegunLista() {
		
		Connection conexion = modelo.Conexion.getConexion();
		ArrayList<java.sql.Date> jaiegunak = new ArrayList<java.sql.Date>();
		java.sql.Date egunak;
		try {
			Statement s = conexion.createStatement();
			String query = "SELECT jaiEgun_data FROM jaiegunak";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				egunak=rs.getDate(1);
				jaiegunak.add(egunak);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return (jaiegunak);
	}
	public static void txertatuBezeroa(Bezeroa bezeroa) {
		Connection conexion = modelo.Conexion.getConexion();
		
		try {
			PreparedStatement s = (PreparedStatement) conexion.prepareStatement(
					"INSERT INTO `bezeroa` (`nan`, `izena`, `abizenak`, `jaiotze_data`, `pasahitza`)"
							+ " VALUES(?, ?, ?, ?, ?)");
			s.setString(1, bezeroa.getDni());
			s.setString(2, bezeroa.getIzena());
			s.setString(3, bezeroa.getAbizena());
			s.setString(4, bezeroa.getData());
			s.setString(5, bezeroa.getPasahitza());

			s.executeUpdate();
			s.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public static void txertatuErreserba(Erreserba e1) {
		Connection conexion = modelo.Conexion.getConexion();
		
		try {
			PreparedStatement s = (PreparedStatement) conexion.prepareStatement(
					"INSERT INTO `erreserba` ( `ostatu_ostatu_id`, `bezeroa_nan`, `pertsona_kopuru`, `erreserbaGela_kopuru`, `pentsio_mota`, `tarifa_denboraldia`, `sartze_data`, `irtetze_data`, `prezio_totala`)"
								+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			s.setInt(1,e1.getOstatu_id());
			s.setString(2, e1.getBezero_nan());
			s.setInt(3, e1.getPertsona_kop());
			s.setInt(4,e1.getErreserba_gela_kop() );
			s.setString(5, e1.getPentsio_mota());
			s.setString(6, e1.getTarifa_denboraldia());
			s.setString(7, e1.getSartze_data());
			s.setString(8, e1.getIrtetze_data());
			s.setDouble(9,e1.getPrezio_totala());
			
			s.executeUpdate();
			s.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static void erreserbaJaiegunaIgo(int erreserba_kod, int jaiegun_kod) {
		Connection conexion = modelo.Conexion.getConexion();
		
		try {
			PreparedStatement s = (PreparedStatement) conexion.prepareStatement(
					"INSERT INTO `erreserba_jaiegunak`(`erreserba_erreserba_kod`, `jaiEgunak_jaiEgunak_kod`)"
					+ " VALUES (?, ?)");
			s.setInt(1, erreserba_kod);
			s.setInt(2, jaiegun_kod);
			
			s.executeUpdate();
			s.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public static void legediaonartua() {
		Connection conexion = modelo.Conexion.getConexion();
		
		try {
			PreparedStatement s = (PreparedStatement) conexion.prepareStatement(
					"INSERT INTO `legedia`(`id_bezeroa`) VALUES (?)");
			s.setInt(1, 0);
			s.executeUpdate();
			s.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static boolean konprobatuDatuBasea(String Nan) {
		Connection conexion = modelo.Conexion.getConexion();
	
		String dni = "";
		boolean erabakia = false;

		try {
			Statement s = conexion.createStatement();
			String query = "select * from cliente";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				dni = rs.getString(1);
				if (dni.equals(Nan)) {
					erabakia = true;
					break;
				}

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return erabakia;
	}

	public static double logelaPrezioaSuite(int ostatu_id) {
		Connection conexion = modelo.Conexion.getConexion();
	
		double logela_prezioa=0;

		try {
			Statement s = conexion.createStatement();
			String query = "SELECT prezioa FROM `hotelak_suite` WHERE ostatu_id ="+ostatu_id;
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				logela_prezioa=rs.getDouble(1);
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return logela_prezioa;
	}
	public static double logelaPrezioaBikoitza(int ostatu_id) {
		Connection conexion = modelo.Conexion.getConexion();
	
		double logela_prezioa=0;

		try {
			Statement s = conexion.createStatement();
			String query = "SELECT prezioa FROM `hotelak_bikoitza` WHERE ostatu_id ="+ostatu_id;
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				logela_prezioa=rs.getDouble(1);
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return logela_prezioa;
	}
	public static double logelaPrezioaBanakakoa(int ostatu_id) {
		Connection conexion = modelo.Conexion.getConexion();
	
		double logela_prezioa=0;

		try {
			Statement s = conexion.createStatement();
			String query = "SELECT prezioa FROM `hotelak_banakakoa` WHERE ostatu_id ="+ostatu_id;
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				logela_prezioa=rs.getDouble(1);
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return logela_prezioa;
	}
	public static double logela_prezioaEtxeApart(int ostatu_id) {
		Connection conexion = modelo.Conexion.getConexion();
	
		double logela_prezioa=0;

		try {
			Statement s = conexion.createStatement();
			String query = "select prezioa from etxeakprezioa where etxea_etxe_kod="+ostatu_id;
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				logela_prezioa=rs.getDouble(1);
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return logela_prezioa;
	}
	public static int erreserbaKod() {
		Connection conexion = modelo.Conexion.getConexion();
	
		
		int erreserba_kod=0;
		try {
			Statement s = conexion.createStatement();
			String query = "SELECT MAX(erreserba_kod) FROM erreserba";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				erreserba_kod=rs.getInt(1);
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return erreserba_kod;
	}
	public void misMetodos(Metodoak metodos) {
		this.metodos=metodos;
	}
	public static void bezeroPromozioa(String nan, int promozio_id) {
		Connection conexion = modelo.Conexion.getConexion();
		System.out.println(nan);
		try {
			PreparedStatement s = (PreparedStatement) conexion.prepareStatement(
					"INSERT INTO `bezeroa_promozioa`(`bezeroa_nan`, `promozio_id`) "
					+ "VALUES (? ,?)");
			s.setString(1, nan);
			s.setInt(2, promozio_id);
			s.executeUpdate();
			s.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public static void Promozioa(String zergatia, String promozio_kod) {
		Connection conexion = modelo.Conexion.getConexion();
		
		try {
			PreparedStatement s = (PreparedStatement) conexion.prepareStatement(
					"INSERT INTO `promozioa`( `promozio_zergatia`, `promozio_kodea`) "
					+ "VALUES (?, ?)");
			s.setString(1, zergatia);
			s.setString(2, promozio_kod);
			s.executeUpdate();
			s.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public static void PromozioaPrezioa(int promozio_id, int prezioa) {
		Connection conexion = modelo.Conexion.getConexion();
		
		try {
			PreparedStatement s = (PreparedStatement) conexion.prepareStatement(
					"INSERT INTO `promozio_prezioa`(`prom_prez_kod`, `promozio_prez`) "
					+ "VALUES (?, ?)");
			s.setInt(1, promozio_id);
			s.setInt(2, prezioa);
			s.executeUpdate();
			s.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public static int PromozioId() {
		Connection conexion = modelo.Conexion.getConexion();
	
		
		int promozio_id=0;
		try {
			Statement s = conexion.createStatement();
			String query = "SELECT MAX(promozio_id) FROM promozioa";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				promozio_id=rs.getInt(1);
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return promozio_id;
	}
	public static ArrayList<Integer> zerbitzuPrezioak() {
		Connection conexion = modelo.Conexion.getConexion();
		ArrayList<Integer> prezioak = new ArrayList<Integer>();
		
		try {
			Statement s = conexion.createStatement();
			String query = "SELECT zerbitzu_prezioa.prezioa FROM zerbitzugehigarriak, zerbitzugehigarriak_zerbitzu_prezioa,zerbitzu_prezioa WHERE zerbitzugehigarriak.kod_zerbitzuak = zerbitzugehigarriak_zerbitzu_prezioa.zerbitzuGehigarriak_kod_zerbitzuak AND zerbitzugehigarriak_zerbitzu_prezioa.zerbitzu_prezioa_prezio_kod = zerbitzu_prezioa.prezio_kod";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				prezioak.add(rs.getInt(1));
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return prezioak;
	}
	public static ArrayList<Zerbitzuak> ostatuZerbitzuak() {
		Connection conexion = modelo.Conexion.getConexion();
		ArrayList<Zerbitzuak> zerbitzulist = new ArrayList<Zerbitzuak>();
		int ostatu_id;
		String izena;
		int zerbitzu_kod;
		
		try {
			Statement s = conexion.createStatement();
			String query = "SELECT ostatu.ostatu_id, zerbitzugehigarriak.izena, zerbitzugehigarriak.kod_zerbitzuak\r\n" + 
					"FROM zerbitzugehigarriak, zerbitzugehigarriak_zerbitzu_prezioa,zerbitzu_prezioa, ostatu, zerbitzugehigarriak_ostatu\r\n" + 
					"WHERE zerbitzugehigarriak.kod_zerbitzuak = zerbitzugehigarriak_zerbitzu_prezioa.zerbitzuGehigarriak_kod_zerbitzuak\r\n" + 
					"AND zerbitzugehigarriak_zerbitzu_prezioa.zerbitzu_prezioa_prezio_kod = zerbitzu_prezioa.prezio_kod";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				ostatu_id=rs.getInt(1);
				izena=rs.getString(2);
				zerbitzu_kod=rs.getInt(3);
				Zerbitzuak z= new Zerbitzuak(ostatu_id, izena, zerbitzu_kod);
				zerbitzulist.add(z);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return zerbitzulist;
	}
}
