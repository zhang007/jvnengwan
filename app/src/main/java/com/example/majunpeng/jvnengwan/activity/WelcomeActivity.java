package com.example.majunpeng.jvnengwan.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.adapter.ViewPagerAdapter_Welcome;
import com.example.majunpeng.jvnengwan.fragment.WelcomFragment;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<Fragment> fragments;
    private ViewPagerAdapter_Welcome mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        setSharePreference();

        initView();
        initFragment();
        mViewPagerAdapter = new ViewPagerAdapter_Welcome(getSupportFragmentManager
                (), fragments);
        viewPager.setOffscreenPageLimit(0);
        viewPager.setAdapter(mViewPagerAdapter);


    }

    private void setSharePreference() {
        SharedPreferences preferences = getSharedPreferences("jumpCode",
                MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putInt("jumpKey", 1);
        edit.commit();


    }

    private void initFragment() {
        Fragment fragment = null;
        fragments = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            fragment = new WelcomFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("page", i);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager_welcome);
    }
}
