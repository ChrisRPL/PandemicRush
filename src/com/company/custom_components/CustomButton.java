package com.company.custom_components;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class CustomButton extends JButton {

    private Font buttonsFont;

    public CustomButton(String text){
        this.buttonsFont = new Font("Century Gothic", Font.BOLD, 40);

        setFont(buttonsFont);
        setForeground(new Color(19, 236, 236));
        setBackground(Color.WHITE);
        setFocusPainted(false);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        setMinimumSize(new Dimension(270, 70));
        setText(text);
    }

    public CustomButton(Color background, String filePath){
        setBackground(background);
        setFocusPainted(false);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        setIcon(new ImageIcon(filePath));
    }
}
