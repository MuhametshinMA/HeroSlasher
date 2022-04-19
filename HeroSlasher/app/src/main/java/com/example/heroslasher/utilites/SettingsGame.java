package com.example.heroslasher.utilites;

public class SettingsGame {
    public static int[] distance = {9999, 7777, 6666, 3333, 1111};
    public static void addDistance(int value) {
        for (int i = 0; i < 5; i++) {
            if (distance[i] < value) {
                for (int j = 4; j > 0 ; j++) {
                    distance[i] = distance[j - 1];
                }
                distance[i] = value;
                break;
            }
        }
    }
}
