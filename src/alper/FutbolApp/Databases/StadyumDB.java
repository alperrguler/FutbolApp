package alper.FutbolApp.Databases;

import alper.FutbolApp.entities.Stadyum;
import alper.FutbolApp.utility.DataBaseManager;

public class StadyumDB extends DataBaseManager<Stadyum> {

    private static final StadyumDB instance = new StadyumDB();

    private StadyumDB() {
    }

    public static StadyumDB getInstance() {
        return instance;
    }
}