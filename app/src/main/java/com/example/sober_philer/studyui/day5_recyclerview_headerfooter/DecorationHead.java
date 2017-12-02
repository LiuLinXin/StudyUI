package com.example.sober_philer.studyui.day5_recyclerview_headerfooter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Created by sober_philer on 2017/12/2.
 * Description:
 */

public class DecorationHead extends RecyclerView.ItemDecoration {

    private List<String> datas;
    private Paint paint;

    public DecorationHead(List<String> datas) {
        this.datas = datas;
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(20);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        Log.i("philer", parent.getChildCount()+"");
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            String substring = "头";
            int y = (child.getTop() + child.getBottom()) / 2;
            c.drawText(substring, 0, y, paint);
        }
    }

    /**
     * 这个地方的super方法会把四个方向设为0
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Log.i("philder", "getItemOffsets");
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = 100;
    }
}
