package com.example.admin.kk.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.kk.Mapplication;
import com.example.admin.kk.R;
import com.example.admin.kk.adapter.PersonHomeTab02Adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lihongl on 2017/6/24.
 * emile is 24107661@qq.com
 * @see 首页关注界面主体。显示了一个滚动vire
 */

@SuppressLint("ValidFragment")
public class PersonHomeTab02 extends BaseFragment implements AdapterView.OnItemClickListener{

    GridView person_home_tab02_gv;
    private List<HashMap<String, Object>> mData;

    @Override
    protected void initViews() {
        person_home_tab02_gv = (GridView) findViewById(R.id.person_home_tab02_gv);

    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void init() {
        mData = setTestData();
        PersonHomeTab02Adapter adapter = new PersonHomeTab02Adapter(mContext,mData);
        person_home_tab02_gv.setAdapter(adapter);
        person_home_tab02_gv.setOnItemClickListener(this);
    }

    @SuppressLint("ValidFragment")
    public PersonHomeTab02(Mapplication application, Activity activity, Context context)  {
        super(application, activity, context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.person_home_tab_02,null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    private List<HashMap<String, Object>> setTestData() {
        // 新建一个集合类，用于存放多条数据
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = null;
        for (int i = 1; i <= 4; i++) {
            map = new HashMap<String, Object>();
            map.put("person_home_tab02_item_img",R.mipmap.ic_launcher_round);//这里为了省事，直接使用了资源ID，以后要用Bitmap显示,这样可以适配网络图片和本地图片两种情况【待定】TODO
            map.put("person_home_tab02_item_tv", "好少年" + i);
            list.add(map);
        }
        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv = (TextView) view.findViewById(R.id.person_home_tab02_item_tv);
        Toast.makeText(this.getActivity(),tv.getText() , Toast.LENGTH_SHORT).show();
    }
}
