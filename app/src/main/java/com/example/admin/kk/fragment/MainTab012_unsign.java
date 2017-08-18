package com.example.admin.kk.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.admin.kk.Mapplication;
import com.example.admin.kk.R;
import com.example.admin.kk.adapter.ReMenBaAdapter;
import com.example.admin.kk.interfacee.OnClickItemElementListenter;
import com.example.admin.kk.main.PersonHomeActitivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lihongl on 2017/6/24.
 * emile is 24107661@qq.com
 */

@SuppressLint("ValidFragment")
public class MainTab012_unsign extends BaseFragment implements OnClickItemElementListenter{


    ListView mtab02_unsign_lv ;
    private List<HashMap<String, Object>> mData;

    @Override
    protected void initViews() {
        mtab02_unsign_lv = (ListView) findViewById(R.id.mtab02_unsign_lv);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void init() {
        mData = setTestData();
        ReMenBaAdapter adapter = new ReMenBaAdapter(mContext,mData);
        mtab02_unsign_lv.setAdapter(adapter);
        adapter.setOnClickItemElementListenter(this);
    }

    @SuppressLint("ValidFragment")
    public MainTab012_unsign(Mapplication application, Activity activity, Context context)  {
        super(application, activity, context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.main_tab_012_unsign,null);
        return super.onCreateView(inflater, container, savedInstanceState);

    }


    private List<HashMap<String, Object>> setTestData() {
        //TODO 这里暂时先构造一个加图片
        Drawable nav_up = getResources().getDrawable(R.mipmap.ic_launcher);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());

        // 新建一个集合类，用于存放多条数据
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = null;
        for (int i = 1; i <= 20; i++) {
            map = new HashMap<String, Object>();
            map.put("remen_logo_img_tv", nav_up);
//            map.put("img", R.mipmap.ic_launcher);
            map.put("remen_title_tv", "时光老了好少年");
            map.put("renmen_flllow_tv", "246");
            map.put("remen_loc_author_tv", "[北京]kk");
            map.put("remen_book_type_tv", "书摘");
            list.add(map);
        }
        return list;
    }

    @Override
    public void onItemElementClick(View v, int postion) {
        switch (v.getId()){
            case R.id.remen_logo_img_tv:
                Intent intent = new Intent(mActivity, PersonHomeActitivity.class);//这里使用actviy  防止内存泄漏 TODO 传递一些标志着个人信息的数据,以此来进入不同的用户页面
                startActivity(intent);
                break;
        }
    }
}
