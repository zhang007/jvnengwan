package com.example.majunpeng.jvnengwan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.majunpeng.jvnengwan.R;

public class LiveVideoWebViewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_video);
        webView = (WebView) findViewById(R.id.webView_zhangfan);
        String url = getIntent().getStringExtra("url");
        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return true;
            }
        });


        //设置自适应屏幕
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);//设置此属性，可任意比例缩放
        settings.setLoadWithOverviewMode(true);
    }
}
