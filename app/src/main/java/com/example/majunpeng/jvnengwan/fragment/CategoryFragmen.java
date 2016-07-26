package com.example.majunpeng.jvnengwan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.httputils.OkHttpUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragmen extends Fragment {


    public CategoryFragmen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        OkHttpUtils okHttpUtils=new OkHttpUtils();
        okHttpUtils.getString();
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

}
