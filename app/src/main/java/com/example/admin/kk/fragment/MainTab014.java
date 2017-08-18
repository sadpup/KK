package com.example.admin.kk.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.admin.kk.Mapplication;
import com.example.admin.kk.R;
import com.example.admin.kk.adapter.FindBfAdapter;
import com.example.admin.kk.interfacee.OnClickItemElementListenter;
import com.example.admin.kk.main.MainActivity;
import com.example.admin.kk.main.PersonHomeActitivity;
import com.example.admin.kk.util.T;
import com.example.admin.kk.view.SlideShowView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lihongl on 2017/6/24.
 * emile is 24107661@qq.com
 */

@SuppressLint("ValidFragment")
public class MainTab014 extends BaseFragment implements OnClickItemElementListenter{

    private ListView lv_remen_ba;
    private List<HashMap<String, Object>> mData;

    public MainTab014(Mapplication application, Activity activity, Context context)  {
        super(application, activity, context);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.main_tab_014, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    protected void initViews() {
        lv_remen_ba = (ListView) findViewById(R.id.lv_remen_ba);
    }

    private List<HashMap<String, Object>> setTestData() {
        // 新建一个集合类，用于存放多条数据
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = null;
        for (int i = 1; i <= 40; i++) {
            map = new HashMap<String, Object>();
            map.put("list_findbf_item_img", R.mipmap.ic_launcher_round);
            map.put("list_findbf_item_tv01", "张铁柱");
            map.put("list_findbf_item_tv02", "最近在看：《三国演义》");
            map.put("list_findbf_item_tv03", "文摘数 56|粉丝数 250");
            map.put("list_findbf_item_tv04", "+关注");
            list.add(map);
        }
        return list;
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void init() {
        mData = setTestData();
        FindBfAdapter adapter = new FindBfAdapter(mContext,mData);
        lv_remen_ba.setAdapter(adapter);
        adapter.setOnClickItemElementListenter(this);


    }

    @Override
    public void onItemElementClick(View v, int postion) {
        switch (v.getId()){
            case R.id.list_findbf_item_img:
                Intent intent = new Intent(mActivity, PersonHomeActitivity.class);//这里使用actviy  防止内存泄漏 TODO 传递一些标志着个人信息的数据,以此来进入不同的用户页面
                startActivity(intent);
                break;
        }
    }
}
