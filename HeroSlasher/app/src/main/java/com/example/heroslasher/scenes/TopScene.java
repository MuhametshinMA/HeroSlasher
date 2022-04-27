package com.example.heroslasher.scenes;

import android.graphics.Color;

import com.example.gear2d.CoreFW;
import com.example.gear2d.SceneFW;
import com.example.heroslasher.R;
import com.example.heroslasher.utilites.SettingsGame;

public class TopScene extends SceneFW {
    //String[] numbers = new String[5];
    public TopScene(CoreFW coreFW) {
        super(coreFW);
        for (int i = 0; i < 5; i++) {
            //this.numbers[i] = " " + (i + 1) + "." + SettingsGame.distance[i];
            //System.out.println(String.valueOf(numbers[0]));
        }
    }

    @Override
    public void update() {
        if (coreFW.getTouchListener().getTouchUp(0, 0, sceneWidth, sceneHeight)) {
            coreFW.setScene(new MainMenuScene(coreFW));
        }
    }

    @Override
    public void drawing() {
        graphicsFW.drawText(coreFW.getString(R.string.txt_topScene_bestResults),
                120, 200, Color.GREEN, 40, null);
        graphicsFW.drawText(""+SettingsGame.distance[0], 120, 300,  Color.GREEN, 35, null);
        graphicsFW.drawText(""+SettingsGame.distance[1], 120, 350, Color.GREEN, 35, null);
        graphicsFW.drawText(""+SettingsGame.distance[2], 120, 400, Color.GREEN, 35, null);
        graphicsFW.drawText(""+SettingsGame.distance[3], 120, 450, Color.GREEN, 35, null);
        graphicsFW.drawText(""+SettingsGame.distance[4], 120, 500, Color.GREEN, 35, null);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
        graphicsFW.clearScene(Color.BLACK);
    }

    @Override
    public void dispose() {

    }
}
