package alper.FutbolApp.modules;



import alper.FutbolApp.Databases.FutbolcuDB;
import alper.FutbolApp.Databases.MenajerDB;
import alper.FutbolApp.Databases.TakimDB;
import alper.FutbolApp.entities.Futbolcu;
import alper.FutbolApp.entities.Menajer;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenajerModule {
	
	private static MenajerDB menajerDB;
	private static TakimDB takimDB;
	private static FutbolcuDB futbolcuDB;
	private static Optional<Menajer> aktifMenajer = Optional.empty();  // aktif menajer bilgisini burada tutuyoruz
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void menajerModule(MenajerDB menajerDB, TakimDB takimDB, FutbolcuDB futbolcuDB) {
		MenajerModule.menajerDB = menajerDB;
		MenajerModule.takimDB = takimDB;
		MenajerModule.futbolcuDB = futbolcuDB;
		
		int opt;
		do {
			
			opt = menajerGirisMenu();
			menajerGirisMenuOpsiyonlari(opt);
		} while (opt != 0);
	}
	
	private static Optional<Menajer> girisYap() {
		while (true) {
			System.out.println("lütfen menajer ID giriniz");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("lütfen menajer sifrenizi giriniz");
			String sifre = scanner.nextLine();
			Optional<Menajer> menager1 = menajerDB.meajerIdVeSifresiniBul(id, sifre);
			
			if (menager1.isPresent()) {
				aktifMenajer = menager1;
				System.out.println("başarılı bir şekilde giriş yaptınız");
				return menager1;
			}
			else {
				System.out.println("giriş yapılamadı.Lütfen tekrar deneyiniz");
			}
			
		}
	}
	
	private static int menajerGirisMenu() {
		System.out.println("-----Menajer Giris Menu-----");
		System.out.println("1-Giris Yap");
		System.out.println("0-Geri dön");
		System.out.print("seciminiz: ");
		int opt = scanner.nextInt();
		scanner.nextLine();
		return opt;
	}
	
	private static int menajerGirisMenuOpsiyonlari(int opt) {
		while (true) {
			switch (opt) {
				case 1: {
					girisYap();
					menajerMenuOpsiyonlari(menajerMenu());
					break;
				}
				
				case 2: {
					System.out.println("Ana menuye donuluyor");
					break;
				}
				case 0: {
					System.out.println("0--Ust menuye donuluyor ");
					break;
				}
			}
			return opt;
		}
	}
	
	private static int menajerMenu() {
		
		System.out.println("-----Menajer Menu-----");
		System.out.println("1-Takimimin detaylarını goruntuleyin");
		System.out.println("2-Takimimin futbolcularımı goruntuleyin");
		System.out.println("3-Diğer takimlarin özet bilgilerini goruntuleyin");
		System.out.println("4-Diğer takimlarin futbolcularının özet bilgilerini goruntuleyin");
		System.out.println("0-Cıkıs yap");
		System.out.print("seciminiz: ");
		int opt = scanner.nextInt();
		scanner.nextLine();
		return opt;
	}
	
	private static int menajerMenuOpsiyonlari(int opt) {
		switch (opt) {
			case 1: {
				kulubumunDetaylariniGoruntule();
				menajerGirisMenuOpsiyonlari(menajerMenu());
				break;
			}
			case 2: {
				kulubumunFutbolculariniGoruntule();
				menajerGirisMenuOpsiyonlari(menajerMenu());
				break;
			}
			case 3: {
				takimlerinOzetBilgileriniGoruntule();
				takimIdyeGoreFutbolcularOzetBilgi();
				menajerGirisMenuOpsiyonlari(menajerMenu());
				break;
			}
			case 0: {
				System.out.println("Ust menuye donuluyor");
			}
		}
		return opt;
	}
	
	private static void takimIdyeGoreFutbolcularOzetBilgi () {
		System.out.println("Futbolcularini goruntulemek istediginiz takimi seciniz:");
		int takimId = scanner.nextInt();
		scanner.nextLine();
		List<Futbolcu> futbolcuList = futbolcuDB.takimIdyeGoreFutbolculariListele(takimId);
		futbolcuList.forEach(futbolcu -> System.out.println(futbolcu.toStringOzet()));
	}
	
	private static void takimlerinOzetBilgileriniGoruntule() {
		takimDB.takimlarIsimIdList();
	}
	
	private static void kulubumunDetaylariniGoruntule() {
		if (aktifMenajer.isEmpty()) {
			System.out.println("lütfen giriş yapınız");
		}
		takimDB.menajerinTakimIdsineGoreTakimBul(aktifMenajer.get().getTakimID());
	}
	
	private static void kulubumunFutbolculariniGoruntule() {
		if (aktifMenajer.isEmpty()) {
			System.out.println("lütfen giriş yapınız");
		}
		List<Futbolcu> takiminFutbolculari = futbolcuDB.takimIdyeGoreFutbolcuBul(aktifMenajer.get().getTakimID());
		takiminFutbolculari.forEach(System.out::println);
	}
}