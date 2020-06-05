package com.company.custom_components;

import com.company.StatystykiGry;
import com.company.modele.Panstwo;
import com.company.wspolczynniki_mechaniki.StanSektoraPanstwa;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class CustomDialog extends JTabbedPane {
    private Map<String,String[]> ulepszeniaAtrybuty, transportAtrybuty;
    private Panstwo panstwo;
    private DecimalFormat df;
    private List<Panstwo> panstwa;

    public CustomDialog(Map<String,String[]> ulepszeniaAtrybuty, Map<String,String[]> transportAtrybuty, Panstwo panstwo, List<Panstwo> panstwa){
        this.ulepszeniaAtrybuty = ulepszeniaAtrybuty;
        this.transportAtrybuty = transportAtrybuty;
        this.panstwo = panstwo;
        this.panstwa = panstwa;

        df = new DecimalFormat("#");

        setBackground(Color.WHITE);


        JPanel informacjePanstwa = new JPanel();
        GroupLayout informacjePanstwaLayout = new GroupLayout(informacjePanstwa);
        Font titleFont = new Font("Century Gothic", Font.PLAIN, 20);
        Font opisFont = new Font("Century Gothic", Font.PLAIN, 15);

        CustomLabel nazwaPanstwa = new CustomLabel("<html>" + panstwo.getNazwaPanstwa() +"</html>", Color.WHITE, new Color(19, 236, 236), titleFont);

        CustomLabel danePanstwa = new CustomLabel("<html>LUDNOŚĆ: "+ df.format(panstwo.getLudnosc()) +"" +
                "<br>LUDNOŚĆ WYZDROWIAŁA: "+ df.format(panstwo.getLudnoscUleczona()) +
                "<br>LUDNOŚĆ ZAKAŻONA: "+ df.format(panstwo.getLudnoscZakazona()) +"" +
                "<br>OSÓB NA KWARANTANNIE: "+ (panstwo.isWprowadzonaKwarantanna()
                ? df.format(panstwo.getLudnoscNaKwarantannie()) : "BRAK WPROWADZONEJ KWARANTANNY") +"" +
                "<br><h2>STAN GOSPODARKI: <font color="+panstwo.getStanGospodarki().getKolor()+">"
                + panstwo.getStanGospodarki().getStan() +"</font>" +
                "<br>STAN SŁUŻBY ZDROWIA: <font color="+ panstwo.getStanSluzbyZdrowia().getKolor() +">" +
                ""+ panstwo.getStanSluzbyZdrowia().getStan() +"</font></html>", new Color(19, 236, 236), Color.WHITE, titleFont);

        JPanel ulepszeniaPanstwa = new JPanel();
        int col = 5;
        int row = 9;

        GridLayout ulepszeniaPanstwaLayout = new GridLayout(row, col);
        ulepszeniaPanstwa.setLayout(ulepszeniaPanstwaLayout);


        for (Map.Entry<String,String[]> ulepszenia : ulepszeniaAtrybuty.entrySet()){
            JLabel ikonka = new JLabel(new ImageIcon(ulepszenia.getValue()[0]));
            ikonka.setOpaque(true);
            ikonka.setBackground(Color.WHITE);
            ikonka.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

            CustomLabel nazwa = new CustomLabel("<html>"+ulepszenia.getValue()[1]+"</html>", new Color(19, 236, 236), Color.WHITE, titleFont, new Dimension(300, 80));
            CustomLabel opis = new CustomLabel("<html>OPIS: "+ ulepszenia.getValue()[2]+"</html>", Color.BLACK, Color.WHITE, opisFont, new Dimension(300, 80));
            CustomLabel cena = new CustomLabel("<html>CENA: "+ Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny() +" pkt.</html>", new Color(19, 236, 236), Color.WHITE, titleFont, new Dimension(300, 80));

            ulepszeniaPanstwa.add(ikonka);
            ulepszeniaPanstwa.add(nazwa);
            ulepszeniaPanstwa.add(opis);
            ulepszeniaPanstwa.add(cena);

            JButton ulepszenieBtn = new JButton();

            switch (ulepszenia.getKey()){
                case "ulepszonaSluzbaZdrowia":
                    if (panstwo.isUlepszonaSluzbaZdrowia()){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("ZAKUPIONE");
                    }else if (panstwo.getStanSluzbyZdrowia()== StanSektoraPanstwa.WYSMIENITY){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("NIEDOSTEPNE");
                    }
                    else {
                        if (StatystykiGry.punkty >= Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny()) {
                            ulepszenieBtn.setText("KUP");
                            ulepszenieBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    panstwo.ulepszSluzbeZdrowia();
                                    ulepszenieBtn.setEnabled(false);
                                    ulepszenieBtn.setText("ZAKUPIONE");
                                    StatystykiGry.punkty-=Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny();
                                }
                            });
                        } else {
                            ulepszenieBtn.setEnabled(false);
                            ulepszenieBtn.setText("MAŁO PUNKTÓW");
                        }
                    }
                    break;

                case "ulepszonaGospodarka":
                    if (panstwo.isUlepszonaGospodarka()){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("ZAKUPIONE");
                    }else if (panstwo.getStanGospodarki()==StanSektoraPanstwa.WYSMIENITY){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("NIEDOSTEPNE");
                    }
                    else {

                        if (StatystykiGry.punkty >= Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny()) {
                            ulepszenieBtn.setText("KUP");
                            ulepszenieBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    panstwo.ulepszStanGospodarki();
                                    ulepszenieBtn.setEnabled(false);
                                    ulepszenieBtn.setText("ZAKUPIONE");
                                    StatystykiGry.punkty-=Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny();
                                }
                            });
                        }else {
                            ulepszenieBtn.setEnabled(false);
                            ulepszenieBtn.setText("MAŁO PUNKTÓW");
                        }
                    }
                    break;

                case "wprowadzenieKwarantanny":
                    if (panstwo.isWprowadzonaKwarantanna()){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("ZAKUPIONE");
                    }else {

                        if (StatystykiGry.punkty >= Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny()) {
                            ulepszenieBtn.setText("KUP");
                            ulepszenieBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    panstwo.setWprowadzonaKwarantanna(true);
                                    ulepszenieBtn.setEnabled(false);
                                    ulepszenieBtn.setText("ZAKUPIONE");
                                    StatystykiGry.punkty-=Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny();
                                }
                            });
                        }else {
                            ulepszenieBtn.setEnabled(false);
                            ulepszenieBtn.setText("MAŁO PUNKTÓW");
                        }
                    }
                    break;

                case "ulepszonaKwarantanna":
                    if (panstwo.isUlepszonaKwarantanna()){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("ZAKUPIONE");
                    } else if (!panstwo.isWprowadzonaKwarantanna()){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("NIEDOSTEPNE");
                    }else {

                        if (StatystykiGry.punkty >= Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny()) {
                            ulepszenieBtn.setText("KUP");
                            ulepszenieBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    panstwo.setUlepszonaKwarantanna(true);
                                    ulepszenieBtn.setEnabled(false);
                                    ulepszenieBtn.setText("ZAKUPIONE");
                                    StatystykiGry.punkty-=Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny();
                                }
                            });
                        }else {
                            ulepszenieBtn.setEnabled(false);
                            ulepszenieBtn.setText("MAŁO PUNKTÓW");
                        }
                    }
                    break;

                case "kontrolaNaGranicach":
                    if (panstwo.isKontrolaNaGranicach()){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("ZAKUPIONE");
                    } else {

                        if (StatystykiGry.punkty >= Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny()) {
                            ulepszenieBtn.setText("KUP");
                            ulepszenieBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    panstwo.setKontrolaNaGranicach(true);
                                    ulepszenieBtn.setEnabled(false);
                                    ulepszenieBtn.setText("ZAKUPIONE");
                                    StatystykiGry.punkty-=Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny();
                                }
                            });
                        }else {
                            ulepszenieBtn.setEnabled(false);
                            ulepszenieBtn.setText("MAŁO PUNKTÓW");
                        }
                    }
                    break;

                case "kontrolaWPortach":
                    if (panstwo.isKontrolaWPortach()){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("ZAKUPIONE");
                    } else if (!panstwo.czyPosiadaPort()){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("NIEDOSTEPNE");
                    } else {

                        if (StatystykiGry.punkty >= Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny()) {
                            ulepszenieBtn.setText("KUP");
                            ulepszenieBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    panstwo.setKontrolaWPortach(true);
                                    ulepszenieBtn.setEnabled(false);
                                    ulepszenieBtn.setText("ZAKUPIONE");
                                    StatystykiGry.punkty-=Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny();
                                }
                            });
                        }else {
                            ulepszenieBtn.setEnabled(false);
                            ulepszenieBtn.setText("MAŁO PUNKTÓW");
                        }
                    }
                    break;

                case "kontrolaNaLotniskach":
                    if (panstwo.isKontrolaNaLotniskach()){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("ZAKUPIONE");
                    } else if (!panstwo.czyPosiadaLotnisko()){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("NIEDOSTEPNE");
                    } else {
                        if (StatystykiGry.punkty >= Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny()) {
                            ulepszenieBtn.setText("KUP");
                            ulepszenieBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    panstwo.setKontrolaNaLotniskach(true);
                                    ulepszenieBtn.setEnabled(false);
                                    ulepszenieBtn.setText("ZAKUPIONE");
                                    StatystykiGry.punkty-=Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny();
                                }
                            });
                        }else {
                            ulepszenieBtn.setEnabled(false);
                            ulepszenieBtn.setText("MAŁO PUNKTÓW");
                        }
                    }
                    break;

                case "kwarantannaTotalna":
                    if (panstwo.isKwarantannaTotalna()){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("ZAKUPIONE");
                    } else if (!panstwo.isWprowadzonaKwarantanna()){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("NIEDOSTEPNE");
                    } else {
                        if (StatystykiGry.punkty >= Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny()) {
                            ulepszenieBtn.setText("KUP");
                            ulepszenieBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    panstwo.wprowadzKwarantanneTotalna();
                                    ulepszenieBtn.setEnabled(false);
                                    ulepszenieBtn.setText("ZAKUPIONE");
                                    StatystykiGry.punkty-=Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny();
                                }
                            });
                        }else {
                            ulepszenieBtn.setEnabled(false);
                            ulepszenieBtn.setText("MAŁO PUNKTÓW");
                        }
                    }
                    break;

                case "pomocSasiadowi":
                    if (panstwo.isPomocLosowemuSasiadowi()){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("ZAKUPIONE");
                    } else if (panstwo.getPanstwaSasiadujace()==null){
                        ulepszenieBtn.setEnabled(false);
                        ulepszenieBtn.setText("NIEDOSTEPNE");
                    } else {
                        if (StatystykiGry.punkty >= Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny()) {
                            ulepszenieBtn.setText("KUP");
                            ulepszenieBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    List<String> panstwaSasiadujace = panstwo.getPanstwaSasiadujace();
                                    int indeksPanstwa = (int)(Math.random()*(panstwaSasiadujace.size()));
                                    String nazwaPanstwa = panstwaSasiadujace.get(indeksPanstwa);
                                    Panstwo wylosowanePanstwo=null;
                                    for (int j=0; j<panstwa.size(); j++){
                                        if (panstwa.get(j).getNazwaPanstwa().equals(nazwaPanstwa)){
                                            wylosowanePanstwo=panstwa.get(j);
                                            break;
                                        }
                                    }

                                    if (wylosowanePanstwo!=null)
                                        panstwo.pomocSasiadowi(wylosowanePanstwo);

                                    ulepszenieBtn.setEnabled(false);
                                    ulepszenieBtn.setText("ZAKUPIONE");
                                    StatystykiGry.punkty-=Integer.parseInt(ulepszenia.getValue()[3])*panstwo.getStanGospodarki().getMnoznikCeny();
                                }
                            });
                        }else {
                            ulepszenieBtn.setEnabled(false);
                            ulepszenieBtn.setText("MAŁO PUNKTÓW");
                        }
                    }
                    break;
            }

            ulepszeniaPanstwa.add(ulepszenieBtn);
        }


        JPanel transportPanstwa = new JPanel();

        int rowT=5, colT=4;

        GridLayout transportPanstwaLayout = new GridLayout(rowT, colT);
        transportPanstwa.setLayout(transportPanstwaLayout);

        for (Map.Entry<String,String[]> transport : transportAtrybuty.entrySet()){
            JLabel ikonka = new JLabel(new ImageIcon(transport.getValue()[0]));
            ikonka.setOpaque(true);
            ikonka.setBackground(Color.WHITE);
            ikonka.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

            CustomLabel nazwa = new CustomLabel("<html><h1>"+transport.getValue()[1]+"</h1></html>", new Color(19, 236, 236), Color.WHITE, titleFont, new Dimension(300, 80));

            JLabel wymagania = new JLabel(new ImageIcon("img/info.png"));
            wymagania.setToolTipText(transport.getValue()[2]);
            wymagania.setOpaque(true);
            wymagania.setBackground(Color.WHITE);
            wymagania.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));


            transportPanstwa.add(ikonka);
            transportPanstwa.add(nazwa);
            transportPanstwa.add(wymagania);

            JLabel stan = new JLabel();
            stan.setFont(titleFont);
            stan.setForeground(new Color(19, 236, 236));
            stan.setOpaque(true);
            stan.setBackground(Color.WHITE);
            stan.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            nazwa.setPreferredSize(new Dimension(300, 80));

            JButton transportBtn = new JButton();

            switch (transport.getKey()){
                case "car":
                    if (panstwo.czyWylaczonaDrogaSamochodowa()){
                        stan.setText("<html><h2>STAN: <font color='red'>WYŁĄCZONY</font></h2></html>");
                        transportBtn.setEnabled(false);
                        transportBtn.setText("WYŁĄCZONY");
                    }else {
                        stan.setText("<html><h2>STAN: <font color='green'>WŁĄCZONA</font></h2></html>");

                        if ((panstwo.getLudnoscZakazona()/panstwo.getLudnosc())>=0.01 && panstwo.isKontrolaNaGranicach()) {
                            transportBtn.setText("WYŁĄCZ");

                            transportBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    panstwo.setWylaczonaDrogaSamochodowa(true);
                                    stan.setText("<html><h2>STAN: <font color='red'>WYŁĄCZONY</font></h2></html>");
                                    transportBtn.setEnabled(false);
                                    transportBtn.setText("WYŁĄCZONY");
                                }
                            });
                        } else {
                            transportBtn.setText("BRAK WYMAGAŃ");
                            transportBtn.setEnabled(false);
                        }
                    }
                    break;

                case "bus":
                    if (panstwo.czyWylaczonaDrogaAutobusowa()){
                        stan.setText("<html><h2>STAN: <font color='red'>WYŁĄCZONY</font></h2></html>");
                        transportBtn.setEnabled(false);
                        transportBtn.setText("WYŁĄCZONY");
                    }else {
                        stan.setText("<html><h2>STAN: <font color='green'>WŁĄCZONA</font></h2></html>");

                        if ((panstwo.getLudnoscZakazona()/panstwo.getLudnosc())>=0.02 && panstwo.isKontrolaNaGranicach()
                                && panstwo.isUlepszonaGospodarka()) {

                            transportBtn.setText("WYŁĄCZ");

                            transportBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    panstwo.setWylaczonaDrogaAutobusowa(true);
                                    stan.setText("<html><h2>STAN: <font color='red'>WYŁĄCZONY</font></h2></html>");
                                    transportBtn.setEnabled(false);
                                    transportBtn.setText("WYŁĄCZONY");
                                }
                            });
                        } else {
                            transportBtn.setText("BRAK WYMAGAŃ");
                            transportBtn.setEnabled(false);
                        }
                    }
                    break;

                case "train":
                    if (panstwo.czyWylaczonaDrogaPociagowa()){
                        stan.setText("<html><h2>STAN: <font color='red'>WYŁĄCZONY</font></h2></html>");
                        transportBtn.setEnabled(false);
                        transportBtn.setText("WYŁĄCZONY");
                    }else {
                        stan.setText("<html><h2>STAN: <font color='green'>WŁĄCZONA</font></h2></html>");

                        if ((panstwo.getLudnoscZakazona()/panstwo.getLudnosc())>=0.03 && panstwo.isKontrolaNaGranicach()
                                && panstwo.isUlepszonaGospodarka() && panstwo.isWprowadzonaKwarantanna()) {

                            transportBtn.setText("WYŁĄCZ");

                            transportBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    panstwo.setWylaczonaDrogaPociagowa(true);
                                    stan.setText("<html><h2>STAN: <font color='red'>WYŁĄCZONY</font></h2></html>");
                                    transportBtn.setEnabled(false);
                                    transportBtn.setText("WYŁĄCZONY");
                                }
                            });
                        } else {
                            transportBtn.setText("BRAK WYMAGAŃ");
                            transportBtn.setEnabled(false);
                        }
                    }
                    break;

                case "ship":
                    if (!panstwo.czyPosiadaPort()){
                        stan.setText("<html><h2>STAN: <font color='red'>NIEDOSTĘPNY</font></h2></html>");
                        transportBtn.setEnabled(false);
                        transportBtn.setText("NIEDOSTĘPNY");
                    } else if (panstwo.czyWylaczonaDrogaWodna()){
                        stan.setText("<html><h2>STAN: <font color='red'>WYŁĄCZONY</font></h2></html>");
                        transportBtn.setEnabled(false);
                        transportBtn.setText("WYŁĄCZONY");
                    } else {
                        stan.setText("<html><h2>STAN: <font color='green'>WŁĄCZONA</font></h2></html>");

                        if ((panstwo.getLudnoscZakazona()/panstwo.getLudnosc())>=0.04 && panstwo.isKontrolaNaGranicach()
                                && panstwo.isUlepszonaGospodarka() && panstwo.isWprowadzonaKwarantanna() &&
                                (panstwo.getLudnoscNaKwarantannie()/panstwo.getLudnosc())>=0.01 && panstwo.isKontrolaWPortach()) {

                            transportBtn.setText("WYŁĄCZ");
                            transportBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    panstwo.setWylaczonaDrogaWodna(true);
                                    stan.setText("<html><h2>STAN: <font color='red'>WYŁĄCZONY</font></h2></html>");
                                    transportBtn.setEnabled(false);
                                    transportBtn.setText("WYŁĄCZONY");
                                }
                            });
                        } else {
                            transportBtn.setText("BRAK WYMAGAŃ");
                            transportBtn.setEnabled(false);
                        }
                    }
                    break;

                case "plane":
                    if (!panstwo.czyPosiadaLotnisko()){
                        stan.setText("<html><h2>STAN: <font color='red'>NIEDOSTĘPNY</font></h2></html>");
                        transportBtn.setEnabled(false);
                        transportBtn.setText("NIEDOSTĘPNY");
                    } else if (panstwo.czyWylaczonaDrogaPowietrzna()){
                        stan.setText("<html><h2>STAN: <font color='red'>WYŁĄCZONY</font></h2></html>");
                        transportBtn.setEnabled(false);
                        transportBtn.setText("WYŁĄCZONY");
                    } else {
                        stan.setText("<html><h2>STAN: <font color='green'>WŁĄCZONA</font></h2></html>");

                        if ((panstwo.getLudnoscZakazona()/panstwo.getLudnosc())>=0.05 && panstwo.isKontrolaNaGranicach()
                                && panstwo.isUlepszonaGospodarka() && panstwo.isWprowadzonaKwarantanna() &&
                                (panstwo.getLudnoscNaKwarantannie()/panstwo.getLudnosc())>=0.02 && panstwo.isKontrolaWPortach()
                                && panstwo.isKwarantannaTotalna() && panstwo.isKontrolaNaLotniskach()) {

                            transportBtn.setText("WYŁĄCZ");
                            transportBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    panstwo.setWylaczonaDrogaPowietrzna(true);
                                    stan.setText("<html><h2>STAN: <font color='red'>WYŁĄCZONY</font></h2></html>");
                                    transportBtn.setEnabled(false);
                                    transportBtn.setText("WYŁĄCZONY");
                                }
                            });
                        } else {
                            transportBtn.setText("BRAK WYMAGAŃ");
                            transportBtn.setEnabled(false);
                        }
                    }
                    break;
            }
            transportPanstwa.add(stan);
            transportPanstwa.add(transportBtn);
        }


        informacjePanstwaLayout.setVerticalGroup(
                informacjePanstwaLayout.createSequentialGroup()
                        .addComponent(nazwaPanstwa)
                        .addComponent(danePanstwa)
        );

        informacjePanstwaLayout.setHorizontalGroup(
                informacjePanstwaLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(nazwaPanstwa)
                        .addComponent(danePanstwa)
        );
        addTab("INFORMACJE", informacjePanstwa);
        addTab("ULEPSZENIA", ulepszeniaPanstwa);
        addTab("TRANSPORT", transportPanstwa);
        informacjePanstwa.setLayout(informacjePanstwaLayout);
        transportPanstwa.setLayout(transportPanstwaLayout);

    }
}
