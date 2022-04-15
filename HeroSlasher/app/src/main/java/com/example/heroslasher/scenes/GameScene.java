package com.example.heroslasher.scenes;

import android.graphics.Color;

import com.example.gear2d.CoreFW;
import com.example.gear2d.SceneFW;
import com.example.heroslasher.R;
import com.example.heroslasher.classes.GameManager;
import com.example.heroslasher.generator.GeneratorBackground;

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
    }
    private void drawingStateGameOver() {
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
