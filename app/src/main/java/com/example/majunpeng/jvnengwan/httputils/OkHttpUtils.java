package com.example.majunpeng.jvnengwan.httputils;

import android.os.Handler;
import android.os.Message;

import com.example.majunpeng.jvnengwan.interface1.OnLStringClick;

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
    private String json1;
Handler mHandler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (msg.what==1){
           json1= (String) msg.obj;
            listener.get(json1);
        }
    }
};
    OnLStringClick listener;
    public void getString(String json, OnLStringClick listener){
        this.listener=listener;
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(json)
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

            String  str =response.body().string();
                    Message message=Message.obtain();
                    message.what=1;
                    message.obj=str;
                    mHandler.sendMessage(message);

                }
            }
        });

    }

}
