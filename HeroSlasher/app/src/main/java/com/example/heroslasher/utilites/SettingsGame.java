package com.example.heroslasher.utilites;

import android.content.SharedPreferences;

import com.example.gear2d.CoreFW;

public class SettingsGame {
    public static boolean sMusicOn = true;
    public static boolean sSoundOn = true;
    public static int[] distance = {9999, 7777, 6666, 3333, 1111};
    public static void saveSettings(CoreFW coreFW) {
        SharedPreferences.Editor editor = coreFW.getSharedPreferences().edit();
        editor.clear();
        editor.putBoolean("soundOn", sSoundOn);
        editor.putBoolean("musicOn", sMusicOn);
        for (int i = 0; i < 5; i++) {
            editor.putInt("passed distance: " + i, distance[i]);
        }
        editor.apply();
    }
    
    public static void loadSettings(CoreFW coreFW) {
        sSoundOn = coreFW.getSharedPreferences().getBoolean("soundOn", true);
        sSoundOn = coreFW.getSharedPreferences().getBoolean("musicOn", true);
        for (int i = 0; i < 5; i++) {
            distance[i] = coreFW.getSharedPreferences().getInt("passed distance: " + i, distance[i]);
        }
    }
    public static void addDistance(int value) {
        for (int i = 0; i < 5; i++) {
            if(distance[i] == value) break;
            if (distance[i] < value) {
                for (int j = 4; j > i ; j--) {
                    //System.out.println("i: "+i+" j: "+j);
                    distance[j] = distance[j - 1];
                }
                distance[i] = value;
                break;
            }
        }
    }
}
