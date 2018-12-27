package com.example.apple.rxbususe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RecieveActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve);
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, RecieveActivity.class));
    }



    public void sendEvent(View view) {
        RxBus.getDefault().post(new EventBean(1, "听说名字长回头率很高"));
    }
}
