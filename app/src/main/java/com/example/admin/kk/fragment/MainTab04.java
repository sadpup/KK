package com.example.admin.kk.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.kk.Mapplication;
import com.example.admin.kk.R;
import com.example.admin.kk.adapter.MainTab04RvAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lihongl on 2017/6/24.
 * emile is 24107661@qq.com
 */

@SuppressLint("ValidFragment")
public class MainTab04 extends BaseFragment{

    List<HashMap<String,Object>> mData;
    private RecyclerView main_tab04_history_recuylerview;

    @Override
    protected void initViews() {
        main_tab04_history_recuylerview = (RecyclerView) findViewById(R.id.main_tab04_history_recuylerview);
        LinearLayoutManager  linearLayoutManager = new LinearLayoutManager(mActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        main_tab04_history_recuylerview.setLayoutManager(linearLayoutManager);
        main_tab04_history_recuylerview.setHasFixedSize(true);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void init() {
        mData = setTestData();
        MainTab04RvAdapter adapter = new MainTab04RvAdapter(mContext,mData);
        main_tab04_history_recuylerview.setAdapter(adapter);
    }

    @SuppressLint("ValidFragment")
    public MainTab04(Mapplication application, Activity activity, Context context)  {
        super(application, activity, context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.main_tab_04,null);
        return super.onCreateView(inflater, container, savedInstanceState);

    }



    private List<HashMap<String, Object>> setTestData() {
        // 新建一个集合类，用于存放多条数据
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = null;
        for (int i = 1; i <= 12; i++) {
            map = new HashMap<String, Object>();
            map.put("main_tab04_history_item_tv01", "你看着扁担又长又宽");
            map.put("main_tab04_history_item_tv02", "就像这碗，又圆又大");
            list.add(map);
        }
        return list;
    }

}
