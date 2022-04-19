package com.example.heroslasher.scenes;

import android.graphics.Color;

import com.example.gear2d.CoreFW;
import com.example.gear2d.SceneFW;
import com.example.heroslasher.R;
import com.example.heroslasher.classes.GameManager;
import com.example.heroslasher.generator.GeneratorBackground;
import com.example.heroslasher.objects.Header;

public class GameScene extends SceneFW {

    enum GameState {
        READY, RUNNING, PAUSE, GAMEOVER
    }
    GameState gameState;
    GameManager gameManager;

    public GameScene(CoreFW coreFW) {
        super(coreFW);
        gameState = GameState.READY;
        gameManager = new GameManager(coreFW, sceneWidth, sceneHeight);
        setName("Game scene");
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
        }
    }

    private void drawingStateRunning() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText("Game scene", 100, 200, Color.RED, 60, null);

        gameManager.drawing(coreFW,graphicsFW);
    }
    private void updateStatePause() {
    }
    private void drawingStatePause() {
    }
    private void updateStateGameOver() {
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

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
