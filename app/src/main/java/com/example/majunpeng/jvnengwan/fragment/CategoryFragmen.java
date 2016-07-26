package com.example.majunpeng.jvnengwan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.httputils.OkHttpUtils;
import com.example.majunpeng.jvnengwan.interface1.OnLStringClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragmen extends Fragment implements OnLStringClick {
String josn;

    public CategoryFragmen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        OkHttpUtils okHttpUtils=new OkHttpUtils();
      okHttpUtils.getString("http://zhibo.sogou.com/gamelivedata?sysVer=4.4.2&pageSize=100&appVer=301&type=json&pageNo=1",this);

        Log.e("AAA12",""+josn);
        return inflater.inflate(R.layout.fragment_category, container, false);
    }
//接口回调
    @Override
    public void get(String str) {
    josn=str;


    }
}
