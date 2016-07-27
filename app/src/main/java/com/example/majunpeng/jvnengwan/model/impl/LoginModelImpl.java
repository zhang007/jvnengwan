package com.example.majunpeng.jvnengwan.model.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.majunpeng.jvnengwan.bean.User;
import com.example.majunpeng.jvnengwan.model.LoginModel;
import com.example.majunpeng.jvnengwan.model.listener.OnLoginListener;
import com.example.majunpeng.jvnengwan.utils.PersonDAO;

import java.util.Date;

public class LoginModelImpl implements LoginModel {

    @Override
    public void getRegisterState(User user, OnLoginListener listener, Context
            context) {

        PersonDAO dao = new PersonDAO(context);
        String name = user.getName();
        String pwd = user.getPwd();

        Cursor cursor = dao.query("user", new String[]{"userName"}, "userName=?",
                new String[]{name}, null, null, null);
        if (cursor.moveToNext()) {
            listener.loginFailure("注册失败，该用户名已被注册");
        } else {
            ContentValues values = new ContentValues();
            values.put("userName", name);
            values.put("pwd", pwd);
            values.put("loginCode", "0");
            values.put("loginTime", "0");
            long n = dao.insert("user", null, values);
            if (n > 0) {
                listener.loginSuccess();
            } else {
                listener.loginFailure("网络异常,注册失败");
            }

        }


    }

    @Override
    public void getLoginState(User user, OnLoginListener listener, Context context) {


        // TODO: 2016/7/26 登录查询
        PersonDAO dao = new PersonDAO(context);
        String name = user.getName();
        String pwd = user.getPwd();


        Cursor cursor = dao.query("user", null, "userName=?", new String[]{name},
                null, null, null);
        if (cursor.moveToNext()) {
            String pwd1 = cursor.getString(cursor.getColumnIndex("pwd"));
            if (pwd.equals(pwd1)) {
                listener.loginSuccess();
                ContentValues values = new ContentValues();
                values.put("loginCode", "1");
                String s = new Date().toString();
                Log.i("TAG", "==getLoginState: " + s);

                dao.update("user", values, "userName=?", new String[]{name});
                Cursor cursor1 = dao.query("user", null, "userName=?", new
                        String[]{name},
                        null, null, null);
                String loginCode = cursor.getString(cursor.getColumnIndex
                        ("loginCode"));

                Log.i("TAG", "==loginCode: " + loginCode);


            } else {
                listener.loginFailure("密码错误");
            }

        } else {
            listener.loginFailure("用户不存在");

        }


    }


}
