package com.example.sober_philer.studyui.day32_filter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2018/5/16.
 */

public class Day32Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewFilterOne filterOne = new ViewFilterOne(this);
        ViewFilterTow filterTow = new ViewFilterTow(this);
        setContentView(filterTow);
    }
}
