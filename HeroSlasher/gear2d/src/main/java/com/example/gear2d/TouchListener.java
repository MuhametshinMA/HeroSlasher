package com.example.gear2d;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

public class TouchListener implements View.OnTouchListener {

    public float x;
    public float y;

    float touchX;
    float touchY;

    boolean isTouchDown;
    boolean isTouchUp;

    float sceneWidth;
    float sceneHeight;

    public TouchListener(View view, float sceneWidth, float sceneHeight) {
        view.setOnTouchListener(this);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        synchronized (this) {

            x = motionEvent.getX();
            y = motionEvent.getY();

            isTouchDown = false;
            isTouchUp = false;

            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touchX = motionEvent.getX();
                    touchY = motionEvent.getY();
                    isTouchUp = false;
                    isTouchDown = true;
                    System.out.println("TOUCH DOWN");
                    break;
                case MotionEvent.ACTION_UP:
                    touchX = motionEvent.getX();
                    touchY = motionEvent.getY();
                    isTouchUp = true;
                    isTouchDown = false;
                    System.out.println("TOUCH UP");
                    break;
            }
        }
        return true;
    }

    public boolean getTouchDown(int x, int y, int touchWidth, int touchHeight) {
        if (isTouchDown) {
            System.out.println("TouchX: " + touchX + " TouchY: " + touchY);
            System.out.println("X: " + x + " Y: " + y + " width: "
                    + touchWidth + " height: " + touchHeight);
            if ((touchX > x) && (touchX < (x + touchWidth - 1)) && (touchY > y) && (touchY < (y + (touchHeight - 1)))) {
                isTouchDown = false;
                System.out.println("Was touchedDown");
                return true;
            }
        }
        return false;
    }
    public boolean getTouchUp(int x, int y, int touchWidth, int touchHeight) {
        if (isTouchUp) {
            if ((touchX >= x) && (touchX <= x + touchWidth - 1) && (touchY >= y) && (touchY <= y + (touchHeight - 1))) {
                isTouchUp = false;
                System.out.println("Was touchedUp");
                return true;
            }
        }
        return false;
    }
}
