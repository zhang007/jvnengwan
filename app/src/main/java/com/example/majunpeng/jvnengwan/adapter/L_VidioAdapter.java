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
import com.example.majunpeng.jvnengwan.bean.LvidioInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ASUS on 2016/7/28.
 */
public class L_VidioAdapter extends BaseAdapter{
    private Context mContext;
    private List<LvidioInfo.VideosBean.GameinfoBean>list;
    public L_VidioAdapter(Context context,List<LvidioInfo.VideosBean.GameinfoBean>list) {
       this.mContext = context;
        this.list=list;
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
        ViewHolder holder;
        if (convertView==null){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.l_jieshuo_item,parent,false);
            holder.mTextView= (TextView) convertView.findViewById(R.id.l_text_miss);
            holder.mTextView2= (TextView) convertView.findViewById(R.id.l_text_time);
            holder.mImageView= (ImageView) convertView.findViewById(R.id.l_image_photo);
            holder.mTextView3= (TextView) convertView.findViewById(R.id.l_text_big);
            holder.mTextView4= (TextView) convertView.findViewById(R.id.l_text_small);
            holder.mTextView5= (TextView) convertView.findViewById(R.id.l_text_ci);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        LvidioInfo.VideosBean.GameinfoBean gameinfo=list.get(position);
        holder.mTextView.setText(gameinfo.getCommentator());
        holder.mTextView2.setText(gameinfo.getDuration());
        holder.mTextView3.setText(gameinfo.getTitle());
        holder.mTextView4.setText(gameinfo.getAbstractX());
        Long along=gameinfo.getViewtimes();
       holder.mTextView5.setText(along+"次");
       String url= gameinfo.getRawcoverimage();
        Picasso.with(mContext)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .centerCrop()
                .resize(120,120)
                .config(Bitmap.Config.RGB_565)
                .into(holder.mImageView);
        return convertView;
    }
    static class ViewHolder{
        TextView mTextView;
        TextView mTextView2;
        ImageView mImageView;
        TextView mTextView3;
        TextView mTextView4;
        TextView mTextView5;

    }
}
