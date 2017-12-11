package com.example.sober_philer.studyui.day8_snackbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2017/12/9.
 * description:
 */

public class PhilerSnackBar implements ValueAnimator.AnimatorUpdateListener {

    private View showView;
    String text;
    Context context;
    FrameLayout parent;

    public PhilerSnackBar(View view, String text) {
        this.text = text;
        getParent(view);
        if (parent == null) {
            throw new RuntimeException("父布局有问题");
        }
        if (context != null) {
            showView = LayoutInflater.from(context).inflate(R.layout.day8_snackview, parent, false);
            TextView tvContent = (TextView) showView.findViewById(R.id.tvContent);
            tvContent.setText(text);
        }
    }

    private void getParent(View view) {
        View parent = view;
        do {
            if (parent instanceof FrameLayout) {
                this.parent = (FrameLayout) parent;
                context = ((FrameLayout) parent).getContext();
                return;
            }
            ViewParent parent1 = parent.getParent();
            if (parent1 instanceof View) {
                parent = (View) parent1;
            }
        } while (parent != null);
    }

    public void show() {
        if (showView.getParent() == null) {
            showView.setVisibility(View.INVISIBLE);
            parent.addView(showView);
        }
        showView.post(new Runnable() {
            @Override
            public void run() {
                int height = showView.getHeight();
                Log.i("philer", "height : " + height);
                ValueAnimator valueAnimator = ValueAnimator.ofInt(showView.getHeight(), 0);
                valueAnimator.addUpdateListener(PhilerSnackBar.this);
                valueAnimator.setDuration(300);
                valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                valueAnimator.start();
                showView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        int y = (int) animation.getAnimatedValue();
        showView.setTranslationY(y);
    }
}
