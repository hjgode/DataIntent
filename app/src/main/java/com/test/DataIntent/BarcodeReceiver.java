package com.test.DataIntent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BarcodeReceiver  extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Bundle bundle;
        Object obj;
        Log.e("!!!", intent.getAction() + intent.getCategories() + "");
        TextView tv_result = ((MyApplication) context.getApplicationContext()).tv_result;
        if (tv_result != null && intent != null && (bundle = intent.getExtras()) != null) {
            for (String key : bundle.keySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append(tv_result.getText().toString());
                sb.append("Key=");
                sb.append(key);
                sb.append(", value=");
                if (bundle.getString(key) == null) {
                    obj = bundle.getByteArray(key) != null ? getDatabytes(bundle.getByteArray(key)) : Integer.valueOf(bundle.getInt(key));
                } else {
                    obj = bundle.getString(key);
                }
                sb.append(obj);
                sb.append("\n");
                tv_result.setText(sb.toString());
            }
            tv_result.setText(tv_result.getText().toString() + "\n");
        }
    }

    private String getDatabytes(byte[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte temp : arr) {
            sb.append(temp);
        }
        return sb.toString();
    }
}
