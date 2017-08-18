/**
 * Copyright 2015 Bartosz Lipinski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.admin.kk.fragment;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.kk.R;
import com.example.admin.kk.main.DummyFragmentActivity;


/**
 * Created by Bartosz Lipinski
 * 28.01.15
 */
public class DummyFragment extends BaseFragment implements View.OnClickListener{

    private static final String EXTRA_COLOR = "com.bartoszlipinski.flippablestackview.fragment.DummyFragment.EXTRA_COLOR";

    LinearLayout mMainLayout;

    public static DummyFragment newInstance(int backgroundColor,int i) {
        DummyFragment fragment = new DummyFragment();
        Bundle bdl = new Bundle();
        bdl.putInt(EXTRA_COLOR, backgroundColor);
        bdl.putInt("i", i);//增加了一个值

        fragment.setArguments(bdl);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dummy, container, false);
        Bundle bdl = getArguments();

        ii = bdl.getInt("i");
        bgc = bdl.getInt(EXTRA_COLOR);

        mMainLayout = (LinearLayout) v.findViewById(R.id.main_layout);

        LayerDrawable bgDrawable = (LayerDrawable) mMainLayout.getBackground();
        GradientDrawable shape = (GradientDrawable) bgDrawable.findDrawableByLayerId(R.id.background_shape);
//        shape.setColor(bdl.getInt(EXTRA_COLOR));

        TextView tv = (TextView) v.findViewById(R.id.tv2);//TODO 增加了一个视图
        tv.setText("中间是一张布局截图,低"+bdl.getInt("i")+"张");

        mMainLayout.setOnClickListener(this);

        return v;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void init() {

    }


    int ii;
    int bgc;
    @Override
    public void onClick(View v) {
        Intent dummyIntent = new Intent(this.getActivity(),DummyFragmentActivity.class);
        dummyIntent.putExtra("ii",ii);
        dummyIntent.putExtra(EXTRA_COLOR,bgc);
        startActivity(dummyIntent);
    }
}
