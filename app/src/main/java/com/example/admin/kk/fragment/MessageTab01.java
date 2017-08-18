package com.example.admin.kk.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.kk.Mapplication;
import com.example.admin.kk.R;
import com.example.admin.kk.adapter.MessageTab01Adapter;
import com.example.admin.kk.adapter.ReMenBaAdapter;
import com.example.admin.kk.main.PersonHomeActitivity;
import com.example.admin.kk.view.flippablestackview.FlippableStackView;
import com.example.admin.kk.view.flippablestackview.StackPageTransformer;
import com.example.admin.kk.view.flippablestackview.ValueInterpolator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lihongl on 2017/6/24.
 * emile is 24107661@qq.com
 * @see 首页关注界面主体。显示了一个滚动vire
 */

@SuppressLint("ValidFragment")
public class MessageTab01 extends BaseFragment implements MessageTab01Adapter.OnItemMessageTab01Listener{

    ListView message_tab01_lv ;
    private List<HashMap<String, Object>> mData;

    @Override
    protected void initViews() {
        message_tab01_lv = (ListView) findViewById(R.id.message_tab01_lv);

    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void init() {
        mData = setTestData();
        MessageTab01Adapter adapter = new MessageTab01Adapter(mContext,mData);
        message_tab01_lv.setAdapter(adapter);
        adapter.setOnItemMessageTab01Listener(this);
    }

    @SuppressLint("ValidFragment")
    public MessageTab01(Mapplication application, Activity activity, Context context)  {
        super(application, activity, context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.message_tab_01,null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    private List<HashMap<String, Object>> setTestData() {
        // 新建一个集合类，用于存放多条数据
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = null;
        for (int i = 1; i <= 5; i++) {
            map = new HashMap<String, Object>();
            map.put("message_tab01_item_img", R.mipmap.ic_launcher_round);//这里为了省事，直接使用了资源ID，以后要用Bitmap显示,这样可以适配网络图片和本地图片两种情况【待定】TODO
//            map.put("img", R.mipmap.ic_launcher);
            map.put("message_tab01_item_tv01", "好少年");
            map.put("message_tab01_item_tv02", "关注了你");
            map.put("message_tab01_item_follow_tv", "+ 关注");
            map.put("message_tab01_item_tv03", i + "分钟以前");
            list.add(map);
        }
        for (int i = 6; i <= 11; i++) {
            map = new HashMap<String, Object>();
            map.put("message_tab01_item_img", R.mipmap.ic_launcher);
//            map.put("img", R.mipmap.ic_launcher);
            map.put("message_tab01_item_tv01", "言旭");
            map.put("message_tab01_item_tv02", "赞了你");
            map.put("message_tab01_item_follow_tv", "已关注");
            map.put("message_tab01_item_tv03", i + "分钟以前");
            list.add(map);
        }
        return list;
    }

    @Override
    public void onItemClick(View v, int i) {
        switch (v.getId()){
            case R.id.message_tab01_item_follow_tv:
                TextView follow_tv = (TextView) v;
                follow_tv.setText("已关注");
                Toast.makeText(this.getActivity(),"点击了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.message_tab01_item_img:
                Intent intent = new Intent(mActivity, PersonHomeActitivity.class);//这里使用actviy  防止内存泄漏 TODO 传递一些标志着个人信息的数据,以此来进入不同的用户页面
                startActivity(intent);
                break;
            default:
                Toast.makeText(this.getActivity(),"点击了"+v.getId(),Toast.LENGTH_SHORT).show();
        }
    }
}
