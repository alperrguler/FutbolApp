package alper.FutbolApp.entities;

import alper.FutbolApp.Databases.MusabakaDB;

import java.time.LocalDate;

public class Musabaka extends BaseEntity {
	static int musabakaIDCOunt=0;
	private String  evSahibi;
	private String  misafirTakim;
	private String stadyum;
	private int evSahibiSkor;
	private int misafirTakimSkor;
	private String hakemIsmi;
	private LocalDate musabakaTarihi; //localdate time yap
	//sonradan stadyumID eklenecek
	
	
	public Musabaka(String  evSahibi, String  misafirTakim, String stadyum, int evSahibiSkor, int misafirTakimSkor,
	                String hakemIsmi, LocalDate musabakaTarihi, MusabakaDB musabakaDB) {
		this.evSahibi = evSahibi;
		this.misafirTakim = misafirTakim;
		this.stadyum = stadyum;
		this.evSahibiSkor = evSahibiSkor;
		this.misafirTakimSkor = misafirTakimSkor;
		this.hakemIsmi = hakemIsmi;
		this.musabakaTarihi = musabakaTarihi;
		musabakaDB.save(this);
	}
	
	public Musabaka(String evSahibi, String misafirTakim) {
		this.evSahibi=evSahibi;
		this.misafirTakim=misafirTakim;
	}
	
	
	public static int getMusabakaIDCOunt() {
		return musabakaIDCOunt;
	}
	
	public static void setMusabakaIDCOunt(int musabakaIDCOunt) {
		Musabaka.musabakaIDCOunt = musabakaIDCOunt;
	}
	
	public String getEvSahibi() {
		return evSahibi;
	}
	
	public void setEvSahibi(String  evSahibi) {
		this.evSahibi = evSahibi;
	}
	
	public String getMisafirTakim() {
		return misafirTakim;
	}
	
	public void setMisafirTakim(String misafirTakim) {
		this.misafirTakim = misafirTakim;
	}
	
	public String getStadyum() {
		return stadyum;
	}
	
	public void setStadyum(String stadyum) {
		this.stadyum = stadyum;
	}
	
	public int getEvSahibiSkor() {
		return evSahibiSkor;
	}
	
	public void setEvSahibiSkor(int evSahibiSkor) {
		this.evSahibiSkor = evSahibiSkor;
	}
	
	public int getMisafirTakimSkor() {
		return misafirTakimSkor;
	}
	
	public void setMisafirTakimSkor(int misafirTakimSkor) {
		this.misafirTakimSkor = misafirTakimSkor;
	}
	
	public String getHakemIsmi() {
		return hakemIsmi;
	}
	
	public void setHakemIsmi(String hakemIsmi) {
		this.hakemIsmi = hakemIsmi;
	}
	
	public LocalDate getMusabakaTarihi() {
		return musabakaTarihi;
	}
	
	public void setMusabakaTarihi(LocalDate musabakaTarihi) {
		this.musabakaTarihi = musabakaTarihi;
	}
	

	public String toStringFikstur() {
		return "Musabaka{" + "evSahibi=" + getEvSahibi()+" VS " + ", misafirTakim=" + getMisafirTakim() + ", " +
				"musabakaTarihi=" + getMusabakaTarihi() +  '}';
	}
	@Override
	public String toString() {
		return "Musabaka{" + "evSahibi=" + getEvSahibi() + ", misafirTakim=" + getMisafirTakim() + ", stadyum='" + getStadyum() + '\'' + ", evSahibiSkor=" + getEvSahibiSkor() + ", misafirTakimSkor=" + getMisafirTakimSkor() + ", hakemIsmi='" + getHakemIsmi() + '\'' + ", musabakaTarihi=" + getMusabakaTarihi() + ", id=" + getId() + '}';
	}
}