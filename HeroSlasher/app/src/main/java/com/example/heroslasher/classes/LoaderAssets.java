package com.example.heroslasher.classes;

import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
import com.example.gear2d.utilites.UtilResource;
import com.example.heroslasher.R;

public class LoaderAssets {
    public LoaderAssets(CoreFW coreFW, GraphicsFW graphicsFW) {
        loadTexture(graphicsFW);
        loadSpritePlayer(graphicsFW);
    }

    private void loadSpritePlayer(GraphicsFW graphicsFW) {
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,0, 64, 32, 32));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,32, 64, 32, 32));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,64, 64, 32, 32));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,96, 64, 32, 32));
    }

    private void loadTexture(GraphicsFW graphicsFW) {
        UtilResource.textureAtlas = graphicsFW.newTexture("chibi1.png");
    }
}
