package alper.FutbolApp.entities;


import alper.FutbolApp.Databases.LigDB;
import alper.FutbolApp.model.DatabaseModel;
import alper.FutbolApp.utility.FileIOWriter;
import alper.FutbolApp.utility.enums.EBolge;
import alper.FutbolApp.utility.enums.EKume;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Lig extends BaseEntity {
	private  static DatabaseModel databaseModel=DatabaseModel.getInstance();
	static int ligIDCount = 0;
	//TODO lig puan listesi
	private String ligIsmi;
	private List<Integer> takimIDList;
	//	private List<Integer> takimPuan; daha sonra yapılacak
	private String sezon;
	private EKume kume;
	private EBolge bolge;
	private LocalDate baslangicTarihi;




	public Lig(LigDB ligDB) {
		this.id=++ligIDCount;
		takimIDList=new ArrayList<>();
		ligDB.save(this);
		FileIOWriter.ligleriDosyayaYazdir(databaseModel);

	}


	public Lig(String ligIsmi, List<Integer> takimIDList,LigDB ligDB,LocalDate baslangicTarihi) {
		this.ligIsmi = ligIsmi;
		this.takimIDList = takimIDList;
		this.id=++ligIDCount;
		this.baslangicTarihi=baslangicTarihi;
		takimIDList=new ArrayList<>();
		ligDB.save(this);
		FileIOWriter.ligleriDosyayaYazdir(databaseModel);
	}

	public Lig(String ligIsmi, LigDB ligDB) {
		this.ligIsmi = ligIsmi;
		takimIDList=new ArrayList<>();
		this.id=++ligIDCount;
		ligDB.save(this);
		FileIOWriter.ligleriDosyayaYazdir(databaseModel);
	}

	public Lig(String ligIsmi, String sezon, EKume kume, EBolge bolge, LigDB ligDB,LocalDate baslangicTarihi) {
		this.ligIsmi = ligIsmi;
		this.sezon = sezon;
		this.kume = kume;
		this.bolge = bolge;
		this.id=++ligIDCount;
		this.baslangicTarihi=baslangicTarihi;
		takimIDList=new ArrayList<>();
		ligDB.save(this);
		FileIOWriter.ligleriDosyayaYazdir(databaseModel);

	}

	public LocalDate getBaslangicTarihi() {
		return baslangicTarihi;
	}

	public void setBaslangicTarihi(LocalDate baslangicTarihi) {
		this.baslangicTarihi = baslangicTarihi;
	}

	public static int getLigIDCount() {
		return ligIDCount;
	}

	public static void setLigIDCount(int ligIDCount) {
		Lig.ligIDCount = ligIDCount;
	}

	public String getLigIsmi() {
		return ligIsmi;
	}

	public void setLigIsmi(String ligIsmi) {
		this.ligIsmi = ligIsmi;
	}

	public List<Integer> getTakimIDList() {
		return takimIDList;
	}

	public void setTakimIDList(List<Integer> takimIDList) {
		this.takimIDList = takimIDList;
	}

	public String getSezon() {
		return sezon;
	}

	public void setSezon(String sezon) {
		this.sezon = sezon;
	}

	public EKume getKume() {
		return kume;
	}

	public void setKume(EKume kume) {
		this.kume = kume;
	}

	public EBolge getBolge() {
		return bolge;
	}

	public void setBolge(EBolge bolge) {
		this.bolge = bolge;
	}

	@Override
	public String toString() {
		return "Lig{" + "baslangicTarihi=" + getBaslangicTarihi() + ", bolge=" + getBolge() + ", kume=" + getKume() + ", ligIsmi='" + getLigIsmi() + '\'' + ", sezon='" + getSezon() + '\'' + ", takimIDList=" + getTakimIDList() + ", id=" + getId() + '}';
	}
}