package com.example.majunpeng.jvnengwan.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.adapter.L_VidioAdapter;
import com.example.majunpeng.jvnengwan.bean.LvidioInfo;
import com.example.majunpeng.jvnengwan.httputils.OkHttpUtils;
import com.example.majunpeng.jvnengwan.interface1.OnLStringClick;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class L_shiPin extends Fragment implements OnLStringClick {
    private OkHttpUtils okHttpUtils;
    private List<LvidioInfo.VideosBean.GameinfoBean> data;
    private ListView l_listView;
    private RelativeLayout l_relative_jieshuo;
    private String josn;
    private L_VidioAdapter adapter;
    private SwipeRefreshLayout swipe;


    public L_shiPin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_l_shi_pin, container, false);
        okHttpUtils = new OkHttpUtils();
        okHttpUtils.getString("http://zhibo.sogou.com/searchgame?sysVer=4.4." +
                "2&product=video_search&f=0&appVer=301&resulttype=json&req_" +
                "from=app&sp=jsid%3A0%3Bgamename%3A%E8%8B%B1%E9%9B%84%E8%81%94%E7" +
                "%9B%9F%3BpageNo%3A1%3BpageSize%3A100%3B&query=%E8%8B%B1%E9%9B%84%E8" +
                "%81%94%E7%9B%9F&requesttype=all", this);
        init(view);
        data = new ArrayList<>();
        return view;
    }

    private void init(View view) {
        l_listView = ((ListView) view.findViewById(R.id.l_listView));
        l_relative_jieshuo = ((RelativeLayout) view.findViewById(R.id.l_relative_jieShuo));
        swipe = ((SwipeRefreshLayout) view.findViewById(R.id.l_swipeViewpager));
    }

    @Override
    public void get(String str) {
        josn = str;
        Gson gson = new Gson();
        LvidioInfo lvidoInfo = gson.fromJson(josn, LvidioInfo.class);
        data = lvidoInfo.getVideos().getGameinfo();
        adapter = new L_VidioAdapter(getActivity(), data);

        l_listView.setAdapter(adapter);
        //关闭刷新
        swipe.setRefreshing(false);
        initSwipe();
        // swipeRefreshLayout.setRefreshing(false);
        // initSwipe();
    }

    private void initSwipe() {
        //设置进度背景颜色
        swipe.setProgressBackgroundColorSchemeColor(Color.WHITE);
        //设置进度的动画颜色
        swipe.setColorSchemeColors(Color.BLUE,Color.YELLOW,Color.RED,Color.GREEN);
        //设置大小SwipeRefreshLayout.LARGE  SwipeRefreshLayout.DEFAULT
        swipe.setSize(SwipeRefreshLayout.DEFAULT);
        //向下滑动多少 px  swipeRefreshLayout才展示出来
        swipe.setDistanceToTriggerSync(50);
        //滑动监听
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                okHttpUtils.getString("http://zhibo.sogou.com/searchgame?sysVer=4.4." +
                        "2&product=video_search&f=0&appVer=301&resulttype=json&req_" +
                        "from=app&sp=jsid%3A0%3Bgamename%3A%E8%8B%B1%E9%9B%84%E8%81%94%E7" +
                        "%9B%9F%3BpageNo%3A1%3BpageSize%3A100%3B&query=%E8%8B%B1%E9%9B%84%E8" +
                        "%81%94%E7%9B%9F&requesttype=all", L_shiPin.this);
                adapter.notifyDataSetChanged();
                //判断是否正在刷新
                if(swipe.isRefreshing()){
                    //关闭刷新
                    swipe.setRefreshing(false);
                }
            }
        });
    }
}
