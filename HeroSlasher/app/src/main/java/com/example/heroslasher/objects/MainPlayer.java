package com.example.heroslasher.objects;

import android.graphics.Rect;

import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
import com.example.gear2d.ObjectsFW;
import com.example.gear2d.LoaderAssets;
import com.example.gear2d.AnimationFW;
import com.example.gear2d.utilites.UtilTimerFW;

public class MainPlayer extends ObjectsFW {
    final int GRAVITY = -3;
    final double MAX_SPEED = 15;
    final int MIN_SPEED = 1;

    AnimationFW animationMainPlayer;

    CoreFW coreFW;
    LoaderAssets loaderAssets;
    UtilTimerFW onShieldHit;

    private int shield;
    protected int condition;


    public static int NO_BOOSTED = 0;
    public static int BOOSTED = 1;
    public static int NO_BOOSTED_HITED = 2;
    public static int BOOSTED_HITED = 3;
    public static int DEAD = 4;

    public MainPlayer(CoreFW coreFW, int maxScreenX, int maxScreenY, int minScreenY) {
        this.coreFW = coreFW;
        condition = NO_BOOSTED;
        loaderAssets = new LoaderAssets(coreFW.getGraphics(),"chichi.png",
                3, 5, condition);
        animationMainPlayer = new AnimationFW(speed, MAX_SPEED, loaderAssets);
        x = 110;
        y = 100;
        speed = 3;
        shield = 3;
        onShieldHit = new UtilTimerFW();

        radius = loaderAssets.sprites.get(0).getHeight()/4;

        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - loaderAssets.sprites.get(0).getHeight();
        this.minScreenY = minScreenY;

    }
    public void update() {
        animationMainPlayer.runAnimation();
        isBoost();
        changeShieldAnim();

        y -= speed + GRAVITY;
        if (y < minScreenY) {
            y = minScreenY;
        }
        if (y > maxScreenY) {
            y = maxScreenY;
        }

        hitBox = new Rect(x, y,
                loaderAssets.sprites.get(0).getWidth(),
                loaderAssets.sprites.get(0).getHeight());
    }

    private void changeShieldAnim() {
        if (onShieldHit.timerDelay(1)) {
            if (condition == NO_BOOSTED_HITED) {
                setCondition(NO_BOOSTED);
            }
            if (condition == BOOSTED_HITED) {
                setCondition(BOOSTED);
            }
        }
    }

    private void setCondition(int condition) {

        this.condition = condition;
        loaderAssets.loadSprite(coreFW.getGraphics(),3, 5, condition);
        animationMainPlayer.setSpeedAnimation(speed);
    }
    public void drawing(GraphicsFW graphicsFW) {
        animationMainPlayer.drawingAnimation(graphicsFW, x, y);
    }
    public double getSpeed() {
        return speed;
    }
    public int getShield() {
        return shield;
    }

    public void hitEnemy() {
        shield--;
        if ((condition == BOOSTED) || (condition == BOOSTED_HITED)) {
            setCondition(BOOSTED_HITED);
        }
        if ((condition == NO_BOOSTED) || (condition == NO_BOOSTED_HITED)) {
            setCondition(NO_BOOSTED_HITED);
        }
        onShieldHit.startTimer();
    }
    public void isBoost() {
        if (coreFW.getTouchListener().getTouchDown(0,0,
                coreFW.getCurrentScene().sceneWidth,
                coreFW.getCurrentScene().sceneHeight)) {
            setCondition(BOOSTED);
            System.out.println("Boosted");
        }

        if (coreFW.getTouchListener().getTouchUp(0,0,
                coreFW.getCurrentScene().sceneWidth,
                coreFW.getCurrentScene().sceneHeight)) {
            setCondition(NO_BOOSTED);
            System.out.println("N#O Boosted");
        }
        if ((condition == BOOSTED) || (condition == BOOSTED_HITED)) {
            speed += 1;
            animationMainPlayer.setSpeedAnimation(speed);
        } else {
            speed -= 1;
            animationMainPlayer.setSpeedAnimation(speed);
        }

        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
            animationMainPlayer.setSpeedAnimation(speed);
        }
        if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
            animationMainPlayer.setSpeedAnimation(speed);
        }
    }
}
