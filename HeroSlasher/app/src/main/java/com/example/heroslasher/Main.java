package com.example.heroslasher;

import com.example.gear2d.CoreFW;
import com.example.gear2d.SceneFW;
import com.example.heroslasher.scenes.MainMenuScene;

public class Main extends CoreFW {

    public SceneFW getStartScene() {
        //LoaderAssets loaderAssets = new LoaderAssets(this, this.getGraphics());
        return new MainMenuScene(this);
    }
}