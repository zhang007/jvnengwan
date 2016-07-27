package com.example.majunpeng.jvnengwan.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.majunpeng.jvnengwan.bean.User;
import com.example.majunpeng.jvnengwan.utils.PersonDAO;

/**
 * Created by zhangfan on 2016/7/26.
 */
public class LoginModelImpl implements LoginModel {


    @Override
    public void getLoginState(User user, OnLoginListener listener, Context context) {

        String name = user.getName();
        String pwd = user.getPwd();
        PersonDAO dao = new PersonDAO(context);
        if (user.isRegister()) {
            Cursor cursor = dao.query("user", new String[]{"userName"}, "where " +
                    "userName=?", new String[]{name}, null, null, null);
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

        } else {
            // TODO: 2016/7/26 登录查询


        }


    }
}
