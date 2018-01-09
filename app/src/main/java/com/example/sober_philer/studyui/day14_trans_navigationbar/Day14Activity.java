package com.example.sober_philer.studyui.day14_trans_navigationbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2018/1/7.
 */

public class Day14Activity extends BaseTransActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏的透明属性
        setContentView(R.layout.day14_activity);
        toolbar = findViewById(R.id.toolbar);
//        toolbar.post(new Runnable() {
//            @Override
//            public void run() {
                transContent(Color.RED);
//            }
//        });
    }

}
