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

        int x = (int)coreFW.getTouchLiestener().x;
        int y = (int)coreFW.getTouchLiestener().y;
        coreFW.getGraphics().drawPixel((int)coreFW.getTouchLiestener().x, (int)coreFW.getTouchLiestener().y, Color.WHITE);

        String text = "X: "+x+"; Y: "+y;
        //coreFW.getGraphics().drawText(text, (int)coreFW.getTouchLiestener().x, (int)coreFW.getTouchLiestener().y, Color.WHITE, 30, null);

        coreFW.getGraphics().drawRect(x, y, x + 100, y + 50, Color.GREEN);
        coreFW.getGraphics().drawText(text, x, y, Color.WHITE, 30, null);

        if (coreFW.getTouchLiestener().getTouchUp(20, 350, 150, 40)) {
            coreFW.setScene(new GameScene(coreFW));
            //coreFW.getGraphics().drawText(text, x, y, Color.RED, 30, null);
            //coreFW.getGraphics().drawRect(x, y, x + 100, y + 50, Color.BLUE);
        }


    }

    @Override
    public void drawing() {
        coreFW.getGraphics().clearScene(Color.BLACK);
        coreFW.getGraphics().drawText(coreFW.getString(R.string.txt_mainMenu_nameGame), 100, 100, Color.GREEN, 60, null);
        coreFW.getGraphics().drawText(coreFW.getString(R.string.txt_mainMenu_newGame), 20, 300, Color.GREEN, 40, null);
        coreFW.getGraphics().drawText(coreFW.getString(R.string.txt_mainMenu_settings), 20, 350, Color.GREEN, 40, null);
        coreFW.getGraphics().drawText(coreFW.getString(R.string.txt_mainMenu_Score), 20, 400, Color.GREEN, 40, null);
        coreFW.getGraphics().drawText(coreFW.getString(R.string.txt_mainMenu_exitGame), 20, 450, Color.GREEN, 40, null);
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
