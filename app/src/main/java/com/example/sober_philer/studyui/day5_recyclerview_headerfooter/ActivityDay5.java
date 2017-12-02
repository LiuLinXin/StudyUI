package com.example.sober_philer.studyui.day5_recyclerview_headerfooter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sober_philer.studyui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.通过ItemDecoration实现每个item前面显示一个文字头
 * 2.使用视频中的思想实现头部和底部
 */
public class ActivityDay5 extends AppCompatActivity {

    private HeaderFooterRecyclerView rvContent;
    private List<String> datas = new ArrayList<>();
    private InnerAdapter adapter = new InnerAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day5);
        initView();
        initData();
    }

    private void initView(){
        rvContent = (HeaderFooterRecyclerView) findViewById(R.id.rvContent);
        rvContent.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData(){
        for (int i=0;i<60;i++){
            datas.add("data : "+i);
        }
        rvContent.addItemDecoration(new DecorationHead(datas));
        TextView tvHead = new TextView(this);
        tvHead.setGravity(Gravity.CENTER);
        tvHead.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100));
        tvHead.setText("我是头部");
        rvContent.setHeadView(tvHead);

        TextView tvFooter = new TextView(this);
        tvFooter.setGravity(Gravity.CENTER);
        tvFooter.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100));
        tvFooter.setText("我是尾部");
        rvContent.setFooterView(tvFooter);

        rvContent.setAdapter(adapter);
    }

    private class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.InnerHolder>{

        @Override
        public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(ActivityDay5.this).inflate(R.layout.day5_item, parent, false);
            return new InnerHolder(inflate);
        }

        @Override
        public void onBindViewHolder(InnerHolder holder, int position) {
            holder.tvTitle.setText(datas.get(position));
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        class InnerHolder extends RecyclerView.ViewHolder{
            private TextView tvTitle;
            public InnerHolder(View itemView) {
                super(itemView);
                tvTitle = itemView.findViewById(R.id.tvText);
            }
        }
    }
}
