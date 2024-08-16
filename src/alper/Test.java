package alper;


import alper.FutbolApp.Databases.FutbolcuDB;
import alper.FutbolApp.Databases.LigDB;
import alper.FutbolApp.Databases.MenajerDB;
import alper.FutbolApp.Databases.TakimDB;
import alper.FutbolApp.modules.TakimModule;

import java.util.Scanner;


public class Test {
	private static final FutbolcuDB futbolcuDB = new FutbolcuDB();
	private static final TakimDB takimDB=new TakimDB();
	private static final LigDB ligDB = new LigDB();
	private static final MenajerDB menajerDB=new MenajerDB();
	
	public static void main(String[] args) {
	
//		DataGenerator.generateData(futbolcuDB,takimDB,ligDB,menajerDB);
//		FileIOWriter.nesneleriYazdir(futbolcuDB,takimDB,ligDB,menajerDB);
//		FileIOReader.nesneleriOku(futbolcuDB,takimDB,ligDB,menajerDB);
//		ligDB.findAll().forEach(System.out::println);
//		FileIOWriter.menajerleriDosyayaYazdir(menajerDB);
//		FileIOWriter.takimlariDosyayaYazdir(takimDB);
//		FileIOWriter.futbolculariDosyayaYazdir(futbolcuDB);
//		FileIOWriter.ligleriDosyayaYazdir(ligDB);
//		FileIOReader.futbolcuDosyasiniOku(futbolcuDB);
//		futbolcuDB.findAll().forEach(System.out::println);
//
		startApplication();
	}

	public static void startApplication() {
		int opt = 1; // Başlangıçta döngüyü çalıştırmak için 1 ile başlatıyoruz.
		while (opt != 0) {
			// Takım modülünü çağırıyoruz
			TakimModule.takimModule(takimDB, futbolcuDB, ligDB);

			// Kullanıcıdan yeni bir seçim alıyoruz
			opt = getUserInput(); // Kullanıcıdan yeni bir opt değeri al
		}
	}


	private static int getUserInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Lütfen bir seçenek girin (0 çıkış, 1 devam): ");
		return scanner.nextInt(); // Kullanıcının girdiği değeri döndürüyoruz
	}

}