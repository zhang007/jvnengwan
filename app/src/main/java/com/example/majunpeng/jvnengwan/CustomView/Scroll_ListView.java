package com.example.majunpeng.jvnengwan.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by majunpeng on 2016/7/26.
 */
public class Scroll_ListView extends ScrollView{
    public Scroll_ListView(Context context) {
        super(context);
    }

    public Scroll_ListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Scroll_ListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    /**
     * 重写该方法，达到使ListView适应ScrollView的效果
     */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
