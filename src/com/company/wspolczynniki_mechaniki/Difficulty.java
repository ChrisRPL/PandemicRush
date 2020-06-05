package com.company.wspolczynniki_mechaniki;

public enum Difficulty {
    EASY("EASY", 1500, 0.08, 3000, 3500,
            2000, 0.11, 2500, 0.16,
            4000, 0.19, 4500, 0.21,
            4500, 0.25, 3),
    MEDIUM("MEDIUM", 1500, 0.09, 2500, 3500,
            2500, 0.14, 3000, 0.19,
            3500, 0.22, 4000, 0.24,
            4500, 0.26, 2),
    HARD("HARD", 1500, 0.11, 3000, 3500,
            2000, 0.15, 2500, 0.22,
            3500, 0.24, 4000, 0.25,
            4500, 0.27, 1);

    private String nazwaTrudnosci;

    private int szybkoscZakazeniaPanstwa;
    private double mnoznikZakazeniaPanstwa;
    private int szybkoscZdrowienia;
    private int szybkoscZdrowieniaKwarantanna;

    private int szybkoscZakazeniaAuto;
    private double mnoznikZakazeniaAuto;

    private int szybkoscZakazeniaAutobus;
    private double mnoznikZakazeniaAutobus;

    private int szybkoscZakazeniaPociag;
    private double mnoznikZakazeniaPociag;

    private int szybkoscZakazeniaStatek;
    private double mnoznikZakazeniaStatek;

    private int szybkoscZakazeniaSamolot;
    private double mnoznikZakazeniaSamolot;

    private int wspolczynnikRankingu;


    Difficulty(String nazwaTrudnosci, int szybkoscZakazeniaPanstwa, double mnoznikZakazeniaPanstwa, int szybkoscZdrowienia, int szybkoscZdrowieniaKwarantanna,
               int szybkoscZakazeniaAuto, double mnoznikZakazeniaAuto, int szybkoscZakazeniaAutobus, double mnoznikZakazeniaAutobus,
               int szybkoscZakazeniaPociag, double mnoznikZakazeniaPociag, int szybkoscZakazeniaStatek, double mnoznikZakazeniaStatek,
               int szybkoscZakazeniaSamolot, double mnoznikZakazeniaSamolot, int wspolczynnikRankingu){

        this.nazwaTrudnosci = nazwaTrudnosci;

        this.szybkoscZakazeniaPanstwa = szybkoscZakazeniaPanstwa;
        this.mnoznikZakazeniaPanstwa = mnoznikZakazeniaPanstwa;
        this.szybkoscZdrowienia = szybkoscZdrowienia;
        this.szybkoscZdrowieniaKwarantanna = szybkoscZdrowieniaKwarantanna;

        this.szybkoscZakazeniaAuto = szybkoscZakazeniaAuto;
        this.mnoznikZakazeniaAuto = mnoznikZakazeniaAuto;

        this.szybkoscZakazeniaAutobus = szybkoscZakazeniaAutobus;
        this.mnoznikZakazeniaAutobus = mnoznikZakazeniaAutobus;

        this.szybkoscZakazeniaPociag = szybkoscZakazeniaPociag;
        this.mnoznikZakazeniaPociag = mnoznikZakazeniaPociag;

        this.szybkoscZakazeniaStatek = szybkoscZakazeniaStatek;
        this.mnoznikZakazeniaStatek = mnoznikZakazeniaStatek;

        this.szybkoscZakazeniaSamolot = szybkoscZakazeniaSamolot;
        this.mnoznikZakazeniaSamolot = mnoznikZakazeniaSamolot;

        this.wspolczynnikRankingu = wspolczynnikRankingu;

    }

    public String getNazwaTrudnosci() {
        return nazwaTrudnosci;
    }

    public int getSzybkoscZakazeniaPanstwa() {
        return szybkoscZakazeniaPanstwa;
    }

    public double getMnoznikZakazeniaPanstwa() {
        return mnoznikZakazeniaPanstwa;
    }

    public int getSzybkoscZdrowienia() {
        return szybkoscZdrowienia;
    }

    public int getSzybkoscZdrowieniaKwarantanna() {
        return szybkoscZdrowieniaKwarantanna;
    }

    public int getSzybkoscZakazeniaAuto() {
        return szybkoscZakazeniaAuto;
    }

    public double getMnoznikZakazeniaAuto() {
        return mnoznikZakazeniaAuto;
    }

    public int getSzybkoscZakazeniaAutobus() {
        return szybkoscZakazeniaAutobus;
    }

    public double getMnoznikZakazeniaAutobus() {
        return mnoznikZakazeniaAutobus;
    }

    public int getSzybkoscZakazeniaPociag() {
        return szybkoscZakazeniaPociag;
    }

    public double getMnoznikZakazeniaPociag() {
        return mnoznikZakazeniaPociag;
    }

    public int getSzybkoscZakazeniaStatek() {
        return szybkoscZakazeniaStatek;
    }

    public double getMnoznikZakazeniaStatek() {
        return mnoznikZakazeniaStatek;
    }

    public int getSzybkoscZakazeniaSamolot() {
        return szybkoscZakazeniaSamolot;
    }

    public double getMnoznikZakazeniaSamolot() {
        return mnoznikZakazeniaSamolot;
    }

    public int getWspolczynnikRankingu() {
        return wspolczynnikRankingu;
    }
}
