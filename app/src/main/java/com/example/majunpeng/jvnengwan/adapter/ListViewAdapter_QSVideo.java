package com.example.majunpeng.jvnengwan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.bean.QSBaiKeBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by zhangfan on 2016/7/27.
 */
public class ListViewAdapter_QSVideo extends BaseAdapter {
    private List<QSBaiKeBean.ItemsBean> data;
    private Context context;

    public ListViewAdapter_QSVideo(List<QSBaiKeBean.ItemsBean> data, Context
            context) {
        this.data = data;
        this.context = context;
    }

    public List<QSBaiKeBean.ItemsBean> getData() {
        return data;
    }

    public void setData(List<QSBaiKeBean.ItemsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(List<QSBaiKeBean.ItemsBean> data) {
        this.data.addAll(data);
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
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout
                    .item_listview_vitamio, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }

        QSBaiKeBean.ItemsBean itemsBean = data.get(position);
        if (itemsBean != null) {
            String highUrl = itemsBean.getHigh_url();
            String title = itemsBean.getContent();
            holder.jcVideoPlayer.setUp(highUrl, title);

        }


        return convertView;
    }

    class ViewHolder {
        JCVideoPlayerStandard jcVideoPlayer;

        public ViewHolder(View view) {

            jcVideoPlayer = (JCVideoPlayerStandard) view.findViewById(R.id
                    .videoPlayer);

        }
    }
}
