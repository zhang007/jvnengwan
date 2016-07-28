package com.example.majunpeng.jvnengwan.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.majunpeng.jvnengwan.activity.MyApp;
import com.example.majunpeng.jvnengwan.model.LoadDataModel;
import com.example.majunpeng.jvnengwan.model.listener.OnLoadDataListener;

/**
 * Created by zhangfan on 2016/7/27.
 */
public class LoadDataModelImpl implements LoadDataModel, Response.ErrorListener,
        Response.Listener<String> {
    private OnLoadDataListener listener;

    private Object bean;

    @Override
    public void getData(String url, OnLoadDataListener listener) {

        this.listener = listener;

        StringRequest request = new StringRequest(StringRequest.Method.GET, url,
                this, this);

        request.setTag("cancel");

        MyApp.queue.add(request);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        listener.getDataForGson(false, error.toString());

    }

    @Override
    public void onResponse(String response) {

        listener.getDataForGson(true, response);
        MyApp.queue.cancelAll("cancel");


    }
}
