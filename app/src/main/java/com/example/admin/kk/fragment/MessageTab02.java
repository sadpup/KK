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
import com.example.admin.kk.adapter.MessageTab02Adapter;
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
public class MessageTab02 extends BaseFragment implements MessageTab02Adapter.OnItemMessageTab01Listener,AdapterView.OnItemClickListener{

    ListView message_tab02_lv ;
    private List<HashMap<String, Object>> mData;

    @Override
    protected void initViews() {
        message_tab02_lv = (ListView) findViewById(R.id.message_tab02_lv);

    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void init() {
        mData = setTestData();
        MessageTab02Adapter adapter = new MessageTab02Adapter(mContext,mData);
        message_tab02_lv.setAdapter(adapter);
        adapter.setOnItemMessageTab01Listener(this);
    }

    @SuppressLint("ValidFragment")
    public MessageTab02(Mapplication application, Activity activity, Context context)  {
        super(application, activity, context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.message_tab_02,null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    private List<HashMap<String, Object>> setTestData() {
        // 新建一个集合类，用于存放多条数据
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = null;
        for (int i = 1; i <= 5; i++) {
            map = new HashMap<String, Object>();
            map.put("message_tab02_item_img", R.mipmap.ic_launcher_round);//这里为了省事，直接使用了资源ID，以后要用Bitmap显示,这样可以适配网络图片和本地图片两种情况【待定】TODO
//            map.put("img", R.mipmap.ic_launcher);
            map.put("message_tab02_item_tv01", "冯小刚");
            map.put("message_tab02_item_timediff_tv", i + "分钟以前");
            map.put("message_tab02_item_tv02", "评论：" + i+ "“你写的文笔很喜欢呢呢你写的文笔很喜欢呢呢你写的文笔很喜欢呢呢你写的文笔很喜欢呢呢你写的文笔很喜欢呢呢你写的文笔很喜欢呢呢”");
            list.add(map);
        }
        return list;
    }

    @Override
    public void onItemClick(View v, int i) {
        switch (v.getId()){
//            case R.id.message_tab02_item_follow_tv:
//                TextView follow_tv = (TextView) v;
//                follow_tv.setText("已关注");
//                break;
//            default:
//                Toast.makeText(this.getActivity(),"点击了"+v.getId(),Toast.LENGTH_SHORT).show();
            case R.id.message_tab02_item_img:
                Intent intent = new Intent(mActivity, PersonHomeActitivity.class);//这里使用actviy  防止内存泄漏 TODO 传递一些标志着个人信息的数据,以此来进入不同的用户页面
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this.getActivity(),"消息ID："+position,Toast.LENGTH_SHORT).show();
    }
}
