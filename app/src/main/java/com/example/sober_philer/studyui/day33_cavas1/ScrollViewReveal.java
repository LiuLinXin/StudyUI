package com.example.sober_philer.studyui.day33_cavas1;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.sober_philer.studyui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by philer on 2018/6/13.
 * Describe:
 */

public class ScrollViewReveal extends HorizontalScrollView{

    private LinearLayout llRoot;

    private int opStart, opEnd;
    private int meWidth;
    private int imageWidth = 300;

    List<Integer> mipmaps = new ArrayList<>();

    {
        mipmaps.add(R.mipmap.im1);
//        mipmaps.add(R.mipmap.im2);
        mipmaps.add(R.mipmap.im3);
        mipmaps.add(R.mipmap.im4);
        mipmaps.add(R.mipmap.im5);
        mipmaps.add(R.mipmap.im6);
        mipmaps.add(R.mipmap.im7);

        mipmaps.add(R.mipmap.im1);
//        mipmaps.add(R.mipmap.im2);
        mipmaps.add(R.mipmap.im3);
        mipmaps.add(R.mipmap.im4);
        mipmaps.add(R.mipmap.im5);
        mipmaps.add(R.mipmap.im6);
        mipmaps.add(R.mipmap.im7);
    }

    public ScrollViewReveal(Context context) {
        super(context);
        init();
    }

    private void init(){
        FrameLayout.LayoutParams meLayoutparams = new LayoutParams(-1, imageWidth);
        setLayoutParams(meLayoutparams);

        setBackgroundColor(Color.GRAY);
        setHorizontalScrollBarEnabled(false);
        llRoot = new LinearLayout(getContext());
        llRoot.setOrientation(LinearLayout.HORIZONTAL);
        ScrollView.LayoutParams layoutParams = new LayoutParams(-1, -2);
//        layoutParams.leftMargin = imageWidth;
//        layoutParams.rightMargin = imageWidth;
        llRoot.setLayoutParams(layoutParams);
        addView(llRoot);
        for (Integer mipmap : mipmaps) {
            ViewReveal viewReveal = new ViewReveal(getContext(), mipmap);
            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(imageWidth, imageWidth);
            viewReveal.setLayoutParams(layoutParams1);
            llRoot.addView(viewReveal);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        meWidth = getWidth();
        opStart = meWidth / 2 - imageWidth / 2;
        opEnd = opStart + meWidth;

        llRoot.setPadding(opStart, 0, opStart, 0);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        Log.i("philerTest", "onScrollChanged : "+getScrollX());
        int scrollX = getScrollX();
        int startPosition = scrollX / imageWidth;
        int hasScrolled = scrollX % imageWidth;

        int childCount = llRoot.getChildCount();
        for(int i=0;i<childCount;i++) {
            ViewReveal viewReveal = (ViewReveal) llRoot.getChildAt(i);
            if(startPosition == i){
                viewReveal.setOpRegion(hasScrolled, imageWidth);
            }else if(startPosition + 1 == i){
                viewReveal.setOpRegion(0, hasScrolled);
            }else {
                viewReveal.setOpRegion(0, 0);
            }
        }
    }
}















