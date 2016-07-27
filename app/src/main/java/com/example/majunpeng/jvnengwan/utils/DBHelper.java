package com.example.majunpeng.jvnengwan.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static String NAME = "user.db";
    private static int DB_VERSION = 1;

    public DBHelper(Context context) {

        super(context, NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table user(_id Integer primary key autoincrement,"
                + "userName varchar(16),pwd varchar(16),loginCode varchar," +
                "loginTime varchar(32))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
