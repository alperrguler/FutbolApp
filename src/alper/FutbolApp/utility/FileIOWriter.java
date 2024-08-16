package alper.FutbolApp.utility;


import alper.FutbolApp.Databases.FutbolcuDB;
import alper.FutbolApp.Databases.LigDB;
import alper.FutbolApp.Databases.MenajerDB;
import alper.FutbolApp.Databases.TakimDB;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileIOWriter {
	private static final File dosya = new File("C:\\FutbolAPPDatabase");
	
	public static void futbolculariDosyayaYazdir(FutbolcuDB futbolcuDB) {
		File outputFile = new File("C:\\FutbolAPPDatabase\\futbolcuDB.bin");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(futbolcuDB.findAll());
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void takimlariDosyayaYazdir(TakimDB takimDB) {
		File outputFile = new File(dosya, "takimDB.bin");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(takimDB.findAll());
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ligleriDosyayaYazdir(LigDB ligDB){
		File outputFile =new File(dosya,"ligDB.bin");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(ligDB.findAll());
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void menajerleriDosyayaYazdir(MenajerDB menajerDB){
		File outputFile=new File(dosya,"menajerDB.bin");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(menajerDB.findAll());
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void nesneleriYazdir(FutbolcuDB futbolcuDB,TakimDB takimDB,LigDB ligDB,MenajerDB menajerDB){
		futbolculariDosyayaYazdir(futbolcuDB);
		takimlariDosyayaYazdir(takimDB);
		ligleriDosyayaYazdir(ligDB);
		menajerleriDosyayaYazdir(menajerDB);
	}
	
	
}