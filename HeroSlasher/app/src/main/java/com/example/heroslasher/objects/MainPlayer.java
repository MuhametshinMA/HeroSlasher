package com.example.heroslasher.objects;

import android.graphics.Rect;

import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
import com.example.gear2d.ObjectsFW;
import com.example.gear2d.LoaderAssetsAnimation;
import com.example.gear2d.AnimationFW;
import com.example.gear2d.utilites.UtilTimerFW;
import com.example.heroslasher.classes.GameManager;

public class MainPlayer extends ObjectsFW {
    final int GRAVITY = -3;
    final double MAX_SPEED = 15;
    final int MIN_SPEED = 1;

    AnimationFW animationMainPlayer;

    CoreFW coreFW;
    LoaderAssetsAnimation loaderAssetsAnimation;
    UtilTimerFW timerOnShieldHit;
    UtilTimerFW timerOnDead;

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
        loaderAssetsAnimation = new LoaderAssetsAnimation(coreFW,"chichi.png",
                3, 5, condition);
        //loaderAssetsAnimation.execute();
        animationMainPlayer = new AnimationFW(speed, MAX_SPEED, loaderAssetsAnimation);
        x = 110;
        y = 100;
        speed = 3;
        shield = 3;
        timerOnShieldHit = new UtilTimerFW();
        timerOnDead = new UtilTimerFW();


        radius = loaderAssetsAnimation.sprites.get(0).getHeight()/4;

        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - loaderAssetsAnimation.sprites.get(0).getHeight();
        this.minScreenY = minScreenY;

    }
    public void update() {
        animationMainPlayer.runAnimation();
        isBoost();
        changeShieldAnim();
        gravity();
        isDead();
        hitBox = new Rect(x, y,
                loaderAssetsAnimation.sprites.get(0).getWidth(),
                loaderAssetsAnimation.sprites.get(0).getHeight());
    }

    private void isDead() {
        if (condition == DEAD) {
            if (timerOnDead.timerDelay(3)) {
                System.out.println("in MainPlayer isDead: game over true");
                GameManager.gameOver = true;
            }
        }
    }

    private void gravity() {
        y -= speed + GRAVITY;
        if (y < minScreenY) {
            y = minScreenY;
        }
        if (y > maxScreenY) {
            y = maxScreenY;
        }
    }

    private void changeShieldAnim() {
        if (timerOnShieldHit.timerDelay(1)) {
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
            loaderAssetsAnimation.loadSprite(coreFW.getGraphics(),3, 5, condition);
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
        if (shield < 0) {
            setCondition(DEAD);
            timerOnDead.startTimer();

                System.out.println("in MainPlayer hitEnemy: timerOnDead.startTimer() done");

        }
        if ((condition == BOOSTED) || (condition == BOOSTED_HITED)) {
            setCondition(BOOSTED_HITED);
        }
        if ((condition == NO_BOOSTED) || (condition == NO_BOOSTED_HITED)) {
            setCondition(NO_BOOSTED_HITED);
        }
        timerOnShieldHit.startTimer();
    }
    public void isBoost() {
        if (condition != DEAD) {
            if (coreFW.getTouchListener().getTouchDown(0, 0,
                    coreFW.getCurrentScene().sceneWidth,
                    coreFW.getCurrentScene().sceneHeight)) {
                setCondition(BOOSTED);
                System.out.println("Boosted");
            }

            if (coreFW.getTouchListener().getTouchUp(0, 0,
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
}
