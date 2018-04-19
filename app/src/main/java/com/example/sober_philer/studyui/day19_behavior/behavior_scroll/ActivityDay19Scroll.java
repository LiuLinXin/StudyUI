package com.example.sober_philer.studyui.day19_behavior.behavior_scroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2018/4/19.
 * description:behavior监听滑动
 */

public class ActivityDay19Scroll extends AppCompatActivity {

    NestedScrollView right;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day19_behavior_scrol);
        right = findViewById(R.id.right);
        right.post(new Runnable() {
            @Override
            public void run() {
//                right.computeScroll();
                right.smoothScrollTo(0, 10000);
            }
        });
    }
}
