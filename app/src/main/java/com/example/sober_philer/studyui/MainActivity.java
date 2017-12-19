package com.example.sober_philer.studyui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.sober_philer.studyui.day10_toolbar.Day10_toolbarActivity;
import com.example.sober_philer.studyui.day4_recyclerview_itemdecoration.Day4ActivityRecyclerViewDivider;
import com.example.sober_philer.studyui.day5_recyclerview_headerfooter.ActivityDay5;
import com.example.sober_philer.studyui.day6_recyclerview_animation.ActivityDay6RecyclerViewAnimation;
import com.example.sober_philer.studyui.day7_drawerlayout.Day7_activity;
import com.example.sober_philer.studyui.day8_snackbar.Day8SnackbarActivity;
import com.example.sober_philer.studyui.day9_textinputlayout.Day9_textinputlayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.day4).setOnClickListener(this);
        findViewById(R.id.day5).setOnClickListener(this);
        findViewById(R.id.day6).setOnClickListener(this);
        findViewById(R.id.day7).setOnClickListener(this);
        findViewById(R.id.day8).setOnClickListener(this);
        findViewById(R.id.day9).setOnClickListener(this);
        findViewById(R.id.day10).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.day4){
            Intent i = new Intent(this, Day4ActivityRecyclerViewDivider.class);
            startActivity(i);
        }else if(id == R.id.day5){
            startActivity(new Intent(this, ActivityDay5.class));
        }else if(id == R.id.day6){
            startActivity(new Intent(this, ActivityDay6RecyclerViewAnimation.class));
        }else if(id == R.id.day7){
            startActivity(new Intent(this, Day7_activity.class));
        }else if(id == R.id.day8){
            startActivity(new Intent(this, Day8SnackbarActivity.class));
        }else if(id == R.id.day9){
            startActivity(new Intent(this, Day9_textinputlayout.class));
        }else if(id == R.id.day10){
            startActivity(new Intent(this, Day10_toolbarActivity.class));
        }
    }
}
