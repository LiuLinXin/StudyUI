package com.example.sober_philer.studyui.day5_recyclerview_headerfooter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sober_philer on 2017/12/2.
 * Description:
 */

public class AdapterHeaderFooter extends RecyclerView.Adapter {

    private View headerView, footerView;
    private RecyclerView.Adapter adapter;

    public AdapterHeaderFooter(View headerView, View footerView, RecyclerView.Adapter adapter) {
        this.headerView = headerView;
        this.footerView = footerView;
        this.adapter = adapter;
    }

    @Override
    public int getItemViewType(int position) {
        int needPosition = position;
        if(position == 0 && headerView != null){
            return -1;
        }
        if(headerView != null){
            needPosition--;
        }
        if(adapter.getItemCount() > needPosition){
            return adapter.getItemViewType(needPosition);
        }
        Log.i("philer", "getType -2");
        return -2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == -1){
            return new RecyclerView.ViewHolder(headerView){};
        }
        if(viewType == -2){
            return new RecyclerView.ViewHolder(footerView){};
        }
        return adapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType() >= 0){
            int needPosition = position;
            if(headerView != null){
                needPosition--;
            }
            adapter.onBindViewHolder(holder, needPosition);
        }
    }

    @Override
    public int getItemCount() {
        int count = adapter.getItemCount();
        if(headerView != null){
            count++;
        }
        if(footerView != null){
            count++;
        }
        return count;
    }
}
