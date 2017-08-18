package com.example.admin.kk.main;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.codbking.calendar.CaledarAdapter;
import com.codbking.calendar.CaledarTopViewChangeListener;
import com.codbking.calendar.CalendarBean;
import com.codbking.calendar.CalendarDateView;
import com.codbking.calendar.CalendarTopView;
import com.codbking.calendar.CalendarUtil;
import com.codbking.calendar.CalendarView;
import com.example.admin.kk.R;
import com.example.admin.kk.adapter.CalendarListAdapter;

import org.feezu.liuli.timeselector.TimeSelector;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lihongl on 2017/7/2.
 * emile is 24107661@qq.com
 */

public class CalendarActivity extends AppCompatActivity implements View.OnClickListener{

    private CalendarDateView calendar_date_view;

    private TextView calendar_back_tv,//返回的
            calendar_title_tv,//标题
            calendar_date_tv;//日期显示
    private ListView calendar_content_lv;

    private List<HashMap<String, Object>> mData;//封装布局下方的list数据
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendar_back_tv = (TextView) findViewById(R.id.calendar_back_tv);//返回键
        calendar_title_tv = (TextView) findViewById(R.id.calendar_title_tv);//标题明明
        calendar_date_view = (CalendarDateView) findViewById(R.id.calendar_date_view);//日历控件
        calendar_content_lv = (ListView) findViewById(R.id.calendar_content_lv);//下部加载数据的listview
        calendar_date_tv = (TextView) findViewById(R.id.calendar_date_tv);//顶部日期显示位置
        calendar_back_tv.setOnClickListener(this);
        calendar_date_tv.setOnClickListener(this);
        initView();
        initList();
    }

    private void initView() {

        calendar_date_view.setAdapter(new CaledarAdapter() {//这里到时候要抽出去一个adapter
            @Override
            public View getView(View convertView, ViewGroup parentView, CalendarBean bean) {

                if (convertView == null) {
                    convertView = LayoutInflater.from(parentView.getContext()).inflate(R.layout.list_calendar_item, null);
                }

                TextView chinaText = (TextView) convertView.findViewById(R.id.chinaText);
                TextView text = (TextView) convertView.findViewById(R.id.list_calendar_item_text);

                text.setText("" + bean.day);
                if (bean.mothFlag != 0) {
                    text.setTextColor(0xff9299a1);
                } else {
                    text.setTextColor(0xff444444);
                }
                chinaText.setText(bean.chinaDay);

                return convertView;
            }
        });

        calendar_date_view.setOnItemClickListener(new CalendarView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion, CalendarBean bean) {
                calendar_date_tv.setText(bean.year + "/" + bean.moth + "/" + bean.day);
                //TODO  刷新下方数据
                initList();
            }
        });

        int[] data = CalendarUtil.getYMD(new Date());
        calendar_date_tv.setText(data[0] + "/" + data[1] + "/" + data[2]);
    }
    private void initList() {
        mData = setTestData();
        CalendarListAdapter adapter = new CalendarListAdapter(this,mData);
        calendar_content_lv.setAdapter(adapter);
    }
    private List<HashMap<String, Object>> setTestData() {
        // 新建一个集合类，用于存放多条数据
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = null;
        for (int i = 1; i <= 8; i++) {
            map = new HashMap<String, Object>();
            map.put("list_calendar_item_title_desc",calendar_date_tv.getText().toString() + "日流下了如此笔记:");
            list.add(map);
        }
        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.calendar_back_tv:
                finish();
                break;
        case R.id.calendar_date_tv:
            int[] data = CalendarUtil.getYMD(new Date());
            //弹出选择框https://github.com/mrfluency/Time-Selector
            TimeSelector timeSelector = new TimeSelector(this, new TimeSelector.ResultHandler() {
                @Override
                public void handle(String time) {
                    Toast.makeText(getApplicationContext(), time.substring(0, time.indexOf(" ")), Toast.LENGTH_LONG).show();
                }
            }, "2013-11-22 17:34", data[0] + "-" + data[1] + "-" + data[2] + " 17:34");
//          timeSelector.setMode(TimeSelector.MODE.YMDHM);//显示 年月日时分（默认）；
            timeSelector.setMode(TimeSelector.MODE.YMD);//只显示 年月日
            timeSelector.setIsLoop(false);//不设置时为true，即循环显示
            timeSelector.setTitle("");
            timeSelector.setNextBtTip("确认");
            timeSelector.show();
            break;
        }
    }
}
