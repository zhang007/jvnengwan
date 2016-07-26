package com.example.majunpeng.jvnengwan.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.activity.MainActivity;

/**
 * 欢迎页面的Fragment
 */
public class WelcomFragment extends Fragment {

    private ImageView iv_background;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcom, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id
                .iv_backGround_welcome);

        iv_background = ((ImageView) view.findViewById(R.id.iv_backGround_welcome));
        int page = getArguments().getInt("page", -1);
        switch (page) {
            case 0:
                iv_background.setImageResource(R.mipmap.guide1);

                break;
            case 1:
                iv_background.setImageResource(R.mipmap.guide2);
                break;
            case 2:
                iv_background.setImageResource(R.mipmap.guide3);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                break;
        }


        return view;
    }

}
