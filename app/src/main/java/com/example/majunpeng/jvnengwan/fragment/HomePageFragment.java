package com.example.majunpeng.jvnengwan.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.activity.MyApp;
import com.example.majunpeng.jvnengwan.adapter.ListViewAdapter_HomePager;
import com.example.majunpeng.jvnengwan.adapter.ViewPagerAdapter_header;
import com.example.majunpeng.jvnengwan.bean.HomePageData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomePageFragment extends Fragment {
    private ListView mListView;
    private View headerView;
    private ViewPager viewPager_header;
    private ImageView[] dots = new ImageView[5];
    private LinearLayout linearLayout_dot;
    private List<Fragment> fragments;
    private HomePageData homePageData;
    private List<HomePageData.DataBean>data;
    private List<HomePageData.DataBean.DynamicProjectListsBean> content_header;
    private String path = "http://appserver.jnwtv.com:8080/jnwtv-client/project/gethomepageinfo";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        data=new ArrayList<>();
        initView(view);


        //下载数据
        OkhttpDownLoad();


        return view;
    }

    private void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.homePage_ListView);
    }

    //添加ListView 的头布局
    private void addHeaderView() {
        //创建他的headView的布局文件
        headerView = LayoutInflater.from(getActivity()).inflate(R.layout
                .headerview_homepage, mListView, false);
        //headerView中是一个ViewPager
        viewPager_header = (ViewPager) headerView.findViewById(R.id.viewPager_homePager);
        //取消预加载  ！！！没有效果  因为底层DEFAULT_OFFSCREEN_PAGES =1，默认加载一张
        //解决方案重写 把DEFAULT_OFFSCREEN_PAGES 值改成0
        viewPager_header.setOffscreenPageLimit(3);
        //获得点
        linearLayout_dot = (LinearLayout) headerView.findViewById(R.id
                .linearLayout_dot);
        //创建ViewPager所需的Fragment
        initViewPagerFragment();
        //创建ViewPager的适配器
        ViewPagerAdapter_header adapter_header = new ViewPagerAdapter_header
                (getActivity().getSupportFragmentManager(), fragments);
        Log.i("TAG", "===DDDDDDDDDDDDDDDD" + fragments.size() + "");
        viewPager_header.setAdapter(adapter_header);
        mListView.addHeaderView(headerView);

        ListViewAdapter_HomePager adapter=new ListViewAdapter_HomePager(getActivity(),data);
        mListView.setAdapter(adapter);
        //initDot初始化小点
//        initDot();
    }

    //初始化ViewPager的Fragment
    private void initViewPagerFragment() {
        fragments = new ArrayList<>();
        //判断头是否有内容
        if (content_header != null) {
            for (int i = 0; i < content_header.size(); i++) {
                Fragment mjFragment = new HeaderViewPagerFragment();
                Bundle bundle = new Bundle();
                String imageUrl = content_header.get(i).getProjectCoverUrl();
                Log.i("BBBBBBBBB", imageUrl);
                bundle.putString("url", imageUrl);
                mjFragment.setArguments(bundle);
                fragments.add(mjFragment);
            }
        }
    }

    //初始化小点
    private void initDot() {

        for (int i = 0; i < fragments.size(); i++) {

            View childAt = linearLayout_dot.getChildAt(i);

            dots[i] = (ImageView) linearLayout_dot.getChildAt(i);
            dots[i].setSelected(false);
            dots[i].setTag(i);
            dots[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    viewPager_header.setCurrentItem((Integer) v.getTag());

                }
            });

        }
        dots[0].setSelected(true);
    }

    //下载数据
    private void OkhttpDownLoad() {
        //=======================================
        //Volley下载数据
        // 2.POST请求参数


        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, path,
                new com.android.volley.Response
                        .Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        homePageData = gson.fromJson(response, HomePageData.class);
                        data.add(homePageData.getData());
                        Log.i("AAAAAAAAAA", response);
                        content_header = homePageData.getData().getDynamicProjectLists();
                        Log.i("AAAAAAAAAA", content_header.size() + "");
                        addHeaderView();
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("aaa", "onErrorResponse:====>失败 ");
            }
        }) {
            // 携带参数
            @Override
            protected HashMap<String, String> getParams()
                    throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("account", "18593910685");
                hashMap.put("token", "2016072520215246457658992033856018593910685");
                return hashMap;
            }
        };
        //给请求设置取消标记
        stringRequest.setTag("qx");
        ((MyApp) getActivity().getApplication()).queue.add(stringRequest);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //5,取消请求
        MyApp.getQueue().cancelAll("qx");
    }
}
