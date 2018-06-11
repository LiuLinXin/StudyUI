package com.example.sober_philer.studyui.day19_behavior.day19activity2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2018/4/17.
 */

public class ActivityDay19_tow extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day19_tow);
        findViewById(R.id.ivIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewCompat.offsetTopAndBottom(v, 10);
            }
        });
    }
}
