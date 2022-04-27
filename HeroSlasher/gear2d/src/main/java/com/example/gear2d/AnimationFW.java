package com.example.gear2d;

import android.graphics.Bitmap;

public class AnimationFW {
    double speedAnimation;
    double maxSpeed;
    int delayIndex;
    int countFrames;
    int frames;

    Bitmap sprite;
    LoaderAssetsAnimation loaderAssetsAnimation;

    public AnimationFW(double speedAnimation, double maxSpeed, LoaderAssetsAnimation loaderAssetsAnimation) {
        this.loaderAssetsAnimation = loaderAssetsAnimation;

        this.maxSpeed = maxSpeed;

        countFrames = 0;
        delayIndex = 0;

        this.speedAnimation = speedAnimation;
        frames = this.loaderAssetsAnimation.sprites.size();
        sprite = this.loaderAssetsAnimation.sprites.get(0);
    }
     public void runAnimation() {
        delayIndex++;
        if (delayIndex > maxSpeed - speedAnimation) {
            delayIndex = 0;
            sprite = this.loaderAssetsAnimation.sprites.get(countFrames++);
            if (countFrames >= frames) {
                countFrames = 0;
            }
        }
     }

     public void drawingAnimation(GraphicsFW graphicsFW, int x, int y) {
        if (sprite == null) System.out.println("Null");
        graphicsFW.drawTexture(sprite, x, y);
     }
    public void setSpeedAnimation(double speedAnimation) {
        this.speedAnimation = speedAnimation;
    }
}
