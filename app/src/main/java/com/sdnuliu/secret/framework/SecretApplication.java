package com.sdnuliu.secret.framework;

import android.app.Application;
import android.content.Context;

import com.sdnuliu.secret.framework.common.ActivityManager;

/**
 * Created by liuteng on 16/9/22.
 */

public class SecretApplication extends Application {

    private static SecretApplication instance;
    public static Context mApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mApplicationContext = this;
        init();
    }

    private void init() {
        //// TODO: 16/9/22 待定
    }

    public static SecretApplication getInstance() {
        return instance;
    }

    public void exit() {
        ActivityManager.getInstance().exit(this);
    }
}
