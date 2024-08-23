package alper.FutbolApp.utility;

import alper.FutbolApp.entities.*;
import alper.FutbolApp.model.DatabaseModel;

import java.io.*;
import java.util.List;

public class FileIOReader {

	private static final File dosya =new File("C:\\FutbolAPPDatabase");

	public static void futbolcuDosyasiniOku(DatabaseModel databaseModel){

		try(ObjectInputStream ois=
				    new ObjectInputStream(new FileInputStream("C:\\FutbolAPPDatabase\\futbolcuDB.bin"))) {
            databaseModel.futbolcuDB.saveAll((List<Futbolcu>) ois.readObject());
		}

		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void takimDosyasiniOku(DatabaseModel databaseModel){
		File inputFile=new File(dosya,"takimDB.bin");
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(inputFile))) {
            databaseModel.takimDB.saveAll((List<Takim>) ois.readObject());
		}

		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void ligDosyasiniOku(DatabaseModel databaseModel){
		File inputFile=new File(dosya,"ligDB.bin");
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(inputFile))) {
            databaseModel.ligDB.saveAll((List<Lig>) ois.readObject());
		}

		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void menajerDosyasiniOku(DatabaseModel databaseModel){
		File inputFile=new File(dosya,"menajerDB.bin");
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(inputFile))) {
            databaseModel.menajerDB.saveAll((List<Menajer>) ois.readObject());
		}

		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void stadyumDosyasiniOku(DatabaseModel databaseModel){
		File inputFile=new File(dosya,"stadyumDB.bin");
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(inputFile))) {
            databaseModel.stadyumDB.saveAll((List<Stadyum>) ois.readObject());
		}

		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	public static void nesneleriOku(DatabaseModel databaseModel){
		futbolcuDosyasiniOku(databaseModel);
		takimDosyasiniOku(databaseModel);
		ligDosyasiniOku(databaseModel);
		menajerDosyasiniOku(databaseModel);
		stadyumDosyasiniOku(databaseModel);

	}
}