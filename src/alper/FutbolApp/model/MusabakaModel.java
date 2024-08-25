package alper.FutbolApp.model;

import alper.FutbolApp.Databases.FutbolcuDB;
import alper.FutbolApp.Databases.LigDB;
import alper.FutbolApp.Databases.StadyumDB;
import alper.FutbolApp.Databases.TakimDB;
import alper.FutbolApp.entities.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MusabakaModel {
	private static TakimDB takimDB;
	private static LigDB ligDB;
	private static FutbolcuDB futbolcuDB;

	private Integer musabakaID;
	private Takim evSahibiTakim;
	private Takim misafirTakim;
	private Stadyum stadyum;
	private int evSahibiSkor;
	private int misafirTakimSkor;
	private String hakemIsmi;
	private LocalDate musabakaTarihi;
	private Lig ligID;


	public MusabakaModel(TakimDB takimDB, LigDB ligDB, FutbolcuDB futbolcuDB, StadyumDB stadyumDB, Musabaka musabaka,
						 Lig lig) {
		this.takimDB = takimDB;
		this.ligDB = ligDB;
		this.futbolcuDB = futbolcuDB;

		this.musabakaID = musabaka.getId();
		this.evSahibiTakim = takimDB.findById(musabaka.getEvSahibiID()).orElse(null);
		this.misafirTakim = takimDB.findById(musabaka.getMisafirTakimID()).orElse(null);
		this.ligID = ligDB.findById(lig.getId()).orElse(null);
		this.stadyum = stadyumDB.findById(musabaka.getId()).orElse(null);
		this.musabakaTarihi = musabaka.getMusabakaTarihi();
		this.evSahibiSkor = musabaka.getEvSahibiSkor();
		this.misafirTakimSkor = musabaka.getMisafirTakimSkor();
		this.hakemIsmi = musabaka.getHakemIsmi();

	}


	public void musabakaBilgileriniGoster(){
		System.out.println("------------------------------------");
		System.out.println("Musabaka Bilgileri");
		System.out.println("------------------------------------");
		System.out.println("Musabaka ID           : " + musabakaID);
		System.out.println("Ev Sahibi Takım       : " + (evSahibiTakim != null ? evSahibiTakim.getTakimIsim() : "Bilinmiyor"));
		System.out.println("                VS                    ");
		System.out.println("Misafir Takım         : " + (misafirTakim != null ? misafirTakim.getTakimIsim() : "Bilinmiyor"));
		System.out.println("Stadyum ismi          : " + (stadyum != null ? stadyum.getId() : "Bilinmiyor"));
		System.out.println("Musabaka Tarihi       : " + musabakaTarihi);
		System.out.println("Ev Sahibi Skor        : " + evSahibiSkor);
		System.out.println("Misafir Takım Skor     : " + misafirTakimSkor);
		System.out.println("Hakem İsmi            : " + hakemIsmi);
		System.out.println("------------------------------------");
	}

	public static void maclariYaptir(List<Integer[]> musabaklar, Puan puanTablosu, Map<Integer,String> takimIDtoIsim ){
		Random random=new Random();
		for (Integer[] musabaka:musabaklar){
			int evsahibiID=musabaka[0];
			int misafirID=musabaka[1];
			int evsahibiSkor=random.nextInt(5);
			int misafirSkor=random.nextInt(5);

			puanTablosu.macSonucu(evsahibiID,misafirID,evsahibiSkor,misafirSkor);

			System.out.println(takimIDtoIsim.get(evsahibiID)+" "+evsahibiSkor+" - "+misafirSkor+" "+takimIDtoIsim.get(misafirID));
		}
	}
}