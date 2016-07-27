package com.example.majunpeng.jvnengwan.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.bean.LmainInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ASUS on 2016/7/26.
 */
public class L_MyAdapter extends BaseAdapter{
    private Context mContext;
    private List<LmainInfo.DataListBean>list;

    public L_MyAdapter(Context context) {
        this.mContext = context;
    }
    public void addData(List<LmainInfo.DataListBean>data){
        this.list=data;

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView==null){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.l_grid_item,parent,false);
            holder.l_imageView= (ImageView) convertView.findViewById(R.id.l_item_image);
            holder.l_textView= (TextView) convertView.findViewById(R.id.l_item_text1);
            holder.l_textView2= (TextView) convertView.findViewById(R.id.l_item_text2);
            convertView.setTag(holder);
        }else{
           holder= (ViewHolder) convertView.getTag();
        }
        LmainInfo.DataListBean datalist=list.get(position);
        holder.l_textView.setText(datalist.getName());
        if (datalist.getLivenum()!=0){
            holder.l_textView2.setText(datalist.getLivenum()+"条直播");
        }

        String imageurl=datalist.getImgurl();
        Picasso.with(mContext)
                .load(imageurl)
                .error(R.mipmap.ic_launcher)
                .centerCrop()
                .resize(200,300)
                .config(Bitmap.Config.RGB_565)
                .into(holder.l_imageView);

        /**
         * Picasso 使用一句话完成
         * 1,.with() 初始化Picasso对象
         * 2,.load() 加载图片
         * 3,.into()指定下载图片显示的控件
         *
         * placeholder:默认展示的图片
         * error:下载失败展示的图片
         * centerCrop():图片的缩放类型
         * config:图片的解码格式
         * resize:设置图片的大小   宽和高  不能设置成0  :Width must be positive number.
         * transform:对图片变形
         */

        return convertView;
    }



    public static class ViewHolder{
        ImageView l_imageView;
        TextView l_textView;
        TextView l_textView2;
    }
}
