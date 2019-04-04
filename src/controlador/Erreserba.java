package controlador;
import java.sql.*;
public class Erreserba {

	private int erreserba_kod;
	private int ostatu_id;
	private String bezero_nan;
	private String sartze_data;
	private String irtetze_data;
	private int pertsona_kop;
	private double prezio_totala;
	private int erreserba_gela_kop;
	private String pentsio_mota;
	private String ohe_mota;
	private int ohe_kop;
	private String tarifa_denboraldia;
	
	public Erreserba(int erreserba_kod, int ostatu_id, String bezero_nan, String sartze_data, String irtetze_data,
			int pertsona_kop, double prezio_totala, int erreserba_gela_kop, String pentsio_mota, String ohe_mota,
			int ohe_kop, String tarifa_denboraldia) {
		
		this.erreserba_kod = erreserba_kod;
		this.ostatu_id = ostatu_id;
		this.bezero_nan = bezero_nan;
		this.sartze_data = sartze_data;
		this.irtetze_data = irtetze_data;
		this.pertsona_kop = pertsona_kop;
		this.prezio_totala = prezio_totala;
		this.erreserba_gela_kop = erreserba_gela_kop;
		this.pentsio_mota = pentsio_mota;
		this.ohe_mota = ohe_mota;
		this.ohe_kop = ohe_kop;
		this.tarifa_denboraldia = tarifa_denboraldia;
	}

	public int getErreserba_kod() {
		return erreserba_kod;
	}

	public void setErreserba_kod(int erreserba_kod) {
		this.erreserba_kod = erreserba_kod;
	}

	public int getOstatu_id() {
		return ostatu_id;
	}

	public void setOstatu_id(int ostatu_id) {
		this.ostatu_id = ostatu_id;
	}

	public String getBezero_nan() {
		return bezero_nan;
	}

	public void setBezero_nan(String bezero_nan) {
		this.bezero_nan = bezero_nan;
	}

	public String getSartze_data() {
		return sartze_data;
	}

	public void setSartze_data(String sartze_data) {
		this.sartze_data = sartze_data;
	}

	public String getIrtetze_data() {
		return irtetze_data;
	}

	public void setIrtetze_data(String irtetze_data) {
		this.irtetze_data = irtetze_data;
	}

	public int getPertsona_kop() {
		return pertsona_kop;
	}

	public void setPertsona_kop(int pertsona_kop) {
		this.pertsona_kop = pertsona_kop;
	}

	public double getPrezio_totala() {
		return prezio_totala;
	}

	public void setPrezio_totala(double prezio_totala) {
		this.prezio_totala = prezio_totala;
	}

	public int getErreserba_gela_kop() {
		return erreserba_gela_kop;
	}

	public void setErreserba_gela_kop(int erreserba_gela_kop) {
		this.erreserba_gela_kop = erreserba_gela_kop;
	}

	public String getPentsio_mota() {
		return pentsio_mota;
	}

	public void setPentsio_mota(String pentsio_mota) {
		this.pentsio_mota = pentsio_mota;
	}

	public String getOhe_mota() {
		return ohe_mota;
	}

	public void setOhe_mota(String ohe_mota) {
		this.ohe_mota = ohe_mota;
	}

	public int getOhe_kop() {
		return ohe_kop;
	}

	public void setOhe_kop(int ohe_kop) {
		this.ohe_kop = ohe_kop;
	}

	public String getTarifa_denboraldia() {
		return tarifa_denboraldia;
	}

	public void setTarifa_denboraldia(String tarifa_denboraldia) {
		this.tarifa_denboraldia = tarifa_denboraldia;
	}

	@Override
	public String toString() {
		
		return
				" \n"
				+"                                                             BIDAI ON S.L.                        "+" \t\n"
				+" **********************************************************************************************************************"+" \t\n"	
				+"Erreserba erreserba_kod=" + erreserba_kod+" \t" + ", ostatu_id=" + ostatu_id+" \t"
				+ ", bezero_nan=" + bezero_nan+" \t"+ ", sartze_data=" + sartze_data+" \t" 
				+ ", irtetze_data=" + irtetze_data+" \t" + ", pertsona_kop=" + pertsona_kop+" \t"
				+ ", prezio_totala=" + prezio_totala+" \t" + ", erreserba_gela_kop=" + erreserba_gela_kop+" \t"
				+ ", pentsio_mota="+ pentsio_mota+" \t" + ", ohe_mota=" + ohe_mota+" \t"
				+ ", ohe_kop=" + ohe_kop+" \t" + ", tarifa_denboraldia="+ tarifa_denboraldia;
	}
	
	
	
}
