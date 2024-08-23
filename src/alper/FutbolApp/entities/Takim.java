package alper.FutbolApp.entities;

import alper.FutbolApp.Databases.TakimDB;
import alper.FutbolApp.model.DatabaseModel;
import alper.FutbolApp.utility.FileIOWriter;
import alper.FutbolApp.utility.enums.ERenkler;

import java.util.List;

public class Takim extends BaseEntity {
	static int takimIdCount = 0;
	private  static DatabaseModel databaseModel=new DatabaseModel();
	private Integer stadyumID;
	private String takimIsim;
	private String baskanIsmi;
	private String kurulusTarihi;
	private ERenkler renkler;
//	private int menajerID=-1;
	
	
	public Takim(String takimIsim,Integer stadyumID, ERenkler renkler, String baskanIsmi, String kurulusTarihi,TakimDB takimDB) {
		this.takimIsim = takimIsim;
		this.stadyumID=stadyumID;
		this.renkler = renkler;
		this.baskanIsmi = baskanIsmi;
		this.kurulusTarihi = kurulusTarihi;
		this.id=++takimIdCount;
		takimDB.save(this);
		FileIOWriter.takimlariDosyayaYazdir(databaseModel);
	}
	
	public Takim(String takimIsim,TakimDB takimDB) {
		this.takimIsim = takimIsim;
		this.id=++takimIdCount;
		takimDB.save(this);
		
	}
	
	public Takim(TakimDB takimDB) {
		this.id=++takimIdCount;
		takimDB.save(this);
		FileIOWriter.takimlariDosyayaYazdir(databaseModel);
	}
	
	public Integer getStadyumID() {
		return stadyumID;
	}
	
	public void setStadyumID(Integer stadyumID) {
		this.stadyumID = stadyumID;
	}
	
	public static int getTakimIdCount() {
		return takimIdCount;
	}
	
	public static void setTakimIdCount(int takimIdCount) {
		Takim.takimIdCount = takimIdCount;
	}
	
	public String getTakimIsim() {
		return takimIsim;
	}
	
	public void setTakimIsim(String takimIsim) {
		this.takimIsim = takimIsim;
	}
	
	public String getBaskanIsmi() {
		return baskanIsmi;
	}
	
	public void setBaskanIsmi(String baskanIsmi) {
		this.baskanIsmi = baskanIsmi;
	}
	
	
	public String getKurulusTarihi() {
		return kurulusTarihi;
	}
	
	public void setKurulusTarihi(String kurulusTarihi) {
		this.kurulusTarihi = kurulusTarihi;
	}
	
	
	
	public ERenkler getRenkler() {
		return renkler;
	}
	
	public void setRenkler(ERenkler renkler) {
		this.renkler = renkler;
	}
	
	@Override
	public String toString() {
		return "Takim{" + "baskanIsmi='" + getBaskanIsmi() + '\'' + ", stadyumID=" + getStadyumID() + ", takimIsim='" + getTakimIsim() + '\'' + ", kurulusTarihi='" + getKurulusTarihi() + '\'' + ", renkler=" + getRenkler() + ", id=" + getId() + '}';
	}
}