package com.example.heroslasher.scenes;

import android.graphics.Color;
import android.preference.PreferenceActivity;

import com.example.gear2d.CoreFW;
import com.example.gear2d.LoaderAssetSound;
import com.example.gear2d.LoaderAssetsMusic;
import com.example.gear2d.SceneFW;
import com.example.heroslasher.R;
import com.example.heroslasher.classes.GameManager;
import com.example.heroslasher.generator.GeneratorBackground;
import com.example.heroslasher.objects.Header;
import com.example.heroslasher.utilites.SettingsGame;

public class GameScene extends SceneFW {

    enum GameState {
        READY, RUNNING, PAUSE, GAMEOVER
    }
    GameState gameState;
    GameManager gameManager;
    LoaderAssetsMusic loaderAssetsMusic;
    LoaderAssetSound gameOverSound;


    public GameScene(CoreFW coreFW) {
        super(coreFW);
        gameState = GameState.READY;
        gameManager = new GameManager(coreFW, sceneWidth, sceneHeight);
        setName("Game scene");
        loaderAssetsMusic = new LoaderAssetsMusic(coreFW,
                "[8-bit NES] Interstellar - No Time For Caution (256  kbps).mp3");
        SettingsGame.loadSettings(coreFW);
        if (SettingsGame.sMusicOn) {
            loaderAssetsMusic.gameMusic.play(true, 1f);
            System.out.println("inGameScene sMusicOn true");
        } else {System.out.println("inGameScene sMusicOn false");}

        gameOverSound = new LoaderAssetSound(coreFW, "gameOver.mp3");
    }

    @Override
    public void update() {
        if (gameState == GameState.READY) {
            updateStateReady();
        }
        if (gameState == GameState.RUNNING) {
            updateStateRunning();
        }
        if (gameState == GameState.PAUSE) {
            updateStatePause();
        }
        if (gameState == GameState.GAMEOVER) {
            updateStateGameOver();
        }
    }

    @Override
    public void drawing() {
        if (gameState == GameState.READY) {
            drawingStateReady();
        }
        if (gameState == GameState.RUNNING) {
            drawingStateRunning();
        }
        if (gameState == GameState.PAUSE) {
            drawingStatePause();
        }
        if (gameState == GameState.GAMEOVER) {
            drawingStateGameOver();
        }
    }
    private void updateStateReady() {
        if (coreFW.getTouchListener().getTouchUp(0, 0, sceneWidth, sceneHeight)) {
            gameState = GameState.RUNNING;
        }
    }

    private void drawingStateReady() {
        graphicsFW.clearScene(Color.YELLOW);
        graphicsFW.drawText("Ready?"+sceneWidth+" "+sceneHeight, 20, 100, Color.GREEN, 60, null);
        graphicsFW.drawRect(20,20, 100,100, Color.BLACK);
    }
    private void updateStateRunning() {
        gameManager.update();
        if (GameManager.gameOver) {
            gameState = GameState.GAMEOVER;
            loaderAssetsMusic.gameMusic.stop();
            gameOverSound.getSoundFW().play(1);
        }
        if (coreFW.isPressedKeyBack()) {
            coreFW.setPressedKeyBack(false);
            gameState = GameState.PAUSE;
        }
    }

    private void drawingStateRunning() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText("Game scene", 100, 200, Color.RED, 60, null);

        gameManager.drawing(coreFW,graphicsFW);
    }
    private void updateStatePause() {
        if (coreFW.getTouchListener().getTouchUp(0, 0, sceneWidth, sceneHeight)) {
            gameState = GameState.RUNNING;
        }
    }
    private void drawingStatePause() {
    }
    private void updateStateGameOver() {
        SettingsGame.addDistance((int)Header.passedDistance);
        SettingsGame.saveSettings(coreFW);
        SettingsGame.loadSettings(coreFW);
        int x = (int)coreFW.getTouchListener().x;
        int y = (int)coreFW.getTouchListener().y;

        String text = "X: "+x+"; Y: "+y;

        graphicsFW.drawRect(x, y, x + 50, y + 50, Color.GREEN);
        graphicsFW.drawText(text, x, y, Color.WHITE, 30, null);


        if (coreFW.getTouchListener().getTouchUp(50, 250, 150, 50)) {
            coreFW.setScene(new GameScene(coreFW));
        }
        if (coreFW.getTouchListener().getTouchUp(50, 300, 150, 50)) {
            coreFW.setScene(new MainMenuScene(coreFW));
        }
    }
    private void drawingStateGameOver() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText("Game over", 300, 300, Color.RED, 60, null);
        graphicsFW.drawText("Player flew: " + Header.passedDistance,
                300, 500, Color.RED, 30, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_newGame),
                50, 300, Color.RED, 50, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_exitGame),
                50, 350, Color.RED, 50, null);
    }

    @Override
    public void pause() {
        loaderAssetsMusic.gameMusic.stop();
    }

    @Override
    public void resume() {
        if (SettingsGame.sMusicOn) {
            loaderAssetsMusic.gameMusic.play(true, 1f);
        }
    }

    @Override
    public void dispose() {
        loaderAssetsMusic.gameMusic.stop();

    }
}
