package com.example.sober_philer.studyui.day6_recyclerview_animation;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by sober_philer on 2017/12/3.
 * Description: recyclerview移动动画回调类
 */

public class AnimationTouchHelper extends ItemTouchHelper.Callback {
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int i = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int i1 = makeMovementFlags(i, ItemTouchHelper.RIGHT);
        return i1;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }
}
