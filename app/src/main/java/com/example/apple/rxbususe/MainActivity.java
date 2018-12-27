package com.example.apple.rxbususe;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends BaseActivity {
    private TextView tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContent = findViewById(R.id.tv_content);
        recieveEvent();
    }

    public void jump(View view) {
        RecieveActivity.start(this);
    }

    private void recieveEvent() {
        Subscription subscription = RxBus.getDefault().toObservable(EventBean.class).subscribe(new Action1<EventBean>() {
            @Override
            public void call(EventBean eventBean) {
                tvContent.setText(eventBean.getUserId() + "------" + eventBean.getNickName());
            }
        });
        rxBusList.add(subscription);
    }
}
