package com.example.heroslasher.scenes;

import android.graphics.Color;

import com.example.gear2d.CoreFW;
import com.example.gear2d.SceneFW;
import com.example.heroslasher.R;

public class GameScene extends SceneFW {

    enum GameState {
        READY, RUNNING, PAUSE, GAMEOVER
    }
    GameState gameState;

    public GameScene(CoreFW coreFW) {
        super(coreFW);
        gameState = GameState.READY;
    }

    @Override
    public void update() {
        if (gameState == GameState.READY) {
            updateStateReady();
        }
        if (gameState == GameState.READY) {
            updateStateRunning();
        }
        if (gameState == GameState.READY) {
            updateStatePause();
        }
        if (gameState == GameState.READY) {
            updateStateGameOver();
        }
    }

    private void updateStateGameOver() {
    }

    private void updateStatePause() {
    }

    private void updateStateRunning() {
    }

    private void updateStateReady() {
        coreFW.getTouchLiestener().getTouchUp(0, 0, )
    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.RED);
        graphicsFW.drawText("Game Scene", 100, 100, Color.BLACK, 40, null);
        if (gameState == GameState.READY) {
            drawingStateReady();
        }
        if (gameState == GameState.READY) {
            drawingStateRunning();
        }
        if (gameState == GameState.READY) {
            drawingStatePause();
        }
        if (gameState == GameState.READY) {
            drawingStateGameOver();
        }
    }

    private void drawingStateGameOver() {
    }

    private void drawingStatePause() {
    }

    private void drawingStateRunning() {
    }

    private void drawingStateReady() {
        coreFW.getGraphics().clearScene(Color.BLACK);
        coreFW.getGraphics().drawText(coreFW.getString(R.string.txt_gameScene_stateReady_ready),
                100, 150, 60, Color.GREEN, null);
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
