package com.company.wspolczynniki_mechaniki;

public enum StanSektoraPanstwa {
    BARDZO_SLABY("BARDZO SŁABY", "#ff0000", 6, 0.02, 0.07, 0.09),
    SLABY("SŁABY", "#ff6f00", 5, 0.03, 0.08, 0.1),
    SREDNI("ŚREDNI", "#e5ff00", 4, 0.04, 0.09, 0.11),
    DOBRY("DOBRY", "#88ff00", 3, 0.06, 0.11, 0.13),
    BARDZO_DOBRY("BARDZO DOBRY", "#2fff00", 2, 0.08, 0.13, 0.15),
    WYSMIENITY("WYŚMIENITY", "#00730f", 1, 0.1, 0.15, 0.17) {
        @Override
        public StanSektoraPanstwa next() {
            return WYSMIENITY;
        };
    };

    private String stan;
    private String kolor;
    private int mnoznikCeny;
    private double wspolczynnikZdrowien, wspolczynnikZdrowienKwarantanna, wspolczynnikPrzenosinKwarantanna;

    public StanSektoraPanstwa next() {
        // No bounds checking required here, because the last instance overrides
        return values()[ordinal() + 1];
    }

    StanSektoraPanstwa(String stan, String kolor, int mnoznikCeny, double wspolczynnikZdrowien, double wspolczynnikZdrowienKwarantanna,
                       double wspolczynnikPrzenosinKwarantanna){
        this.stan = stan;
        this.kolor = kolor;
        this.mnoznikCeny = mnoznikCeny;
        this.wspolczynnikZdrowien = wspolczynnikZdrowien;
        this.wspolczynnikZdrowienKwarantanna = wspolczynnikZdrowienKwarantanna;
        this.wspolczynnikPrzenosinKwarantanna = wspolczynnikPrzenosinKwarantanna;
    }

    public String getStan(){
        return stan;
    }

    public String getKolor(){
        return kolor;
    }

    public int getMnoznikCeny() {
        return mnoznikCeny;
    }

    public double getWspolczynnikZdrowien() {
        return wspolczynnikZdrowien;
    }

    public double getWspolczynnikZdrowienKwarantanna() {
        return wspolczynnikZdrowienKwarantanna;
    }

    public double getWspolczynnikPrzenosinKwarantanna() {
        return wspolczynnikPrzenosinKwarantanna;
    }
}
