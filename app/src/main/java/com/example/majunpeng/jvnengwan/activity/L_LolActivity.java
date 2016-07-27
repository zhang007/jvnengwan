package com.example.majunpeng.jvnengwan.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.adapter.L_MypagerAdapter;
import com.example.majunpeng.jvnengwan.fragment.L_shiPin;
import com.example.majunpeng.jvnengwan.fragment.L_zhibo;

import java.util.ArrayList;
import java.util.List;

public class L_LolActivity extends FragmentActivity {

    private ImageView l_image_left;
    private TextView l_text_left;
    private ImageView l_image_right;
    private TextView l_text_right;
    private ViewPager viewPager;
    private List<Fragment>list;
    private RelativeLayout l_relative_left;
    private RelativeLayout l_relative_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l__lol);
        init();
        initFragment();
        L_MypagerAdapter adapter=new L_MypagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

               if (position==0){

                   l_image_left.setImageResource(R.mipmap.tab_left_selected);
                   l_text_left.setTextColor(Color.argb(255,253,112,84));
                   l_text_left.setText("直播");
                   l_text_right.setText("视频");
                   l_image_right.setImageResource(R.mipmap.tab_right_unselected);
                   l_text_right.setTextColor(Color.argb(255,255,255,255));
               }else{
                   l_image_left.setImageResource(R.mipmap.tab_left_unselected);
                   l_text_left.setTextColor(Color.argb(255,255,255,255));
                   l_text_left.setText("直播");
                   l_text_right.setText("视频");
                   l_image_right.setImageResource(R.mipmap.tab_right_selected);
                   l_text_right.setTextColor(Color.argb(253,253,112,84));
               }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initFragment() {
        L_zhibo zhibo=new L_zhibo();
        list.add(zhibo);
        L_shiPin shipin=new L_shiPin();
        list.add(shipin);
    }


    private void init() {
        l_image_left = ((ImageView) findViewById(R.id.l_image_left));
        l_text_left = ((TextView) findViewById(R.id.l_text_left));
        l_image_right = ((ImageView) findViewById(R.id.l_image_right));
        l_text_right = ((TextView) findViewById(R.id.l_text_right));
        viewPager= (ViewPager) findViewById(R.id.l_viewPager);
        list=new ArrayList<>();
        l_relative_left = ((RelativeLayout) findViewById(R.id.l_relative_left));
        l_relative_right = ((RelativeLayout) findViewById(R.id.l_relative_right));
    }
//直播/视频的变换监听
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.l_relative_left:
                l_image_left.setImageResource(R.mipmap.tab_left_selected);
                l_text_left.setTextColor(Color.argb(255,253,112,84));
                l_text_left.setText("直播");
                l_text_right.setText("视频");
                l_image_right.setImageResource(R.mipmap.tab_right_unselected);
                l_text_right.setTextColor(Color.argb(255,255,255,255));
                viewPager.setCurrentItem(0);
                break;
            case R.id.l_relative_right:
                l_image_left.setImageResource(R.mipmap.tab_left_unselected);
                l_text_left.setTextColor(Color.argb(255,255,255,255));
                l_text_left.setText("直播");
                l_text_right.setText("视频");
                l_image_right.setImageResource(R.mipmap.tab_right_selected);
                l_text_right.setTextColor(Color.argb(253,253,112,84));
                viewPager.setCurrentItem(1);
                break;
        }
    }
}
