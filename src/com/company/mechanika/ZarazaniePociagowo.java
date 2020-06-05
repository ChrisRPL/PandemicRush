package com.company.mechanika;

import com.company.wspolczynniki_mechaniki.Difficulty;
import com.company.modele.Panstwo;

import java.util.List;


public class ZarazaniePociagowo extends Zarazenia implements Runnable {

    public ZarazaniePociagowo(List<Panstwo> panstwa, Difficulty difficulty){
        super(panstwa, difficulty);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                for (int i=0; i<panstwa.size(); i++){
                    if (!panstwa.get(i).czyWylaczonaDrogaPociagowa()&&panstwa.get(i).getPanstwaSasiadujace()!=null&&panstwa.get(i).getLudnoscZakazona()>70000){
                        List<String> panstwaSasiadujace = panstwa.get(i).getPanstwaSasiadujace();


                        int indeksPanstwa = (int)(Math.random()*(panstwaSasiadujace.size()));
                        String nazwaPanstwa = panstwaSasiadujace.get(indeksPanstwa);
                        Panstwo wylosowanePanstwo=null;
                        for (int j=0; j<panstwa.size(); j++){
                            if (panstwa.get(j).getNazwaPanstwa().equals(nazwaPanstwa)){
                                wylosowanePanstwo=panstwa.get(j);
                                break;
                            }
                        }


                        if (wylosowanePanstwo==null) //NA WYPADEK GDYBYM W KTÓRYMS Z PANSWT ZROBIL LITEROWKE I ZADNEGO NIE WYLOSOWALO
                            continue;

                        if (wylosowanePanstwo.getPanstwaSasiadujace()!=null){
                            indeksPanstwa = (int)(Math.random()*(wylosowanePanstwo.getPanstwaSasiadujace().size()));
                            String nazwaWylosowanegoPanstwa = wylosowanePanstwo.getPanstwaSasiadujace().get(indeksPanstwa);

                            for (int j=0; j<panstwa.size(); j++){
                                if (panstwa.get(j).getNazwaPanstwa().equals(nazwaWylosowanegoPanstwa)){
                                    wylosowanePanstwo=panstwa.get(j);
                                    break;
                                }
                            }
                        }

                        if (!panstwa.get(i).isKontrolaNaGranicach()){
                            System.out.println(panstwa.get(i).getNazwaPanstwa() + " " + indeksPanstwa);
                            wylosowanePanstwo.setLudnoscZakazona(wylosowanePanstwo.getLudnoscZakazona() + panstwa.get(i).getLudnoscZakazona()*difficulty.getMnoznikZakazeniaPociag());
                            panstwa.get(i).setLudnoscZakazona(panstwa.get(i).getLudnoscZakazona() - panstwa.get(i).getLudnoscZakazona()*difficulty.getMnoznikZakazeniaPociag());
                        }else {
                            wylosowanePanstwo.setLudnoscZakazona(wylosowanePanstwo.getLudnoscZakazona() + panstwa.get(i).getLudnoscZakazona()*(difficulty.getMnoznikZakazeniaPociag()/2));
                            panstwa.get(i).setLudnoscZakazona(panstwa.get(i).getLudnoscZakazona() - panstwa.get(i).getLudnoscZakazona()*(difficulty.getMnoznikZakazeniaPociag()/2));
                        }
                    }

                }
                Thread.sleep(difficulty.getSzybkoscZakazeniaPociag());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
