package com.example.sober_philer.studyui.day16_fab_hide_show;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by sober_philer on 2018/1/27.
 * description:滑动隐藏的帮助类
 */

public class HelperScrollHide extends RecyclerView.OnScrollListener {

    private static final int THRESHOLD = 10;//滑动的差值控制
    private int distance = 0;
    private HideShowInterface hideShowInterface;
    private boolean visible = true;

    public HelperScrollHide(HideShowInterface hideShowInterface) {
        this.hideShowInterface = hideShowInterface;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        Log.i("philer", dy+"");
        if(dy > THRESHOLD && visible){
            //隐藏
            visible = false;
            hideShowInterface.hide();
            distance = 0;
        }else if(dy < -THRESHOLD && !visible){
            //显示
            visible = true;
            hideShowInterface.show();
            distance = 0;
        }
        distance += dy;
    }
}
