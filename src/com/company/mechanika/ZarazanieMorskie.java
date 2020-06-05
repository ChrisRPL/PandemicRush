package com.company.mechanika;

import com.company.wspolczynniki_mechaniki.Difficulty;
import com.company.modele.Panstwo;

import java.util.LinkedList;
import java.util.List;

public class ZarazanieMorskie extends Zarazenia implements Runnable {

    public ZarazanieMorskie(List<Panstwo> panstwa, Difficulty difficulty){
        super(panstwa, difficulty);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                for (int i=0; i<panstwa.size(); i++){
                    if (!panstwa.get(i).czyWylaczonaDrogaWodna()&&panstwa.get(i).czyPosiadaPort()&&panstwa.get(i).getLudnoscZakazona()>100000){
                        List<Panstwo> panstwaZPortami = new LinkedList<>();

                        for (int j=0; j<panstwa.size(); j++){
                            if (panstwa.get(j).czyPosiadaPort())
                                panstwaZPortami.add(panstwa.get(j));
                        }

                        panstwaZPortami.remove(panstwa.get(i)); //USUWAM OBECNIE WYBRANE PANSTWO Z DOSTEPEM DO MORZA

                        int indeksPanstwa = (int)(Math.random()*(panstwaZPortami.size()));
                        Panstwo wylosowanePanstwo = panstwaZPortami.get(indeksPanstwa);

                        if (!panstwa.get(i).isKontrolaWPortach()){
                            wylosowanePanstwo.setLudnoscZakazona(wylosowanePanstwo.getLudnoscZakazona() + panstwa.get(i).getLudnoscZakazona()*difficulty.getMnoznikZakazeniaStatek());
                            wylosowanePanstwo.setLudnoscZakazona(panstwa.get(i).getLudnoscZakazona() - panstwa.get(i).getLudnoscZakazona()*difficulty.getMnoznikZakazeniaStatek());
                        }else {
                            wylosowanePanstwo.setLudnoscZakazona(wylosowanePanstwo.getLudnoscZakazona() + panstwa.get(i).getLudnoscZakazona()*(difficulty.getMnoznikZakazeniaStatek()/2));
                            panstwa.get(i).setLudnoscZakazona(panstwa.get(i).getLudnoscZakazona() - panstwa.get(i).getLudnoscZakazona()*(difficulty.getMnoznikZakazeniaStatek()/2));
                        }
                    }
                }
                Thread.sleep(difficulty.getSzybkoscZakazeniaStatek());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
