package alper;

import alper.FutbolApp.Databases.FutbolcuDB;
import alper.FutbolApp.Databases.LigDB;
import alper.FutbolApp.Databases.MenajerDB;
import alper.FutbolApp.Databases.TakimDB;
import alper.FutbolApp.modules.MenajerModule;
import alper.FutbolApp.modules.TakimModule;
import alper.FutbolApp.utility.FiksturGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Test {
	private static FutbolcuDB futbolcuDB = new FutbolcuDB();
	private static TakimDB takimDB=new TakimDB();
	private static LigDB ligDB = new LigDB();
	private static MenajerDB menajerDB=new MenajerDB();
	private static Scanner scanner=new Scanner(System.in);
	
	
	public static void main(String[] args) {
	
//		DataGenerator.generateData(futbolcuDB, takimDB, ligDB, menajerDB);
//		FileIOWriter.nesneleriYazdir(futbolcuDB, takimDB, ligDB, menajerDB);
//		FileIOReader.nesneleriOku(futbolcuDB,takimDB,ligDB,menajerDB);
//
//
//		startApplication();
		List<String> takimlar= Arrays.asList("Galatasaray","Fenerbahce","Besiktaş","Trabzon",
				"Başakşehir","Alanyaspor","Antalyaspor","Konyaspor","SivasSspor","Caykurspor",
				"Gaziantep ck","İstanbulun başakşehiri bence olmamaı","MGWX Ankaragucu",
				"Genclerbirliği","Kayserispor","Yeni malatyaspor","Göztepe","Denizlispor",
				"Anilözogli spor(pendik)");
		
		LocalDate sezonBaslangic= LocalDate.of(2024,8,20);
		FiksturGenerator fiksturGenerator=new FiksturGenerator(new ArrayList<>(takimlar),sezonBaslangic);
		fiksturGenerator.generatefikstur();
		fiksturGenerator.fiksturuYazdir();
		
	}

	public static void startApplication(){
		int opt =0;
		do {
			opt = futbolAppMenuOpsiyonlari(futbolAppMenu());
		}while (opt!=0);
	}

	private static int futbolAppMenu(){
		System.out.println("### Futbol App Ana Menu ###");
		System.out.println("1- Menajer Islemleri");
		System.out.println("2- Takim Islemleri");
		System.out.println("0- Cikis");
		System.out.println("Secimiz: ");
		int opt = scanner.nextInt();scanner.nextLine();
		return opt;
	}

	private static int futbolAppMenuOpsiyonlari(int opt){
		switch (opt){
			case 1:{
				MenajerModule.menajerModule(menajerDB,takimDB,futbolcuDB);
				break;
			}
			case 2: {
				TakimModule.takimModule(takimDB,futbolcuDB,ligDB);
				break;
			}
			case 0: {
				System.out.println("FutbolApp kapatiliyor...");
				break;
			}
			default:{
				System.out.println("Gecerli bir secim yapiniz !!");
			}
		}
		return opt;
	}
}