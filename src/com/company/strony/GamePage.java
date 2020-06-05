package com.company.strony;

import com.company.*;
import com.company.custom_components.CustomButton;
import com.company.custom_components.CustomDialog;
import com.company.custom_components.CustomLabel;
import com.company.mechanika.*;
import com.company.modele.Panstwo;
import com.company.wspolczynniki_mechaniki.Difficulty;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.List;

public class GamePage extends JFrame {
    private ImageIcon myImage;
    private JScrollPane gamePage;
    private JLabel label;
    private boolean zatrzymane, wznowione;
    private ListaPanstw listaPanstw;
    private Thread uplywCzasu, panstwaZakazenia, panstwaZdrowienie, kwarantannaZdrowienie,
            zarazanieSamochodowo, zarazanieAutobusowo, zarazaniePociagowo,
            zarazanieMorskie, zarazanieSamolotowo, czyKoniecGry;
    private DecimalFormat df;
    private int deviceWidth, deviceHeight;



    GamePage(Difficulty difficulty){
        StatystykiGry.ludnoscZarazona=1;
        StatystykiGry.ludnoscWyleczona=0;
        StatystykiGry.punkty=0;

        this.zatrzymane=false;
        this.wznowione=true;

        this.deviceHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.deviceWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        this.df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340);

        this.listaPanstw = new ListaPanstw();

        Image img=null;
        try {
            img = ImageIO.read(new File("img/mapa.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        myImage = new ImageIcon(img);
        label = new JLabel(myImage);

        CustomButton backToMenu = new CustomButton(Color.white, "img/home.png");

        backToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                uplywCzasu.interrupt();
                panstwaZakazenia.interrupt();
                panstwaZdrowienie.interrupt();
                kwarantannaZdrowienie.interrupt();
                zarazanieSamochodowo.interrupt();
                zarazanieAutobusowo.interrupt();
                zarazaniePociagowo.interrupt();
                zarazanieMorskie.interrupt();
                zarazanieSamolotowo.interrupt();

                StatystykiGry.ludnoscZarazona=1;
                StatystykiGry.ludnoscWyleczona=0;
                StatystykiGry.punkty=0;
                StatystykiGry.czas=0;

                StartPage startPage = new StartPage();
                setVisible(false);
                dispose();
            }
        });
        backToMenu.setMnemonic(KeyEvent.VK_Q);

        CustomButton stop = new CustomButton(Color.WHITE, "img/pause.png");
        CustomButton play = new CustomButton(Color.WHITE, "img/play.png");

        play.setEnabled(false);

        CustomLabel liczbaZarazonych = new CustomLabel("<html><div style='text-align: center;'><h1>LICZBA ZARAŻONYCH</h1></br><h1>0</h1></div></html>", Color.red, Color.WHITE);
        CustomLabel liczbaPunktow = new CustomLabel("<html><div style='text-align: center;'><h1>LICZBA PUNKTÓW</h1></br><h1>0</h1></div></html>", Color.DARK_GRAY, Color.WHITE);
        CustomLabel liczbaWyzdrowiałych = new CustomLabel("<html><div style='text-align: center;'><h1>LICZBA WYZDROWIAŁYCH</h1></br><h1>0</h1></div></html>", Color.GREEN, Color.WHITE);
        CustomLabel licznikCzasu = new CustomLabel("<html><div style='text-align: center;'><h1>CZAS</h1></br><h1>00:00</h1></div></html>", Color.DARK_GRAY, Color.WHITE);

        JPanel gameControler = new JPanel();
        gameControler.setLayout(new FlowLayout(FlowLayout.CENTER));
        gameControler.add(backToMenu);
        gameControler.add(stop);
        gameControler.add(play);
        gameControler.add(liczbaZarazonych);
        gameControler.add(liczbaPunktow);
        gameControler.add(liczbaWyzdrowiałych);
        gameControler.add(licznikCzasu);
        gameControler.setBackground(new Color(19, 236, 236));
        add(gameControler, BorderLayout.PAGE_END);

        this.uplywCzasu = new Thread(new UplywCzasu(licznikCzasu));

        this.panstwaZakazenia = new Thread(new PanstwaZakazenia(listaPanstw.getPanstwa(), liczbaZarazonych, liczbaWyzdrowiałych, difficulty));

        this.panstwaZdrowienie = new Thread(new PanstwaZdrowienia(listaPanstw.getPanstwa(), liczbaZarazonych, liczbaPunktow, liczbaWyzdrowiałych, difficulty));

        this.kwarantannaZdrowienie = new Thread(new KwarantannaZdrowienie(listaPanstw.getPanstwa(), liczbaWyzdrowiałych, difficulty));

        this.zarazanieSamochodowo = new Thread(new ZarazanieSamochodowo(listaPanstw.getPanstwa(), difficulty));

        this.zarazanieAutobusowo = new Thread(new ZarazanieAutobusowo(listaPanstw.getPanstwa(), difficulty));

        this.zarazaniePociagowo = new Thread(new ZarazaniePociagowo(listaPanstw.getPanstwa(), difficulty));

        this.zarazanieMorskie = new Thread(new ZarazanieMorskie(listaPanstw.getPanstwa(), difficulty));

        this.zarazanieSamolotowo = new Thread(new ZarazanieSamolotowo(listaPanstw.getPanstwa(), difficulty));

        List<Thread> watkiDoZastopowania = new LinkedList<>();
        watkiDoZastopowania.add(uplywCzasu);
        watkiDoZastopowania.add(panstwaZakazenia);
        watkiDoZastopowania.add(panstwaZdrowienie);
        watkiDoZastopowania.add(kwarantannaZdrowienie);
        watkiDoZastopowania.add(zarazanieSamochodowo);
        watkiDoZastopowania.add(zarazanieAutobusowo);
        watkiDoZastopowania.add(zarazaniePociagowo);
        watkiDoZastopowania.add(zarazanieMorskie);
        watkiDoZastopowania.add(zarazanieSamolotowo);

        this.czyKoniecGry = new Thread(new CzyKoniecGry(listaPanstw.getPanstwa(), watkiDoZastopowania, this, difficulty));

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(wznowione);
                if (wznowione){
                    stop.setEnabled(false);
                    play.setEnabled(true);
                    wznowione=false;
                    zatrzymane=true;

                    uplywCzasu.interrupt();
                    panstwaZakazenia.interrupt();
                    panstwaZdrowienie.interrupt();
                    kwarantannaZdrowienie.interrupt();
                    zarazanieSamochodowo.interrupt();
                    zarazanieAutobusowo.interrupt();
                    zarazaniePociagowo.interrupt();
                    zarazanieMorskie.interrupt();
                    zarazanieSamolotowo.interrupt();
                } else {
                    stop.setEnabled(false);
                    play.setEnabled(true);
                }
            }
        });

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (zatrzymane) {
                    wznowione=true;
                    zatrzymane=false;
                    play.setEnabled(false);
                    stop.setEnabled(true);

                    uplywCzasu = new Thread(new UplywCzasu(licznikCzasu));
                    panstwaZakazenia = new Thread(new PanstwaZakazenia(listaPanstw.getPanstwa(), liczbaZarazonych, liczbaWyzdrowiałych, difficulty));
                    panstwaZdrowienie = new Thread(new PanstwaZdrowienia(listaPanstw.getPanstwa(), liczbaZarazonych, liczbaPunktow, liczbaWyzdrowiałych, difficulty));
                    kwarantannaZdrowienie = new Thread(new KwarantannaZdrowienie(listaPanstw.getPanstwa(), liczbaWyzdrowiałych, difficulty));
                    zarazanieSamochodowo = new Thread(new ZarazanieSamochodowo(listaPanstw.getPanstwa(), difficulty));
                    zarazanieAutobusowo = new Thread(new ZarazanieAutobusowo(listaPanstw.getPanstwa(), difficulty));
                    zarazaniePociagowo = new Thread(new ZarazaniePociagowo(listaPanstw.getPanstwa(), difficulty));
                    zarazanieMorskie = new Thread(new ZarazanieMorskie(listaPanstw.getPanstwa(), difficulty));
                    zarazanieSamolotowo = new Thread(new ZarazanieSamolotowo(listaPanstw.getPanstwa(), difficulty));

                    uplywCzasu.start();
                    panstwaZakazenia.start();
                    panstwaZdrowienie.start();
                    kwarantannaZdrowienie.start();
                    zarazanieSamochodowo.start();
                    zarazanieAutobusowo.start();
                    zarazaniePociagowo.start();
                    zarazanieMorskie.start();
                    zarazanieSamolotowo.start();
                } else {
                    play.setEnabled(false);
                    stop.setEnabled(true);
                }
            }
        });

        Map<String, String[]> ulepszeniaAtrybuty = new HashMap<>();

        ulepszeniaAtrybuty.put("ulepszonaSluzbaZdrowia", new String[]{
                "img/sluzba_zdrowia.png",
                "Dofinansowanie służby zdrowia",
                "Zwiększa stan służby zdrowia o jednen stan w górę",
                "20000"
        });

        ulepszeniaAtrybuty.put("ulepszonaGospodarka", new String[]{
                "img/gospodarka.png",
                "Tarcza antykryzysowa",
                "Zwiększa stan gospodarki o jednen stan w górę",
                "10000"
        });

        ulepszeniaAtrybuty.put("wprowadzenieKwarantanny", new String[]{
                "img/kwarantanna.png",
                "Czas kwarantanny",
                "Zarażeni są przenoszeni do kwarantanny, gdzie zdrowieją szybciej",
                "40000"
        });

        ulepszeniaAtrybuty.put("ulepszonaKwarantanna", new String[]{
                "img/kwarantannaUp.png",
                "Kwarantanna++",
                "Zwiększa skuteczność kwarantanny i zdrowienie pacjentów",
                "40000"
        });

        ulepszeniaAtrybuty.put("kontrolaNaGranicach", new String[]{
                "img/granicaKontrola.png",
                "Dokumenciki poproszę!",
                "Wprowadza kontrolę na granicach, spowalnia migrację ludzi drogą lądową",
                "60000"
        });

        ulepszeniaAtrybuty.put("kontrolaWPortach", new String[]{
                "img/portKontrola.png",
                "Co ma pan na tej łajbie?",
                "Wprowadza kontrolę w portach, spowalnia migrację ludzi drogą morską",
                "60000"
        });

        ulepszeniaAtrybuty.put("kontrolaNaLotniskach", new String[]{
                "img/kontrolaLotnisko.png",
                "Dalej pan nie poleci!",
                "Wprowadza kontrolę na lotniskach, spowalnia migrację ludzi drogą powietrzną",
                "60000"
        });

        ulepszeniaAtrybuty.put("kwarantannaTotalna", new String[]{
                "img/kwarantannaTotalna.png",
                "Koronaferie",
                "Wszyscy obecni jak i nowi zarażeni są automatycznie przenoszeni do kwarantanny",
                "80000"
        });

        ulepszeniaAtrybuty.put("pomocSasiadowi", new String[]{
                "img/pomocSasiadowi.png",
                "Nie ma to jak sąsiad",
                "Wybierany jest losowy sąsiad państwa, zabieranych jest od niego połowa zarażonych i ulepszona służba zdrowia",
                "100000"
        });

        Map<String, String[]> transportAtrybuty = new HashMap<>();

        transportAtrybuty.put("car", new String[]{
                "img/car.png",
                "Samochodowy",
                "<html>- 1% zarażonych w państwie<br>- wykupione \"Dokumenciki poproszę!\"</html>"
        });

        transportAtrybuty.put("bus", new String[]{
                "img/bus.png",
                "Autobusowy",
                "<html>- 2% zarażonych w państwie<br>- wykupione \"Dokumenciki poproszę!\"<br>- wykupione \"Tarcza antykryzysowa\"</html>"
        });

        transportAtrybuty.put("train", new String[]{
                "img/train.png",
                "Pociągowy",
                "<html>- 3% zarażonych w państwie<br>- wykupione \"Dokumenciki poproszę!\"<br>- wykupione \"Tarcza antykryzysowa\"<br>- wykupione  \"Czas kwarantanny\"</html>"
        });

        transportAtrybuty.put("ship", new String[]{
                "img/ship.png",
                "Morski",
                "<html>- 4% zarażonych w państwie<br> - 1% ludności na kwarantannie<br>- wykupione \"Dokumenciki poproszę!\"<br>- wykupione \"Tarcza antykryzysowa\"<br>- wykupione  \"Czas kwarantanny\"<br>- wykupione \"Co ma pan na tej łajbie?\"</html>"
        });

        transportAtrybuty.put("plane", new String[]{
                "img/plane.png",
                "Samolotowy",
                "<html>- 5% zarażonych w państwie<br> - 2% ludności na kwarantannie<br>- wykupione \"Dokumenciki poproszę!\"<br>- wykupione \"Tarcza antykryzysowa\"<br>- wykupione  \"Czas kwarantanny\"<br>- wykupione \"Co ma pan na tej łajbie?\"" +
                        "<br>- wykupione \"Koronaferie\"<br>- wykupione \"Dalej pan nie poleci!\"</html>"
        });

        for (Panstwo panstwo: listaPanstw.getPanstwa()){
            JButton bPanstwo = new JButton();


            bPanstwo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CustomDialog ekranPanstwa = new CustomDialog(ulepszeniaAtrybuty, transportAtrybuty, panstwo, listaPanstw.getPanstwa());

                    JOptionPane.showOptionDialog(null, ekranPanstwa, panstwo.getNazwaPanstwa(), JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null, new Object[] {},
                            null);
                }
            });
            label.add(bPanstwo);
            bPanstwo.setLocation(panstwo.getWspolrzednaX()-5, panstwo.getWspolrzednaY()-2);
            bPanstwo.setToolTipText(panstwo.getNazwaPanstwa());
            bPanstwo.setBackground(new Color(
                    (int)(Math.random()*255),
                    (int)(Math.random()*255),
                    (int)(Math.random()*255)
            ));
            bPanstwo.setSize(20, 20);
        }

        label.setLayout(new BorderLayout());
        gamePage = new JScrollPane(label);
        gamePage.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        gamePage.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        gamePage.setCursor(new Cursor(Cursor.HAND_CURSOR));



        MouseAdapter md = new MouseAdapter() {
            Point origin;

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                origin = new Point(e.getPoint());
                gamePage.setCursor(new Cursor(Cursor.MOVE_CURSOR));
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                gamePage.setCursor(new Cursor(Cursor.MOVE_CURSOR));
                if (origin != null) {
                    JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, label);
                    if (viewPort != null) {
                        int deltaX = origin.x - e.getX();
                        int deltaY = origin.y - e.getY();

                        Rectangle view = viewPort.getViewRect();
                        view.x += deltaX;
                        view.y += deltaY;

                        label.scrollRectToVisible(view);
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                gamePage.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        };

        label.addMouseListener(md);
        label.addMouseMotionListener(md);

        add(gamePage);
        setSize(deviceWidth, deviceHeight);


        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);

        uplywCzasu.start();
        panstwaZakazenia.start();
        panstwaZdrowienie.start();
        kwarantannaZdrowienie.start();
        zarazanieSamochodowo.start();
        zarazanieAutobusowo.start();
        zarazaniePociagowo.start();
        zarazanieMorskie.start();
        zarazanieSamolotowo.start();
        czyKoniecGry.start();

    }
}
