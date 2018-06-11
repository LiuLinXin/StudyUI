package com.example.sober_philer.studyui.day28_myview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2018/5/12.
 */

public class Day28Activity extends AppCompatActivity{

    View viewGroup, view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day28activity);
        viewGroup = findViewById(R.id.viewGroup);
        view = findViewById(R.id.view);
        viewGroup.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("philerTest", "viewGroup ontouchListener");
                return true;
            }
        });

//        viewGroup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i("philerTest", "viewGroup onclicklistener");
//            }
//        });

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("philerTest", "view ontouchListener");
                return false;
            }
        });

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i("philerTest", "view onclicklistener");
//            }
//        });

    }
}
