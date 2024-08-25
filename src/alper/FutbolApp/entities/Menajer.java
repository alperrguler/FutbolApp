package alper.FutbolApp.entities;

import alper.FutbolApp.Databases.MenajerDB;
import alper.FutbolApp.model.DatabaseModel;
import alper.FutbolApp.utility.FileIOWriter;

import java.time.LocalDate;

public class Menajer extends BaseEntity {
	static int manajerIDCount=0;
	private  static DatabaseModel databaseModel= DatabaseModel.getInstance();

	private String isim;
	private String soyIsim;
	private String sifre;
	//	private long sozlesmeBedeli;  buraya sonradan sözleşme entitysi gelicek
	private LocalDate dogumTarihi;
	private int takimID;


	public Menajer(LocalDate dogumTarihi, String isim, String soyIsim,String sifre, int takimID, MenajerDB menajerDB) {
		this.dogumTarihi = dogumTarihi;
		this.isim = isim;
		this.soyIsim = soyIsim;
		this.takimID = takimID;
		this.sifre=sifre;
		this.id=++manajerIDCount;
		menajerDB.save(this);
		FileIOWriter.menajerleriDosyayaYazdir(databaseModel);

	}


	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public static int getManajerIDCount() {
		return manajerIDCount;
	}

	public static void setManajerIDCount(int manajerIDCount) {
		Menajer.manajerIDCount = manajerIDCount;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyIsim() {
		return soyIsim;
	}

	public void setSoyIsim(String soyIsim) {
		this.soyIsim = soyIsim;
	}

	public LocalDate getDogumTarihi() {
		return dogumTarihi;
	}

	public void setDogumTarihi(LocalDate dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}

	public int getTakimID() {
		return takimID;
	}

	public void setTakimID(int takimID) {
		this.takimID = takimID;
	}

	@Override
	public String toString() {
		return "Menajer{" + "dogumTarihi=" + getDogumTarihi() + ", isim='" + getIsim() + '\'' + ", sifre='" + getSifre() + '\'' + ", soyIsim='" + getSoyIsim() + '\'' + ", takimID=" + getTakimID() + ", id=" + getId() + '}';
	}
}