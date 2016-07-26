package com.example.majunpeng.jvnengwan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.majunpeng.jvnengwan.bean.HomePageData;

import java.util.List;

/**
 * Created by majunpeng on 2016/7/26.
 * ListView多布局的适配器
 */
public class ListViewAdapter_HomePager extends BaseAdapter{
    private LayoutInflater mInflater;

    //数据源
    private List <HomePageData> data;

    //构造方法
    public ListViewAdapter_HomePager(Context context,List <HomePageData> data){
        mInflater=LayoutInflater.from(context);
        this.data=data;
    }

    //重写的四个方法
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //创建正确的ConvertView      ConvertView复用
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {




        return convertView;
    }

    /**
     * 重写的两个方法===================================
     * @return
     */

    //该方法返回多个不同的布局
    @Override
    public int getViewTypeCount() {
        //这个是固定值
        return super.getViewTypeCount();
    }

    //该方法根据position   返回相应的Item
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    private  class ViewHolder {

    }
}
