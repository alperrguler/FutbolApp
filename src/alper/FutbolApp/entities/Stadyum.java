package alper.FutbolApp.entities;

import alper.FutbolApp.Databases.StadyumDB;

public class Stadyum extends BaseEntity {
	private static int stadyumID;

	private String stadyumIsmi;
	private String konum;
	private Integer kapasite;

	public Stadyum(String stadyumIsmi, String konum, Integer kapasite,StadyumDB stadyumDB) {
		this.stadyumIsmi = stadyumIsmi;
		this.konum = konum;
		this.kapasite = kapasite;
		stadyumDB.save(this);

	}
}