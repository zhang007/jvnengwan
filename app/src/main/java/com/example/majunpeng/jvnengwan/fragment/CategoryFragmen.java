package com.example.majunpeng.jvnengwan.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.activity.L_LolActivity;
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
    private List<LmainInfo.DataListBean> data;
    private GridView l_gridView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private L_MyAdapter adapter;
    private OkHttpUtils okHttpUtils;
    public CategoryFragmen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        okHttpUtils = new OkHttpUtils();
        okHttpUtils.getString("http://zhibo.sogou.com/gamelivedata?sysVer=4.4.2&pageSize=100&appVer=301&type=json&pageNo=1", this);
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        init(view);
        data = new ArrayList<>();

        return view;
    }

    private void init(View view) {
        l_gridView = ((GridView) view.findViewById(R.id.l_gridView));
        swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.l_swipeLayout);
    }

    //接口回调
    @Override
    public void get(String str) {
        josn = str;
        Gson gson = new Gson();
        LmainInfo lmainInfo = gson.fromJson(josn, LmainInfo.class);
        data = lmainInfo.getData_list();
         adapter = new L_MyAdapter(getActivity());
        adapter.addData(data);
        l_gridView.setAdapter(adapter);
        l_gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), L_LolActivity.class));
            }
        });

        adapter.notifyDataSetChanged();
        //关闭刷新
        swipeRefreshLayout.setRefreshing(false);
        initSwipe();
    }
//刷新方法
    private void initSwipe() {
        //设置进度背景颜色
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        //设置进度的动画颜色
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE,Color.YELLOW,Color.RED,Color.GREEN);
        //设置大小SwipeRefreshLayout.LARGE  SwipeRefreshLayout.DEFAULT
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        //向下滑动多少 px  swipeRefreshLayout才展示出来
        swipeRefreshLayout.setDistanceToTriggerSync(50);
        //滑动监听
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                okHttpUtils.getString("http://zhibo.sogou.com/gamelivedata?sysVer=4.4.2&pageSize=100&appVer=301&type=json&pageNo=1", CategoryFragmen.this);
              adapter.notifyDataSetChanged();
                //判断是否正在刷新
                if(swipeRefreshLayout.isRefreshing()){
                    //关闭刷新
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });
    }
}
