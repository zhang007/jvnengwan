package com.example.majunpeng.jvnengwan.activity;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by majunpeng on 2016/7/27.
 */
public class MyApp extends Application{
    public static RequestQueue queue;
    @Override
    public void onCreate() {
        super.onCreate();
        queue= Volley.newRequestQueue(getApplicationContext());
    }
    public static RequestQueue getQueue(){

        return queue;
    }
}
