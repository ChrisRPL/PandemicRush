package com.company.strony;


import com.company.custom_components.CustomButton;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartPage extends JFrame {

    private int deviceWidth, deviceHeight;

    public StartPage(){

        deviceHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        deviceWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        JPanel startPage = new JPanel();
        Font titleFont = new Font("Century Gothic", Font.PLAIN, 80);

        ImageIcon i = new ImageIcon("img/red_cross.png");
        JLabel appTitle = new JLabel("PANDEMIC RUSH", i, SwingConstants.HORIZONTAL);


        appTitle.setFont(titleFont);
        appTitle.setForeground(Color.WHITE);
        appTitle.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        CustomButton bStart = new CustomButton("START");
        CustomButton bHighScores = new CustomButton("HIGH SCORES");
        CustomButton bExit = new CustomButton("EXIT");



        bExit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bExit.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
                bExit.setBackground(Color.lightGray);
                bExit.setForeground(Color.WHITE);
                startPage.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bExit.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                bExit.setBackground(Color.WHITE);
                bExit.setForeground(new Color(19, 236, 236));
                startPage.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        bHighScores.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HighScoresPage highScoresPage = new HighScoresPage();
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
                bHighScores.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
                bHighScores.setBackground(Color.lightGray);
                bHighScores.setForeground(Color.WHITE);
                startPage.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bHighScores.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                bHighScores.setBackground(Color.WHITE);
                bHighScores.setForeground(new Color(19, 236, 236));
                startPage.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        bStart.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DifficultyPage dPage = new DifficultyPage();
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
                bStart.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
                bStart.setBackground(Color.lightGray);
                bStart.setForeground(Color.WHITE);
                startPage.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                bStart.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                bStart.setBackground(Color.WHITE);
                bStart.setForeground(new Color(19, 236, 236));
                startPage.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        GroupLayout groupLayout = new GroupLayout(startPage);
        getContentPane().setLayout(new GridBagLayout());
        startPage.setLayout(groupLayout);


        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(appTitle)
                        .addGap(100)
                        .addComponent(bStart)
                        .addGap(50)
                        .addComponent(bHighScores)
                        .addGap(50)
                        .addComponent(bExit)
        );

        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addComponent(appTitle)
                        .addGap(100)
                        .addComponent(bStart)
                        .addGap(50)
                        .addComponent(bHighScores)
                        .addGap(50)
                        .addComponent(bExit)
        );

        add(startPage);

        setResizable(false);
        getContentPane().setBackground(new Color(19, 236, 236));
        startPage.setBackground(new Color(19, 236, 236));
        setSize(deviceWidth, deviceHeight);


        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }
}
