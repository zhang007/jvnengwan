package com.example.majunpeng.jvnengwan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.activity.LiveVideoWebViewActivity;
import com.example.majunpeng.jvnengwan.bean.MyLiveVideoBean;
import com.example.majunpeng.jvnengwan.model.LoadImageModel;
import com.example.majunpeng.jvnengwan.model.impl.LoadImageModelImpl;

import java.util.List;

/**
 * Created by zhangfan on 2016/7/28.
 */
public class MyGrideViewAdapter_MyLive extends BaseAdapter implements View
        .OnClickListener {

    private List<Object> data;
    private Context context;
    private LoadImageModel loadImageModel;
    private String url = null;

    public MyGrideViewAdapter_MyLive(List<Object> data, Context context) {
        this.data = data;
        this.context = context;
    }


    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(List<Object> data) {
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

        loadImageModel = new LoadImageModelImpl();

        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout
                    .item_gridview_mylive, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);


        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        Object o = data.get(position);


        String name = null;
        String rawcoverimageUrl = null;
        String viewers = null;
        String title = null;
        String commentator = null;
        String sourcename = null;

        if (o instanceof MyLiveVideoBean.RecLiveBean.DataListBean.MyArrayListBean) {

            MyLiveVideoBean.RecLiveBean.DataListBean.MyArrayListBean
                    myArrayListBean1 = (MyLiveVideoBean.RecLiveBean.DataListBean
                    .MyArrayListBean) o;

            if (myArrayListBean1 != null) {
                MyLiveVideoBean.RecLiveBean.DataListBean.MyArrayListBean.MapBean
                        map = myArrayListBean1.getMap();
                url = map.getUrl();
                name = map.getName();
                rawcoverimageUrl = map.getRawcoverimage();
                viewers = map.getViewers();
                title = map.getTitle();
                commentator = map.getCommentator();
                sourcename = map.getSourcename();

            }

        } else if (o instanceof MyLiveVideoBean.HotLiveBean.DataListBean
                .MyArrayListBean) {


            MyLiveVideoBean.HotLiveBean.DataListBean.MyArrayListBean
                    myArrayListBean2 =
                    (MyLiveVideoBean.HotLiveBean.DataListBean.MyArrayListBean) o;


            if (myArrayListBean2 != null) {

                MyLiveVideoBean.HotLiveBean.DataListBean.MyArrayListBean.MapBean
                        map = myArrayListBean2.getMap();
                url = map.getUrl();
                name = map.getName();
                rawcoverimageUrl = map.getRawcoverimage();
                viewers = map.getViewers();
                title = map.getTitle();
                commentator = map.getCommentator();
                sourcename = map.getSourcename();
            }

        } else if (o instanceof MyLiveVideoBean.ConLiveBean.DataListBean
                .MyArrayListBean) {

            MyLiveVideoBean.ConLiveBean.DataListBean.MyArrayListBean
                    myArrayListBean3 = (MyLiveVideoBean.ConLiveBean
                    .DataListBean.MyArrayListBean) o;

            if (myArrayListBean3 != null) {

                MyLiveVideoBean.ConLiveBean.DataListBean.MyArrayListBean.MapBean
                        map = myArrayListBean3.getMap();
                url = map.getUrl();
                name = map.getName();
                rawcoverimageUrl = map.getRawcoverimage();
                viewers = map.getViewers();
                title = map.getTitle();
                commentator = map.getCommentator();
                sourcename = map.getSourcename();
            }


        }


        double num = Integer.parseInt(viewers);


        holder.tv_name.setText(name);
        holder.tv_title.setText(title);
        holder.tv_commentator.setText(commentator);
        holder.tv_sourceName.setText(sourcename);
        holder.tv_viewers.setText(num / 10000 + "万");
        loadImageModel.loadImage(rawcoverimageUrl, context, holder.iv);

        convertView.setOnClickListener(this);


        return convertView;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, LiveVideoWebViewActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);

    }


    class ViewHolder {
        ImageView iv;
        TextView tv_name, tv_title, tv_viewers, tv_sourceName, tv_commentator;

        public ViewHolder(View view) {
            iv = (ImageView) view.findViewById(R.id.iv_gridView_myLive);
            tv_name = (TextView) view.findViewById(R.id.tv_nameGridView_myLive);
            tv_title = (TextView) view.findViewById(R.id.tv_TitleGridView_myLive);
            tv_viewers = (TextView) view.findViewById(R.id
                    .tv_viewersGridView_myLive);
            tv_sourceName = (TextView) view.findViewById(R.id
                    .tv_sourceNameGridView_myLive);
            tv_commentator = (TextView) view.findViewById(R.id
                    .tv_commentatorGridView_myLive);


        }
    }


}
