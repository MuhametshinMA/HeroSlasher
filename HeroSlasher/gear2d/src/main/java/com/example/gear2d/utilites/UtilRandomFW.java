package com.example.gear2d.utilites;

import java.util.Random;

public class UtilRandomFW {
    public static int getCasualNumber(int number) {
        Random random = new Random();
        int casualNumber;
        casualNumber = random.nextInt(number);
        return casualNumber;
    }
    public static int getGap(int minNum, int maxNum) {
        int gap = (int)(Math.random() * (++maxNum) + minNum);
        return gap;
    }
}
