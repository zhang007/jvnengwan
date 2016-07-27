package com.example.majunpeng.jvnengwan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.majunpeng.jvnengwan.R;

public class AuthorTimeActivity extends AppCompatActivity {

    private ListView listView_video_Vitamio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_time);
        initView();
    }

    private void initView() {
        listView_video_Vitamio = (ListView) findViewById(R.id
                .listView_video_Vitamio);
    }
}
