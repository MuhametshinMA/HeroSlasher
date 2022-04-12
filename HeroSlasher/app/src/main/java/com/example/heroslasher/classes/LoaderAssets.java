package com.example.heroslasher.classes;

import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
import com.example.heroslasher.utilites.UtilResource;

import java.util.ArrayList;

public class LoaderAssets {
    public LoaderAssets(CoreFW coreFW, GraphicsFW graphicsFW) {
        loadTextureAtlas(graphicsFW);
        loadSpritePlayer(graphicsFW);
        loadTextureEnemy(graphicsFW);
        loadSpriteEnemy(graphicsFW);
    }

    private void loadSpriteEnemy(GraphicsFW graphicsFW) {
        UtilResource.spriteEnemy = new ArrayList<>();
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureEnemy,
                0, 1, 5,5));
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureEnemy,
                1, 1, 5,5));
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureEnemy,
                2, 1, 5,5));
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureEnemy,
                3, 1, 5,5));
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureEnemy,
                4, 1, 5,5));
    }

    private void loadSpritePlayer(GraphicsFW graphicsFW) {
        UtilResource.spritePlayer = new ArrayList<>();
        UtilResource.spritePlayerBoost = new ArrayList<>();
        //System.out.println("Width: " + UtilResource.textureAtlas.getWidth() + "Height: " + UtilResource.textureAtlas.getHeight());

        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                0, 0, 3, 2));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                1, 0, 3, 2));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                2, 0, 3, 2));

        UtilResource.spritePlayerBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                0, 1, 3, 2));
        UtilResource.spritePlayerBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                1, 1, 3, 2));
        UtilResource.spritePlayerBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                2, 1, 3, 2));
    }

    private void loadTextureAtlas(GraphicsFW graphicsFW) {
        UtilResource.textureAtlas = graphicsFW.newTexture("chichi.png");
        if (UtilResource.textureAtlas == null) {
            System.out.println("Null");
        } else System.out.println(" not Null");
    }

    private void loadTextureEnemy(GraphicsFW graphicsFW) {
        UtilResource.textureEnemy = graphicsFW.newTexture("explosion.png");
        if (UtilResource.textureEnemy == null) {
            System.out.println("Null");
        } else System.out.println(" not Null");
    }
}
