package com.example.admin.kk.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.kk.Mapplication;
import com.example.admin.kk.R;
import com.example.admin.kk.fragment.PersonHomeTab01;
import com.example.admin.kk.fragment.PersonHomeTab02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihongl on 2017/7/1.
 * emile is 24107661@qq.com
 */

public class PersonHomeActitivity extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{

    private RadioButton person_home_tab_rb01,person_home_tab_rb02;
    private PersonHomeTab01 mTab01;
    private PersonHomeTab02 mTab02;

    //操作相关
    private Mapplication mApplication;
    private FragmentManager fragmentManager;
    private TextView person_home_back_tv;

    //切换相关 viewpager
    private List<Fragment> mTabContents = new ArrayList<Fragment>();
    private FragmentPagerAdapter mAdapter;
    private ViewPager mViewPager;
    private RadioGroup person_home_tab_rg;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_home);
        mApplication = Mapplication.getInstance();
        fragmentManager = getSupportFragmentManager();
        mViewPager = (ViewPager) findViewById(R.id.person_home_tab_vp);
        person_home_tab_rg = (RadioGroup) findViewById(R.id.person_home_tab_rg);

        person_home_back_tv = (TextView) findViewById(R.id.person_home_back_tv);
        person_home_tab_rb01 = (RadioButton) findViewById(R.id.person_home_tab_rb01);
        person_home_tab_rb02 = (RadioButton) findViewById(R.id.person_home_tab_rb02);
        person_home_tab_rb01.setOnClickListener(this);
        person_home_tab_rb02.setOnClickListener(this);
        person_home_back_tv.setOnClickListener(this);

        mTab01 = new PersonHomeTab01(mApplication,this,this);
        mTab02 = new PersonHomeTab02(mApplication,this,this);
        mTabContents.add(mTab01);
        mTabContents.add(mTab02);
        mAdapter = new FragmentPagerAdapter(fragmentManager) {
            @Override
            public int getCount() {
                return mTabContents.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mTabContents.get(position);
            }
        };

        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(this);
        //设置初始界面为首页
//        setTabSelection(1);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.person_home_back_tv:
                finish();
                break;
            case R.id.person_home_tab_rb01:
//                setTabSelection(1);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.person_home_tab_rb02:
                mViewPager.setCurrentItem(1);
//                setTabSelection(2);
                break;
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {
        person_home_tab_rg.getChildAt(i).setClickable(true);
        Toast.makeText(mApplication, "i:"+i, Toast.LENGTH_SHORT).show();
    }
}
