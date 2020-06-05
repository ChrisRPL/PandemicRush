package com.company.mechanika;

import com.company.*;
import com.company.modele.Panstwo;
import com.company.modele.WynikGry;
import com.company.strony.StartPage;
import com.company.wspolczynniki_mechaniki.Difficulty;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CzyKoniecGry implements Runnable {

    private List<Panstwo> panstwa;
    private List<Thread> watkiDoZastopowania;
    private JFrame oknoAplikacji;
    private Difficulty difficulty;
    private final String FILENAME = "ranking.ser";
    private DecimalFormat df;

    public CzyKoniecGry(List<Panstwo> panstwa, List<Thread> watkiDoZastopowania, JFrame oknoAplikacji, Difficulty difficulty){
        this.panstwa = panstwa;
        this.watkiDoZastopowania = watkiDoZastopowania;
        this.oknoAplikacji = oknoAplikacji;
        this.difficulty = difficulty;

        df = new DecimalFormat("#");
    }

    @Override
    public void run() {

        boolean wszysycyZakazeni=false, wszyscyUleczeni=true;
        double ludnosc = 0;

        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);

                for (int i=0; i<panstwa.size(); i++){
                    ludnosc+=panstwa.get(i).getLudnosc();
                    if (panstwa.get(i).getLudnoscZakazona()>=1)
                        wszyscyUleczeni=false;
                }

                if (StatystykiGry.ludnoscZarazona>=ludnosc)
                    wszysycyZakazeni=true;

                JPanel komunikat = new JPanel();
                Font labelFont = new Font("Century Gothic", Font.BOLD, 30);
                String[] opjca = {"ZAKOŃCZ GRĘ"};
                GridLayout gridLayout = new GridLayout(4, 1);
                komunikat.setLayout(gridLayout);

                JLabel wynik = new JLabel();
                wynik.setFont(labelFont);
                wynik.setForeground(wszysycyZakazeni ? Color.red : Color.green);
                wynik.setBackground(Color.WHITE);
                wynik.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

                JLabel prosbaNick = new JLabel("PODAJ SWÓJ NICK:");
                prosbaNick.setFont(labelFont);
                prosbaNick.setForeground(new Color(19, 236, 236));
                prosbaNick.setBackground(Color.WHITE);
                prosbaNick.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

                JTextField poleNick = new JTextField();
                poleNick.setFont(labelFont);
                komunikat.add(wynik);
                komunikat.add(prosbaNick);
                komunikat.add(poleNick);

                if (wszyscyUleczeni) {

                    for (int i=0; i<watkiDoZastopowania.size(); i++) {
                        watkiDoZastopowania.get(i).interrupt();
                    }

                    wynik.setText("WYGRAŁEŚ! UDAŁO SIĘ OSTATECZNIE WYTĘPIĆ WIRUSA!");
                    zakonczRozgrywke(komunikat, opjca, poleNick);
                }

                if (wszysycyZakazeni) {

                    for (int i=0; i<watkiDoZastopowania.size(); i++)
                        watkiDoZastopowania.get(i).interrupt();

                    wynik.setText("PRZEGRAŁEŚ! POPULACJA ZIEMI ZOSTAŁA CAŁKOWICIE ZARAŻONA!");
                    zakonczRozgrywke(komunikat, opjca, poleNick);
                }
                wszysycyZakazeni=false;
                wszyscyUleczeni=true;
                ludnosc=0;

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void zakonczRozgrywke(JPanel komunikat, String[] opjca, JTextField poleNick) {
        int opcjaWybrana = JOptionPane.showOptionDialog(oknoAplikacji, komunikat, "KONIEC GRY", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, opjca, opjca[0]);
        if (opcjaWybrana==JOptionPane.YES_OPTION) {
            WynikGry wynikGry = new WynikGry(poleNick.getText(), df.format(StatystykiGry.ludnoscZarazona), df.format(StatystykiGry.ludnoscWyleczona), StatystykiGry.czas, difficulty);

            StatystykiGry.ludnoscZarazona=1;
            StatystykiGry.ludnoscWyleczona=0;
            StatystykiGry.punkty=0;
            StatystykiGry.czas=0;

            FileOutputStream fileOut = null;
            ObjectOutputStream objectOut = null;

            FileInputStream fileIn = null;
            ObjectInputStream objectIn = null;
            File f = new File(FILENAME);
            ArrayList<WynikGry> wynikiGier = new ArrayList<>();
            try {
                if (f.exists()) {
                    fileIn = new FileInputStream(FILENAME);
                    objectIn = new ObjectInputStream(fileIn);

                    wynikiGier = (ArrayList<WynikGry>) objectIn.readObject();
                    wynikiGier.add(wynikGry);


                    fileIn.close();
                    objectIn.close();

                    fileOut = new FileOutputStream(FILENAME);
                    objectOut = new ObjectOutputStream(fileOut);
                    objectOut.writeObject(wynikiGier);

                    objectOut.close();
                    fileOut.close();
                }else {
                    fileOut = new FileOutputStream(FILENAME);
                    objectOut = new ObjectOutputStream(fileOut);
                    wynikiGier.add(wynikGry);
                    objectOut.writeObject(wynikiGier);

                    objectOut.close();
                    fileOut.close();
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            StartPage startPage = new StartPage();
            oknoAplikacji.setVisible(false);
            oknoAplikacji.dispose();
            Thread.currentThread().interrupt();
        }
    }
}
