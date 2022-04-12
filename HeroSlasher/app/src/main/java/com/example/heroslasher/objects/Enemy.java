package com.example.heroslasher.objects;

import com.example.gear2d.AnimationFW;
import com.example.gear2d.GraphicsFW;
import com.example.gear2d.ObjectsFW;
import com.example.gear2d.utilites.UtilRandomFW;
import com.example.heroslasher.utilites.UtilResource;

public class Enemy extends ObjectsFW {
    AnimationFW animationEnemy;
    public Enemy(int sceneWidth, int sceneHeight, int minScreenY, short enemyType) {
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight - UtilResource.spriteEnemy.get(0).getHeight();
        this.minScreenX = 0;
        this.minScreenY = minScreenY;
        //this.speed = UtilRandomFW.getCasualNumber(23);
        this.x = maxScreenX;
        this.y = UtilRandomFW.getCasualNumber(maxScreenY);
        switch (enemyType) {
            case 1:
                speed = UtilRandomFW.getGap(2, 5);
                animationEnemy = new AnimationFW(speed, UtilResource.spriteEnemy);
                break;
            case 2:
                speed = UtilRandomFW.getGap(4, 9);
                break;
        }
    }
    public void update(double speedPlayer) {
        x -= speed + speedPlayer;
        if (x < minScreenX) {
            x = maxScreenX;
            y = UtilRandomFW.getCasualNumber(maxScreenY);
        }
        animationEnemy.runAnimation();
    }
    public void drawing(GraphicsFW graphicsFW) {
        animationEnemy.drawingAnimation(graphicsFW, x, y);
    }
}
