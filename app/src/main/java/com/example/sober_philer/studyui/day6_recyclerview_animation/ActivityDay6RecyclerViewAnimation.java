package com.example.sober_philer.studyui.day6_recyclerview_animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sober_philer.studyui.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sober_philer on 2017/12/3.
 * Description: recyclerview滑动交换与滑动删除
 */

public class ActivityDay6RecyclerViewAnimation extends AppCompatActivity implements AnimationTouchHelper.MoveCallBack {

    private RecyclerView rvContent;
    private List<String> datas = new ArrayList<>();
    private ItemTouchHelper itemTouchHelper;
    private InnerAdapter innerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day6_activity);
        initView();
        initData();

    }

    private void initView(){
        rvContent = (RecyclerView) findViewById(R.id.rvContent);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvContent.setLayoutManager(linearLayoutManager);
    }

    private void initData(){
        for (int i=0;i<50;i++){
            datas.add("data : "+i);
        }
        innerAdapter = new InnerAdapter();
        AnimationTouchHelper animationTouchHelper = new AnimationTouchHelper(this);
        itemTouchHelper = new ItemTouchHelper(animationTouchHelper);
        itemTouchHelper.attachToRecyclerView(rvContent);
        rvContent.setAdapter(innerAdapter);
    }

    @Override
    public void onMove(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        Collections.swap(datas, viewHolder.getAdapterPosition(), target.getAdapterPosition());
        innerAdapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
//        View itemView = viewHolder.itemView;
//        itemView.setAlpha(1);
//        itemView.setScaleY(1);
//        itemView.setScaleX(1);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder) {
        datas.remove(viewHolder.getAdapterPosition());
        innerAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
    }

    private class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.InnerHolder> implements View.OnClickListener, View.OnTouchListener {
        @Override
        public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(ActivityDay6RecyclerViewAnimation.this).inflate(R.layout.day6_item, parent, false);
            return new InnerHolder(inflate);
        }

        @Override
        public void onBindViewHolder(InnerHolder holder, int position) {
            holder.tvText.setText(datas.get(position));
            holder.ivMove.setTag(holder);
            holder.ivMove.setOnTouchListener(this);
            int adapterPosition = holder.getAdapterPosition();
            int layoutPosition = holder.getLayoutPosition();
            int oldPosition = holder.getOldPosition();
            int position1 = holder.getPosition();
//            Log.i("philer", position +" : adapterPosition-"+adapterPosition+
//            "  layoutPosition-"+layoutPosition+
//            "  oldPosition-"+oldPosition+
//            "  position1"+position1);
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            if(id == R.id.ivMove){

            }
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                InnerHolder holder = (InnerHolder) v.getTag();
                itemTouchHelper.startDrag(holder);
            }
            return false;
        }

        class InnerHolder extends RecyclerView.ViewHolder{
            private TextView tvText;
            private ImageView ivMove;
            public InnerHolder(View itemView) {
                super(itemView);
                tvText = (TextView) itemView.findViewById(R.id.tvText);
                ivMove = (ImageView) itemView.findViewById(R.id.ivMove);
            }
        }
    }

}
