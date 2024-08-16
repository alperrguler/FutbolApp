package alper;


import alper.FutbolApp.Databases.FutbolcuDB;
import alper.FutbolApp.Databases.LigDB;
import alper.FutbolApp.Databases.MenajerDB;
import alper.FutbolApp.Databases.TakimDB;
import alper.FutbolApp.modules.TakimModule;
import alper.FutbolApp.utility.FileIOReader;

public class Test {
	private static FutbolcuDB futbolcuDB = new FutbolcuDB();
	private static TakimDB takimDB=new TakimDB();
	private static LigDB ligDB = new LigDB();
	private static MenajerDB menajerDB=new MenajerDB();
	
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
		starApplication();
	}
	
	public static void starApplication(){
		int opt =0;
		do {
			TakimModule.takimModule(takimDB,futbolcuDB,ligDB);
		}while (opt!=0);
		
	}
}