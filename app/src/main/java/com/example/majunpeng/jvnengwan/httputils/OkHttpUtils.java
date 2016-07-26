package com.example.majunpeng.jvnengwan.httputils;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ASUS on 2016/7/26.
 */
public class OkHttpUtils {

    public String getString(){
        String str=null;
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url("http://zhibo.sogou.com/gamelivedata?sysVer=4.4.2&pageSize=100&appVer=301&type=json&pageNo=1")
                .addHeader("User-Agent", "Apache-HttpClient/UNAVAILABLE (java 1.4)").build();
        //变成一个Call任务
        Call call=okHttpClient.newCall(request);
        //get请求的异步执行
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response!=null){
                    Log.e("AAA","==Thread===="+Thread.currentThread().getName());
                    Log.e("AAA","==请求码=="+response.code());
                    Log.e("AAA","==请求成功的信息=="+response.message());
                    Log.e("AAA","==请求成功的字符串=="+response.body().string());
                }
            }
        });
        return str;
    }

}
