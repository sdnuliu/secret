package com.sdnuliu.secret.moudle.main.view;

import com.sdnuliu.secret.framework.base.BasePresenter;
import com.sdnuliu.secret.framework.base.BaseView;

/**
 * Created by liuteng on 16/9/28.
 */

public interface MainContract {

    interface View extends BaseView<Presenter> {
        //主界面对应的v层方法

    }

    interface Presenter extends BasePresenter {
        //主界面对应的p层方法
    }
}
