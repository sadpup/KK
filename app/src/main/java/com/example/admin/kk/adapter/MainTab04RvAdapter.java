package com.example.admin.kk.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.kk.R;

import java.util.HashMap;
import java.util.List;

/**
 * 我的界面历史纪录的横向recycleView 的数据适配器
 * */
public class MainTab04RvAdapter extends  RecyclerView.Adapter<MainTab04RvAdapter.ViewHolder> {


    private List<HashMap<String, Object>> mData;

    private Context context;
    public MainTab04RvAdapter(Context context, List<HashMap<String, Object>> mData) {
        this.mData=mData;
        this.context=context;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_main_tab04_history_item, null);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.main_tab04_history_item_tv01.setText(mData.get(position).get("main_tab04_history_item_tv01").toString());
        holder.main_tab04_history_item_tv02.setText(mData.get(position).get("main_tab04_history_item_tv02").toString());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView main_tab04_history_item_tv01;
        TextView main_tab04_history_item_tv02;
        public ViewHolder(View v) {
            super(v);
            main_tab04_history_item_tv01 = (TextView) v.findViewById(R.id.main_tab04_history_item_tv01);
            main_tab04_history_item_tv02 = (TextView) v.findViewById(R.id.main_tab04_history_item_tv02);
        }
    }

}
