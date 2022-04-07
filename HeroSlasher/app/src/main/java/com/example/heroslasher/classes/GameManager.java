package com.example.heroslasher.classes;

import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
import com.example.heroslasher.objects.MainPlayer;

public class GameManager {
    private int maxScreenY;
    private int maxScreenX;
    private int minScreenY;
    private int minScreenX;

    MainPlayer mainPlayer;
    public GameManager(CoreFW coreFW, int sceneWidth, int sceneHeight) {
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        minScreenX = 0;
        minScreenY = 0;
        mainPlayer = new MainPlayer(maxScreenX, maxScreenY);
    }

    public void update() {
        mainPlayer.update();
    }
    public void drawing(CoreFW coreFW, GraphicsFW graphicsFW) {
        mainPlayer.drawing(graphicsFW);
    }
}
