package com.example.admin.kk.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import com.example.admin.kk.R;


public class TimelineAdapter extends  RecyclerView.Adapter<TimelineAdapter.ViewHolder> {


    private List<HashMap<String, Object>> mData;

    private Context context;
    public TimelineAdapter(Context context, List<HashMap<String, Object>> mData) {
        this.mData=mData;
        this.context=context;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_main_tab03_timeline_item, null);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.item_timeline_yearmonth.setText(mData.get(position).get("item_timeline_yearmonth").toString());
        holder.item_timeline_day.setText(mData.get(position).get("item_timeline_day").toString());
//        int color = context.getResources().getColor(R.color.colorPp);
//        holder.civ.setFillColor(color);
//        holder.civ.setBorderColor(ColorUtils.setAlphaComponent(color, ALPHA));
//        holder.img.setBackgroundResource(R.mipmap.ic_zhihu_logo);
//        holder.item_timeline_view.setBackgroundResource(mData.size()%2==0?R.color.colorAccent: R.color.colorPrimary);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_timeline_yearmonth;
        TextView item_timeline_day;
        public ViewHolder(View v) {
            super(v);
            item_timeline_yearmonth = (TextView) v.findViewById(R.id.item_timeline_yearmonth);
            item_timeline_day = (TextView) v.findViewById(R.id.item_timeline_day);
        }
    }

}
