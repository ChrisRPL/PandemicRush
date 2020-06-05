package com.company.mechanika;

import com.company.wspolczynniki_mechaniki.Difficulty;
import com.company.modele.Panstwo;

import java.util.LinkedList;
import java.util.List;


public class ZarazanieSamolotowo extends Zarazenia implements Runnable {

    public ZarazanieSamolotowo(List<Panstwo> panstwa, Difficulty difficulty){
        super(panstwa, difficulty);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                for (int i=0; i<panstwa.size(); i++){
                    if (!panstwa.get(i).czyWylaczonaDrogaPowietrzna()&&panstwa.get(i).czyPosiadaLotnisko()&&panstwa.get(i).getLudnoscZakazona()>100000){
                        List<Panstwo> panstwaZLotniskami = new LinkedList<>();

                        for (int j=0; j<panstwa.size(); j++){
                            if (panstwa.get(j).czyPosiadaLotnisko())
                                panstwaZLotniskami.add(panstwa.get(j));
                        }

                        panstwaZLotniskami.remove(panstwa.get(i)); //USUWAM OBECNIE WYBRANE PANSTWO Z LOTNISKIEM

                        int indeksPanstwa = (int)(Math.random()*(panstwaZLotniskami.size()));
                        Panstwo wylosowanePanstwo = panstwaZLotniskami.get(indeksPanstwa);

                        if (!panstwa.get(i).isKontrolaNaLotniskach()){
                            wylosowanePanstwo.setLudnoscZakazona(wylosowanePanstwo.getLudnoscZakazona() + panstwa.get(i).getLudnoscZakazona()*difficulty.getMnoznikZakazeniaSamolot());
                            wylosowanePanstwo.setLudnoscZakazona(panstwa.get(i).getLudnoscZakazona() - panstwa.get(i).getLudnoscZakazona()*difficulty.getMnoznikZakazeniaSamolot());
                        }else {
                            wylosowanePanstwo.setLudnoscZakazona(wylosowanePanstwo.getLudnoscZakazona() + panstwa.get(i).getLudnoscZakazona()*(difficulty.getMnoznikZakazeniaSamolot()/2));
                            panstwa.get(i).setLudnoscZakazona(panstwa.get(i).getLudnoscZakazona() - panstwa.get(i).getLudnoscZakazona()*(difficulty.getMnoznikZakazeniaSamolot()/2));
                        }
                    }
                }
                Thread.sleep(difficulty.getSzybkoscZakazeniaSamolot());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
