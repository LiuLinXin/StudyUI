package com.example.sober_philer.studyui.day14_trans_navigationbar;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2018/1/7.
 */

public class Day14Activity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏的透明属性
//		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)//全屏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.day14_activity);
        //5.0+可以直接用API来修改状态栏的颜色。
//		getWindow().setStatusBarColor(getResources().getColor(R.color.material_blue_grey_800));
        //1.先设置toolbar的高度
//        toolbar = (Toolbar)findViewById(R.id.toolbar);
//		LayoutParams params = toolbar.getLayoutParams();
//		int statusBarHeight = getStatusBarHeight(this);
//		params.height += statusBarHeight ;
//		toolbar.setLayoutParams(params );
        //2.设置paddingTop，以达到状态栏不遮挡toolbar的内容。
//        toolbar.setPadding(
//                toolbar.getPaddingLeft(),
//                toolbar.getPaddingTop()+getStatusBarHeight(this),
//                toolbar.getPaddingRight(),
//                toolbar.getPaddingBottom());


    }

    /**
     * 获取状态栏的高度
     * @param context
     * @return
     */
    private int getStatusBarHeight(Context context) {
        // 反射手机运行的类：android.R.dimen.status_bar_height.
        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            String heightStr = clazz.getField("status_bar_height").get(object).toString();
            int height = Integer.parseInt(heightStr);
            //dp--->px
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

}
