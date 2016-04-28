package com.example.HelloMoon;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by Elkin on 27.04.2016.
 */
public class HelloMoonFragment extends Fragment {
    private Button mPlayButton;
    private Button mStopButton;
    private Button mPauseButton;
    private VideoView mVideoView;
    private AudioPlayer mPlayer = new AudioPlayer();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);

        mVideoView = (VideoView) v.findViewById(R.id.hellomoon_VideoView);
//        String resourceUri = "G:/Programming/HelloMoon_git/res/raw/apollo17_stroll.mpg";
        mVideoView.setVideoURI(Uri.parse("android.resource://" + "com.example.HelloMoon" +"/"+R.raw.apollo_17_stroll));
        mVideoView.setMediaController(new MediaController(getActivity()));
        mVideoView.requestFocus(0);

        mVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                mVideoView.setVideoURI(resourceUri);
                mVideoView.start();
            }
        });

        mPlayButton = (Button) v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "play", Toast.LENGTH_LONG);
                mPlayer.play(getActivity());
            }
        });

        mPauseButton = (Button) v.findViewById(R.id.hellomoon_pauseButton);
        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "pause", Toast.LENGTH_LONG);
                mPlayer.pause();
            }
        });

        mStopButton = (Button) v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "stop", Toast.LENGTH_SHORT);
                mPlayer.stop();
            }
        });
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
