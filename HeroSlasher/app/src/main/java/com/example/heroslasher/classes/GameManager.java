package com.example.heroslasher.classes;

import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
import com.example.heroslasher.generator.GeneratorBackground;
import com.example.heroslasher.generator.GeneratorEnemy;
import com.example.heroslasher.objects.Header;
import com.example.heroslasher.objects.MainPlayer;

public class GameManager {
    private int maxScreenY;
    private int maxScreenX;
    private int minScreenY;
    private int minScreenX;

    MainPlayer mainPlayer;
    GeneratorBackground generatorBackground;
    GeneratorEnemy generatorEnemy;
    Header header;

    public GameManager(CoreFW coreFW, int sceneWidth, int sceneHeight) {
        header = new Header(coreFW);
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        minScreenX = 0;
        minScreenY = header.getHEIGHT_HEADER();
        mainPlayer = new MainPlayer(coreFW, maxScreenX, maxScreenY, minScreenY);
        generatorBackground = new GeneratorBackground(sceneWidth, sceneHeight);
        generatorEnemy = new GeneratorEnemy(sceneWidth, sceneHeight, minScreenY);
    }

    public void update() {
        mainPlayer.update();
        generatorBackground.update(mainPlayer.getSpeed());
        generatorEnemy.update(mainPlayer.getSpeed());
        header.setPassedDistance(mainPlayer.getSpeed());
        header.setCurrentSpeedPlayer(mainPlayer.getSpeed());
        header.setCurrentShieldPlayer(mainPlayer.getShield());
    }
    public void drawing(CoreFW coreFW, GraphicsFW graphicsFW) {
        generatorBackground.drawing(graphicsFW);
        mainPlayer.drawing(graphicsFW);
        generatorEnemy.driwing(graphicsFW);
        header.drawing(graphicsFW);
    }

}
