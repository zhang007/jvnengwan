package com.example.majunpeng.jvnengwan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.adapter.L_MyAdapter;
import com.example.majunpeng.jvnengwan.bean.LmainInfo;
import com.example.majunpeng.jvnengwan.httputils.OkHttpUtils;
import com.example.majunpeng.jvnengwan.interface1.OnLStringClick;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragmen extends Fragment implements OnLStringClick {
private String josn;
private List<LmainInfo.DataListBean>data;
    private GridView l_gridView;

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
        View view= inflater.inflate(R.layout.fragment_category, container, false);
        init(view);
        data=new ArrayList<>();
        return view;
    }

    private void init(View view) {
        l_gridView = ((GridView) view.findViewById(R.id.l_gridView));
    }

    //接口回调
    @Override
    public void get(String str) {
    josn=str;
        Gson gson=new Gson();
        LmainInfo lmainInfo=gson.fromJson(josn,LmainInfo.class);
              data = lmainInfo.getData_list();
        L_MyAdapter adapter=new L_MyAdapter(getActivity());
        adapter.addData(data);
        l_gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
