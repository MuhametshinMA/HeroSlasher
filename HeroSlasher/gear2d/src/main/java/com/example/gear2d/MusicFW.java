package com.example.gear2d;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

public class MusicFW implements MediaPlayer.OnCompletionListener {

    MediaPlayer mediaPlayer;
    boolean isPrepared = false;

    public MusicFW(AssetFileDescriptor assetFileDescriptor) throws IOException {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(),
                assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        mediaPlayer.prepare();
        isPrepared = true;
        mediaPlayer.setOnCompletionListener(this);
    }

    public void play(boolean looping, float volume) {
        if (mediaPlayer.isPlaying()) {
            return;
        }

        synchronized (this) {
            if (!isPrepared) {
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            mediaPlayer.setLooping(looping);
            mediaPlayer.setVolume(volume, volume);
            mediaPlayer.start();
        }
    }

    public void stop() {
        mediaPlayer.stop();
        synchronized (this) {
            isPrepared = false;
        }
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        synchronized (this) {
            isPrepared = false;
        }
    }
}
