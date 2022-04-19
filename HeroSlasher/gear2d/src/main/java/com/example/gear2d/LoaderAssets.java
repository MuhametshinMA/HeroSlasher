package com.example.gear2d;

import android.graphics.Bitmap;

import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
//import com.example.heroslasher.objects.MainPlayer;
//import com.example.heroslasher.utilites.UtilResource;

import java.util.ArrayList;

public class LoaderAssets {
    public Bitmap texture;
    public ArrayList<Bitmap> sprites;
    public LoaderAssets(GraphicsFW graphicsFW, String fileName,
                        int col, int row, int condition) {
        loadTexture(graphicsFW, fileName);
        loadSprite(graphicsFW, col, row, condition);
    }
    public void loadSprite(GraphicsFW graphicsFW, int col, int row, int condition) {
        sprites = new ArrayList<>();

        for (int i = 0; i < col; i++) {
            sprites.add(graphicsFW.newSprite(texture,
                    i, condition, col, row));
        }
    }
    private void loadTexture(GraphicsFW graphicsFW, String fileName) {
        texture = graphicsFW.newTexture(fileName);
        /*System.out.println(fileName);
        if (texture == null) {
            System.out.println("texture in LoaderAssets Null");
        } else System.out.println("texture in LoaderAssets not Null");*/
    }
}
