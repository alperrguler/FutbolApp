package alper.FutbolApp.utility;


import alper.FutbolApp.Databases.FutbolcuDB;
import alper.FutbolApp.Databases.LigDB;
import alper.FutbolApp.Databases.MenajerDB;
import alper.FutbolApp.Databases.TakimDB;
import alper.FutbolApp.entities.Futbolcu;
import alper.FutbolApp.entities.Lig;
import alper.FutbolApp.entities.Menajer;
import alper.FutbolApp.entities.Takim;
import alper.FutbolApp.utility.enums.EBolge;
import alper.FutbolApp.utility.enums.EKume;
import alper.FutbolApp.utility.enums.EMevki;
import alper.FutbolApp.utility.enums.ERenkler;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class DataGenerator {
	
	public static void generateData(FutbolcuDB futbolcuDB, TakimDB takimDB, LigDB ligDB, MenajerDB menajerDB){
		generateManajer(menajerDB);
		generateTakimlar(takimDB,ligDB);
		rastgeleFutbolcuUret(futbolcuDB);
	}
	
	
	private static final String[] ISIM =
			{"Ahmet", "Mehmet", "Ali", "Anıl", "Hasan", "Murat", "Kemal", "İbrahim", "Oğuz", "Emre", "Serkan", "Barış"
					, "Halil", "Berk", "Kaan", "Sinan", "Erdem", "Hakan", "Cihan", "Levent", "Rıza", "Volkan", "Arda",
					"Sefa", "Fikret", "Can", "Orhan", "Eren", "Burak", "Selim", "Tolga", "Umut", "Uğur", "Özgür",
					"Taner", "Kadir", "Cem", "Ege", "Bora", "Mert", "Vedat", "Deniz", "Tarık", "Yavuz", "Gökhan",
					"Koray", "Enes", "Erkan", "Tuncay", "Fırat", "Tamer"};
	
	private static final String[] SOYISIM =
			{"Özogli", "Kaya", "Demir", "Çelik", "Şahin", "Aydın", "Yıldız", "Arslan", "Doğan", "Güneş", "Öztürk", "K" +
					"ıl", "ıç", "Kurt", "Koç", "Erdoğan", "Polat", "Avcı", "Aksoy", "Taş", "Ünal", "Durmaz", "Erdem",
					"Bulut", "Çetin", "Korkmaz", "Keskin", "Tan", "Güler", "Baş", "Bozkurt", "Ergin", "Özdemir", "Can"
					, "Karaca", "Orhan", "Turan", "Kara", "Ay", "Tekin", "Aslan", "Kurtuluş", "Uzun", "Çalışkan", "Y" +
					"ücel", "Dinç", "Boz", "Duman", "Şen", "Eken", "Işık", "Özer"};
	
	public static void rastgeleFutbolcuUret(FutbolcuDB futbolcuDB) {
		Random random = new Random();
		int takimID = 1;
		for (int i = 0; i < 18; i++) {
			for (int j = 0; j < 11; j++) {
				Futbolcu futbolcu = new Futbolcu(futbolcuDB);
				switch (j) {
					case 0:
						futbolcu.setMevki(EMevki.KALECI);
						break;
					case 1, 2, 3, 4:
						futbolcu.setMevki(EMevki.DEFANS);
						break;
					case 5, 6, 7, 8:
						futbolcu.setMevki(EMevki.ORTASAHA);
						break;
					case 9, 10:
						futbolcu.setMevki(EMevki.HUCUM);
						break;
				}
				futbolcu.setIsim(ISIM[random.nextInt(0, ISIM.length)]);
				futbolcu.setSoyIsim(SOYISIM[random.nextInt(0, SOYISIM.length)]);
				futbolcu.setBonservisBedeli(random.nextLong(100_000, 5_000_000));
				futbolcu.setDogumTarihi(LocalDate.of(random.nextInt(1980, 2005), random.nextInt(1, 13),
				                                     random.nextInt(1, 28)));
				futbolcu.setTakimID(takimID);
			}
			takimID++;
		}
		
	}
	
	// TODO menajeri enttiy olarak yap
	public static void generateTakimlar(TakimDB takimDB, LigDB ligDB) {
		Takim takim1 = new Takim("Galatasaray", ERenkler.KIRMIZI_SARI, "Dursun Özbek", "1905", takimDB);
		Takim takim2 = new Takim("Fenerbahçe", ERenkler.SARI_LACIVERT, "Ali Koç", "1907", takimDB);
		Takim takim3 = new Takim("Beşiktaş", ERenkler.SİYAH_BEYAZ, "Ahmet Nur Çebi", "1903", takimDB);
		Takim takim4 = new Takim("Trabzonspor", ERenkler.BORDO_MAVİ, "Ahmet Ağaoğlu", "1967", takimDB);
		Takim takim5 = new Takim("Başakşehir", ERenkler.ÇİFT_KIRMIZI, " Göksel Gümüşdağ", "2014", takimDB);
		Takim takim6 = new Takim("Alanyaspor", ERenkler.TURUNCU_LACIVERT, "Hasan Çavuşoğlu", "1948", takimDB);
		Takim takim7 = new Takim("Antalyaspor", ERenkler.ŞERİTLİ_KIRMIZI, "Aziz Çetin", "1966", takimDB);
		Takim takim8 = new Takim("Konyaspor", ERenkler.YEŞİL_BEYAZ, "Hilmi Kullukçu", "1922", takimDB);
		Takim takim9 = new Takim("Sivasspor", ERenkler.KIRMIZI_BEYAZ, "Mecnun Otyakmaz", "1967", takimDB);
		Takim takim10 = new Takim("Çaykur Rizespor", ERenkler.YEŞİL_MAVİ, "İbrahim Turgut", "1953", takimDB);
		Takim takim11 = new Takim("Gaziantep FK", ERenkler.ÇİFT_KIRMIZI, "Adil Kürükçü", "1969", takimDB);
		Takim takim12 = new Takim("İstanbul Başakşehir", ERenkler.ÇİFT_KIRMIZI, " Göksel Gümüşdağ", "2014", takimDB);
		Takim takim13 = new Takim("MKE Ankaragücü", ERenkler.SİYAH_KIRMIZI, "Fatih Mert", "1910", takimDB);
		Takim takim14 = new Takim("Gençlerbirliği", ERenkler.KIRMIZI_SIYAH, "Murat Cavcav", "1923", takimDB);
		Takim takim15 = new Takim("Kayserispor", ERenkler.KIRMIZI_SIYAH, "Berna Gözbaşı", "1966", takimDB);
		Takim takim16 = new Takim("Yeni Malatyaspor", ERenkler.YEŞİL_SIYAH, "Adil Gevrek", "1986", takimDB);
		Takim takim17 = new Takim("Göztepe", ERenkler.ÇİFT_KIRMIZI, "Mehmet Sepil", "1925", takimDB);
		Takim takim18 = new Takim("Denizlispor", ERenkler.ÇİFT_KIRMIZI, "Ali İpek", "1966", takimDB);
		
		Lig turkiyeSuperLigi = new Lig("Türkiye super lig","sezon1", EKume.SUPER_LIG, EBolge.TURKIYE, ligDB);
		
		turkiyeSuperLigi.getTakimIDList()
		                .addAll(List.of(takim1.getId(), takim2.getId(), takim3.getId(), takim4.getId(), takim5.getId(), takim6.getId(), takim7.getId(), takim8.getId(), takim9.getId(),
		                                takim10.getId(), takim11.getId(), takim12.getId(), takim13.getId(), takim14.getId(), takim15.getId(), takim16.getId(), takim17.getId(),
		                                takim18.getId()));
	}
	
	public static void generateManajer(MenajerDB menajerDB){
		Menajer manajer1 = new Menajer(LocalDate.of(1976, 6, 10), "Okan", "Buruk", 1,menajerDB);
		Menajer manajer2 = new Menajer(LocalDate.of(1955, 12, 24), "Jorge", "Jesus", 2,menajerDB);
		Menajer manajer3 = new Menajer(LocalDate.of(1967, 3, 24), "Şenol", "Güneş", 3,menajerDB);
		Menajer manajer4 = new Menajer(LocalDate.of(1962, 10, 20), "Abdullah", "Avcı", 4,menajerDB);
		Menajer manajer5 = new Menajer(LocalDate.of(1981, 1, 4), "Emre", "Belözoğlu", 5,menajerDB);
		Menajer manajer6 = new Menajer(LocalDate.of(1973, 3, 15), "Bülent", "Korkmaz", 6,menajerDB);
		Menajer manajer7 = new Menajer(LocalDate.of(1964, 3, 23), "Ersun", "Yanal", 7,menajerDB);
		Menajer manajer8 = new Menajer(LocalDate.of(1974, 8, 16), "İlhan", "Palut", 8,menajerDB);
		Menajer manajer9 = new Menajer(LocalDate.of(1970, 11, 27), "Rıza", "Çalımbay", 9,menajerDB);
		Menajer manajer10 = new Menajer(LocalDate.of(1968, 2, 28), "Bülent", "Uygun", 10,menajerDB);
		Menajer manajer11 = new Menajer(LocalDate.of(1978, 8, 15), "Erol", "Bulut", 11,menajerDB);
		Menajer manajer12 = new Menajer(LocalDate.of(1981, 1, 4), "Emre", "Belözoğlu", 12,menajerDB);
		Menajer manajer13 = new Menajer(LocalDate.of(1970, 4, 5), "Çağlar", "Karabıyık", 13,menajerDB);
		Menajer manajer14 = new Menajer(LocalDate.of(1965, 8, 20), "Yılmaz", "Vural", 14,menajerDB);
		Menajer manajer15 = new Menajer(LocalDate.of(1980, 10, 27), "Çağdaş", "Atan", 15,menajerDB);
		Menajer manajer16 = new Menajer(LocalDate.of(1969, 6, 12), "İbrahim", "Üzülmez", 16,menajerDB);
		Menajer manajer17 = new Menajer(LocalDate.of(1970, 6, 1), "Tamer", "Tuna", 17,menajerDB);
		Menajer manajer18 = new Menajer(LocalDate.of(1977, 2, 18), "Yücel", "İldiz", 18,menajerDB);
		
	}
	
}