package com.company.mechanika;

import com.company.wspolczynniki_mechaniki.Difficulty;
import com.company.modele.Panstwo;
import com.company.StatystykiGry;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

public class PanstwaZdrowienia implements Runnable {

    private List<Panstwo> panstwa;
    private JLabel liczbaZarazonych;
    private JLabel liczbaPunktow;
    private JLabel liczbaWyzdrowiałych;
    private Difficulty difficulty;
    private DecimalFormat df;

    public PanstwaZdrowienia(List<Panstwo> panstwa, JLabel liczbaZarazonych, JLabel liczbaPunktow, JLabel liczbaWyzdrowiałych,
                      Difficulty difficulty){

        this.panstwa = panstwa;
        this.liczbaZarazonych = liczbaZarazonych;
        this.liczbaPunktow = liczbaPunktow;
        this.liczbaWyzdrowiałych = liczbaWyzdrowiałych;
        this.difficulty = difficulty;

        df = new DecimalFormat("#");

    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(difficulty.getSzybkoscZdrowienia());
                for (int i=0; i<panstwa.size(); i++){
                    if (panstwa.get(i).getLudnoscZakazona()>0){

                        panstwa.get(i).setLudnoscUleczona(panstwa.get(i).getLudnoscUleczona()
                                + panstwa.get(i).getLudnoscZakazona()*panstwa.get(i).getStanSluzbyZdrowia().getWspolczynnikZdrowien());

                        StatystykiGry.ludnoscWyleczona += panstwa.get(i).getLudnoscZakazona()*panstwa.get(i).getStanSluzbyZdrowia().getWspolczynnikZdrowien();

                        StatystykiGry.punkty+= panstwa.get(i).getLudnoscZakazona()*panstwa.get(i).getStanSluzbyZdrowia().getWspolczynnikZdrowien();

                        liczbaWyzdrowiałych.setText("<html><div style='text-align: center;'><h1>LICZBA WYZDROWIAŁYCH</h1></br><h1>"+ df.format(StatystykiGry.ludnoscWyleczona) +"</h1></div></html>");
                        liczbaPunktow.setText("<html><div style='text-align: center;'><h1>PUNKTY</h1></br><h1>"+ df.format(StatystykiGry.punkty) +"</h1></div></html>");
                        StatystykiGry.ludnoscZarazona-=panstwa.get(i).getLudnoscZakazona()*panstwa.get(i).getStanSluzbyZdrowia().getWspolczynnikZdrowien();
                        liczbaZarazonych.setText("<html><div style='text-align: center;'><h1>LICZBA ZARAŻONYCH</h1></br><h1>"+ df.format(StatystykiGry.ludnoscZarazona) +"</h1></div></html>");
                        panstwa.get(i).setLudnoscZakazona(panstwa.get(i).getLudnoscZakazona()
                                - panstwa.get(i).getLudnoscZakazona()*panstwa.get(i).getStanSluzbyZdrowia().getWspolczynnikZdrowien());

                    }
                    if (panstwa.get(i).isWprowadzonaKwarantanna()){

                        panstwa.get(i).setLudnoscNaKwarantannie(panstwa.get(i).getLudnoscNaKwarantannie()
                                + panstwa.get(i).getLudnoscZakazona()*panstwa.get(i).getStanSluzbyZdrowia().getWspolczynnikPrzenosinKwarantanna());

                        StatystykiGry.ludnoscZarazona-=panstwa.get(i).getLudnoscZakazona()*panstwa.get(i).getStanSluzbyZdrowia().getWspolczynnikPrzenosinKwarantanna();
                        liczbaZarazonych.setText("<html><div style='text-align: center;'><h1>LICZBA ZARAŻONYCH</h1></br><h1>"+ df.format(StatystykiGry.ludnoscZarazona) +"</h1></div></html>");
                        panstwa.get(i).setLudnoscZakazona(panstwa.get(i).getLudnoscZakazona() - panstwa.get(i).getLudnoscZakazona()*panstwa.get(i).getStanSluzbyZdrowia().getWspolczynnikPrzenosinKwarantanna());
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
