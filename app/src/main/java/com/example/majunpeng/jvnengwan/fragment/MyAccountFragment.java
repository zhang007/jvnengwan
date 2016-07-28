package com.example.majunpeng.jvnengwan.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.activity.AuthorTimeActivity;
import com.example.majunpeng.jvnengwan.activity.LoginActivity;
import com.example.majunpeng.jvnengwan.activity.MyLiveActivity;


public class MyAccountFragment extends Fragment implements View.OnClickListener {

    private ImageView iv_login_account;
    private LinearLayout linearLayout_authorTime_Account;
    private LinearLayout linearLayout_myAttention_Account;
    private LinearLayout linearLayout_authorOrder_Account;
    private LinearLayout linearLayout_offLineVideo_account;
    private LinearLayout linearLayout_myCollection_account;
    private LinearLayout linearLayout_watchingHistory_account;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_account, container,
                false);

        initView(view);

        return view;
    }

    private void initView(View view) {

        iv_login_account = (ImageView) view.findViewById(R.id.iv_login_account);
        iv_login_account.setOnClickListener(this);

        linearLayout_authorTime_Account = (LinearLayout) view.findViewById(R.id
                .linearLayout_authorTime_Account);
        linearLayout_authorTime_Account.setOnClickListener(this);

        linearLayout_myAttention_Account = (LinearLayout) view.findViewById(R.id
                .linearLayout_myAttention_Account);
        linearLayout_myAttention_Account.setOnClickListener(this);

        linearLayout_authorOrder_Account = (LinearLayout) view.findViewById(R.id
                .linearLayout_authorOrder_Account);
        linearLayout_authorOrder_Account.setOnClickListener(this);

        linearLayout_offLineVideo_account = (LinearLayout) view.findViewById(R.id
                .linearLayout_offLineVideo_account);
        linearLayout_offLineVideo_account.setOnClickListener(this);

        linearLayout_myCollection_account = (LinearLayout) view.findViewById(R.id
                .linearLayout_myCollection_account);
        linearLayout_myCollection_account.setOnClickListener(this);

        linearLayout_watchingHistory_account = (LinearLayout) view.findViewById(R
                .id.linearLayout_watchingHistory_account);
        linearLayout_watchingHistory_account.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.iv_login_account:
                intent = new Intent(getActivity(), LoginActivity.class);

                break;
            case R.id.linearLayout_authorTime_Account:
                intent = new Intent(getActivity(), AuthorTimeActivity.class);

                break;
            case R.id.linearLayout_myAttention_Account:
                intent = new Intent(getActivity(),MyLiveActivity.class);

                break;
            case R.id.linearLayout_authorOrder_Account:
                break;
            case R.id.linearLayout_offLineVideo_account:
                break;
            case R.id.linearLayout_myCollection_account:
                break;
            case R.id.linearLayout_watchingHistory_account:
                break;
        }


        startActivity(intent);
    }



}
