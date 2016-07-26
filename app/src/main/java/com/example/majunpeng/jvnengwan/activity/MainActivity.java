package com.example.majunpeng.jvnengwan.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.fragment.AuthorListFragment;
import com.example.majunpeng.jvnengwan.fragment.CategoryFragmen;
import com.example.majunpeng.jvnengwan.fragment.HomePageFragment;
import com.example.majunpeng.jvnengwan.fragment.MyAccountFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> fragmentList = null;
    private ImageView iv_homePage_mainActivity;
    private TextView tv_homePage_mainActivity;
    private ImageView iv_category_mainActivity;
    private TextView tv_category_mainActivity;
    private ImageView iv_author_mainActivity;
    private TextView tv_author_mainActivity;
    private ImageView iv_myAccount_mainActivity;
    private TextView tv_myAccount_mainActivity;
    private HomePageFragment homePageFragment;
    private CategoryFragmen categoryFragmen;
    private AuthorListFragment authorListFragment;
    private MyAccountFragment myAccountFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        createFragment();
        addFragment();
        hideFragment();

        fragmentManager.beginTransaction().show(homePageFragment).commit();
        iv_homePage_mainActivity.setImageResource(R.mipmap
                .navigation_bar_home_selected);
        tv_homePage_mainActivity.setTextColor(Color.RED);
    }


    public void hideFragment() {
        for (int i = 0; i < fragmentList.size(); i++) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.hide(fragmentList.get(i));
            transaction.commit();
        }
    }

    //加载所用的fragment;
    private void addFragment() {

        fragmentManager = getSupportFragmentManager();

        for (int i = 0; i < fragmentList.size(); i++) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.fragmentLayout_Homepage, fragmentList.get(i));
            transaction.commit();
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.show(homePageFragment).commit();

    }

    private void createFragment() {

        fragmentList = new ArrayList<>();
        homePageFragment = new HomePageFragment();
        fragmentList.add(homePageFragment);

        categoryFragmen = new CategoryFragmen();
        fragmentList.add(categoryFragmen);

        authorListFragment = new AuthorListFragment();
        fragmentList.add(authorListFragment);

        myAccountFragment = new MyAccountFragment();
        fragmentList.add(myAccountFragment);


    }

    private void initView() {


        iv_homePage_mainActivity = (ImageView) findViewById(R.id
                .iv_homePage_mainActivity);

        tv_homePage_mainActivity = (TextView) findViewById(R.id
                .tv_homePage_mainActivity);

        iv_category_mainActivity = (ImageView) findViewById(R.id
                .iv_category_mainActivity);

        tv_category_mainActivity = (TextView) findViewById(R.id
                .tv_category_mainActivity);

        iv_author_mainActivity = (ImageView) findViewById(R.id
                .iv_authorList_mainActivity);

        tv_author_mainActivity = (TextView) findViewById(R.id
                .tv_authorList_mainActivity);

        iv_myAccount_mainActivity = (ImageView) findViewById(R.id
                .iv_myAccount_mainActivity);

        tv_myAccount_mainActivity = (TextView) findViewById(R.id
                .tv_myAccount_mainActivity);

    }


    public void changeIconState() {
        iv_homePage_mainActivity.setImageResource(R.mipmap
                .navigation_bar_home_normal);
        iv_category_mainActivity.setImageResource(R.mipmap
                .navigation_bar_gamelist_normal);
        iv_author_mainActivity.setImageResource(R.mipmap
                .navigation_bar_anchorlist_normal);
        iv_myAccount_mainActivity.setImageResource(R.mipmap
                .navigation_bar_my_normal);

        tv_homePage_mainActivity.setTextColor(Color.rgb(176, 176, 176));
        tv_category_mainActivity.setTextColor(Color.rgb(176, 176, 176));
        tv_author_mainActivity.setTextColor(Color.rgb(176, 176, 176));
        tv_myAccount_mainActivity.setTextColor(Color.rgb(176, 176, 176));


    }


    public void showFragmentClick(View view) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (view.getId()) {
            case R.id.linearLayout_homePage_mainActivity:
                hideFragment();
                changeIconState();
                transaction.show(homePageFragment);
                iv_homePage_mainActivity.setImageResource(R.mipmap
                        .navigation_bar_home_selected);
                tv_homePage_mainActivity.setTextColor(Color.RED);

                break;
            case R.id.linearLayout_category_mainActivity:
                changeIconState();
                hideFragment();
                transaction.show(categoryFragmen);
                iv_category_mainActivity.setImageResource(R.mipmap
                        .navigation_bar_gamelist_selected);
                tv_category_mainActivity.setTextColor(Color.RED);

                break;
            case R.id.linearLayout_authorList_mainActivity:
                changeIconState();
                hideFragment();
                transaction.show(authorListFragment);
                iv_author_mainActivity.setImageResource(R.mipmap
                        .navigation_bar_anchorlist_selected);
                tv_author_mainActivity.setTextColor(Color.RED);

                break;
            case R.id.linearLayout_myAccount_mainActivity:
                changeIconState();
                hideFragment();
                transaction.show(myAccountFragment);
                iv_myAccount_mainActivity.setImageResource(R.mipmap
                        .navigation_bar_my_selected);
                tv_myAccount_mainActivity.setTextColor(Color.RED);

                break;

        }

        transaction.commit();


    }
}
