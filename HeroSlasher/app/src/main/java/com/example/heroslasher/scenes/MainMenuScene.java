package com.example.heroslasher.scenes;

import android.graphics.Color;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
import com.example.gear2d.SceneFW;
import com.example.heroslasher.R;

public class MainMenuScene extends SceneFW {

    public MainMenuScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {

        int x = (int)coreFW.getTouchListener().x;
        int y = (int)coreFW.getTouchListener().y;

        String text = "X: "+x+"; Y: "+y;

        graphicsFW.drawRect(x, y, x + 100, y + 50, Color.GREEN);
        graphicsFW.drawText(text, x, y, Color.WHITE, 30, null);
        graphicsFW.drawRect(20, 250, 100, 290, Color.BLUE);

        if (coreFW.getTouchListener().getTouchUp(20, 250, 150, 40)) {
            coreFW.setScene(new GameScene(coreFW));
        }
    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_nameGame), 100, 100, Color.GREEN, 60, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_newGame), 20, 300, Color.GREEN, 40, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_settings), 20, 350, Color.GREEN, 40, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_Score), 20, 400, Color.GREEN, 40, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_exitGame), 20, 450, Color.GREEN, 40, null);
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
