package com.example.admin.kk.login;

/**
 * Created by lihongl on 2017/5/28.
 * emile is 24107661@qq.com
 */

public interface LoginInteractor {

    interface OnLoginFinishedLisener{

        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String username,String password,OnLoginFinishedLisener lisener);

}
