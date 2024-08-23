package alper.FutbolApp.Databases;

import alper.FutbolApp.utility.enums.EMevki;
import alper.FutbolApp.entities.Futbolcu;
import alper.FutbolApp.utility.DataBaseManager;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FutbolcuDB extends DataBaseManager<Futbolcu> {
	
	//isme ve soyisme göre futbolcu bulma
	public Optional<Futbolcu> ismiVeSoyIsmiBul(String isim, String soyIsim) {
		return veriListesi.stream()
		                  .filter(futbolcu -> futbolcu.getIsim().equalsIgnoreCase(isim) && futbolcu.getSoyIsim()
		                                                                                           .equalsIgnoreCase(soyIsim))
		                  .findFirst();
	}
	
	// mevkiye göre futbolcu bulma
	public List<Futbolcu> mevkiBul(EMevki mevki) {
		return veriListesi.stream()
		                  .filter(futbolcu -> futbolcu.getMevki().equals(mevki)).collect(Collectors.toList());
	}
	
	// takımID ye göre futbolcu bulma
	public List<Futbolcu> takimIDBul(Integer takimID) {
		return veriListesi.stream()
		                  .filter(futbolcu -> futbolcu.getTakimID().equals(takimID))
		                  .collect(Collectors.toList());
	}
	
	public boolean futbolcuSil(int id){
		return veriListesi.removeIf(futbolcu -> futbolcu.getId()==id);
	}
	public List<Futbolcu> takimIdyeGoreFutbolcuBul(Integer takimId){
		return veriListesi.stream()
		                  .filter(futbolcu -> futbolcu.getTakimID().equals(takimId))
		                  .collect(Collectors.toList());
	}
	
	public List<Futbolcu> takimIdyeGoreFutbolculariListele(int takimId) {
		return veriListesi.stream()
				.filter(futbolcu -> futbolcu.getTakimID().equals(takimId))
				.collect(Collectors.toList());
	}
}