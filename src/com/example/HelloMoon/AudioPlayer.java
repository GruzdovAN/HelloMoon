package com.example.HelloMoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Elkin on 27.04.2016.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;
    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
    public void pause() {
        if (mPlayer != null) {
            mPlayer.pause();
            mPlayer = null;
        }
    }
    public void play(Context context) {
        stop();
        mPlayer = MediaPlayer.create(context, R.raw.one_small_step);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
        mPlayer.start();
    }
}
