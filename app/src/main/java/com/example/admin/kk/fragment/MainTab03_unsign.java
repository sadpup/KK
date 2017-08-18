package com.example.admin.kk.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.admin.kk.Mapplication;
import com.example.admin.kk.R;
import com.example.admin.kk.login.LoginActivity;
import com.example.admin.kk.main.PersonHomeActitivity;

/**
 * Created by lihongl on 2017/6/24.
 * emile is 24107661@qq.com
 */

@SuppressLint("ValidFragment")
public class MainTab03_unsign extends BaseFragment implements  View.OnClickListener{

    private Button main_tab03_unsign_login_btn;

    @Override
    protected void initViews() {
        main_tab03_unsign_login_btn = (Button) findViewById(R.id.main_tab03_unsign_login_btn);
    }

    @Override
    protected void initEvents() {
        main_tab03_unsign_login_btn.setOnClickListener(this);
    }

    @Override
    protected void init() {

    }

    @SuppressLint("ValidFragment")
    public MainTab03_unsign(Mapplication application, Activity activity, Context context)  {
        super(application, activity, context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.main_tab_03_unsign,null);
        return super.onCreateView(inflater, container, savedInstanceState);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_tab03_unsign_login_btn:
                Intent intent = new Intent(mActivity, LoginActivity.class);//这里使用actviy  防止内存泄漏 TODO 传递一些标志着个人信息的数据,以此来进入不同的用户页面
                startActivity(intent);
                break;
        }
    }
}
