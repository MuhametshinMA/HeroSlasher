package com.example.gear2d;

import android.graphics.Bitmap;

import com.example.gear2d.GraphicsFW;

import java.util.ArrayList;

public class AnimationFW {
    double speedAnimation;
    int delayIndex;
    int countFrames;
    int frames;

    Bitmap sprite;
    ArrayList<Bitmap> spriteArr;
    /*
    Bitmap sprite1;
    Bitmap sprite2;
    Bitmap sprite3;
    */

    public AnimationFW(double speedAnimation, ArrayList<Bitmap> spriteArr/*Bitmap sprite1, Bitmap sprite2, Bitmap sprite3*/) {
        this.spriteArr = new ArrayList<>();
        this.sprite = spriteArr.get(0);
        countFrames = 0;
        delayIndex = 0;
        for(Bitmap bm: spriteArr) {
            this.spriteArr.add(bm);
        }
        /*
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
        this.sprite3 = sprite3;
        */
        this.speedAnimation = speedAnimation;
        frames = this.spriteArr.size();
        //System.out.println("Frames: " + frames);
    }
     public void runAnimation() {
        delayIndex++;
        if (delayIndex > speedAnimation) {
            delayIndex = 0;
            sprite = this.spriteArr.get(countFrames++);
            if (countFrames >= frames) {
                countFrames = 0;
            }
        }
        /*
        if (countFrames == 0) {
            sprite = sprite1;
        }
        if (countFrames == 1) {
            sprite = sprite2;
        }
        if (countFrames == 2) {
            sprite = sprite3;
        }
        */
        //System.out.println("Count Frames: " +countFrames);

     }

     public void drawingAnimation(GraphicsFW graphicsFW, int x, int y) {
        graphicsFW.drawTexture(sprite, x, y);
     }
}
