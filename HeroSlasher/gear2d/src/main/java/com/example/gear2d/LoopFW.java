package com.example.gear2d;

import java.util.Date;

public class LoopFW implements Runnable{

    private final float FPS = 60;
    private final float SECOND = 1000000000;
    private final float UPDATE_TIME = SECOND/FPS;

    private boolean running = false;

    Thread gameTHread = null;

    //temp
    float updates = 0;
    float drawing = 0;
    long timer = 0;

    @Override
    public void run() {
        float lasttime = System.nanoTime();
        float delta = 0;
        timer = System.currentTimeMillis();
        while(running) {
            float nowTime = System.nanoTime();
            float elapsedTime = nowTime - lasttime;
            lasttime = nowTime;
            delta+= elapsedTime/UPDATE_TIME;
            if(delta > 1) {
                updateGame();
                drawingGame();
                delta--;
            }
            if ((System.currentTimeMillis()-timer) > 1000) {
                Date date = new Date();
                System.out.println("Updates = " + updates + " Drawing " + drawing + " " + date.toString());
                updates = 0;
                drawing = 0;
                timer+= 1000;
            }
        }
    }

    private void updateGame() {
        updates++;
    }
    private void drawingGame() {
        drawing++;
    }

    public void startGame() {
        if (running) {
            return;
        }
        running = true;
        gameTHread = new Thread(this);
        gameTHread.start();
    }

    public void stopGame() {
        if (!running) {
            return;
        }
        running = false;
        try {
            gameTHread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
