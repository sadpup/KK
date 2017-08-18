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
import android.widget.Button;
import android.widget.ListView;

import com.example.admin.kk.Mapplication;
import com.example.admin.kk.R;
import com.example.admin.kk.adapter.ReMenBaAdapter;
import com.example.admin.kk.login.LoginActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lihongl on 2017/6/24.
 * emile is 24107661@qq.com
 */

@SuppressLint("ValidFragment")
public class MainTab02_unsign extends BaseFragment implements View.OnClickListener{

    private Button main_tab02_createtrees_btn,main_tab02_jointrees_btn;

    @Override
    protected void initViews() {
        main_tab02_createtrees_btn = (Button) findViewById(R.id.main_tab02_createtrees_btn);
        main_tab02_jointrees_btn = (Button) findViewById(R.id.main_tab02_jointrees_btn);
        main_tab02_jointrees_btn.setOnClickListener(this);
        main_tab02_createtrees_btn.setOnClickListener(this);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void init() {
    }

    @SuppressLint("ValidFragment")
    public MainTab02_unsign(Mapplication application, Activity activity, Context context)  {
        super(application, activity, context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.main_tab_02,null);
        return super.onCreateView(inflater, container, savedInstanceState);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_tab02_createtrees_btn:
                Intent intent = new Intent(mActivity, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.main_tab02_jointrees_btn:
                Intent intent2 = new Intent(mActivity, LoginActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
