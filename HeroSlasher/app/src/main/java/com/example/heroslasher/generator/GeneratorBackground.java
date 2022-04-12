package com.example.heroslasher.generator;

import android.graphics.Color;

import com.example.gear2d.GraphicsFW;
import com.example.gear2d.utilites.UtilRandomFW;
import com.example.heroslasher.objects.Star;

import java.util.ArrayList;

public class GeneratorBackground {
    public ArrayList<Star> starArrayList = new ArrayList<Star>();

    public GeneratorBackground(int sceneWidth, int sceneHeight) {
        int starSpeak = UtilRandomFW.getCasualNumber(117);
        for (int i = 0; i < starSpeak; i++) {
            Star star = new Star(sceneWidth, sceneHeight);
            starArrayList.add(star);
        }
    }
    public void update(double speed) {
        for (int i = 0; i < starArrayList.size(); i++) {
            starArrayList.get(i).update(speed);
        }
    }

    public void drawing(GraphicsFW graphicsFW) {
        for (int i = 0; i < starArrayList.size(); i++) {
            graphicsFW.drawPixel(starArrayList.get(i).getX(),starArrayList.get(i).getY(), Color.WHITE);
        }
    }
}
