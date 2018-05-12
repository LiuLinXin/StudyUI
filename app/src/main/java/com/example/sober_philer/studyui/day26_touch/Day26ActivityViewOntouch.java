package com.example.sober_philer.studyui.day26_touch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2018/5/7.
 * description:
 */

public class Day26ActivityViewOntouch extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    View tvText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day26_ontouch);
        tvText = findViewById(R.id.tvText);
        tvText.setOnClickListener(this);
        tvText.setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i("philerTest", "OnClickListener");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.i("philerTest", "OnTouchListener : "+event.getAction());
        return false;
    }
}
