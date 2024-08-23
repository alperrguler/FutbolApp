package alper.FutbolApp.modules;

import alper.FutbolApp.Databases.FutbolcuDB;
import alper.FutbolApp.Databases.LigDB;
import alper.FutbolApp.Databases.TakimDB;
import alper.FutbolApp.entities.Futbolcu;
import alper.FutbolApp.entities.Takim;
import alper.FutbolApp.model.DatabaseModel;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


/**
 * Kulüp modulü; Menüde; 1- Isme Gore Kulup Ara, 2- Kulupleri Listele
 */
public class TakimModule {
	private static DatabaseModel databaseModel;
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void takimModule(DatabaseModel dbModel) {
		databaseModel = dbModel;
		int opt;
		do {
			opt = takimModelMenu();
			takimModelMenuOpsiyonlari(opt);
		} while (opt != 0);
	}
	
	private static int takimModelMenu() {
		System.out.println("-----Takim Menu-----");
		System.out.println("1-Isme göre takım ara");
		System.out.println("2-Takimlari listele");
		System.out.println("0-Çıkış");
		System.out.print("Seçiminiz: ");
		int opt = scanner.nextInt();
		scanner.nextLine();
		return opt;
	}
	
	private static void takimModelMenuOpsiyonlari(int opt) {
		TakimDB takimDB = databaseModel.takimDB;

		switch (opt) {
			case 1: {
				System.out.println("Lütfen bir takım ismi giriniz: ");
				String arananTakim = scanner.nextLine();
				List<Takim> takimList = takimDB.girilenMetniIcerenleriListele(arananTakim);
				
				if (takimList.isEmpty()) {
					System.out.println("Takım Bulunamadı!");
					return;
				} else {
					System.out.println("Bulunan Takımlar:");
					for (Takim takim : takimList) {
						System.out.println("ID: " + takim.getId() + ", İsim: " + takim.getTakimIsim());
					}
					
					int detaySecim = takimDetayMenu();
					takimDetayMenuSecenekleri(detaySecim, takimList);
				}
				break;
			}
			
			case 2: {
				System.out.println("#### Takımlar Listesi ####");
				takimDB.takimlarIsimIdList();
				
				int detaySecim = takimDetayMenu();
				takimDetayMenuSecenekleri(detaySecim, takimDB.findAll());
				break;
			}
			case 0: {
				System.out.println("Ana menüye dönülüyor :)");
				break;
			}
			default:
				System.out.println("Lütfen geçerli bir seçim yapınız!!");
		}
	}
	
	private static int takimDetayMenu() {
		System.out.println("-----Takım Detay Menu-----");
		System.out.println("1- Takım Detaylarını Görüntüle");
		System.out.println("2- Takım Kadrosunu Görüntüle");
		System.out.println("0- Takım Menü'ye dön");
		System.out.print("Seçiminiz: ");
		int opt = scanner.nextInt();
		scanner.nextLine();
		return opt;
	}
	
	private static void takimDetayMenuSecenekleri(int opt, List<Takim> takimList) {
		FutbolcuDB futbolcuDB = databaseModel.futbolcuDB;
		switch (opt) {
			case 1: {
				if (takimList.size() == 1) {
					Takim takim = takimList.getFirst();
					System.out.println(takim);
				} else {
					Integer takimId = idAl();
					Optional<Takim> takim = takimList.stream()
					                                 .filter(t -> t.getId() == takimId)
					                                 .findFirst();
					if (takim.isPresent()) {
						System.out.println(takim.get());
					} else {
						System.out.println("Geçersiz ID. Tekrar deneyin.");
						
					}
				}
				break;
			}
			case 2: {
				if (takimList.size() == 1) {
					Integer takimId = takimList.get(0).getId();
					List<Futbolcu> futbolcuList = futbolcuDB.takimIdyeGoreFutbolcuBul(takimId);
					if (futbolcuList.isEmpty()) {
						System.out.println("Bu takımın kadrosu bulunamadı!");
					} else {
						futbolcuList.forEach(System.out::println);
					}
				} else {
					Integer takimId = idAl();
					List<Futbolcu> futbolcuList = futbolcuDB.takimIdyeGoreFutbolcuBul(takimId);
					if (futbolcuList.isEmpty()) {
						System.out.println("Bu takımın kadrosu bulunamadı!");
					} else {
						futbolcuList.forEach(System.out::println);
					}
				}
				break;
			}
			case 0: {
				break;
			}
			default:
				System.out.println("Geçerli bir seçim yapınız.");
		}
		
	}
	
	
	private static int idAl() {
		System.out.println("Bir takim seciniz(id no ile): ");
		int takimId = scanner.nextInt();
		return takimId;
	}
}