package alper.FutbolApp.Databases;

import alper.FutbolApp.entities.Musabaka;
import alper.FutbolApp.utility.DataBaseManager;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MusabakaDB extends DataBaseManager<Musabaka> {

	private static final MusabakaDB instance = new MusabakaDB();

	private MusabakaDB() {
	}

	public static MusabakaDB getInstance() {
		return instance;
	}
}