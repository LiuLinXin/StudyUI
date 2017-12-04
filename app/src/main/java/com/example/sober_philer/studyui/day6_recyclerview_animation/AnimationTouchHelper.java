package com.example.sober_philer.studyui.day6_recyclerview_animation;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2017/12/3.
 * Description: recyclerview移动动画回调类
 */

public class AnimationTouchHelper extends ItemTouchHelper.Callback {

    public static interface MoveCallBack {
        void onMove(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target);

        void onSwiped(RecyclerView.ViewHolder viewHolder);
    }

    private MoveCallBack moveCallBack;

    public AnimationTouchHelper(MoveCallBack moveCallBack) {
        this.moveCallBack = moveCallBack;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int i = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int i1 = makeMovementFlags(i, ItemTouchHelper.RIGHT);
        return i1;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        moveCallBack.onMove(viewHolder, target);
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        moveCallBack.onSwiped(viewHolder);
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder.itemView.setBackgroundColor(Color.GRAY);
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
//        View itemView = viewHolder.itemView;
        viewHolder.itemView.setBackgroundColor(Color.WHITE);
//        itemView.setAlpha(1);
//        itemView.setScaleY(1);
//        itemView.setScaleY(1);
        super.clearView(recyclerView, viewHolder);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            View itemView = viewHolder.itemView;
            float alpha = 1 - Math.abs(dX / itemView.getWidth());
            itemView.setAlpha(alpha);
            itemView.setScaleX(alpha);
            itemView.setScaleY(alpha);
        }
        if(isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            viewHolder.itemView.setTag(R.string.app_name, dX);
        }else {
            float tag = (float) viewHolder.itemView.getTag(R.string.app_name);
//            super.onChildDraw(c, recyclerView, viewHolder,tag , dY, actionState, isCurrentlyActive);
        }
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            View itemView = viewHolder.itemView;
            float alpha = 1;
            itemView.setAlpha(alpha);
            itemView.setScaleX(alpha);
            itemView.setScaleY(alpha);
        }
    }

    @Override
    public void onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        Log.i("philer",  viewHolder.itemView.getX()+"");
        if(isCurrentlyActive) {
            super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }else {
            float tag = (float) viewHolder.itemView.getTag(R.string.app_name);
//            super.onChildDrawOver(c, recyclerView, viewHolder, tag, dY, actionState, isCurrentlyActive);
        }
    }
}
