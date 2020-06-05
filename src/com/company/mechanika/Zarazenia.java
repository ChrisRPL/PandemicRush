package com.company.mechanika;

import com.company.modele.Panstwo;
import com.company.wspolczynniki_mechaniki.Difficulty;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

public class Zarazenia {
    protected List<Panstwo> panstwa;
    protected Difficulty difficulty;
    protected DecimalFormat df;

    public Zarazenia(List<Panstwo> panstwa, Difficulty difficulty){
        this.panstwa = panstwa;
        this.difficulty = difficulty;

        df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340);
    }

    protected Panstwo wylosujPanstwo(Panstwo panstwo){
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

        return wylosowanePanstwo;
    }
}
