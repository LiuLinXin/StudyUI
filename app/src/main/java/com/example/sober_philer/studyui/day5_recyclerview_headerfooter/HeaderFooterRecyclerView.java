package com.example.sober_philer.studyui.day5_recyclerview_headerfooter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sober_philer on 2017/12/2.
 * Description: 有头部和底部的recyelverview
 */

public class HeaderFooterRecyclerView extends RecyclerView {

    private View headView, footerView;

    public HeaderFooterRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setHeadView(View headView) {
        this.headView = headView;
    }

    public void setFooterView(View footerView) {
        this.footerView = footerView;
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(new AdapterHeaderFooter(headView, footerView, adapter));
    }
}
