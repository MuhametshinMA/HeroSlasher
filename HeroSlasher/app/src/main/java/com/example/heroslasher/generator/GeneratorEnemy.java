package com.example.heroslasher.generator;

import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
import com.example.gear2d.utilites.UtilTimerFW;
import com.example.heroslasher.objects.Enemy;

import java.util.ArrayList;

public class GeneratorEnemy {
    private int maxScreenY;
    private int maxScreenX;
    private int minScreenY;
    private int minScreenX;
    private int amountEnemy;
    private short type;
    UtilTimerFW timerOnDead;

    public static ArrayList<Enemy> enemyArrayList;
    CoreFW coreFW;

    public GeneratorEnemy(CoreFW coreFW,
                          int sceneWidth, int sceneHeight, int minScreenY,
                          short type, int amountEnemy) {
        this.coreFW = coreFW;
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        minScreenX = 0;
        this.minScreenY = minScreenY;
        this.amountEnemy = amountEnemy;
        this.type = type;
        enemyArrayList = new ArrayList<>();
        timerOnDead = new UtilTimerFW();
    }
    public void update(double speedPlayer) {
        addEnemy();
        isDead();
        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.get(i).update(speedPlayer);
        }
    }

    private void addEnemy() {
        if (enemyArrayList.size() < amountEnemy) {
            for (int i = 0; i < amountEnemy; i++) {
                enemyArrayList.add(new Enemy(coreFW, maxScreenX, maxScreenY, minScreenY, (short) type));
                //System.out.println("Enemy added: "+ i + " Enemies: " + enemyArrayList.size());
            }
        }
    }
    public void drawing(GraphicsFW graphicsFW) {
        for (int i = 0; i < enemyArrayList.size(); i++) {
            //System.out.println("Enemies: " + enemyArrayList.size() + " i: " + i);
            enemyArrayList.get(i).drawing(graphicsFW);
        }
    }

    public void hitPlayer(int enemy) {
        enemyArrayList.get(enemy).isHitPlayer();
        timerOnDead.startTimer();
    }
    private void isDead() {
        for (int i = 0; i < enemyArrayList.size(); i++) {
            if (enemyArrayList.get(i).isDead) {
                if (timerOnDead.timerDelay(2)) {
                    enemyArrayList.remove(i);
                }
            }
        }
    }
}
