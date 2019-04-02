package com.example.sober_philer.studyui.day31_paint;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2018/5/15.
 */

public class Day31Activity extends AppCompatActivity implements View.OnClickListener {



    ViewScaning viewStart;
    ViewScaning viewStart33;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day31_activity);

        viewStart = findViewById(R.id.viewStart);
        viewStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.viewStart){
            viewStart.start();
        }
    }
}
