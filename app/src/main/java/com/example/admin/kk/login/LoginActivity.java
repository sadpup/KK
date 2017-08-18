package com.example.admin.kk.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.kk.Mapplication;
import com.example.admin.kk.R;
import com.example.admin.kk.main.MainActivity;

import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/**
 * Created by lihongl on 2017/5/27.
 * emile is 24107661@qq.com
 */

public class LoginActivity extends Activity implements LoginView , View.OnClickListener{

    private ProgressBar progressBar;
    private EditText username ;
    private EditText password;
    private Button login;
    private TextView back;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progess);
        username = (EditText) findViewById(R.id.username);
        password  = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login_login_bt);
        back = (TextView) findViewById(R.id.login_back_tv);

        login.setOnClickListener(this);
        back.setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_back_tv:
                finish();
                break;
            case R.id.login_login_bt:
                presenter.validateCredentails(username.getText().toString(),password.getText().toString());
                break;
        }
    }

    void loginActivityFinash(View view){
        finish();
    }

    @Override
    public void showProgess() {
            progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
            progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError("username is error");
    }

    @Override
    public void serPasswordError() {
        password.setError("password is error");
    }

    @Override
    public void navigateToHome() {
        Mapplication.getInstance().logined = true;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
