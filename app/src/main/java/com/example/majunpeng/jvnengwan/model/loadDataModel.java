package com.example.majunpeng.jvnengwan.model;

import com.example.majunpeng.jvnengwan.model.listener.OnLoadDataListener;

/**
 * Created by zhangfan on 2016/7/27.
 */
public interface LoadDataModel {

    void getData(String url, OnLoadDataListener listener);


}
