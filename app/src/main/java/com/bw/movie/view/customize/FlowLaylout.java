package com.bw.movie.view.customize;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.ArrayList;

/**
 * @包名 com.bw.movie.view.customize
 * @MengXuanmengxuan
 * @日期2020/3/21
 * @项目名MxMove
 * @类名FLaylot
 **/
public class FlowLaylout extends ViewGroup {

     ArrayList<String> ss= new ArrayList<>();
    public FlowLaylout(Context context) {
        super(context);
    }

    public FlowLaylout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLaylout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        //获得儿童计数
        int childCount = getChildCount();

        int space = 15;
        int left=0;
        int top = space;
        int right = 0;
        int bottom = 0;
        for (int j = 0; j <childCount; j++) {
            View childAt = getChildAt(j);
            childAt.measure(0,0);
            int measuredWidthAndState = childAt.getMeasuredWidthAndState();//测量的宽度和状态
            int measuredHeightAndState = childAt.getMeasuredHeightAndState();//测量的高度和状态

            left=space+right;//左=空格+右;
            right=left+measuredWidthAndState;// 右=左+测量的宽度和状态
            if (right>getWidth()){//右键>获取宽度
                left=space;//左=空格
                right=left+measuredWidthAndState;// 右=左+测量的宽度和状态
                top=bottom+space;//顶部=底部+空格
            }
            bottom=top+measuredHeightAndState;//底部=顶部 +测得的高度和状态

            childAt.layout(left,top,right,bottom);

        }

    }
    public void setTag(String tag){

if (!ss.contains(tag)){

    TextView textView = new TextView(getContext());
    textView.setText(tag);
    textView.setTextColor(20);
   textView.setPadding(10,10,10,10);//设置填充
    textView.setTextColor(Color.GREEN);
    addView(textView);
    ss.add(tag);

    textView.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            for (int i = 0; i < ss.size(); i++) {
                mOnChecked.getTag(ss.get(i));
            }
        }
    });
}
    }

    public void setmOnChecked(setOnChecked mOnChecked) {
        this.mOnChecked = mOnChecked;
    }

    setOnChecked mOnChecked;
    protected interface setOnChecked{
void getTag(String t);
    }

}
