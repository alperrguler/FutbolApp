package alper.FutbolApp.Databases;

import alper.FutbolApp.entities.Lig;
import alper.FutbolApp.utility.DataBaseManager;


public class LigDB extends DataBaseManager<Lig> {

	private static final LigDB instance = new LigDB();

	private LigDB() {
	}

	public static LigDB getInstance() {
		return instance;
	}

}