package com.example.gear2d;

public class LoaderAssetsMusic {
    public MusicFW gameMusic;

    public LoaderAssetsMusic(CoreFW coreFW, String fileName) {
        loadAudio(coreFW, fileName);
    }

    private void loadAudio(CoreFW coreFW, String fileName) {
        gameMusic = coreFW.getAudioFW().newMusic(fileName);
    }
}
