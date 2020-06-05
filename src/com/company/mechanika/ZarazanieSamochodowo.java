package com.company.mechanika;

import com.company.wspolczynniki_mechaniki.Difficulty;
import com.company.modele.Panstwo;

import java.util.List;

public class ZarazanieSamochodowo extends Zarazenia implements Runnable {

    public ZarazanieSamochodowo(List<Panstwo> panstwa, Difficulty difficulty){
        super(panstwa, difficulty);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                for (int i=0; i<panstwa.size(); i++){
                    if (!panstwa.get(i).czyWylaczonaDrogaSamochodowa()&&panstwa.get(i).getPanstwaSasiadujace()!=null&&panstwa.get(i).getLudnoscZakazona()>40000){
                        Panstwo wylosowanePanstwo = super.wylosujPanstwo(panstwa.get(i));

                        if (wylosowanePanstwo==null) //NA WYPADEK GDYBYM W KTÓRYMS Z PANSWT ZROBIL LITEROWKE I ZADNEGO NIE WYLOSOWALO
                            continue;

                        if (!panstwa.get(i).isKontrolaNaGranicach()){
                            wylosowanePanstwo.setLudnoscZakazona(wylosowanePanstwo.getLudnoscZakazona() + panstwa.get(i).getLudnoscZakazona()*difficulty.getMnoznikZakazeniaAuto());
                            panstwa.get(i).setLudnoscZakazona(panstwa.get(i).getLudnoscZakazona() - panstwa.get(i).getLudnoscZakazona()*difficulty.getMnoznikZakazeniaAuto());
                        }else {
                            wylosowanePanstwo.setLudnoscZakazona(wylosowanePanstwo.getLudnoscZakazona() + panstwa.get(i).getLudnoscZakazona()*(difficulty.getMnoznikZakazeniaAuto()/2));
                            panstwa.get(i).setLudnoscZakazona(panstwa.get(i).getLudnoscZakazona() - panstwa.get(i).getLudnoscZakazona()*(difficulty.getMnoznikZakazeniaAuto()/2));
                        }
                    }

                }
                Thread.sleep(difficulty.getSzybkoscZakazeniaAuto());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
