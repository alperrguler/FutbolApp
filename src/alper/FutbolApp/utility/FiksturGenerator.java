package alper.FutbolApp.utility;

import alper.FutbolApp.entities.Musabaka;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class FiksturGenerator {
	private List<String> takimIsimleri;
	private List<DayOfWeek> gunler = Arrays.asList(DayOfWeek.FRIDAY,DayOfWeek.SATURDAY,DayOfWeek.SUNDAY,DayOfWeek.MONDAY);
	private List<List<Musabaka>> fikstur;
	private LocalDate sezonbaslangic;
	
	
	
	public FiksturGenerator(List<String> takimIsimleri, LocalDate sezonbaslangic) {
		this.takimIsimleri = takimIsimleri;
		this.fikstur = new ArrayList<>();
		this.sezonbaslangic=sezonbaslangic;
		
	}
	
	public void generatefikstur() {
		Integer takimSayisi = takimIsimleri.size();
		boolean tekMi = takimSayisi % 2 != 0;
		
		if (tekMi) {
			takimIsimleri.add("BAY");
			takimSayisi++;
		}
		for (int hafta = 0; hafta < takimSayisi - 1; hafta++) {
			List<Musabaka> musabakalar = new ArrayList<>();
			for (int i = 0; i < takimSayisi / 2; i++) {
				String evSahibi = takimIsimleri.get(i);
				String misafirTakim = takimIsimleri.get(takimSayisi - 1 - i);
				musabakalar.add(new Musabaka(evSahibi, misafirTakim));
				
			}
			takimIsimleri.add(1,takimIsimleri.remove(takimIsimleri.size()-1));
			fikstur.add(musabakalar);
		}
		for (int hafta =0;hafta<takimSayisi-1;hafta++){
			List<Musabaka> musabakalar=new ArrayList<>();
			for (int i = 0; i <takimSayisi/2 ; i++) {
				String evSahibi = takimIsimleri.get(takimSayisi-1-i);
				String misafirTakim=takimIsimleri.get(i);
				musabakalar.add(new Musabaka(evSahibi,misafirTakim));
			}
			takimIsimleri.add(1,takimIsimleri.remove(takimIsimleri.size()-1));
			fikstur.add(musabakalar);
		}
		gunleriAta();
	}
	
	private void gunleriAta() {
		Random random=new Random();
		for (int hafta = 0; hafta < fikstur.size(); hafta++) {
			List<Musabaka> musabakalar=fikstur.get(hafta);
			Collections.shuffle(musabakalar);
			for (Musabaka musabaka:musabakalar){
				DayOfWeek gun=gunler.get(random.nextInt(gunler.size()));
				LocalDate musabakaTarihi=sezonbaslangic.plusWeeks(hafta).with(gun);
				musabaka.setMusabakaTarihi(musabakaTarihi);
			}
			
		}
		
		
	}
	
	public void fiksturuYazdir(){
		int haftaNumarasi=1;
		for (List<Musabaka> musabakalar:fikstur){
			System.out.println("Hafta "+haftaNumarasi++);
			for (Musabaka musabaka:musabakalar){
				System.out.println(musabaka.toStringFikstur());
			}
			System.out.println();
		}
	}
	
	
}