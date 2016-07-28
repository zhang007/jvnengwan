package com.example.majunpeng.jvnengwan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.majunpeng.jvnengwan.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class PlayVidioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_vidio);
        JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.videoplayer_playVideo);
        jcVideoPlayerStandard.setUp("http://2449.vod.myqcloud.com/2449_bfbbfa3cea8f11e5aac3db03cda99974.f20.mp4"
                , "嫂子想我没");
//        jcVideoPlayerStandard.thumbImageView();
    }
}
