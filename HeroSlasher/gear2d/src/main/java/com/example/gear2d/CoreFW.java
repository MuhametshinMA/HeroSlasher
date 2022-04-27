package com.example.gear2d;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CoreFW extends AppCompatActivity {

    private final float FRAME_BUFFER_WIDTH = 800;
    private final float FRAME_BUFFER_HEIGHT = 600;

    private LoopFW loopFW;
    private GraphicsFW graphicsFW;
    private TouchListener touchListener;

    private AudioFW audioFW;
    private Display display;
    private Point sizeDisplay;
    private Bitmap frameBuffer;
    private SceneFW sceneFW;
    private float sceneWidth;
    private float sceneHeight;

    private boolean stateOnPause;
    private boolean stateOnResume;
    private SharedPreferences sharedPreferences;
    private boolean isPressedKeyBack;

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    private final String SETTINGS = "settings";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(SETTINGS, MODE_PRIVATE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        sizeDisplay = new Point();
        display = getWindowManager().getDefaultDisplay();
        display.getSize(sizeDisplay);
        frameBuffer = Bitmap.createBitmap((int)FRAME_BUFFER_WIDTH, (int)FRAME_BUFFER_HEIGHT,Bitmap.Config.ARGB_8888);
        sceneWidth = FRAME_BUFFER_WIDTH/sizeDisplay.x;
        sceneHeight = FRAME_BUFFER_HEIGHT/sizeDisplay.y;

        audioFW = new AudioFW(this);
        loopFW = new LoopFW(this, frameBuffer);
        graphicsFW = new GraphicsFW(getAssets(),frameBuffer);
        touchListener = new TouchListener(loopFW, sceneWidth, sceneHeight);

        sceneFW = getStartScene();

        stateOnPause = false;
        stateOnResume = false;
        isPressedKeyBack = false;
        setContentView(loopFW);
    }

    public CoreFW() {
    }

    public AudioFW getAudioFW() {
        return audioFW;
    }

    public void onResume() {
        super.onResume();
        sceneFW.resume();
        loopFW.startGame();
    }
    public void onPause() {
        super.onPause();
        sceneFW.pause();
        loopFW.stopGame();
        stateOnPause = true;
        if (isFinishing()) {
            sceneFW.dispose();
        }
    }
    public GraphicsFW getGraphics() {
        return graphicsFW;
    }
    public TouchListener getTouchListener() {
        return touchListener;
    }
    public void setScene(SceneFW sceneFW) {
        if (sceneFW == null) {
            throw new IllegalArgumentException("can't upload scene");
        }
        this.sceneFW.pause();
        this.sceneFW.dispose();
        sceneFW.resume();
        sceneFW.update();
        this.sceneFW = sceneFW;
    }

    public SceneFW getCurrentScene() {
        return sceneFW;
    }
    public SceneFW getStartScene() {
        return sceneFW;
    }

    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            isPressedKeyBack = true;
            return true;
        }
        return false;
    }

    public boolean isPressedKeyBack() {
        return isPressedKeyBack;
    }

    public void setPressedKeyBack(boolean pressedKeyBack) {
        isPressedKeyBack = pressedKeyBack;
    }
}
