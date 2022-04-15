package com.example.heroslasher.objects;

import android.graphics.Rect;

import com.example.gear2d.AnimationFW;
import com.example.gear2d.GraphicsFW;
import com.example.gear2d.ObjectsFW;
import com.example.gear2d.utilites.UtilRandomFW;
import com.example.gear2d.LoaderAssets;

public class Enemy extends ObjectsFW {

    public LoaderAssets loaderAssets;

    public int condition;
    double MAX_SPEED = 10;

    private static int LIVE = 0;
    private static int DEAD = 1;

    AnimationFW animationEnemy;
    public Enemy(GraphicsFW graphicsFW,
                 int sceneWidth, int sceneHeight, int minScreenY, short enemyType) {

        condition = LIVE;
        switch (enemyType) {
            case 1:
                speed = UtilRandomFW.getGap(2, 5);
                loaderAssets = new LoaderAssets(graphicsFW,"enemy1.png",
                        20, 2, condition);
                if (graphicsFW == null) {System.out.println("in Enemy graphics: null");}
                else {System.out.println("in Enemy graphics: NOT null");}
                animationEnemy = new AnimationFW(speed, MAX_SPEED, loaderAssets);
                break;
            case 2:
                speed = UtilRandomFW.getGap(4, 9);
                break;
        }
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight - loaderAssets.sprites.get(0).getHeight();
        this.minScreenX = 0;
        this.minScreenY = minScreenY;
        radius = loaderAssets.sprites.get(0).getHeight()/4;
        this.x = maxScreenX;
        this.y = UtilRandomFW.getCasualNumber(maxScreenY);
        System.out.println("in Enemy: created");
    }
    public void update(double speedPlayer) {
        animationEnemy.runAnimation();
        x -= speed + speedPlayer;
        if (x < minScreenX) {
            x = maxScreenX;
            y = UtilRandomFW.getCasualNumber(maxScreenY);
        }

        hitBox = new Rect(x, y,
                loaderAssets.sprites.get(0).getWidth(),
                loaderAssets.sprites.get(0).getHeight());
    }
    public void drawing(GraphicsFW graphicsFW) {
        animationEnemy.drawingAnimation(graphicsFW, x, y);
    }
}
