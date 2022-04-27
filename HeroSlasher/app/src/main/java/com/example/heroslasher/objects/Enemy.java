package com.example.heroslasher.objects;

import android.graphics.Rect;

import com.example.gear2d.AnimationFW;
import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
import com.example.gear2d.ObjectsFW;
import com.example.gear2d.utilites.UtilRandomFW;
import com.example.gear2d.LoaderAssetsAnimation;

public class Enemy extends ObjectsFW {

    public LoaderAssetsAnimation loaderAssetsAnimation;

    public int condition;
    double MAX_SPEED = 10;

    private static int LIVE = 0;
    private static int DEAD = 1;
    public boolean isDead;
    GraphicsFW graphicsFW;

    AnimationFW animationEnemy;
    public Enemy(CoreFW coreFW,
                 int sceneWidth, int sceneHeight, int minScreenY, short enemyType) {

        condition = LIVE;
        this.graphicsFW = coreFW.getGraphics();
        initTypeEnemy(coreFW, enemyType);
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight - loaderAssetsAnimation.sprites.get(0).getHeight();
        this.minScreenX = 0;
        this.minScreenY = minScreenY;
        radius = loaderAssetsAnimation.sprites.get(0).getHeight()/4;
        this.x = maxScreenX;
        this.y = UtilRandomFW.getCasualNumber(maxScreenY);
        isDead = false;

    }

    private void initTypeEnemy(CoreFW coreFW, short enemyType) {
        switch (enemyType) {
            case 1:
                speed = UtilRandomFW.getGap(2, 5);
                loaderAssetsAnimation = new LoaderAssetsAnimation(coreFW,"enemy1.png",
                        20, 2, condition);
                //if (graphicsFW == null) {System.out.println("in Enemy graphics: null");}
                //else {System.out.println("in Enemy graphics: NOT null");}
                animationEnemy = new AnimationFW(speed, MAX_SPEED, loaderAssetsAnimation);
                break;
            case 2:
                speed = UtilRandomFW.getGap(4, 9);
                break;
        }
    }

    public void update(double speedPlayer) {
        animationEnemy.runAnimation();
        x -= speed + speedPlayer;
        if (x < minScreenX) {
            x = maxScreenX;
            y = UtilRandomFW.getCasualNumber(maxScreenY);
        }

        hitBox = new Rect(x, y,
                loaderAssetsAnimation.sprites.get(0).getWidth(),
                loaderAssetsAnimation.sprites.get(0).getHeight());
    }

    public void isHitPlayer() {
        setCondition(DEAD);
        isDead = true;
    }

    public void drawing(GraphicsFW graphicsFW) {
        animationEnemy.drawingAnimation(graphicsFW, x, y);
    }
    private void setCondition(int condition) {
        this.condition = condition;
        loaderAssetsAnimation.loadSprite(graphicsFW,20, 2, condition);
        animationEnemy.setSpeedAnimation(speed);
    }
}
