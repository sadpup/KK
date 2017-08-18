package com.example.admin.kk.main;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.kk.Mapplication;
import com.example.admin.kk.R;
import com.example.admin.kk.fragment.MainTab011;
import com.example.admin.kk.fragment.MainTab012_sign;
import com.example.admin.kk.fragment.MainTab012_unsign;
import com.example.admin.kk.fragment.MainTab013;
import com.example.admin.kk.fragment.MainTab014;
import com.example.admin.kk.fragment.MainTab02_sign;
import com.example.admin.kk.fragment.MainTab02_unsign;
import com.example.admin.kk.fragment.MainTab03_sign;
import com.example.admin.kk.fragment.MainTab03_unsign;
import com.example.admin.kk.fragment.MainTab04;
import com.example.admin.kk.login.LoginActivity;
import com.example.admin.kk.publish.PublishDialog;

import android.support.v4.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView ivMenu;

    PublishDialog pDialog;
    ImageButton custom_title_left_tv;
    ImageButton custom_title_btLogin,custom_title_btCalendar,custom_title_btAdd;//消息和日历和“+”，他仨在一个地方，+号创建树堆时候用的
    private LinearLayout ll_tab_bottom01;
    private LinearLayout ll_tab_bottom02;
    private LinearLayout ll_tab_bottom03;
    private LinearLayout ll_tab_bottom04;
    private ImageButton btn_tab_bottom01;
    private ImageButton btn_tab_bottom02;
    private ImageButton btn_tab_bottom03;
    private ImageButton btn_tab_bottom04;

    //这个是切换相关的
    private Mapplication mApplication;
    private FragmentManager fragmentManager;
    Fragment mTab011,mTab012,mTab013,mTab014,mTab02,mTab03,mTab04;

    //title 切换 相关的
    private TextView custom_title_center_tv;
    private RadioGroup custom_title_center_rg;
    private RadioButton custom_title_center_rb01,custom_title_center_rb02,custom_title_center_rb03,custom_title_center_rb04;
    private Drawable custom_title_radiobutton_selector;
    private static int currTab = 11;//用来记录当前tab,用于界面切换之后返回体验优化
    private static int currTopTab = 1;//用来记录当前tab,用于界面切换之后返回体验优化

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mApplication = Mapplication.getInstance();
        fragmentManager = getSupportFragmentManager();

        ivMenu = (ImageView) findViewById(R.id.ivMenu);//首页弹出菜单  “+”
        ivMenu.setOnClickListener(this);

        custom_title_left_tv = (ImageButton) findViewById(R.id.custom_title_left_tv);//顶部左侧按钮
        custom_title_btLogin = (ImageButton) findViewById(R.id.custom_title).findViewById(R.id.custom_title_btLogin);//title 中的登录按钮
        custom_title_btCalendar   = (ImageButton) findViewById(R.id.custom_title_btCalendar);//title 中的消息按钮，默认隐藏
        custom_title_btAdd   = (ImageButton) findViewById(R.id.custom_title_btAdd);
        custom_title_center_tv = (TextView) findViewById(R.id.custom_title_center_tv);
        custom_title_center_rg = (RadioGroup) findViewById(R.id.custom_title_center_rg);
        custom_title_center_rb01 = (RadioButton) findViewById(R.id.custom_title_center_rb01);
        custom_title_center_rb02 = (RadioButton) findViewById(R.id.custom_title_center_rb02);
        custom_title_center_rb03 = (RadioButton) findViewById(R.id.custom_title_center_rb03);
        custom_title_center_rb04 = (RadioButton) findViewById(R.id.custom_title_center_rb04);
        custom_title_radiobutton_selector = this.getResources().getDrawable(R.drawable.custom_title_radiobutton_selector);//TODO 这个忘了是干啥的了
        custom_title_center_rb01.setOnClickListener(this);
        custom_title_center_rb02.setOnClickListener(this);
        custom_title_center_rb03.setOnClickListener(this);
        custom_title_center_rb04.setOnClickListener(this);
        ll_tab_bottom01 = (LinearLayout) findViewById(R.id.bottom_bar).findViewById(R.id.ll_tab_bottom01);//底部四个菜单按钮 首页，树堆，待定
        ll_tab_bottom02 = (LinearLayout) findViewById(R.id.bottom_bar).findViewById(R.id.ll_tab_bottom02);
        ll_tab_bottom03 = (LinearLayout) findViewById(R.id.bottom_bar).findViewById(R.id.ll_tab_bottom03);
        ll_tab_bottom04 = (LinearLayout) findViewById(R.id.bottom_bar).findViewById(R.id.ll_tab_bottom04);
        btn_tab_bottom01 = (ImageButton) findViewById(R.id.btn_tab_bottom01);//控制下面四个按钮图片变化
        btn_tab_bottom02 = (ImageButton) findViewById(R.id.btn_tab_bottom02);//控制下面四个按钮图片变化
        btn_tab_bottom03 = (ImageButton) findViewById(R.id.btn_tab_bottom03);//控制下面四个按钮图片变化
        btn_tab_bottom04 = (ImageButton) findViewById(R.id.btn_tab_bottom04);//控制下面四个按钮图片变化
        custom_title_btLogin.setOnClickListener(this);
        custom_title_btCalendar.setOnClickListener(this);
        ll_tab_bottom01.setOnClickListener(this);
        ll_tab_bottom02.setOnClickListener(this);
        ll_tab_bottom03.setOnClickListener(this);
        ll_tab_bottom04.setOnClickListener(this);

    }

    /**
     * @param index
     * @param transaction
     * @see 设置显示的fragment 并且进行fragment切换时的优化处理
     * */
    private void setTabSelection(int index) {//
        currTab = index;
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        //TODO 控制按钮的初始颜色
        btn_tab_bottom01.setBackgroundResource(R.mipmap.home_off);
        btn_tab_bottom02.setBackgroundResource(R.mipmap.treeheep_off);
        btn_tab_bottom03.setBackgroundResource(R.mipmap.treetime_off);
        btn_tab_bottom04.setBackgroundResource(R.mipmap.my_off);


        //TODO 隐藏所有的fragment，以防止有多个Fragment显示在界面上的情况
        if (mTab011 != null) {
            transaction.hide(mTab011);
        }
        if (mTab012 != null) {
            transaction.hide(mTab012);
        }
        if (mTab013 != null) {
            transaction.hide(mTab013);
        }
        if (mTab014 != null) {
            transaction.hide(mTab014);
        }
        if (mTab02 != null) {
            transaction.hide(mTab02);
        }
        if (mTab03 != null) {
            transaction.hide(mTab03);
        }
        if (mTab04 != null) {
            transaction.hide(mTab04);
        }

        switch (index) {
            case 11:
                // TODO 当点击了消息tab时，改变控件的图片和文字颜色
                custom_title_center_tv.setVisibility(View.GONE);
                custom_title_center_rg.setVisibility(View.VISIBLE);
                custom_title_btCalendar.setVisibility(View.GONE);
                custom_title_btLogin.setVisibility(View.VISIBLE);
                custom_title_btAdd.setVisibility(View.GONE);
                custom_title_left_tv.setVisibility(View.VISIBLE);
                custom_title_center_tv.setCompoundDrawables(null,null,null,null);

                btn_tab_bottom01.setBackgroundResource(R.mipmap.home_on);//图片

                if (mTab011 == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mTab011 = new MainTab011(mApplication,this,this);
                    transaction.add(R.id.main_fl_context, mTab011);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mTab011);
                }
                break;
            case 12:
                // TODO 当点击了消息tab时，改变控件的图片和文字颜色
                custom_title_center_tv.setVisibility(View.GONE);
                custom_title_center_rg.setVisibility(View.VISIBLE);
                custom_title_btCalendar.setVisibility(View.GONE);
                custom_title_btLogin.setVisibility(View.VISIBLE);
                custom_title_btAdd.setVisibility(View.GONE);
                custom_title_left_tv.setVisibility(View.VISIBLE);
                custom_title_center_tv.setCompoundDrawables(null,null,null,null);

                btn_tab_bottom01.setBackgroundResource(R.mipmap.home_on);//图片
                if(Mapplication.logined)
                    mTab012 = new MainTab012_sign(mApplication,this,this);
                else
                    mTab012 = new MainTab012_unsign(mApplication,this,this);
                transaction.add(R.id.main_fl_context, mTab012);
                break;
            case 13:
                // TODO 当点击了消息tab时，改变控件的图片和文字颜色
                custom_title_center_tv.setVisibility(View.GONE);
                custom_title_center_rg.setVisibility(View.VISIBLE);
                custom_title_btCalendar.setVisibility(View.GONE);
                custom_title_btLogin.setVisibility(View.VISIBLE);
                custom_title_btAdd.setVisibility(View.GONE);
                custom_title_left_tv.setVisibility(View.VISIBLE);
                custom_title_center_tv.setCompoundDrawables(null,null,null,null);

                btn_tab_bottom01.setBackgroundResource(R.mipmap.home_on);//图片
                if (mTab013 == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mTab013 = new MainTab013(mApplication,this,this);
                    transaction.add(R.id.main_fl_context, mTab013);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mTab013);
                }
                break;
            case 14:
                // TODO 当点击了消息tab时，改变控件的图片和文字颜色
                custom_title_center_tv.setVisibility(View.GONE);
                custom_title_center_rg.setVisibility(View.VISIBLE);
                custom_title_btCalendar.setVisibility(View.GONE);
                custom_title_btLogin.setVisibility(View.VISIBLE);
                custom_title_btAdd.setVisibility(View.GONE);
                custom_title_left_tv.setVisibility(View.VISIBLE);
                custom_title_center_tv.setCompoundDrawables(null,null,null,null);

                btn_tab_bottom01.setBackgroundResource(R.mipmap.home_on);//图片
                if (mTab014 == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mTab014 = new MainTab014(mApplication,this,this);
                    transaction.add(R.id.main_fl_context, mTab014);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mTab014);
                }
                break;
            case 2://树堆界面
                // TODO 当点击了消息tab时，改变控件的图片和文字颜色
                custom_title_center_tv.setVisibility(View.VISIBLE);
                custom_title_center_tv.setText("树堆");
                custom_title_center_rg.setVisibility(View.GONE);
                custom_title_btAdd.setVisibility(View.VISIBLE);//显示+按钮
                custom_title_btCalendar.setVisibility(View.GONE);
                custom_title_btLogin.setVisibility(View.GONE);
                custom_title_left_tv.setVisibility(View.VISIBLE);
                custom_title_center_tv.setCompoundDrawables(null,null,null,null);

                btn_tab_bottom02.setBackgroundResource(R.mipmap.treeheep_on);//图片
                if(Mapplication.logined)
                    mTab02 = new MainTab02_sign(mApplication,this,this);
                else
                    mTab02 = new MainTab02_unsign(mApplication,this,this);
                transaction.add(R.id.main_fl_context, mTab02);
                break;
            case 3://树轴界面
                // TODO 当点击了消息tab时，改变控件的图片和文字颜色
                custom_title_center_tv.setVisibility(View.VISIBLE);
                custom_title_center_tv.setText("树轴");
                custom_title_center_rg.setVisibility(View.GONE);
                custom_title_btCalendar.setVisibility(View.VISIBLE);
                custom_title_btLogin.setVisibility(View.GONE);
                custom_title_btAdd.setVisibility(View.GONE);
                custom_title_left_tv.setVisibility(View.VISIBLE);
                custom_title_center_tv.setCompoundDrawables(null,null,null,null);

                btn_tab_bottom03.setBackgroundResource(R.mipmap.treetime_on);//图片
                if(Mapplication.logined)
                    mTab03 = new MainTab03_sign(mApplication,this,this);
                else
                    mTab03 = new MainTab03_unsign(mApplication,this,this);
                transaction.add(R.id.main_fl_context, mTab03);
                break;
            case 4://我的界面
                // TODO 当点击了消息tab时，改变控件的图片和文字颜色
                custom_title_center_tv.setVisibility(View.VISIBLE);
                custom_title_center_tv.setText("玛丽苏小黎");
                custom_title_center_rg.setVisibility(View.GONE);
                custom_title_btCalendar.setVisibility(View.GONE);
                custom_title_btLogin.setVisibility(View.GONE);
                custom_title_btAdd.setVisibility(View.GONE);
                custom_title_left_tv.setVisibility(View.GONE);

                Drawable drawable = this.getResources().getDrawable(R.mipmap.ic_launcher_round);
                drawable.setBounds(0, 0, 100,100);//drawable.getMinimumWidth(), drawable.getMinimumHeight());
                custom_title_center_tv.setCompoundDrawables(drawable,null,null,null);

                btn_tab_bottom04.setBackgroundResource(R.mipmap.my_on);//图片

                if (mTab04 == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mTab04 = new MainTab04(mApplication,this,this);
                    transaction.add(R.id.main_fl_context, mTab04);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mTab04);
                }
                break;

            default:
                break;
        }
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //设置初始界面为首页
        setTabSelection(currTab);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.custom_title_btLogin://消息按钮
                if(Mapplication.logined)
                    startActivity(new Intent(this,MessageActivity.class));
                else
                    startActivity(new Intent(this,LoginActivity.class));
                break;
            case R.id.ivMenu://加号弹出窗
                if (pDialog == null) {
                    pDialog = new PublishDialog(MainActivity.this);
                    pDialog.setArticleBtnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "功能开发中。。。", Toast.LENGTH_LONG).show();
                        }
                    });
                    pDialog.setMiniBlogBtnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Intent intent  = new Intent(MainActivity.this,AbstractActivity.class);
                            startActivity(intent);
                        }
                    });
                    pDialog.setLetterBtnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "功能开发中。。。", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                pDialog.show();
                break;
            case R.id.custom_title_center_rb01://首页--关注
                currTopTab = 1;
                setTabSelection(11);
                break;
            case R.id.custom_title_center_rb02://首页--自选
                currTopTab = 2;
                setTabSelection(12);
                break;
            case R.id.custom_title_center_rb03://首页--精选
                currTopTab = 3;
                setTabSelection(13);
                break;
            case R.id.custom_title_center_rb04://首页--发现
                currTopTab = 4;
                setTabSelection(14);
                break;
            case R.id.ll_tab_bottom01://首页--关注
                setTabSelection(10 + currTopTab);
                break;
            case R.id.ll_tab_bottom02://树堆
                setTabSelection(2);
                break;
            case R.id.ll_tab_bottom03://树轴(点击的时候去判断是否登录了,选择跳转关系最合理)
                setTabSelection(3);
                break;
            case R.id.ll_tab_bottom04://我的
                if(Mapplication.logined)
                    setTabSelection(4);
                else
                    startActivity(new Intent(this,LoginActivity.class));
                break;
        }

    }
}
