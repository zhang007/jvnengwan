package com.example.majunpeng.jvnengwan.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by majunpeng on 2016/7/27.
 */
public class NoScrollGridview extends GridView{
    public NoScrollGridview(Context context) {
        super(context);
    }

    public NoScrollGridview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollGridview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /**
     * 设置不滚动
     */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }
}
