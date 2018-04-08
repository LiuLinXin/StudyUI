package com.example.sober_philer.studyui.day18_coordinatorlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2018/4/4.
 * description:协调布局使用
 */

public class ActivityDay18 extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day18);
        findViewById(R.id.fab).setOnClickListener(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");

        CollapsingToolbarLayout collapsing_toolbar = findViewById(R.id.collapsing_toolbar);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.fab){
            Snackbar.make(findViewById(R.id.fab), "点击了按钮", Snackbar.LENGTH_SHORT).setDuration(1000).show();
        }
    }
}
