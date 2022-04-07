package com.example.heroslasher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.gear2d.CoreFW;
import com.example.gear2d.LoopFW;
import com.example.gear2d.SceneFW;
import com.example.heroslasher.classes.LoaderAssets;
import com.example.heroslasher.scenes.MainMenuScene;

public class Main extends CoreFW {

    public SceneFW getStartScene() {
        LoaderAssets loaderAssets = new LoaderAssets(this, this.getGraphics());
        return new MainMenuScene(this);
    }
}