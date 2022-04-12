package com.example.heroslasher.objects;

import com.example.gear2d.ObjectsFW;
import com.example.gear2d.utilites.UtilRandomFW;

public class Star extends ObjectsFW {
    public Star(int sceneWidth, int sceneHeight) {
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        this.minScreenX = 0;
        this.minScreenY = 0;
        this.speed = UtilRandomFW.getCasualNumber(23);
        this.x = UtilRandomFW.getCasualNumber(maxScreenX);
        this.y = UtilRandomFW.getCasualNumber(maxScreenY);
    }
    public void update(double speed) {
        x -= speed;
        x -= this.speed;
        if (x < 0) {
            x = maxScreenX;
        }
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
