package com.company.strony;

import com.company.custom_components.CustomButton;
import com.company.custom_components.CustomRadioButton;
import com.company.wspolczynniki_mechaniki.Difficulty;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

public class DifficultyPage extends JFrame {

    DifficultyPage(){
        JPanel difficultyPage = new JPanel();
        difficultyPage.setBackground(new Color(19, 236, 236));
        getContentPane().setBackground(new Color(19, 236, 236));

        List<String> trudnosciObjasnienia = new LinkedList<>();

        trudnosciObjasnienia.add(
                "Gospodarka, służba zdrowia oraz sytuacja w państwach jest stabilna, " +
                        "szpitale gotowe na walkę z wirusem a nastroje wśród społeczności świata optymalne."
        );

        trudnosciObjasnienia.add(
                "Niepokoje wśród społeczności rosną, rządy oraz służby zdrowia państw są zaskoczone wybuchem pandemii, " +
                        "wirus jest bardziej agresywny, a globalna gospodarka zaczyna powoli wchodzić w kryzys."
        );

        trudnosciObjasnienia.add(
                "Globalna panika, służby zdrowia w państwach mają poważne kłopoty w zwalczaniu wirusa, " +
                        "który jest silnie odporny i rozwija się w bardzo szybkim tempie, wielki krach" +
                        " na giełdzie oraz kryzysy ekonomiczne na całym świecie."
        );

        JLabel infoLabel = new JLabel("WYBIERZ POZIOM TRUDNOSCI");
        Font titleFont = new Font("Century Gothic", Font.PLAIN, 70);
        Font wyjasnienieFont = new Font("Century Gothic", Font.PLAIN, 25);
        Font buttonsFont = new Font("Century Gothic", Font.BOLD, 40);

        infoLabel.setFont(titleFont);
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        CustomRadioButton bEasy = new CustomRadioButton("EASY");
        CustomRadioButton bMedium = new CustomRadioButton("MEDIUM");
        CustomRadioButton bHard = new CustomRadioButton("HARD");
        CustomButton graj = new CustomButton("GRAJ!");
        CustomButton powrot = new CustomButton("POWRÓT");

        ButtonGroup difficulties = new ButtonGroup();
        difficulties.add(bEasy);
        difficulties.add(bMedium);
        difficulties.add(bHard);


        JLabel opisTrudnosci = new JLabel("<html>"+trudnosciObjasnienia.get(0)+"</html>");
        opisTrudnosci.setFont(wyjasnienieFont);
        opisTrudnosci.setMaximumSize(new Dimension(500, 200));
        opisTrudnosci.setBackground(Color.DARK_GRAY);
        opisTrudnosci.setOpaque(true);
        opisTrudnosci.setForeground(Color.WHITE);
        opisTrudnosci.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        bEasy.setSelected(true);
        GroupLayout groupLayout = new GroupLayout(difficultyPage);
        getContentPane().setLayout(new GridBagLayout());
        difficultyPage.setLayout(groupLayout);

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                .addComponent(bEasy)
                .addGroup(
                        groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(infoLabel)
                                .addGap(50)
                        .addComponent(bMedium)
                                .addGap(30)
                        .addComponent(opisTrudnosci)
                                .addGap(30)
                        .addComponent(graj)
                                .addGap(30)
                        .addComponent(powrot)
                )
                .addComponent(bHard)
        );

        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                .addComponent(infoLabel)
                        .addGap(50)
                .addGroup(
                        groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(bEasy)
                        .addComponent(bMedium)
                        .addComponent(bHard)
                )
                        .addGap(30)
                .addComponent(opisTrudnosci)
                        .addGap(30)
                        .addComponent(graj)
                        .addGap(30)
                        .addComponent(powrot)
        );

        bEasy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opisTrudnosci.setText("<html>"+trudnosciObjasnienia.get(0)+"</html>");
            }
        });

        bMedium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opisTrudnosci.setText("<html>"+trudnosciObjasnienia.get(1)+"</html>");
            }
        });

        bHard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opisTrudnosci.setText("<html>"+trudnosciObjasnienia.get(2)+"</html>");
            }
        });

        graj.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Difficulty difficulty = bEasy.isSelected() ? Difficulty.EASY : (bMedium.isSelected() ? Difficulty.MEDIUM : Difficulty.HARD);

                GamePage gamePage = new GamePage(difficulty);
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
                graj.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
                graj.setBackground(Color.lightGray);
                graj.setForeground(Color.WHITE);
                difficultyPage.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                graj.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                graj.setBackground(Color.WHITE);
                graj.setForeground(new Color(19, 236, 236));
                difficultyPage.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

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
                difficultyPage.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                powrot.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                powrot.setBackground(Color.WHITE);
                powrot.setForeground(new Color(19, 236, 236));
                difficultyPage.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        add(difficultyPage);

        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }

}
