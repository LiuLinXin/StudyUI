package com.example.sober_philer.studyui;

import android.animation.ObjectAnimator;
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
import com.example.sober_philer.studyui.day18_coordinatorlayout.activitybpagetow.ActivityPageTow;
import com.example.sober_philer.studyui.day19_behavior.behavior_scroll.ActivityDay19Scroll;
import com.example.sober_philer.studyui.day20_propertyanimotion.Day20Activity;
import com.example.sober_philer.studyui.day21_animator.Day21MatieralDesign;
import com.example.sober_philer.studyui.day23_svg.Day23Activity;
import com.example.sober_philer.studyui.day24_animfram.Day24ActivityAnimFram;
import com.example.sober_philer.studyui.day26_touch.Day26ActivityViewOntouch;
import com.example.sober_philer.studyui.day28_use_touch.Day28Activity;
import com.example.sober_philer.studyui.day29_scroller.Day29Activity;
import com.example.sober_philer.studyui.day31_paint.Day31Activity;
import com.example.sober_philer.studyui.day32_filter.Day32Activity;
import com.example.sober_philer.studyui.day33_cavas1.ActivityDay33;
import com.example.sober_philer.studyui.day34_cavas2.ActivityCavas2;
import com.example.sober_philer.studyui.day35_path.Day35Activity;
import com.example.sober_philer.studyui.day36_pathmeasure.Day36Activity;
import com.example.sober_philer.studyui.day37_ui_draw.Day37Activity;
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
        findViewById(R.id.day19).setOnClickListener(this);
        findViewById(R.id.day20).setOnClickListener(this);
        findViewById(R.id.day21).setOnClickListener(this);
        findViewById(R.id.day23).setOnClickListener(this);
        findViewById(R.id.day24).setOnClickListener(this);
        findViewById(R.id.day26).setOnClickListener(this);
        findViewById(R.id.day28).setOnClickListener(this);
        findViewById(R.id.day28_2).setOnClickListener(this);
        findViewById(R.id.day29).setOnClickListener(this);
        findViewById(R.id.day31).setOnClickListener(this);
        findViewById(R.id.day32).setOnClickListener(this);
        findViewById(R.id.day33).setOnClickListener(this);
        findViewById(R.id.day34).setOnClickListener(this);
        findViewById(R.id.day35).setOnClickListener(this);
        findViewById(R.id.day36).setOnClickListener(this);
        findViewById(R.id.day37).setOnClickListener(this);
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
//            startActivity(new Intent(this, ActivityDay18PageOne.class));
            startActivity(new Intent(this, ActivityPageTow.class));
        }else if(id == R.id.day19){
//            startActivity(new Intent(this, ActivityDay18PageOne.class));
//            startActivity(new Intent(this, ActivityDay19.class));
            startActivity(new Intent(this, ActivityDay19Scroll.class));
        }else if(id == R.id.day20){
//            startActivity(new Intent(this, ActivityDay18PageOne.class));
//            startActivity(new Intent(this, ActivityDay19.class));
            startActivity(new Intent(this, Day20Activity.class));
        }else if(id == R.id.day21){
            startActivity(new Intent(this, Day21MatieralDesign.class));
        }else if(id == R.id.day23){
            startActivity(new Intent(this, Day23Activity.class));
        }else if(id == R.id.day24){
            startActivity(new Intent(this, Day24ActivityAnimFram.class));
        }else if(id == R.id.day26){
            startActivity(new Intent(this, Day26ActivityViewOntouch.class));
        }else if(id == R.id.day28){
            startActivity(new Intent(this, com.example.sober_philer.studyui.day28_myview.Day28Activity.class));
        }else if(id == R.id.day28_2){
            startActivity(new Intent(this, Day28Activity.class));
        }else if(id == R.id.day29){
            startActivity(new Intent(this, Day29Activity.class));
        }else if(id == R.id.day31){
            startActivity(new Intent(this, Day31Activity.class));
        }else if(id == R.id.day32){
            startActivity(new Intent(this, Day32Activity.class));
        }else if(id == R.id.day33){
            startActivity(new Intent(this, ActivityDay33.class));
        }else if(id == R.id.day34){
            startActivity(new Intent(this, ActivityCavas2.class));
        }else if(id == R.id.day35){
            startActivity(new Intent(this, Day35Activity.class));
        }else if(id == R.id.day36){
            startActivity(new Intent(this, Day36Activity.class));
        }else if(id == R.id.day37){
            startActivity(new Intent(this, Day37Activity.class));
        }
    }
}
