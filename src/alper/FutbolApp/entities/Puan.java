package alper.FutbolApp.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Puan {
    private Map<Integer,Integer> puanlar;
    private Map<Integer,Integer> galibiyetler;
    private Map<Integer,Integer> maglubiyetler;
    private Map<Integer,Integer> beraberlikler;
    //galatasaru  1 evsahibi puan0  G 0  M 1   B 1
    // fenerbahce  1  misafir  puanı3 G 1  M 0  B 1
    public Puan(List<Integer> takimIDlist) {
        this.beraberlikler = new HashMap<>();
        this.galibiyetler = new HashMap<>();
        this.maglubiyetler = new HashMap<>();
        this.puanlar = new HashMap<>();
        for (Integer takimID: takimIDlist){
            puanlar.put(takimID,0);
            galibiyetler.put(takimID,0);   // galibiyetler.put(2,1)
            maglubiyetler.put(takimID,0);
            beraberlikler.put(takimID,0);
        }
    }
    public void macSonucu(Integer evSahibiID,Integer misafirID,int evSahibiSkor,int misafirSkor){
        if (evSahibiSkor>misafirSkor){
            puanlar.put(evSahibiID,puanlar.get(evSahibiID)+3);
            galibiyetler.put(evSahibiID,galibiyetler.get(evSahibiID)+1);
            maglubiyetler.put(misafirID,maglubiyetler.get(misafirID)+1);
        }
        else if (evSahibiSkor<misafirSkor) {
            puanlar.put(misafirID,puanlar.get(misafirID)+3);
            galibiyetler.put(misafirID,galibiyetler.get(misafirID)+1);
            maglubiyetler.put(evSahibiID,maglubiyetler.get(evSahibiID)+1);
        }else {
            puanlar.put(evSahibiID,puanlar.get(evSahibiID)+1);
            puanlar.put(misafirID,puanlar.get(misafirID)+1);
            beraberlikler.put(evSahibiID,beraberlikler.get(evSahibiID)+1);
            beraberlikler.put(misafirID,beraberlikler.get(misafirID)+1);
        }
    }
    public void puanTablosuYazdir(Map<Integer, String> takimIDtoIsim) {
        System.out.println("Takım\tPuan\tG\tB\tM");
        for (Integer takimID : puanlar.keySet()) {
            System.out.println(takimIDtoIsim.get(takimID) + "\t" +
                    puanlar.get(takimID) + "\t" +
                    galibiyetler.get(takimID) + "\t" +
                    beraberlikler.get(takimID) + "\t" +
                    maglubiyetler.get(takimID));
        }
    }
}