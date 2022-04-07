package com.example.gear2d.utilites;

import java.util.Random;

public class UtilRandomFW {
    public static int getCasualNumber(int number) {
        Random random = new Random();
        int casualNumber;
        casualNumber = random.nextInt(number);
        return casualNumber;
    }
}
