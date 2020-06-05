package com.company.custom_components;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class CustomRadioButton extends JRadioButton {
    private String text;
    private Font buttonsFont;

    public CustomRadioButton(String text){
        this.buttonsFont = new Font("Century Gothic", Font.BOLD, 40);
        this.text = text;

        setFont(buttonsFont);
        setForeground(new Color(19, 236, 236));
        setBackground(Color.WHITE);
        setFocusPainted(false);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        setText(text);
    }
}
