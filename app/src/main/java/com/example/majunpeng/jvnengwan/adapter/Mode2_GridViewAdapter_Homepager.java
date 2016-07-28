package com.example.majunpeng.jvnengwan.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.bean.HomePageData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by majunpeng on 2016/7/27.
 */
public class Mode2_GridViewAdapter_Homepager extends BaseAdapter{
    private Context context;
    private List<HomePageData.DataBean.CrowdfundingProjectListsBean> data;
    private ImageLoader imageLoader;
    public Mode2_GridViewAdapter_Homepager(Context context, List<HomePageData.DataBean.CrowdfundingProjectListsBean> data) {
        this.context = context;
        this.data = data;
        Log.i("tag", "data============== "+data.size()+"");
    }

    //填充数据
    public void addDatas(List<HomePageData.DataBean.CrowdfundingProjectListsBean> list) {
        data.addAll(list);
        notifyDataSetChanged();
    }

    //清除数据
    public void clearData() {
        data.clear();
        notifyDataSetChanged();
    }

    public void setData(List<HomePageData.DataBean.CrowdfundingProjectListsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder =null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_mjgridview2,null);
            viewHolder =  new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //设置数据
        HomePageData.DataBean.CrowdfundingProjectListsBean categoryData = (HomePageData.DataBean.CrowdfundingProjectListsBean) getItem(position);
        if(categoryData.getProjectName()!=null){
            viewHolder.tv.setText(categoryData.getProjectName());
            Log.i("Tag", "============== "+categoryData.getProjectName());
        }
        Log.i("Tag", "============== "+categoryData.getCrowdfundingProjectCoverUrl());
        Picasso.with(context)
                .load(categoryData.getCrowdfundingProjectCoverUrl())
                .config(Bitmap.Config.RGB_565)
                .into(viewHolder.imageView);
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView tv;

        public ViewHolder(View convertView) {
            imageView = (ImageView) convertView.findViewById(R.id.mode2_gridview_ImageView);
            tv = (TextView) convertView.findViewById(R.id.mode2_gridview_shopName);
        }
    }
}
