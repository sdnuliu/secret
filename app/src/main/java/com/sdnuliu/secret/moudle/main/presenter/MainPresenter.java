package com.sdnuliu.secret.moudle.main.presenter;

import android.util.Log;

import com.sdnuliu.secret.framework.utils.ToastUtils;
import com.sdnuliu.secret.moudle.main.view.MainContract;

/**
 * Created by liuteng on 16/9/22.
 */
public class MainPresenter implements MainContract.Presenter {
    private static final String TAG = "MainPresenter";
    private MainContract.View mView;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void unsubscribe() {
        Log.d(TAG, "unsubscribe");
    }

    @Override
    public void start() {
        ToastUtils.showShort("mainPresenter start");
    }
}
