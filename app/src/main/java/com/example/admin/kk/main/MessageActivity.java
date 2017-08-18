package com.example.admin.kk.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.admin.kk.Mapplication;
import com.example.admin.kk.R;
import com.example.admin.kk.fragment.MessageTab01;
import com.example.admin.kk.fragment.MessageTab02;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener{

    //操作相关
    private Mapplication mApplication;
    private FragmentManager fragmentManager;
    //切换相关
    private MessageTab01 mTab01 = null;
    private MessageTab02 mTab02 = null;
    //页面按钮
    private TextView message_title_back_tv;
    private RadioButton message_title_tab_rb01;
    private RadioButton message_title_tab_rb02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        mApplication = Mapplication.getInstance();
        fragmentManager = getSupportFragmentManager();

        message_title_back_tv = (TextView) findViewById(R.id.message_title_back_tv);
        message_title_tab_rb01 = (RadioButton) findViewById(R.id.message_title_tab_rb01);
        message_title_tab_rb02 = (RadioButton) findViewById(R.id.message_title_tab_rb02);
        message_title_back_tv.setOnClickListener(this);
        message_title_tab_rb01.setOnClickListener(this);
        message_title_tab_rb02.setOnClickListener(this);

        //设置初始界面为首页
        setTabSelection(1);
    }

    /**
     * @param index
     * @param transaction
     * @see 设置显示的fragment 并且进行fragment切换时的优化处理
     * */
    private void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        //TODO 控制按钮的初始颜色

        //TODO 隐藏所有的fragment，以防止有多个Fragment显示在界面上的情况
        if (mTab01 != null) {
            transaction.hide(mTab01);
        }
        if (mTab02 != null) {
            transaction.hide(mTab02);
        }

        switch (index) {
            case 1:
                // TODO 当点击了消息tab时，改变控件的图片和文字颜色
                if (mTab01 == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mTab01 = new MessageTab01(mApplication,this,this);
                    transaction.add(R.id.message_fl_context, mTab01);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mTab01);
                }
                break;
            case 2:
                // TODO 当点击了消息tab时，改变控件的图片和文字颜色
                if (mTab02 == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mTab02 = new MessageTab02(mApplication,this,this);
                    transaction.add(R.id.message_fl_context, mTab02);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mTab02);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.message_title_back_tv:
                finish();
                break;
            case R.id.message_title_tab_rb01:
                setTabSelection(1);
                break;
            case R.id.message_title_tab_rb02:
                setTabSelection(2);
                break;
        }

    }
}
