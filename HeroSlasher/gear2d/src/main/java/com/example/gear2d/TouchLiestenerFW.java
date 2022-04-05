package com.example.gear2d;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

public class TouchLiestenerFW implements View.OnTouchListener {

    public float x;
    public float y;

    float touchX;
    float touchY;

    boolean isTouchDown;
    boolean isTouchUp;

    float sceneWidth;
    float sceneHeight;

    public TouchLiestenerFW(View view, float sceneWidth, float sceneHeight) {
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
                    touchX = motionEvent.getX()/**sceneWidth*/;
                    touchY = motionEvent.getY()/**sceneHeight*/;
                    isTouchUp = false;
                    isTouchDown = true;
                    break;
                case MotionEvent.ACTION_UP:
                    touchX = motionEvent.getX()/**sceneWidth*/;
                    touchY = motionEvent.getY()/**sceneHeight*/;
                    isTouchUp = true;
                    isTouchDown = false;
                    break;
            }
        }
        return true;
    }

    public boolean getTouchUp(int x, int y, int touchWidth, int touchHeight) {
        if (isTouchUp) {
            if ((touchX >= x) && (touchX <= x + touchWidth - 1) && (touchY >= y) && (touchY <= y + touchHeight - 1)) {
                isTouchUp = false;
                return true;
            }
        }
        return false;
    }
    public boolean getTouchDown(int x, int y, int touchWidth, int touchHeight) {
        if (isTouchDown) {
            if ((touchX >= x) && (touchX <= x + touchWidth - 1) && (touchY >= y) && (touchY <= y + touchHeight - 1)) {
                isTouchDown = false;
                return true;
            }
        }
        return false;
    }
}
