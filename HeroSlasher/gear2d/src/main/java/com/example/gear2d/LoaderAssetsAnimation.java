package com.example.gear2d;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
//import com.example.heroslasher.objects.MainPlayer;
//import com.example.heroslasher.utilites.UtilResource;

import java.util.ArrayList;

public class LoaderAssetsAnimation {
    public Bitmap texture;
    public ArrayList<Bitmap> sprites;

    public LoaderAssetsAnimation(CoreFW coreFW, String fileName,
                                 int col, int row, int condition) {
        loadTexture(coreFW.getGraphics(), fileName);
        loadSprite(coreFW.getGraphics(), col, row, condition);
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
