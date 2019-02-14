package com.illusion.readinglights;

import com.illusion.readinglights.utils.ScreenUtils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtils.keepScreenOn(this);
    }
}
