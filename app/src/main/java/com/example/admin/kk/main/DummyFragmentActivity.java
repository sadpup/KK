package com.example.admin.kk.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.kk.R;

import org.w3c.dom.Text;

/**
 * Created by lihongl on 2017/6/27.
 * emile is 24107661@qq.com
 */

public class DummyFragmentActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummyfragment_detail);
        int ii = getIntent().getExtras().getInt("ii");
        int bgc = getIntent().getExtras().getInt("bgc");
        TextView textView = (TextView) findViewById(R.id.dummy_activity_tv);
        textView.setText(textView.getText()+":"+ii);
        textView.setBackgroundColor(bgc);//没生效
    }
}
