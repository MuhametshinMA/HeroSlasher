package com.example.heroslasher.scenes;

import android.graphics.Color;

import com.example.gear2d.CoreFW;
import com.example.gear2d.SceneFW;

public class ExitScene extends SceneFW {
    public ExitScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {
        int x = (int)coreFW.getTouchListener().x;
        int y = (int)coreFW.getTouchListener().y;

        String text = "X: "+x+"; Y: "+y;

        graphicsFW.drawRect(x, y, x + 100, y + 50, Color.GREEN);
        graphicsFW.drawText(text, x, y, Color.WHITE, 30, null);
        if (coreFW.getTouchListener().getTouchUp(50,400,50,50)) {
            coreFW.finish();
        }
        if (coreFW.getTouchListener().getTouchUp(200,400,50,50)) {
            coreFW.setScene(new MainMenuScene(coreFW));
        }
    }

    @Override
    public void drawing() {
        coreFW.getGraphics().clearScene(Color.BLACK);
        coreFW.getGraphics().drawText("Quit game?", 200, 350, Color.GREEN, 60, null);
        coreFW.getGraphics().drawText("Yes", 50, 450, Color.GREEN, 50, null);
        coreFW.getGraphics().drawText("No", 200, 450, Color.GREEN, 50, null);
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
