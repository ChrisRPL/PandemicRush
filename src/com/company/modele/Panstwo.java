package com.company.modele;

import com.company.wspolczynniki_mechaniki.StanSektoraPanstwa;

import java.util.List;

public class Panstwo {

    private String nazwaPanstwa;
    private int wspolrzednaX;
    private int wspolrzednaY;
    private double ludnosc;
    private double ludnoscZakazona;
    private double ludnoscUleczona;
    private double ludnoscNaKwarantannie;
    private List<String> panstwaSasiadujace;
    private StanSektoraPanstwa stanGospodarki;
    private StanSektoraPanstwa stanSluzbyZdrowia;
    private boolean posiadaLotnisko;
    private boolean posiadaPort;
    private boolean wylaczonaDrogaSamochodowa;
    private boolean wylaczonaDrogaAutobusowa;
    private boolean wylaczonaDrogaPociagowa;
    private boolean wylaczonaDrogaWodna;
    private boolean wylaczonaDrogaPowietrzna;

    //ZMIENNE DOTYCZĄCE ULEPSZEŃ
    private boolean ulepszonaSluzbaZdrowia;
    private boolean wprowadzonaKwarantanna;
    private boolean ulepszonaKwarantanna;
    private boolean ulepszonaGospodarka;
    private boolean kontrolaNaGranicach;
    private boolean kontrolaWPortach;
    private boolean kontrolaNaLotniskach;
    private boolean kwarantannaTotalna;
    private boolean pomocLosowemuSasiadowi;


    public Panstwo(String nazwaPanstwa, int wspolrzednaX, int wspolrzednaY, int ludnosc, List<String> panstwaSasiadujace, StanSektoraPanstwa stanGospodarki, StanSektoraPanstwa stanSluzbyZdrowia,
            boolean posiadaLotnisko, boolean posiadaPort){

        this.nazwaPanstwa = nazwaPanstwa;
        this.wspolrzednaX = wspolrzednaX;
        this.wspolrzednaY = wspolrzednaY;
        this.ludnosc = ludnosc;
        this.ludnoscZakazona = nazwaPanstwa.equals("CHINY") ? 1 : 0;
        this.ludnoscUleczona = 0;
        this.ludnoscNaKwarantannie = 0;
        this.panstwaSasiadujace = panstwaSasiadujace;
        this.stanGospodarki = stanGospodarki;
        this.stanSluzbyZdrowia = stanSluzbyZdrowia;
        this.posiadaLotnisko = posiadaLotnisko;
        this.posiadaPort = posiadaPort;

        this.wylaczonaDrogaSamochodowa = false;
        this.wylaczonaDrogaAutobusowa = false;
        this.wylaczonaDrogaPociagowa = false;

        this.wylaczonaDrogaWodna = !this.posiadaPort;
        this.wylaczonaDrogaPowietrzna = !this.posiadaLotnisko;

        this.ulepszonaSluzbaZdrowia = false;
        this.wprowadzonaKwarantanna = false;
        this.ulepszonaKwarantanna = false;
        this.ulepszonaGospodarka = false;
        this.kontrolaNaGranicach = false;
        this.kontrolaWPortach = false;
        this.kontrolaNaLotniskach = false;
        this.kwarantannaTotalna = false;
        this.pomocLosowemuSasiadowi = false;

    }

    public void ulepszSluzbeZdrowia(){
        this.ulepszonaSluzbaZdrowia = true;
        this.stanSluzbyZdrowia = this.stanSluzbyZdrowia.next();
    }

    public void ulepszStanGospodarki(){
        this.ulepszonaGospodarka = true;
        this.stanGospodarki = this.stanGospodarki.next();
    }

    public void pomocSasiadowi(Panstwo panstwo){
        this.pomocLosowemuSasiadowi=true;
        panstwo.stanSluzbyZdrowia = panstwo.stanSluzbyZdrowia.next();
        this.ludnoscNaKwarantannie = panstwo.ludnoscZakazona/4;
        panstwo.ludnoscZakazona -= panstwo.ludnoscZakazona/4;
    }

    public void wprowadzKwarantanneTotalna(){
        this.kwarantannaTotalna = true;
        this.ludnoscNaKwarantannie+=this.ludnoscZakazona;
        this.ludnoscZakazona=0;
    }

    //GETTERY

    public String getNazwaPanstwa() {
        return nazwaPanstwa;
    }

    public int getWspolrzednaX() {
        return wspolrzednaX;
    }

    public int getWspolrzednaY() {
        return wspolrzednaY;
    }

    public double getLudnosc() {
        return ludnosc;
    }

    public double getLudnoscZakazona() {
        return ludnoscZakazona;
    }

    public double getLudnoscUleczona() {
        return ludnoscUleczona;
    }

    public double getLudnoscNaKwarantannie() {
        return ludnoscNaKwarantannie;
    }

    public List<String> getPanstwaSasiadujace() {
        return panstwaSasiadujace;
    }

    public StanSektoraPanstwa getStanGospodarki() {
        return stanGospodarki;
    }

    public StanSektoraPanstwa getStanSluzbyZdrowia() {
        return stanSluzbyZdrowia;
    }

    public boolean czyPosiadaLotnisko() {
        return posiadaLotnisko;
    }

    public boolean czyPosiadaPort() {
        return posiadaPort;
    }

    public boolean czyWylaczonaDrogaSamochodowa() {
        return wylaczonaDrogaSamochodowa;
    }

    public boolean czyWylaczonaDrogaAutobusowa() {
        return wylaczonaDrogaAutobusowa;
    }

    public boolean czyWylaczonaDrogaPociagowa() {
        return wylaczonaDrogaPociagowa;
    }

    public boolean czyWylaczonaDrogaWodna() {
        return wylaczonaDrogaWodna;
    }

    public boolean czyWylaczonaDrogaPowietrzna() {
        return wylaczonaDrogaPowietrzna;
    }

    public boolean isUlepszonaSluzbaZdrowia() {
        return ulepszonaSluzbaZdrowia;
    }

    public boolean isWprowadzonaKwarantanna() {
        return wprowadzonaKwarantanna;
    }

    public boolean isUlepszonaKwarantanna() {
        return ulepszonaKwarantanna;
    }

    public boolean isUlepszonaGospodarka() {
        return ulepszonaGospodarka;
    }

    public boolean isKontrolaNaGranicach() {
        return kontrolaNaGranicach;
    }

    public boolean isKontrolaWPortach() {
        return kontrolaWPortach;
    }

    public boolean isKontrolaNaLotniskach() {
        return kontrolaNaLotniskach;
    }

    public boolean isKwarantannaTotalna() {
        return kwarantannaTotalna;
    }

    public boolean isPomocLosowemuSasiadowi() {
        return pomocLosowemuSasiadowi;
    }

    //SETTERY

    public void setLudnoscZakazona(double ludnoscZakazona) {
        this.ludnoscZakazona = ludnoscZakazona;
    }

    public void setLudnoscUleczona(double ludnoscUleczona) {
        this.ludnoscUleczona = ludnoscUleczona;
    }

    public void setLudnoscNaKwarantannie(double ludnoscNaKwarantannie) {
        this.ludnoscNaKwarantannie = ludnoscNaKwarantannie;
    }

    public void setWylaczonaDrogaSamochodowa(boolean wylaczonaDrogaSamochodowa) {
        this.wylaczonaDrogaSamochodowa = wylaczonaDrogaSamochodowa;
    }

    public void setWylaczonaDrogaAutobusowa(boolean wylaczonaDrogaAutobusowa) {
        this.wylaczonaDrogaAutobusowa = wylaczonaDrogaAutobusowa;
    }

    public void setWylaczonaDrogaPociagowa(boolean wylaczonaDrogaPociagowa) {
        this.wylaczonaDrogaPociagowa = wylaczonaDrogaPociagowa;
    }

    public void setWylaczonaDrogaWodna(boolean wylaczonaDrogaWodna) {
        this.wylaczonaDrogaWodna = wylaczonaDrogaWodna;
    }

    public void setWylaczonaDrogaPowietrzna(boolean wylaczonaDrogaPowietrzna) {
        this.wylaczonaDrogaPowietrzna = wylaczonaDrogaPowietrzna;
    }

    public void setWprowadzonaKwarantanna(boolean wprowadzonaKwarantanna) {
        this.wprowadzonaKwarantanna = wprowadzonaKwarantanna;
    }

    public void setUlepszonaKwarantanna(boolean ulepszonaKwarantanna) {
        this.ulepszonaKwarantanna = ulepszonaKwarantanna;
    }

    public void setKontrolaNaGranicach(boolean kontrolaNaGranicach) {
        this.kontrolaNaGranicach = kontrolaNaGranicach;
    }

    public void setKontrolaWPortach(boolean kontrolaWPortach) {
        this.kontrolaWPortach = kontrolaWPortach;
    }

    public void setKontrolaNaLotniskach(boolean kontrolaNaLotniskach) {
        this.kontrolaNaLotniskach = kontrolaNaLotniskach;
    }
}
