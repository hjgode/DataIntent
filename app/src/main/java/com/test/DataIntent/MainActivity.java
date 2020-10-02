package com.test.DataIntent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.test.DataIntent.BuildConfig;


public class MainActivity extends AppCompatActivity {
    public TextView tv_result;
    private BarcodeReceiver barcodeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_result=findViewById(R.id.tv_result);
//        tv_result.setMovementMethod(new ScrollingMovementMethod());
        ((MyApplication) getApplication()).tv_result=this.tv_result;

        this.barcodeReceiver = new BarcodeReceiver();

        registerReceiver();
    }

    @Override
    public void onResume(){
        super.onResume();
        registerReceiver();
    }
    @Override
    public void onPause(){
        super.onPause();
        unregisterReceiver();
    }
    void registerReceiver(){
        IntentFilter filter = new IntentFilter("com.test.intent.action.BARCODE");
        //TODO: Honeywell needs ALWAYS a Category-NOT NULL, i.e. "android.intent.category.DEFAULT"
        filter.addCategory("android.intent.category.DEFAULT1");
        registerReceiver(this.barcodeReceiver, filter);
    }
    void unregisterReceiver(){
        unregisterReceiver(this.barcodeReceiver);
    }

    public void clear(View view) {
        this.tv_result.setText("");
    }

}