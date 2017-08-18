package com.example.admin.kk.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.codbking.calendar.CaledarAdapter;
import com.codbking.calendar.CalendarBean;
import com.codbking.calendar.CalendarDateView;
import com.codbking.calendar.CalendarUtil;
import com.codbking.calendar.CalendarView;
import com.example.admin.kk.R;
import com.example.admin.kk.adapter.CalendarListAdapter;

import org.feezu.liuli.timeselector.TimeSelector;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.example.admin.kk.R.id.webview;

/**
 * Created by lihongl on 2017/7/2.
 * emile is 24107661@qq.com
 */

public class AbstractActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView abstract_back_tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstract);
        abstract_back_tv  = (TextView) findViewById(R.id.abstract_back_tv);
        abstract_back_tv.setOnClickListener(this);
        WebView webView = (WebView) findViewById(webview);
        webView.loadUrl("http://baidu.com");

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.abstract_back_tv:
                finish();
                break;
        }
    }
}
