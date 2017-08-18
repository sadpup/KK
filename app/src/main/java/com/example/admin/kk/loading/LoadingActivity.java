package com.example.admin.kk.loading;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.admin.kk.R;
import com.example.admin.kk.main.MainActivity;

import android.os.Handler;

/**
 * Created by lihongl on 2017/6/17.
 * emile is 24107661@qq.com
 */

public class LoadingActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        //TODO 可以加入一个 “进入按钮只点击一次的效果”

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loading(null);
            }
        },2000);

    }

    public void loading(View view) {
        if(this == null){

        }else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            finish();
        }
    }
}
