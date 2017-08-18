package com.example.admin.kk.login;

import android.os.Handler;

/**
 * Created by lihongl on 2017/5/28.
 * emile is 24107661@qq.com
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedLisener lisener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(username.isEmpty()){
                    lisener.onUsernameError();
                    return;
                }
                if(password.isEmpty()){
                    lisener.onPasswordError();
                    return;
                }
                lisener.onSuccess();
            }
        },2000);
    }
}
