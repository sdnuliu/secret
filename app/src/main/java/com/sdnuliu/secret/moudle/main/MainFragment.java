package com.sdnuliu.secret.moudle.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sdnuliu.secret.R;
import com.sdnuliu.secret.moudle.main.view.MainContract;

/**
 * Created by liuteng on 16/9/28.
 */

public class MainFragment extends Fragment implements MainContract.View {
    private MainContract.Presenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.content_main, container, false);
        return root;

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
