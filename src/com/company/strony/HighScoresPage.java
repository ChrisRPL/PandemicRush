package com.company.strony;

import com.company.custom_components.CustomButton;
import com.company.modele.RankingModel;
import com.company.modele.RankingRenderer;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class HighScoresPage extends JFrame {
    private final String FILENAME = "ranking.ser";

    HighScoresPage(){
        JPanel highScores = new JPanel();

        ImageIcon i = new ImageIcon("img/puchar.png");
        JLabel appTitle = new JLabel( "HALL OF FAME", i, SwingConstants.HORIZONTAL);
        Font titleFont = new Font("Century Gothic", Font.PLAIN, 80);

        highScores.setBackground(new Color(19, 236, 236));
        getContentPane().setBackground(new Color(19, 236, 236));

        appTitle.setFont(titleFont);
        appTitle.setForeground(Color.WHITE);
        appTitle.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        JList listaRankingowa = new JList();

        File f = new File(FILENAME);

        if (f.exists()) {
            RankingModel rankingModel = new RankingModel();
            listaRankingowa.setModel(rankingModel);
            listaRankingowa.setCellRenderer(new RankingRenderer());
        }
        JScrollPane jScrollPane = new JScrollPane(listaRankingowa);
        jScrollPane.setPreferredSize(new Dimension(300, 700));

        CustomButton powrot = new CustomButton("POWRÓT");

        GroupLayout groupLayout = new GroupLayout(highScores);
        highScores.setLayout(groupLayout);

        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(appTitle)
                        .addGap(50)
                        .addComponent(jScrollPane)
                        .addGap(50)
                        .addComponent(powrot)
        );

        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addComponent(appTitle)
                        .addGap(50)
                        .addComponent(jScrollPane)
                        .addGap(50)
                        .addComponent(powrot)
        );

        getContentPane().setLayout(new GridBagLayout());

        add(highScores);

        powrot.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StartPage startPage = new StartPage();
                setVisible(false);
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                powrot.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
                powrot.setBackground(Color.lightGray);
                powrot.setForeground(Color.WHITE);
                highScores.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                powrot.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                powrot.setBackground(Color.WHITE);
                powrot.setForeground(new Color(19, 236, 236));
                highScores.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }
}
