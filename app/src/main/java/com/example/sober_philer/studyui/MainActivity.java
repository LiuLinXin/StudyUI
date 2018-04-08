package com.example.sober_philer.studyui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.sober_philer.studyui.day10_toolbar.Day10_toolbarActivity;
import com.example.sober_philer.studyui.day11_palette.Day11ActivityGridPalette;
import com.example.sober_philer.studyui.day12_tablayout.Day12ActivityTablayout;
import com.example.sober_philer.studyui.day13_trans_h.Day13ActivityTrans;
import com.example.sober_philer.studyui.day14_trans_navigationbar.Day14Activity;
import com.example.sober_philer.studyui.day15_cardview_floatingactionbar.Day15Activity;
import com.example.sober_philer.studyui.day16_fab_hide_show.Day16_fabhideshow;
import com.example.sober_philer.studyui.day18_coordinatorlayout.ActivityDay18;
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
        findViewById(R.id.day11).setOnClickListener(this);
        findViewById(R.id.day12).setOnClickListener(this);
        findViewById(R.id.day13).setOnClickListener(this);
        findViewById(R.id.day14).setOnClickListener(this);
        findViewById(R.id.day15).setOnClickListener(this);
        findViewById(R.id.day16).setOnClickListener(this);
        findViewById(R.id.day18).setOnClickListener(this);
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
        }else if(id == R.id.day11){
            startActivity(new Intent(this, Day11ActivityGridPalette.class));
        }else if(id == R.id.day12){
            startActivity(new Intent(this, Day12ActivityTablayout.class));
        }else if(id == R.id.day13){
            startActivity(new Intent(this, Day13ActivityTrans.class));
        }else if(id == R.id.day14){
            startActivity(new Intent(this, Day14Activity.class));
        }else if(id == R.id.day15){
            startActivity(new Intent(this, Day15Activity.class));
        }else if(id == R.id.day16){
            startActivity(new Intent(this, Day16_fabhideshow.class));
        }else if(id == R.id.day18){
            startActivity(new Intent(this, ActivityDay18.class));
        }
    }
}
