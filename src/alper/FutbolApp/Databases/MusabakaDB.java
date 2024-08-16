package alper.FutbolApp.Databases;

import alper.FutbolApp.entities.Musabaka;
import alper.FutbolApp.utility.DataBaseManager;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MusabakaDB extends DataBaseManager<Musabaka> {
	
	// atStartOfDay().toLocalDate()) alperen hocaya sor
	
	//tarihe göre müsabaka bulma
	public List<Musabaka> tarihindekiMusabakalariBul(LocalDate date){
		return veriListesi.stream()
				.filter(musabaka -> musabaka.getMusabakaTarihi().equals(date))
				.collect(Collectors.toList());
	}
	
	// musabaka silme
	public void musabakaIptalEt(int id){
		veriListesi.removeIf(musabaka -> musabaka.getId()==id);
	}
	
}