package com.example.heroslasher.scenes;

import android.graphics.Color;
import android.os.Build;
import android.view.MotionEvent;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
import com.example.gear2d.LoadAssetsFonts;
import com.example.gear2d.LoaderAssetSound;
import com.example.gear2d.SceneFW;
import com.example.heroslasher.R;
import com.example.heroslasher.objects.Header;
import com.example.heroslasher.utilites.SettingsGame;

public class MainMenuScene extends SceneFW {

    LoaderAssetSound tapSound;
    LoadAssetsFonts loadAssetsFonts;


    public MainMenuScene(CoreFW coreFW) {
        super(coreFW);
        tapSound = new LoaderAssetSound(coreFW, "tap.mp3");
        loadAssetsFonts = new LoadAssetsFonts(coreFW);
    }

    public void playSound() {
        SettingsGame.loadSettings(coreFW);
        if (SettingsGame.sSoundOn) {
            tapSound.getSoundFW().play(1);
        }
    }

    @Override
    public void update() {

        int x = (int)coreFW.getTouchListener().x;
        int y = (int)coreFW.getTouchListener().y;

        String text = "X: "+x+"; Y: "+y;

        graphicsFW.drawRect(x, y, x + 100, y + 50, Color.GREEN);
        graphicsFW.drawText(text, x, y, Color.WHITE, 30, loadAssetsFonts.getFont());

        if (coreFW.getTouchListener().getTouchUp(20, 260, 150, 40)) {
            playSound();
            coreFW.setScene(new GameScene(coreFW));
            Header.passedDistance = 0;
        }
        if (coreFW.getTouchListener().getTouchUp(20, 310, 150, 40)) {
            playSound();
            coreFW.setScene(new SettingsScene(coreFW));
        }
        if (coreFW.getTouchListener().getTouchUp(20, 360, 150, 40)) {
            playSound();
            coreFW.setScene(new TopScene(coreFW));
        }
        if (coreFW.getTouchListener().getTouchUp(20, 410, 150, 40)) {
            playSound();
            coreFW.setScene(new ExitScene(coreFW));
        }
    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_nameGame), 100, 100, Color.GREEN, 60, loadAssetsFonts.getFont());
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_newGame), 20, 300, Color.GREEN, 40, loadAssetsFonts.getFont());
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_settings), 20, 350, Color.GREEN, 40, loadAssetsFonts.getFont());
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_Score), 20, 400, Color.GREEN, 40, loadAssetsFonts.getFont());
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_exitGame), 20, 450, Color.GREEN, 40, loadAssetsFonts.getFont());
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
