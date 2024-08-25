package alper.FutbolApp.model;

import alper.FutbolApp.Databases.LigDB;
import alper.FutbolApp.entities.Lig;
import alper.FutbolApp.entities.Musabaka;
import alper.FutbolApp.entities.Takim;
import alper.FutbolApp.utility.FiksturGenerator;
import alper.FutbolApp.utility.enums.EBolge;
import alper.FutbolApp.utility.enums.EKume;
import alper.FutbolApp.utility.enums.ERenkler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LigModel {

	private  static DatabaseModel databaseModel;

	//TODO lig puan listesi
	private int ligID;
	private String ligIsmi;
	private List<Takim> takimlar;
	private String sezon;
	private EKume kume;
	private EBolge bolge;
	private LocalDate baslangicTarihi;

	private Map<Takim,List<Musabaka>> takiminFiksturu;

	private Map<Integer, List<MusabakaModel>> fikstur;


	public LigModel(Lig lig, List<Takim> takimlar, DatabaseModel dbModel) {
		this.baslangicTarihi = lig.getBaslangicTarihi();
		this.bolge = lig.getBolge();
		this.fikstur = null;
		this.kume = lig.getKume();
		this.ligID = lig.getId();
		this.ligIsmi = lig.getLigIsmi();
		this.sezon = lig.getSezon();
		this.takimlar = takimlar;
	}

	public LigModel(DatabaseModel databaseModel) {

	}

	public void ligBilgileriniGoster() {
		System.out.println("----------------------------");
		System.out.println("LIG BILGILERI");
		System.out.println("----------------------------");
		System.out.println("Lig ID                   : " + ligID);
		System.out.println("Lig Ismi                 : " + ligIsmi);
		System.out.println("Lig Bolge                : " + bolge);
		System.out.println("Lig Kume                 : " + kume);
		System.out.println("Lig Sezon                : " + sezon);
		System.out.println("Lig Baslangic tarihi     : " + baslangicTarihi);
		System.out.println("Takimlar                 : " + takimlar);

		if (fikstur != null) {
			System.out.println("Fikstur:");
			for (Map.Entry<Integer, List<MusabakaModel>> entry : fikstur.entrySet()) {
				System.out.println("Hafta: " + entry.getKey());
				for (MusabakaModel musabaka : entry.getValue()) {
					musabaka.musabakaBilgileriniGoster();
				}
			}
		} else {
			System.out.println("Fikstur bilgisi mevcut değil.");
		}

		System.out.println("----------------------------");
	}

	public void setFikstur(Map<Integer, List<MusabakaModel>> fikstur) {
		this.fikstur = fikstur;
	}

	public void fiksturOlustur(DatabaseModel databaseModel){
		Takim takim1 = new Takim("Galatasaray", 1, ERenkler.KIRMIZI_SARI, "Dursun Özbek", "1905", databaseModel.takimDB);
		Takim takim2 = new Takim("Fenerbahçe",2, ERenkler.SARI_LACIVERT, "Ali Koç", "1907", databaseModel.takimDB);
		Takim takim3 = new Takim("Beşiktaş",3, ERenkler.SIYAH_BEYAZ, "Ahmet Nur Çebi", "1903", databaseModel.takimDB);
		Takim takim4 = new Takim("Trabzonspor",4, ERenkler.BORDO_MAVI, "Ahmet Ağaoğlu", "1967", databaseModel.takimDB);
		Takim takim5 = new Takim("Başakşehir",5, ERenkler.CIFT_KIRMIZI, "Göksel Gümüşdağ", "2014", databaseModel.takimDB);
		Takim takim6 = new Takim("Alanyaspor",6, ERenkler.TURUNCU_LACIVERT, "Hasan Çavuşoğlu", "1948", databaseModel.takimDB);
		Takim takim7 = new Takim("Antalyaspor",7, ERenkler.SERITLI_KIRMIZI, "Aziz Çetin", "1966", databaseModel.takimDB);
		Takim takim8 = new Takim("Konyaspor",8, ERenkler.YESIL_BEYAZ, "Hilmi Kullukçu", "1922", databaseModel.takimDB);
		Takim takim9 = new Takim("Sivasspor",9, ERenkler.KIRMIZI_BEYAZ, "Mecnun Otyakmaz", "1967", databaseModel.takimDB);
		Takim takim10 = new Takim("Çaykur Rizespor",10, ERenkler.YESIL_MAVI, "İbrahim Turgut", "1953", databaseModel.takimDB);
		Takim takim11 = new Takim("Gaziantep FK",11, ERenkler.CIFT_KIRMIZI, "Adil Kürükçü", "1969", databaseModel.takimDB);
		Takim takim12 = new Takim("İstanbul Başakşehir",12, ERenkler.CIFT_KIRMIZI, "Göksel Gümüşdağ", "2014", databaseModel.takimDB);
		Takim takim13 = new Takim("MKE Ankaragücü",13, ERenkler.SIYAH_KIRMIZI, "Fatih Mert", "1910", databaseModel.takimDB);
		Takim takim14 = new Takim("Gençlerbirliği",14, ERenkler.KIRMIZI_SIYAH, "Murat Cavcav", "1923", databaseModel.takimDB);
		Takim takim15 = new Takim("Kayserispor",15, ERenkler.KIRMIZI_SIYAH, "Berna Gözbaşı", "1966", databaseModel.takimDB);
		Takim takim16 = new Takim("Yeni Malatyaspor",16, ERenkler.YESIL_SIYAH, "Adil Gevrek", "1986", databaseModel.takimDB);
		Takim takim17 = new Takim("Göztepe",17, ERenkler.CIFT_KIRMIZI, "Mehmet Sepil", "1925", databaseModel.takimDB);
		Takim takim18 = new Takim("Denizlispor",18, ERenkler.CIFT_KIRMIZI, "Ali İpek", "1966", databaseModel.takimDB);
		Takim takim19 = new Takim("Bodrum FK",19, ERenkler.YESIL_BEYAZ, "Fikret Öztürk", "1931", databaseModel.takimDB);


		Lig turkiyeSuperLigi = new Lig("Türkiye Süper Lig", "sezon1", EKume.TRENDYOL_SUPER_LIG, EBolge.TURKIYE, databaseModel.ligDB,
				LocalDate.of(2024, 8, 20));


		turkiyeSuperLigi.getTakimIDList()
				.addAll(List.of(takim1.getId(), takim2.getId(), takim3.getId(), takim4.getId(), takim5.getId(),
						takim6.getId(), takim7.getId(), takim8.getId(), takim9.getId(), takim10.getId(),
						takim11.getId(), takim12.getId(), takim13.getId(), takim14.getId(), takim15.getId(),
						takim16.getId(), takim17.getId(), takim18.getId(), takim19.getId()));


		Map<Integer, String> takimIdToNameMap = new HashMap<>();
		takimIdToNameMap.put(takim1.getId(), takim1.getTakimIsim());
		takimIdToNameMap.put(takim2.getId(), takim2.getTakimIsim());
		takimIdToNameMap.put(takim3.getId(), takim3.getTakimIsim());
		takimIdToNameMap.put(takim4.getId(), takim4.getTakimIsim());
		takimIdToNameMap.put(takim5.getId(), takim5.getTakimIsim());
		takimIdToNameMap.put(takim6.getId(), takim6.getTakimIsim());
		takimIdToNameMap.put(takim7.getId(), takim7.getTakimIsim());
		takimIdToNameMap.put(takim8.getId(), takim8.getTakimIsim());
		takimIdToNameMap.put(takim9.getId(), takim9.getTakimIsim());
		takimIdToNameMap.put(takim10.getId(), takim10.getTakimIsim());
		takimIdToNameMap.put(takim11.getId(), takim11.getTakimIsim());
		takimIdToNameMap.put(takim12.getId(), takim12.getTakimIsim());
		takimIdToNameMap.put(takim13.getId(), takim13.getTakimIsim());
		takimIdToNameMap.put(takim14.getId(), takim14.getTakimIsim());
		takimIdToNameMap.put(takim15.getId(), takim15.getTakimIsim());
		takimIdToNameMap.put(takim16.getId(), takim16.getTakimIsim());
		takimIdToNameMap.put(takim17.getId(), takim17.getTakimIsim());
		takimIdToNameMap.put(takim18.getId(), takim18.getTakimIsim());
		takimIdToNameMap.put(takim19.getId(), takim19.getTakimIsim());


		FiksturGenerator
				fiksturGenerator = new FiksturGenerator(turkiyeSuperLigi.getTakimIDList(), LocalDate.of(2024, 8, 20), takimIdToNameMap);
		fiksturGenerator.generateFikstur();
		fiksturGenerator.fiksturuYazdir(takimIdToNameMap);


	}


}