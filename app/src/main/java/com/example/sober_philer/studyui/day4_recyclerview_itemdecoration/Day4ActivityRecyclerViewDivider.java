package com.example.sober_philer.studyui.day4_recyclerview_itemdecoration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sober_philer.studyui.R;

/**
 * 使用itemdecoration添加分割线
 */
public class Day4ActivityRecyclerViewDivider extends AppCompatActivity {

    private RecyclerView rvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3);
        rvContent = (RecyclerView) findViewById(R.id.rvContent);
        rvContent.setLayoutManager(new GridLayoutManager(this, 3));
        rvContent.setAdapter(new InnerAdapter());
        rvContent.addItemDecoration(new ItemDivider(this, 3));
    }

    private class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.InnerHolder>{
        @Override
        public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(Day4ActivityRecyclerViewDivider.this).inflate(R.layout.day4_item, parent, false);
            return new InnerHolder(inflate);
        }

        @Override
        public void onBindViewHolder(InnerHolder holder, int position) {
            holder.tvText.setText(position + "data : "+position);
        }

        @Override
        public int getItemCount() {
            return 47;
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
