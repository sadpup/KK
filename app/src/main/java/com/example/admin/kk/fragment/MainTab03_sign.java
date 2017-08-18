package com.example.admin.kk.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.admin.kk.Mapplication;
import com.example.admin.kk.R;
import com.example.admin.kk.adapter.ReMenBaAdapter;
import com.example.admin.kk.adapter.TimelineAdapter;
import com.example.admin.kk.main.CalendarActivity;
import com.example.admin.kk.main.MessageActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lihongl on 2017/6/24.
 * emile is 24107661@qq.com
 */

@SuppressLint("ValidFragment")
public class MainTab03_sign extends BaseFragment implements View.OnClickListener{


    private RecyclerView recyclerView;
    private List<HashMap<String, Object>> mData;
    private ImageButton custom_title_btLogin,custom_title_btCalendar;

    @Override
    protected void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.main_tab03_sign_lv);
        custom_title_btLogin = (ImageButton) findViewById(R.id.custom_title_btLogin);
        custom_title_btCalendar = (ImageButton) mActivity.findViewById(R.id.custom_title_btCalendar);
        custom_title_btCalendar.setOnClickListener(this);
    }

    @Override
    protected void initEvents() {
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void init() {
        mData = setTestData();
        TimelineAdapter adapter = new TimelineAdapter(mContext,mData);
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("ValidFragment")
    public MainTab03_sign(Mapplication application, Activity activity, Context context)  {
        super(application, activity, context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.main_tab_03_sign,null);
        return super.onCreateView(inflater, container, savedInstanceState);

    }


    private List<HashMap<String, Object>> setTestData() {
        // 新建一个集合类，用于存放多条数据
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = null;
        for (int i = 1; i <= 8; i++) {
            map = new HashMap<String, Object>();
            map.put("item_timeline_yearmonth", "2017/07");
            map.put("item_timeline_day", "01");
            list.add(map);
        }
        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.custom_title_btCalendar:
                Intent intent = new Intent(mActivity, CalendarActivity.class);
                startActivity(intent);
                break;
        }
    }
}
