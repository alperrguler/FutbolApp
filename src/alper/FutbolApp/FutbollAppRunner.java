package alper.FutbolApp;

import alper.FutbolApp.entities.Puan;
import alper.FutbolApp.model.DatabaseModel;
import alper.FutbolApp.model.LigModel;
import alper.FutbolApp.modules.MenajerModule;
import alper.FutbolApp.modules.TakimModule;
import alper.FutbolApp.utility.DataGenerator;
import alper.FutbolApp.utility.FileIOReader;
import alper.FutbolApp.utility.FileIOWriter;

import java.util.*;

public class FutbollAppRunner {
	private static DatabaseModel databaseModel = DatabaseModel.getInstance();
	private static Scanner scanner = new Scanner(System.in);
	private static LigModel ligModel = new LigModel(databaseModel);


	public static void main(String[] args) {

//		DataGenerator.generateData(databaseModel);
//		FileIOWriter.nesneleriYazdir(databaseModel);
		FileIOReader.nesneleriOku(databaseModel);

		startApplication();

	}
	public static void maclariYaptir(List<Integer[]> maclar, Puan puanTablosu, Map<Integer, String> takimIDtoIsim) {
		Random random = new Random();
		for (Integer[] mac : maclar) {
			int evSahibiID = mac[0];
			int misafirID = mac[1];
			int evSahibiGoller = random.nextInt(5);  // Rastgele gol sayısı (0-4)
			int misafirGoller = random.nextInt(5);   // Rastgele gol sayısı (0-4)

			// Maç sonucunu puan tablosuna ekle
			puanTablosu.macSonucu(evSahibiID, misafirID, evSahibiGoller, misafirGoller);

			// Maç sonucunu yazdır
			System.out.println(takimIDtoIsim.get(evSahibiID) + " " + evSahibiGoller + "-" + misafirGoller + " " + takimIDtoIsim.get(misafirID));
		}
	}


	public static void startApplication() {
		int opt = 0;
		do {
			opt = futbolAppMenuOpsiyonlari(futbolAppMenu());
		} while (opt != 0);
	}

	private static int futbolAppMenu() {
		System.out.println("### Futbol App Ana Menu ###");
		System.out.println("1- Menajer Islemleri");
		System.out.println("2- Takim Islemleri");
		System.out.println("3- Musabaka Islemleri");
		System.out.println("4- Fiksturu goruntule");
		System.out.println("0- Cikis");
		System.out.println("Secimiz: ");
		int opt = scanner.nextInt();
		scanner.nextLine();
		return opt;
	}

	private static int futbolAppMenuOpsiyonlari(int opt) {
		switch (opt) {
			case 1: {
				MenajerModule.menajerModule(databaseModel);
				break;
			}
			case 2: {
				TakimModule.takimModule(databaseModel);
				break;
			}
			case 3:{

				break;
			}
			case 4:{
				ligModel.fiksturOlustur(databaseModel);
				break;
			}
			case 0: {
				System.out.println("FutbolApp kapatiliyor...");
				break;
			}
			default: {
				System.out.println("Gecerli bir secim yapiniz !!");
			}
		}
		return opt;
	}
}