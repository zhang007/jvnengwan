package com.example.majunpeng.jvnengwan.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.majunpeng.jvnengwan.R;
import com.squareup.picasso.Picasso;

/**
 * Created by majunpeng on 2016/7/26.
 */
public class HeaderViewPagerFragment extends Fragment{
    private View view;
    private ImageView iv_headerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_header_view_pager, container,
                false);

        iv_headerView = (ImageView) view.findViewById(R.id
                .iv_headerViewPagerFragment);

        String imageUrl = getArguments().getString("url");
        Log.i("CCCCCCCCCCCCCC", imageUrl);

        if (imageUrl != null) {
            Picasso.with(getActivity())
                    .load(imageUrl)
                    .config(Bitmap.Config.RGB_565)
                    .into(iv_headerView);
        }
        return view;
    }
}
