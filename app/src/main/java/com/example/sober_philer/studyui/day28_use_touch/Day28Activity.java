package com.example.sober_philer.studyui.day28_use_touch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sober_philer.studyui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sober_philer on 2018/5/12.
 * description:事件传递应用
 */

public class Day28Activity extends AppCompatActivity {

    private ListView lvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day28_activity);
//        lvContent = findViewById(R.id.lvContent);
//        List<String> datas = new ArrayList<>();
//        for (int i=0;i<30;i++){
//            datas.add("data : "+i);
//        }
//        lvContent.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, datas));
    }
}
