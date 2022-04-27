package com.example.gear2d;

import android.graphics.Typeface;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;

public class LoadAssetsFonts {

    public static Typeface font;


    public LoadAssetsFonts(CoreFW coreFW) {
        loadFont(coreFW);
    }


    private void loadFont(CoreFW coreFW) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            font = coreFW.getResources().getFont(R.font.cairo);
        } else {
            font = ResourcesCompat.getFont(coreFW.getApplicationContext(), R.font.cairo);
        }
    }
    public static Typeface getFont() {
        return font;
    }
}
