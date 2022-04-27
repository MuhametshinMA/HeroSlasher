package com.example.heroslasher.classes;

import com.example.gear2d.CollisionDetectFW;
import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
import com.example.gear2d.LoaderAssetSound;
import com.example.heroslasher.generator.GeneratorBackground;
import com.example.heroslasher.generator.GeneratorEnemy;
import com.example.heroslasher.objects.Header;
import com.example.heroslasher.objects.MainPlayer;

public class GameManager{

    public static boolean gameOver;

    protected MainPlayer mainPlayer;
    GeneratorBackground generatorBackground;
    GeneratorEnemy generatorEnemy;
    Header header;
    LoaderAssetSound boomSound;

    public GameManager(CoreFW coreFW, int sceneWidth, int sceneHeight) {
        header = new Header(coreFW);
        gameOver = false;
        int mMinScreenY = header.getHEIGHT_HEADER();
        mainPlayer = new MainPlayer(coreFW, sceneWidth, sceneHeight, mMinScreenY);
        generatorBackground = new GeneratorBackground(sceneWidth, sceneHeight);
        generatorEnemy = new GeneratorEnemy(coreFW, sceneWidth, sceneHeight, mMinScreenY, (short) 1, 5);
        boomSound = new LoaderAssetSound(coreFW, "boom.mp3");
    }

    public void update() {
        if (GameManager.gameOver) {
            System.out.println("in GameManager update: game over true");
        }
        mainPlayer.update();
        generatorBackground.update(mainPlayer.getSpeed());
        generatorEnemy.update(mainPlayer.getSpeed());
        header.setPassedDistance(mainPlayer.getSpeed());
        header.setCurrentSpeedPlayer(mainPlayer.getSpeed());
        header.setCurrentShieldPlayer(mainPlayer.getShield());
        checkHit();

    }

    private void checkHit() {
        for (int i = 0; i < generatorEnemy.enemyArrayList.size(); i++) {
            if (CollisionDetectFW.collisionDetect(mainPlayer, generatorEnemy.enemyArrayList.get(i))) {

                if (!generatorEnemy.enemyArrayList.get(i).isDead) {
                    boomSound.getSoundFW().play(1);
                    generatorEnemy.hitPlayer(i);
                    mainPlayer.hitEnemy();
                }

            }
        }
    }

    public void drawing(CoreFW coreFW, GraphicsFW graphicsFW) {
        if (GameManager.gameOver) {
            System.out.println("in GameManager drawing: game over true");
        }
        generatorBackground.drawing(graphicsFW);
        mainPlayer.drawing(graphicsFW);
        generatorEnemy.drawing(graphicsFW);
        header.drawing(graphicsFW);
    }
}
