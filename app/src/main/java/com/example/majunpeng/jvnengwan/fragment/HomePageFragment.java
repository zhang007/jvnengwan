package com.example.majunpeng.jvnengwan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.bean.HomePageData;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HomePageFragment extends Fragment {
    private ListView mListView;
    private View headerView;
    private ViewPager viewPager_header;
    private ImageView[] dots = new ImageView[2];
    private LinearLayout linearLayout_dot;
    private List<Fragment> fragments;
    private HomePageData homePageData;
    private List<HomePageData.DataBean.DynamicProjectListsBean> content_header;
    private String path = "http://appserver.jnwtv.com:8080/jnwtv-client/project/gethomepageinfo";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home_page, container, false);
        mListView= (ListView) view.findViewById(R.id.homePage_ListView);

        //ListView 添加头布局


        //下载数据
        OkhttpDownLoad();

        return view;
    }
    //添加ListView 的头布局
    private void addHeaderView(){

        //创建他的headView的布局文件
        headerView=LayoutInflater.from(getActivity()).inflate(R.layout
                .headerview_homepage,mListView,false);

        //headerView中是一个ViewPager
        viewPager_header= (ViewPager) headerView.findViewById(R.id.viewPager_homePager);

        //取消预加载  ！！！没有效果  因为底层DEFAULT_OFFSCREEN_PAGES =1，默认加载一张
        //解决方案重写 把DEFAULT_OFFSCREEN_PAGES 值改成0
        viewPager_header.setOffscreenPageLimit(1);

        //获得点
        linearLayout_dot = (LinearLayout) headerView.findViewById(R.id
                .linearLayout_dot);

        //创建ViewPager所需的Fragment
        initViewPagerFragment();

        //创建ViewPager的适配器
//        ViewPagerAdapter_header adapter_header = new ViewPagerAdapter_header
//                (getActivity().getSupportFragmentManager(), fragments);
//        viewPager_header.setAdapter(adapter_header);

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
                String imageUrl=content_header.get(i).getProjectCoverUrl();

                bundle.putString("imageUrl", imageUrl);
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
        //okhttpclient下载
        OkHttpClient okHttpClient=new OkHttpClient();
        //okhttp:post请求的参数添加方法
        RequestBody requestBodyPost = new FormBody.Builder()
                .add("account", "18593910685")
                .add("token", "2016072520215246457658992033856018593910685")
                .build();
        Request request=new Request.Builder()
                .url(path)
                .post(requestBodyPost)
                .build();
        final Call call=okHttpClient.newCall(request);
        //同步执行  要自己开子线程
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Response response=call.execute();
                    if (response != null) {
                        Log.e("AAA","==请求成功的信息==="+response.message());
                        Log.e("AAA","==请求成功的字符串==="+response.body().string());

                        Gson gson = new Gson();
                        homePageData = gson.fromJson(response.body().string(), HomePageData.class);

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //要得到里面的图片地址
                                content_header=homePageData.getData().getDynamicProjectLists();
                            }
                        });




                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


}
