package com.sdnuliu.secret.moudle.main.presenter;

import android.util.Log;

import com.sdnuliu.secret.framework.base.BasePresenter;

/**
 * Created by liuteng on 16/9/22.
 */
public class MainPresenter implements BasePresenter {
    private static final String TAG = "MainPresenter";

    @Override
    public void unsubscribe() {
        Log.d(TAG, "unsubscribe");
    }
}
