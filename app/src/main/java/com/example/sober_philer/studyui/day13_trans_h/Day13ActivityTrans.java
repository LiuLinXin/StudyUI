package com.example.sober_philer.studyui.day13_trans_h;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2018/1/2.
 */

public class Day13ActivityTrans extends AppCompatActivity  {

    private View viewStatus;
    private RecyclerView rvContent;
    private InnerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.day13_activity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(1);
        }

        viewStatus = findViewById(R.id.viewStatus);
        rvContent = findViewById(R.id.rvContent);
        rvContent.setLayoutManager(new LinearLayoutManager(this));
        rvContent.setAdapter(adapter = new InnerAdapter());
        rvContent.addOnScrollListener(scrollListener);
        ViewGroup.LayoutParams layoutParams = viewStatus.getLayoutParams();
        layoutParams.height = getStatusBarHeight();
    }

    private int getStatusBarHeight(){
        try {
            Class<?> aClass = Class.forName("com.android.internal.R$dimen");
            Object o = aClass.newInstance();
            String status_bar_height = aClass.getField("status_bar_height").get(o).toString();
            return getResources().getDimensionPixelSize(Integer.parseInt(status_bar_height));//dp --> px
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("pphiler", e.getMessage()+"");
        }
        return 0;
    }

    private int nowPosition = -1;

    private RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
            if(nowPosition == firstVisibleItemPosition){
                return;
            }
            nowPosition = firstVisibleItemPosition;
            View childAt = rvContent.getChildAt(0);
            InnerAdapter.InnerHolder childViewHolder = (InnerAdapter.InnerHolder) rvContent.getChildViewHolder(childAt);
            BitmapDrawable drawable = (BitmapDrawable) childViewHolder.ivIcon.getDrawable();
            Bitmap bitmap = drawable.getBitmap();
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    int resultColor = 0;
                    if(resultColor == 0){
                        resultColor = palette.getLightVibrantColor(0);
                    }
                    if(resultColor == 0 ){
                        resultColor = palette.getLightMutedColor(0);
                    }
                    if(resultColor == 0){
                        resultColor = palette.getDarkVibrantColor(0);
                    }
                    if(resultColor == 0) {
                        resultColor = palette.getDarkMutedColor(0);
                    }
                    viewStatus.setBackgroundColor(resultColor);
                }
            });
        }
    };

    private class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.InnerHolder>{

        @Override
        public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(Day13ActivityTrans.this).inflate(R.layout.day11_item, parent, false);
            return new InnerHolder(inflate);
        }

        @Override
        public void onBindViewHolder(InnerHolder holder, int position) {
            int i = position % 7 + 1;
            Log.i("philerlog", "position : "+i);
            int mipmap = getResources().getIdentifier("im" + (position % 7 + 1), "mipmap", getPackageName());
            holder.ivIcon.setImageResource(mipmap);
        }

        @Override
        public int getItemCount() {
            return 14;
        }

        class InnerHolder extends RecyclerView.ViewHolder{

            private ImageView ivIcon;
            private TextView tvText;

            public InnerHolder(View itemView) {
                super(itemView);
                ivIcon = itemView.findViewById(R.id.ivIcon);
                tvText = itemView.findViewById(R.id.tvText);
            }
        }
    }
}
