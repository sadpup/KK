package com.example.admin.kk.login;

import android.util.DisplayMetrics;

/**
 * Created by lihongl on 2017/5/27.
 * emile is 24107661@qq.com
 * 作为中介者要起到 联系 处理部分和UI部分的功能，所以她应该包含该两者的实例，LoginView 和 LoginInteractor
 */

public class LoginPresenterImpl implements LoginPresenter ,LoginInteractor.OnLoginFinishedLisener{

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    LoginPresenterImpl(LoginView loginView ){
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentails(String username, String password) {
        if(loginView != null){
            loginView.showProgess();
        }

        loginInteractor.login(username,password,this);
    }

    @Override
    public void onUsernameError() {
        if(loginView != null){
            loginView.hideProgress();
            loginView.setUsernameError();
        }
    }

    @Override
    public void onPasswordError() {
        if(loginView != null){
            loginView.hideProgress();
            loginView.serPasswordError();
        }
    }

    @Override
    public void onSuccess() {
        loginView.navigateToHome();
    }
}
