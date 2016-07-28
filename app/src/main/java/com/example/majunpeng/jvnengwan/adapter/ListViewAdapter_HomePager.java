package com.example.majunpeng.jvnengwan.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.activity.PlayVidioActivity;
import com.example.majunpeng.jvnengwan.bean.HomePageData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by majunpeng on 2016/7/26.
 * ListView多布局的适配器
 */
public class ListViewAdapter_HomePager extends BaseAdapter implements AdapterView.OnItemClickListener{
    private Context context;

    //数据源
    private List <HomePageData.DataBean> data;

    //构造方法
    public ListViewAdapter_HomePager(Context context,List <HomePageData.DataBean> data){
        this.context=context;
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
        //模块1
        String n1=data.get(position).getBoutiqueProjectLists().size()+"";
        //模块2
        String n2=data.get(position).getCrowdfundingProjectLists().size()+"";
        ViewHolder1 holder_templateName1 = null;
        if (convertView == null) {
            switch (getItemViewType(position)){
                case 1:
                    //模型1布局
                    convertView=LayoutInflater.from(context).inflate(R.layout
                    .item_gridview_homepage,parent, false);
                    holder_templateName1 = new ViewHolder1();
                    holder_templateName1.gridView1 = (GridView) convertView
                            .findViewById(R.id.mode1_gridview);
                    holder_templateName1.GridView2=(GridView) convertView
                            .findViewById(R.id.mode2_gridView);
                    holder_templateName1.gridView3=(GridView) convertView
                            .findViewById(R.id.mode3_gridView);
                    convertView.setTag(holder_templateName1);
                    break;
            }
        }else {
            switch (getItemViewType(position)) {
                case 1:
                    holder_templateName1 = (ViewHolder1) convertView.getTag();
                    break;
            }
        }
        //添加数据
        HomePageData.DataBean dataBean = data.get(position);

        Log.i("tag", "我是posintion "+position+"==="+getItemViewType(position));
        switch (getItemViewType(position)) {
            case 1:
                Log.i("tag", "==============我是模块1 ");
                GridViewAdapter_HomePager adapter1=new GridViewAdapter_HomePager(context,dataBean.getBoutiqueProjectLists());
                Mode2_GridViewAdapter_Homepager adapter2=new Mode2_GridViewAdapter_Homepager(context,dataBean.getCrowdfundingProjectLists());
                Mode3_GridViewAdapter_Homepager adapter3=new Mode3_GridViewAdapter_Homepager(context,dataBean.getDynamicProjectLists());
                holder_templateName1.gridView1.setAdapter(adapter1);
                holder_templateName1.GridView2.setAdapter(adapter2);
                holder_templateName1.gridView3.setAdapter(adapter3);
//                int height = 20;//此处的高度需要动态计算
//                int width = 30;//此处的宽度需要动态计算
//                LinearLayout.LayoutParams linearParams=new LinearLayout.LayoutParams(width,height);
//                LinearLayout.LayoutParams linearParams=new LinearLayout.LayoutParams(height,width);
//                holder_templateName1.GridView2.setLayoutParams(linearParams);


                //=================给gridView设置监听
                holder_templateName1.GridView2.setOnItemClickListener(this);
                break;
        }
        return convertView;
    }
    //用Picasso下载图片
    private void downLOadPicture(String path, ImageView imageView) {

        Picasso.with(context)
                .load(path)
                .config(Bitmap.Config.RGB_565)
                .into(imageView);

    }
    /**
     * 重写的两个方法===================================
     * @return
     */

    //该方法返回多个不同的布局
    @Override
    public int getViewTypeCount() {
        //这个是固定值
        return 1;
    }

    //该方法根据position   返回相应的Item
    @Override
    public int getItemViewType(int position) {
        int type=1;
        //模块1
        String n1=data.get(position).getBoutiqueProjectLists().size()+"";
        //模块2

        if (n1 != null) {
            if(n1.equals("4")){
                type=1;
            }
        }
        return type;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(context, PlayVidioActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("url","");
                context.startActivity(intent);


    }


    public static class ViewHolder1 {
       GridView gridView1,GridView2,gridView3;
    }

}
