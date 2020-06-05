package com.company.custom_components;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class CustomLabel extends JLabel {
    private Font labelsFont;
    private Color foreground, background;
    private String text;
    private Dimension dimension;

    public CustomLabel(String text, Color foreground, Color background){
        this.labelsFont = new Font("Century Gothic", Font.BOLD, 40);
        this.text = text;
        this.foreground = foreground;
        this.background = background;

        setBackground(background);
        setOpaque(true);
        setForeground(foreground);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        setFont(labelsFont);
        setText(text);
    }

    public CustomLabel(String text, Color foreground, Color background, Font labelsFont){
        this(text, foreground, background);
        this.labelsFont = labelsFont;
        setFont(labelsFont);
    }

    public CustomLabel(String text, Color foreground, Color background, Font labelsFont, Dimension dimension){
        this(text, foreground, background, labelsFont);
        this.dimension = dimension;
        setPreferredSize(dimension);
    }
}
