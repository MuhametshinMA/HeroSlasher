package com.example.heroslasher.objects;

import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
import com.example.gear2d.ObjectsFW;
import com.example.heroslasher.utilites.UtilResource;
import com.example.gear2d.AnimationFW;

public class MainPlayer extends ObjectsFW {
    final int GRAVITY = -3;
    final int MAX_SPEED = 35;
    final int MIN_SPEED = 1;
    AnimationFW animationSpriteMainPlayer;
    AnimationFW getAnimationSpriteMainPlayerBoost;

    CoreFW coreFW;

    boolean boosting;
    private int shield;

    public MainPlayer(CoreFW coreFW, int maxScreenX, int maxScreenY, int minScreenY) {
        x = 200;
        y = 100;
        speed = 3;
        shield = 3;
        boosting = false;
        this.coreFW = coreFW;
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spritePlayer.get(0).getHeight();
        this.minScreenY = minScreenY;
        animationSpriteMainPlayer = new AnimationFW(speed, UtilResource.spritePlayer);
        getAnimationSpriteMainPlayerBoost = new AnimationFW(speed,
                UtilResource.spritePlayerBoost);
    }
    public void update() {
        if (coreFW.getTouchLiestener().getTouchDown(0,0,maxScreenX,maxScreenY)) {
            startBoosting();
        }
        if (coreFW.getTouchLiestener().getTouchUp(0,0,maxScreenX,maxScreenY)) {
            stopBoosting();
        }
        if (boosting) {
            speed += 1;
        } else {
            speed -= 1;
        }
        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }
        if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }
        y -= speed + GRAVITY;
        if (y < minScreenY) {
            y = minScreenY;
        }
        if (y > maxScreenY) {
            y = maxScreenY;
        }
        if (boosting) {
            getAnimationSpriteMainPlayerBoost.runAnimation();
        } else {
            animationSpriteMainPlayer.runAnimation();
        }
    }

    private void stopBoosting() {
        boosting = false;
    }

    private void startBoosting() {
        boosting = true;
    }

    public void drawing(GraphicsFW graphicsFW) {
        if (boosting) {
            getAnimationSpriteMainPlayerBoost.drawingAnimation(graphicsFW, x, y);
        } else {
            animationSpriteMainPlayer.drawingAnimation(graphicsFW, x, y);
        }
    }
    public double getSpeed() {
        return speed;
    }
    public int getShield() {
        return shield;
    }
}
