package com.example.sober_philer.studyui.day16_fab_hide_show;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2018/1/12.
 * description:
 */

public class Day16_fabhideshow extends AppCompatActivity {

    private RecyclerView rvContent;
    private View ivIcon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day16_activity);
        rvContent = findViewById(R.id.rvContent);
        ivIcon = findViewById(R.id.ivIcon);
        rvContent.setLayoutManager(new LinearLayoutManager(this));
        rvContent.setAdapter(new InnerAdapter());
//        rvContent.addOnScrollListener(helperScrollHide = new HelperScrollHide(this));
    }


    private class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.InnerHolder>{
        @Override
        public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(Day16_fabhideshow.this).inflate(R.layout.day4_item, parent, false);
            return new InnerHolder(inflate);
        }

        @Override
        public void onBindViewHolder(InnerHolder holder, int position) {
            holder.tvText.setText("data : "+position);
        }

        @Override
        public int getItemCount() {
            return 50;
        }

        class InnerHolder extends RecyclerView.ViewHolder{
            TextView tvText;

            public InnerHolder(View itemView) {
                super(itemView);
                tvText = itemView.findViewById(android.R.id.text1);
            }
        }
    }
}
