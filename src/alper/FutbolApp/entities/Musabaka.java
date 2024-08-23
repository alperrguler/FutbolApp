package alper.FutbolApp.entities;

import alper.FutbolApp.Databases.MusabakaDB;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class Musabaka extends BaseEntity {
	static int musabakaIDCOunt = 0;
	
	private Integer evSahibiID;
	private Integer misafirTakimID;
	private Stadyum stadyum;
	private int evSahibiSkor;
	private int misafirTakimSkor;
	private String hakemIsmi;
	private LocalDate musabakaTarihi; //localdate time yap
	private Integer ligID;
	//sonradan stadyumID eklenecek
	
	
	public Musabaka(Integer evSahibiID, Integer misafirTakimID, Stadyum stadyum, int evSahibiSkor, int misafirTakimSkor
			, String hakemIsmi, LocalDate musabakaTarihi, Integer ligID, MusabakaDB musabakaDB) {
		this.evSahibiID = evSahibiID;
		this.misafirTakimID = misafirTakimID;
		this.stadyum = stadyum;
		this.evSahibiSkor = evSahibiSkor;
		this.misafirTakimSkor = misafirTakimSkor;
		this.hakemIsmi = hakemIsmi;
		this.musabakaTarihi = musabakaTarihi;
		this.ligID = ligID;
		musabakaDB.save(this);
	}
	
	public Musabaka(Integer evSahibiID, Integer misafirTakimID) {
		this.evSahibiID = evSahibiID;
		this.misafirTakimID = misafirTakimID;
	}
	

	
	
	public Integer getEvSahibiID() {
		return evSahibiID;
	}
	
	public void setEvSahibiID(Integer evSahibiID) {
		this.evSahibiID = evSahibiID;
	}
	
	public int getEvSahibiSkor() {
		return evSahibiSkor;
	}
	
	public void setEvSahibiSkor(int evSahibiSkor) {
		this.evSahibiSkor = evSahibiSkor;
	}
	
	public String getHakemIsmi() {
		return hakemIsmi;
	}
	
	public void setHakemIsmi(String hakemIsmi) {
		this.hakemIsmi = hakemIsmi;
	}
	
	public Integer getLigID() {
		return ligID;
	}
	
	public void setLigID(Integer ligID) {
		this.ligID = ligID;
	}
	
	public Integer getMisafirTakimID() {
		return misafirTakimID;
	}
	
	public void setMisafirTakimID(Integer misafirTakimID) {
		this.misafirTakimID = misafirTakimID;
	}
	
	public int getMisafirTakimSkor() {
		return misafirTakimSkor;
	}
	
	public void setMisafirTakimSkor(int misafirTakimSkor) {
		this.misafirTakimSkor = misafirTakimSkor;
	}
	
	public static int getMusabakaIDCOunt() {
		return musabakaIDCOunt;
	}
	
	public static void setMusabakaIDCOunt(int musabakaIDCOunt) {
		Musabaka.musabakaIDCOunt = musabakaIDCOunt;
	}
	
	public LocalDate getMusabakaTarihi() {
		return musabakaTarihi;
	}
	
	public void setMusabakaTarihi(LocalDate musabakaTarihi) {
		this.musabakaTarihi = musabakaTarihi;
	}
	
	public Stadyum getStadyum() {
		return stadyum;
	}
	
	public void setStadyum(Stadyum stadyum) {
		this.stadyum = stadyum;
	}
	
	
	public String toStringFikstur() {
		return "Musabaka{" + "Ev Sahibi = " + getEvSahibiID() + " VS " + "Misafir Takım = " + getMisafirTakimID() + ","
				+ " " + "musabakaTarihi=" + getMusabakaTarihi() + '}';
	}
	
	@Override
	public String toString() {
		return "Musabaka{" + "evSahibiID=" + getEvSahibiID() + ", misafirTakimID=" + getMisafirTakimID() + ", stadyum" + "='" + getStadyum() + '\'' + ", evSahibiSkor=" + getEvSahibiSkor() + ", misafirTakimSkor=" + getMisafirTakimSkor() + ", hakemIsmi='" + getHakemIsmi() + '\'' + ", musabakaTarihi=" + getMusabakaTarihi() + ", ligID=" + getLigID() + ", id=" + getId() + '}';
	}
}