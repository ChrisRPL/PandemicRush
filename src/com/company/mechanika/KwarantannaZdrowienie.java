package com.company.mechanika;

import com.company.wspolczynniki_mechaniki.Difficulty;
import com.company.modele.Panstwo;
import com.company.StatystykiGry;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class KwarantannaZdrowienie implements Runnable {

    private List<Panstwo> panstwa;
    private JLabel liczbaWyzdrowiałych;
    private Difficulty difficulty;
    private DecimalFormat df;

    public KwarantannaZdrowienie(List<Panstwo> panstwa, JLabel liczbaWyzdrowiałych, Difficulty difficulty){
        this.panstwa = panstwa;
        this.liczbaWyzdrowiałych = liczbaWyzdrowiałych;
        this.difficulty = difficulty;

        df = new DecimalFormat("#");
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(difficulty.getSzybkoscZdrowieniaKwarantanna());
                for (int i=0; i<panstwa.size(); i++){
                    if (panstwa.get(i).isWprowadzonaKwarantanna()){
                        if (panstwa.get(i).isUlepszonaKwarantanna()){
                            panstwa.get(i).setLudnoscUleczona(panstwa.get(i).getLudnoscUleczona()
                                    + panstwa.get(i).getLudnoscNaKwarantannie()*panstwa.get(i).getStanSluzbyZdrowia().getWspolczynnikZdrowienKwarantanna()*2);
                            StatystykiGry.ludnoscWyleczona+=panstwa.get(i).getLudnoscNaKwarantannie()*panstwa.get(i).getStanSluzbyZdrowia().getWspolczynnikZdrowienKwarantanna()*2;
                            liczbaWyzdrowiałych.setText("<html><div style='text-align: center;'><h1>LICZBA WYZDROWIAŁYCH</h1></br><h1>"+ df.format(StatystykiGry.ludnoscWyleczona) +"</h1></div></html>");
                            panstwa.get(i).setLudnoscNaKwarantannie(panstwa.get(i).getLudnoscNaKwarantannie()
                                    -panstwa.get(i).getLudnoscNaKwarantannie()*panstwa.get(i).getStanSluzbyZdrowia().getWspolczynnikZdrowienKwarantanna()*2);
                        }else {
                            panstwa.get(i).setLudnoscUleczona(panstwa.get(i).getLudnoscUleczona() + panstwa.get(i).getLudnoscNaKwarantannie()*panstwa.get(i).getStanSluzbyZdrowia().getWspolczynnikZdrowienKwarantanna());
                            StatystykiGry.ludnoscWyleczona+=panstwa.get(i).getLudnoscNaKwarantannie()*panstwa.get(i).getStanSluzbyZdrowia().getWspolczynnikZdrowienKwarantanna();
                            liczbaWyzdrowiałych.setText("<html><div style='text-align: center;'><h1>LICZBA WYZDROWIAŁYCH</h1></br><h1>"+ df.format(StatystykiGry.ludnoscWyleczona) +"</h1></div></html>");
                            panstwa.get(i).setLudnoscNaKwarantannie(panstwa.get(i).getLudnoscNaKwarantannie()-panstwa.get(i).getLudnoscNaKwarantannie()*panstwa.get(i).getStanSluzbyZdrowia().getWspolczynnikZdrowienKwarantanna());
                        }
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
