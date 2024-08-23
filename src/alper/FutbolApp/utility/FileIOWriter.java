package alper.FutbolApp.utility;

import alper.FutbolApp.Databases.*;
import alper.FutbolApp.model.DatabaseModel;

import java.io.*;

public class FileIOWriter {
	private static final File dosya = new File("C:\\FutbolAPPDatabase");

	public static void futbolculariDosyayaYazdir(DatabaseModel databaseModel) {
		File outputFile = new File("C:\\FutbolAPPDatabase\\futbolcuDB.bin");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(databaseModel.futbolcuDB.findAll());
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void takimlariDosyayaYazdir(DatabaseModel databaseModel) {
		File outputFile = new File(dosya, "takimDB.bin");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(databaseModel.takimDB.findAll());
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void ligleriDosyayaYazdir(DatabaseModel databaseModel){
		File outputFile =new File(dosya,"ligDB.bin");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(databaseModel.ligDB.findAll());
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void menajerleriDosyayaYazdir(DatabaseModel databaseModel){
		File outputFile=new File(dosya,"menajerDB.bin");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(databaseModel.menajerDB.findAll());
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void stadyumlariDosyayaYazdir(DatabaseModel databaseModel){
		File outputFile=new File(dosya,"stadyumDB.bin");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(databaseModel.stadyumDB.findAll());
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}



	public static void nesneleriYazdir(DatabaseModel databaseModel){
		futbolculariDosyayaYazdir(databaseModel);
		takimlariDosyayaYazdir(databaseModel);
		ligleriDosyayaYazdir(databaseModel);
		menajerleriDosyayaYazdir(databaseModel);
		stadyumlariDosyayaYazdir(databaseModel);

	}


}