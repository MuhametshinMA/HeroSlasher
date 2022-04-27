package com.example.gear2d;

import android.os.AsyncTask;

public class LoaderAssetSound {
    public SoundFW soundFW;
    private CoreFW coreFW;
    private String fileName;

    public SoundFW getSoundFW() {
        return soundFW;
    }

    public LoaderAssetSound(CoreFW coreFW, String fileName) {
        this.coreFW = coreFW;
        this.fileName = fileName;
        loadSound(coreFW, fileName);
    }

    private void loadSound(CoreFW coreFW, String fileName) {
        soundFW = coreFW.getAudioFW().newSound(fileName);
    }
}
