package com.company.mechanika;

import com.company.StatystykiGry;

import javax.swing.*;

public class UplywCzasu implements Runnable {

    private JLabel licznikCzasu;

    public UplywCzasu(JLabel licznikCzasu){
        this.licznikCzasu = licznikCzasu;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);
                StatystykiGry.czas++;
                String czasMinuty = "", czasSekundy;

                if (StatystykiGry.czas / 60 < 10)
                    czasMinuty = "0" + StatystykiGry.czas / 60;
                else
                    czasMinuty = StatystykiGry.czas / 60 + "";

                if (StatystykiGry.czas % 60 < 10)
                    czasSekundy = "0" + StatystykiGry.czas % 60;
                else
                    czasSekundy = StatystykiGry.czas % 60 + "";

                licznikCzasu.setText("<html><div style='text-align: center;'><h1>CZAS</h1></br><h1>" + czasMinuty + ":" + czasSekundy + "</h1></div></html>");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
