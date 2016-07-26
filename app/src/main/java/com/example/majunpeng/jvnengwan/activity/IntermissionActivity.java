package com.example.majunpeng.jvnengwan.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.majunpeng.jvnengwan.R;

import java.util.Timer;
import java.util.TimerTask;

public class IntermissionActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermission);
        sharedPreferences = getSharedPreferences("jumpCode", MODE_PRIVATE);
        jumpActivity();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private void jumpActivity() {
        new Timer().schedule(new TimerTask() {


            @Override
            public void run() {
                Intent intent = null;
                if (sharedPreferences.getInt("jumpKey", -1) == 1) {
                    intent = new Intent(IntermissionActivity.this, MainActivity
                            .class);
                    startActivity(intent);

                } else {
                    intent = new Intent(IntermissionActivity.this, WelcomeActivity
                            .class);
                    startActivity(intent);
                }

                finish();

            }
        }, 2000);



    }
}
