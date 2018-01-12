package com.example.sober_philer.studyui.day16_fab_hide_show;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by sober_philer on 2018/1/12.
 * description:
 */

public class MyLoadingView extends ViewGroup {

    private ProgressBar progressBar;
    private int progressWidth = 100;
    private TextView tvText;
    private int sWidth;
    private int sHeight;

    public MyLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        progressBar = new ProgressBar(getContext());
        addView(progressBar);

        tvText = new TextView(getContext());
        tvText.setText("加载中...");
        tvText.setGravity(Gravity.CENTER);
        addView(tvText);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        sWidth = MeasureSpec.getSize(widthMeasureSpec);
        sHeight = MeasureSpec.getSize(heightMeasureSpec);

        LayoutParams layoutParams = (LayoutParams)progressBar.getLayoutParams();
        layoutParams.left = (sWidth - progressWidth) / 2;
        layoutParams.top = (sHeight - progressWidth) / 2 - progressWidth;

        LayoutParams tvParams = (LayoutParams)tvText.getLayoutParams();
        tvParams.left = (sWidth - progressWidth) / 2;
        tvParams.top = (sHeight - progressWidth) / 2;

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        LayoutParams params = (LayoutParams) progressBar.getLayoutParams();
        progressBar.layout(params.left, params.top, params.left + progressWidth
                , params.top + progressWidth);

        LayoutParams tipParams = (LayoutParams) tvText.getLayoutParams();
        tvText.layout(tipParams.left, tipParams.top, tipParams.left + progressWidth,
                tipParams.top + progressWidth);
    }

    @Override
    public ViewGroup.LayoutParams generateLayoutParams(
            AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(
            ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    private static class LayoutParams extends ViewGroup.LayoutParams {

        public int left = 0;
        public int top = 0;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }
    }

}
