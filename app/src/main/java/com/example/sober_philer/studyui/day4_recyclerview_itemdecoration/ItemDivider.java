package com.example.sober_philer.studyui.day4_recyclerview_itemdecoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by sober_philer on 2017/11/20.
 * description:
 */

public class ItemDivider extends RecyclerView.ItemDecoration {

    private Drawable mDivider;
    private int[] attrs = new int[]{
            android.R.attr.listDivider
    };
    private int lineItem;

    public ItemDivider(Context context, int lineItem) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs);
        mDivider = typedArray.getDrawable(0);
        this.lineItem = lineItem;
        typedArray.recycle();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int parentLeft = parent.getPaddingLeft();
        int parenttop = parent.getPaddingTop();
        int parentRight = parent.getPaddingRight();
        int parentBottom = parent.getPaddingBottom();

        mDivider.setBounds(parentLeft, parenttop, parentLeft + mDivider.getIntrinsicWidth(), parent.getHeight() - parentBottom);
        mDivider.draw(c);
        for(int i=0;i < Math.min(parent.getChildCount(), lineItem);i++){
            View childAt = parent.getChildAt(i);
            mDivider.setBounds(childAt.getRight(), parenttop, mDivider.getIntrinsicWidth()+ childAt.getRight(), parent.getHeight() - parentBottom);
            mDivider.draw(c);
        }

        mDivider.setBounds(parentLeft, parenttop, parent.getWidth() - parentRight, mDivider.getIntrinsicHeight() + parenttop);
        mDivider.draw(c);
        for(int i=0;i<parent.getChildCount();i+=lineItem){
            View childAt = parent.getChildAt(i);
            mDivider.setBounds(parentLeft, childAt.getBottom(), parent.getWidth() - parentRight, mDivider.getIntrinsicHeight()+childAt.getBottom());
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        super.getItemOffsets(outRect, itemPosition, parent);
        Log.i("philer", parent.getChildCount()+"");
        int left = 0;
        if(needLeft(itemPosition)){
            left += mDivider.getIntrinsicWidth();
        }
        int top = 0;
        if(needTop(itemPosition)){
            top += mDivider.getIntrinsicHeight();
        }
        int right = mDivider.getIntrinsicWidth();
        int bottom = mDivider.getIntrinsicHeight();
        outRect.set(left, top, right, bottom);
    }

    private boolean needTop(int position) {
        if (position < lineItem) {
            return true;
        }
        return false;
    }

    private boolean needLeft(int position) {
        if (position % 3 == 0) {
            return true;
        }
        return false;
    }

}