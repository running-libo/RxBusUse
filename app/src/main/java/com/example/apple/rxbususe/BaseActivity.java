package com.example.apple.rxbususe;

import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import rx.Subscription;

/**
 * create by libo
 * create on 2018/12/27
 * description
 */
public class BaseActivity extends AppCompatActivity {
    protected ArrayList<Subscription> rxBusList = new ArrayList<>();

    @Override
    protected void onDestroy() {
        super.onDestroy();

        clearSubscription();
    }

    /**
     * 取消该页面所有订阅
     */
    private void clearSubscription() {
        for (Subscription subscription : rxBusList) {
            if (subscription != null && subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }
}
