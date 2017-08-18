package com.example.admin.kk.login;

/**
 * Created by lihongl on 2017/5/27.
 * emile is 24107661@qq.com
 */

public interface LoginView {

    void showProgess();

    void hideProgress();

    void setUsernameError();

    void serPasswordError();

    void navigateToHome();

}
