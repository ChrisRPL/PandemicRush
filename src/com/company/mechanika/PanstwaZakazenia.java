package com.company.mechanika;

import com.company.wspolczynniki_mechaniki.Difficulty;
import com.company.modele.Panstwo;
import com.company.StatystykiGry;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class PanstwaZakazenia implements Runnable {

    private List<Panstwo> panstwa;
    private JLabel liczbaZarazonych;
    private JLabel liczbaWyzdrowiałych;
    private Difficulty difficulty;
    private DecimalFormat df;

    public PanstwaZakazenia(List<Panstwo> panstwa, JLabel liczbaZarazonych, JLabel liczbaWyzdrowiałych, Difficulty difficulty){
        this.panstwa = panstwa;
        this.liczbaZarazonych = liczbaZarazonych;
        this.liczbaWyzdrowiałych = liczbaWyzdrowiałych;
        this.difficulty = difficulty;

        df = new DecimalFormat("#");
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(difficulty.getSzybkoscZakazeniaPanstwa());
                for (int i=0; i<panstwa.size(); i++){
                    if (panstwa.get(i).getLudnoscZakazona()>0 && panstwa.get(i).getLudnoscZakazona()<=panstwa.get(i).getLudnosc()){
                        if (panstwa.get(i).getLudnoscZakazona() + panstwa.get(i).getLudnoscZakazona()*difficulty.getMnoznikZakazeniaPanstwa()
                                + panstwa.get(i).getLudnoscUleczona()*(difficulty.getMnoznikZakazeniaPanstwa()/2)>panstwa.get(i).getLudnosc()) {

                            StatystykiGry.ludnoscZarazona+=panstwa.get(i).getLudnosc()-panstwa.get(i).getLudnoscZakazona();
                            liczbaZarazonych.setText("<html><div style='text-align: center;'><h1>LICZBA ZARAŻONYCH</h1></br><h1>"+ df.format(StatystykiGry.ludnoscZarazona) +"</h1></div></html>");
                            panstwa.get(i).setLudnoscZakazona(panstwa.get(i).getLudnosc());

                        }
                        else {

                            StatystykiGry.ludnoscZarazona+=panstwa.get(i).getLudnoscZakazona() * difficulty.getMnoznikZakazeniaPanstwa()
                                    + panstwa.get(i).getLudnoscUleczona() * (difficulty.getMnoznikZakazeniaPanstwa()/2);
                            liczbaZarazonych.setText("<html><div style='text-align: center;'><h1>LICZBA ZARAŻONYCH</h1></br><h1>"+ df.format(StatystykiGry.ludnoscZarazona) +"</h1></div></html>");
                            panstwa.get(i).setLudnoscZakazona(panstwa.get(i).getLudnoscZakazona() + panstwa.get(i).getLudnoscZakazona() * difficulty.getMnoznikZakazeniaPanstwa()
                                    + panstwa.get(i).getLudnoscUleczona() * (difficulty.getMnoznikZakazeniaPanstwa()/2));

                        }

                        StatystykiGry.ludnoscWyleczona-=panstwa.get(i).getLudnoscUleczona()*(difficulty.getMnoznikZakazeniaPanstwa()/2);
                        liczbaWyzdrowiałych.setText("<html><div style='text-align: center;'><h1>LICZBA WYZDROWIAŁYCH</h1></br><h1>"+ df.format(StatystykiGry.ludnoscWyleczona) +"</h1></div></html>");
                        panstwa.get(i).setLudnoscUleczona(panstwa.get(i).getLudnoscUleczona()-panstwa.get(i).getLudnoscUleczona()*(difficulty.getMnoznikZakazeniaPanstwa()/2));

                    }
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
