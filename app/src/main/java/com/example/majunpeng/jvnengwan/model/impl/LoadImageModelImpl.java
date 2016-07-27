package com.example.majunpeng.jvnengwan.model.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.majunpeng.jvnengwan.model.LoadImageModel;
import com.squareup.picasso.Picasso;

/**
 * Created by zhangfan on 2016/7/27.
 */
public class LoadImageModelImpl implements LoadImageModel {
    @Override
    public void loadImage(String uri, Context context, ImageView imageView) {


        Picasso.with(context).load(uri).config(Bitmap.Config.RGB_565).into
                (imageView);

    }
}
