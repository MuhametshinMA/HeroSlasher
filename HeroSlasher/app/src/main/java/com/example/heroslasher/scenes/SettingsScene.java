package com.example.heroslasher.scenes;

import android.graphics.Color;

import com.example.gear2d.CoreFW;
import com.example.gear2d.SceneFW;
import com.example.heroslasher.utilites.SettingsGame;

public class SettingsScene extends SceneFW {
    public static boolean sMusicOn = true;
    public static boolean sSoundOn = true;
    public SettingsScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {
        int x = (int)coreFW.getTouchListener().x;
        int y = (int)coreFW.getTouchListener().y;

        String text = "X: "+x+"; Y: "+y;

        graphicsFW.drawRect(x, y, x + 100, y + 50, Color.GREEN);
        graphicsFW.drawText(text, x, y, Color.WHITE, 30, null);
        if (coreFW.getTouchListener().getTouchUp(250, 270, 100, 30)) {
            SettingsGame.sMusicOn = !SettingsGame.sMusicOn;
            SettingsGame.saveSettings(coreFW);
        }
        if (coreFW.getTouchListener().getTouchUp(250, 320, 100, 30)) {
            SettingsGame.sSoundOn = !SettingsGame.sSoundOn;
            SettingsGame.saveSettings(coreFW);
        }
        if (coreFW.isPressedKeyBack()) {
            coreFW.setPressedKeyBack(false);
            coreFW.setScene(new MainMenuScene(coreFW));
        }
    }

    @Override
    public void drawing() {
        coreFW.getGraphics().clearScene(Color.BLACK);
        coreFW.getGraphics().drawText("Settings", 150, 150, Color.GREEN, 60, null);
        coreFW.getGraphics().drawText("Music", 50, 300, Color.GREEN, 30, null);
        coreFW.getGraphics().drawText("Sound", 50, 350, Color.GREEN, 30, null);
        if (SettingsGame.sMusicOn) {
            coreFW.getGraphics().drawText("On", 250, 300, Color.GREEN, 30, null);
        } else {
            coreFW.getGraphics().drawText("Off", 250, 300, Color.GREEN, 30, null);
        }
        if (SettingsGame.sSoundOn) {
            coreFW.getGraphics().drawText("On", 250, 350, Color.GREEN, 30, null);
        } else {
            coreFW.getGraphics().drawText("Off", 250, 350, Color.GREEN, 30, null);
        }

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
