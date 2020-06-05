package com.company.modele;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;

public class RankingModel extends AbstractListModel {

    private ArrayList<WynikGry> wynikiGier;
    private FileInputStream fileIn = null;
    private ObjectInputStream objectIn = null;
    final private String FILENAME = "ranking.ser";

    public RankingModel(){
        try {
            fileIn = new FileInputStream(FILENAME);
            objectIn = new ObjectInputStream(fileIn);

            wynikiGier = (ArrayList<WynikGry>) objectIn.readObject();
            Collections.sort(wynikiGier);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSize() {
        return wynikiGier.size();
    }

    @Override
    public Object getElementAt(int index) {
        return wynikiGier.get(index);
    }
}
