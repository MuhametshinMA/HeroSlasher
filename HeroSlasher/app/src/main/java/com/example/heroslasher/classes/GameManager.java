package com.example.heroslasher.classes;

import com.example.gear2d.CollisionDetectFW;
import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
import com.example.heroslasher.generator.GeneratorBackground;
import com.example.heroslasher.generator.GeneratorEnemy;
import com.example.heroslasher.objects.Enemy;
import com.example.heroslasher.objects.Header;
import com.example.heroslasher.objects.MainPlayer;

public class GameManager {
    private int maxScreenY;
    private int maxScreenX;
    private int minScreenY;
    private int minScreenX;

    public static boolean gameOver;

    protected MainPlayer mainPlayer;
    GeneratorBackground generatorBackground;
    GeneratorEnemy generatorEnemy;
    Header header;

    public GameManager(CoreFW coreFW, int sceneWidth, int sceneHeight) {
        header = new Header(coreFW);
        gameOver = false;
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        minScreenX = 0;
        minScreenY = header.getHEIGHT_HEADER();
        mainPlayer = new MainPlayer(coreFW, maxScreenX, maxScreenY, minScreenY);
        generatorBackground = new GeneratorBackground(sceneWidth, sceneHeight);
        generatorEnemy = new GeneratorEnemy(coreFW.getGraphics(), sceneWidth, sceneHeight, minScreenY, (short) 1, 5);
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
                    mainPlayer.hitEnemy();
                }
                generatorEnemy.hitPlayer(i);
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
