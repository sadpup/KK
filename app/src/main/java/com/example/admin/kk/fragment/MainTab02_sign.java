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

/**
 * Created by lihongl on 2017/6/24.
 * emile is 24107661@qq.com
 */

@SuppressLint("ValidFragment")
public class MainTab02_sign extends BaseFragment implements View.OnClickListener{

    @Override
    protected void initViews() {
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void init() {
    }

    @SuppressLint("ValidFragment")
    public MainTab02_sign(Mapplication application, Activity activity, Context context)  {
        super(application, activity, context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.main_tab_02_sign,null);
        return super.onCreateView(inflater, container, savedInstanceState);

    }


    @Override
    public void onClick(View v) {
    }
}
