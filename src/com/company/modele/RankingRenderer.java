package com.company.modele;

import javax.swing.*;
import java.awt.*;

public class RankingRenderer extends JLabel implements ListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        WynikGry wynikGry = (WynikGry)value;
        int czas = wynikGry.getCzas();

        String czasMinuty = "", czasSekundy;

        if (czas / 60 < 10)
            czasMinuty = "0" + czas / 60;
        else
            czasMinuty = czas / 60 + "";

        if (czas % 60 < 10)
            czasSekundy = "0" + czas % 60;
        else
            czasSekundy = czas % 60 + "";

        setOpaque(true);
        setText("<html><h1>POZYCJA: " + (index+1)+"</h1><br>GRACZ: " + wynikGry.getNazwaGracza() + "<br>WYZDROWIAŁYCH: " + wynikGry.getLudnoscUleczona() + "<br>ZAKAŻONYCH: " + wynikGry.getLudnoscZakazona()
        + "<br>POZIOM: " + wynikGry.getPoziomTrudnosci().getNazwaTrudnosci()+"<br>CZAS: "+czasMinuty+":"+czasSekundy+"</html>");
        setFont(new Font("Century Gothic", Font.PLAIN, 20));

        return this;
    }
}
