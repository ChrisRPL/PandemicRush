package com.company.modele;

import com.company.wspolczynniki_mechaniki.Difficulty;

import java.io.Serializable;

public class WynikGry implements Serializable, Comparable<WynikGry> {
    private String nazwaGracza;
    private String ludnoscZakazona;
    private String ludnoscUleczona;
    private int czas;
    private Difficulty poziomTrudnosci;
    private double wyliczonyRanking;

    public WynikGry(String nazwaGracza, String ludnoscZakazona, String ludnoscUleczona, int czas, Difficulty poziomTrudnosci){
        this.nazwaGracza = nazwaGracza;
        this.ludnoscZakazona = ludnoscZakazona;
        this.ludnoscUleczona = ludnoscUleczona;
        this.czas = czas;
        this.poziomTrudnosci = poziomTrudnosci;
        this.wyliczonyRanking = Double.parseDouble(ludnoscUleczona) - Double.parseDouble(ludnoscZakazona) - czas*poziomTrudnosci.getWspolczynnikRankingu();
    }

    @Override
    public int compareTo(WynikGry wynikGry) {
        if (this.wyliczonyRanking > wynikGry.wyliczonyRanking)
            return -1;
        else if (this.wyliczonyRanking < wynikGry.wyliczonyRanking)
            return 1;
        else
            return this.nazwaGracza.compareTo(wynikGry.nazwaGracza);
    }

    public String getNazwaGracza() {
        return nazwaGracza;
    }

    public String getLudnoscZakazona() {
        return ludnoscZakazona;
    }

    public String getLudnoscUleczona() {
        return ludnoscUleczona;
    }

    public int getCzas() {
        return czas;
    }

    public Difficulty getPoziomTrudnosci() {
        return poziomTrudnosci;
    }
}
