package com.example.heroslasher.objects;

import com.example.gear2d.GraphicsFW;
import com.example.gear2d.ObjectsFW;
import com.example.gear2d.utilites.UtilResource;
import com.example.heroslasher.classes.AnimationGame;

public class MainPlayer extends ObjectsFW {
    final int GRAVITY = -3;
    final int MAX_SPEED = 15;
    final int MIN_SPEED = 1;
    AnimationGame animationSpriteMainPlayer;

    public MainPlayer(int maxScreenX, int maxScreenY) {
        x = 20;
        y = 200;
        speed = 1;
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spritePlayer.get(0).getHeight();
        animationSpriteMainPlayer = new AnimationGame(speed,
                UtilResource.spritePlayer.get(0),
                UtilResource.spritePlayer.get(1),
                UtilResource.spritePlayer.get(2),
                UtilResource.spritePlayer.get(3));
    }
    public void update() {
        y -= speed + GRAVITY;
        if (y < minScreenY) {
            y = minScreenY;
        }
        if (y < maxScreenY) {
            y = maxScreenY;
        }
        animationSpriteMainPlayer.runAnimation();
    }
    public void drawing(GraphicsFW graphicsFW) {
        animationSpriteMainPlayer.drawingAnimation(graphicsFW, x, y);
    }
}
