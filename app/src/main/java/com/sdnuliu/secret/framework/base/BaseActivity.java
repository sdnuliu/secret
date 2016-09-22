package com.sdnuliu.secret.framework.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.sdnuliu.secret.framework.common.ActivityManager;
import com.sdnuliu.secret.framework.utils.ToastUtils;
import com.sdnuliu.secret.framework.widget.DialogLoading;

/**
 * Created by liuteng on 16/9/22.
 * activity 基类
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements View.OnClickListener {

    protected Context mContext;
    /**
     * 页面的根View
     */
    protected View mBaseView;

    protected String fromWhere;

    /**
     * 对应的Presenter
     */
    private T presenter;

    private DialogLoading loading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        ActivityManager.getInstance().addActivity(this);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        View view = LayoutInflater.from(this).inflate(layoutResID, null);
        setContentView(view);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        mBaseView = view;
        init();
    }

    private void init() {
        initViews();
        bindEvents();
        initFromWhere();
    }

    public void createPresenter(T presenter) {
        if (presenter != null)
            this.presenter = presenter;
    }

    /**
     * 跳转页面
     *
     * @param clazz clazz
     */
    public void skipAct(Class clazz) {
        Intent intent = new Intent(this, clazz);
        intent.putExtra("fromWhere", getClass().getSimpleName());
        startActivity(intent);
    }

    /**
     * 跳转页面
     *
     * @param clazz  clazz
     * @param bundle data
     */
    public void skipAct(Class clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        intent.putExtra("fromWhere", getClass().getSimpleName());
        startActivity(intent);
    }

    /**
     * 跳转页面
     *
     * @param clazz  clazz
     * @param bundle data
     * @param flags  flags
     */
    public void skipAct(Class clazz, Bundle bundle, int flags) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        intent.putExtra("fromWhere", getClass().getSimpleName());
        intent.setFlags(flags);
        startActivity(intent);
    }

    private void initFromWhere() {
        if (null != getIntent().getExtras()) {
            if (getIntent().getExtras().containsKey("fromWhere")) {
                fromWhere = getIntent().getExtras().getString("fromWhere");
            }
        }
    }

    protected String getFromWhere() {
        return fromWhere;
    }

    protected abstract void bindEvents();

    protected abstract void initViews();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().removeActivity(this);
        mBaseView = null;
        if (presenter != null)
            presenter.unsubscribe();
    }

    protected void showToast(String info) {
        ToastUtils.showShort(info);
    }

    public void showLoadingDialog() {
        if (loading == null) {
            loading = new DialogLoading(this);
        }
        loading.show();
    }

    public void hideLoadingDialog() {
        if (loading != null) {
            loading.dismiss();
        }

    }
}
