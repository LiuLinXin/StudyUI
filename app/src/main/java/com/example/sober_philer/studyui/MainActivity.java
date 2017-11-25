package com.example.sober_philer.studyui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.sober_philer.studyui.day4_recyclerview_itemdecoration.Day4ActivityRecyclerViewDivider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.day4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.day4){
            Intent i = new Intent(this, Day4ActivityRecyclerViewDivider.class);
            startActivity(i);
        }
    }
}
