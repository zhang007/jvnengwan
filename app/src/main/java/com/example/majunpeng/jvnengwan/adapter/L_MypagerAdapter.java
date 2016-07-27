package com.example.majunpeng.jvnengwan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ASUS on 2016/7/27.
 */
public class L_MypagerAdapter extends FragmentPagerAdapter {
    private List<Fragment>data;
    public L_MypagerAdapter(FragmentManager fm,List<Fragment>data) {
        super(fm);
        this.data=data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
