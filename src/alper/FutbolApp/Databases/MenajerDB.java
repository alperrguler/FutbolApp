package alper.FutbolApp.Databases;

import alper.FutbolApp.entities.Menajer;
import alper.FutbolApp.utility.DataBaseManager;

import java.util.Optional;

public class MenajerDB extends DataBaseManager<Menajer> {
	private static final MenajerDB instance = new MenajerDB();

	private MenajerDB() {}

	public static MenajerDB getInstance() {
		return instance;
	}
	public Optional<Menajer> meajerIdVeSifresiniBul(int id,String sifre){
		return veriListesi.stream()
				.filter(menajer -> menajer.getId()==id&& menajer.getSifre().equals(sifre))
				.findFirst();
	}

}