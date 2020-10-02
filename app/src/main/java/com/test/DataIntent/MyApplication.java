package com.test.DataIntent;

import android.app.Application;
import android.widget.TextView;

public class MyApplication extends Application {
    public String extraKey;
    public TextView tv_result;

    public void onCreate() {
        super.onCreate();
    }
}