package alper.FutbolApp.Databases;

import alper.FutbolApp.entities.Takim;
import alper.FutbolApp.utility.DataBaseManager;
import alper.FutbolApp.utility.enums.ERenkler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TakimDB extends DataBaseManager<Takim> {
	
	//ismiyle takım bulma
	public Optional<Takim> takimiIsmiyleBul(TakimDB takimDB, String takimIsmi){
		return veriListesi.stream()
				.filter(takim -> takim.getTakimIsim().equalsIgnoreCase(takimIsmi))
				.findFirst();
	}
	public List<Takim> renklereGoreTakimBul(ERenkler renkler){
		return veriListesi.stream()
				.filter(takim ->takim.getRenkler().equals(renkler))
				.collect(Collectors.toList());
				
		
	}

	public List<Takim> renklereGoreTakimBul2(ERenkler renkler){
		List<Takim> takimRenkleri=new ArrayList<>();
		for (Takim takim:veriListesi){
			if (takim.getRenkler().equals(renkler)){
				takimRenkleri.add(takim);
			}
			
		}
		return takimRenkleri;
		
	}
	public void searchByPartialName(String ismeGore) {
		veriListesi.stream()
				.map(takim -> takim.getId()+" "+takim.getTakimIsim())
				.forEach(System.out::println);
	}
	
	public List<Takim> ismeGoreButunTakimlariListele(String kulupIsmi) {
		return veriListesi.stream()
		                  .toList();
	}
	public List<Takim>  girilenMetniIcerenleriListele(String kulupIsmi){
		List<Takim> bulunanList = veriListesi.stream()
		                                     .filter(takim -> takim.getTakimIsim().toLowerCase().contains(kulupIsmi.toLowerCase()))
		                                     .toList();
		bulunanList.stream().map(takim -> takim.getId() + " : " + takim.getTakimIsim());
		
//		System.out.println("------- Aranan takim "+ kulupIsmi + " -------");
//		if (bulunanList.isEmpty()){
//			System.out.println("Takim Bulunamadi!!");
//
//		}
//		else{
//			bulunanList.stream().map(takim -> takim.getId() + " : " + takim.getTakimIsim())
//			           .forEach(System.out::println);
//		}
//		System.out.println("-----------------------------------");
		return bulunanList;
	}
	public void takimlarIsimIdList() {
		veriListesi.stream()
		           .map(takim -> takim.getId() + " : " + takim.getTakimIsim())
		           .collect(Collectors.toList())
		           .forEach(System.out::println);
	}

}