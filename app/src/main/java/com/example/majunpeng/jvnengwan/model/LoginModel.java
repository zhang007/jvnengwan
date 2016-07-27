package com.example.majunpeng.jvnengwan.model;

import android.content.Context;

import com.example.majunpeng.jvnengwan.bean.User;

public interface LoginModel {

    void getLoginState(User user, OnLoginListener listener, Context context);

}
