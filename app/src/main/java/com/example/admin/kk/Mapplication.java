package com.example.admin.kk;

import android.app.Application;

/**
 * Created by lihongl on 2017/6/17.
 * emile is 24107661@qq.com
 */

public class Mapplication extends Application{

    public static Mapplication instance;
    public static boolean logined = false;//登录状态位，暂时写在这里

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public static Mapplication getInstance() {
        if(instance == null)
            instance = new Mapplication();
        return instance;
    }
}
