package com.sdnuliu.secret.framework.common;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.Stack;

/**
 * Created by liuteng on 16/9/22.
 * Activity管理的容器
 */

public class ActivityManager {

    private static ActivityManager instance;

    private static Stack<Activity> activityStack = new Stack<>();

    private ActivityManager() {

    }

    /**
     * 单例获取activity的管理类
     *
     * @return
     */
    public static ActivityManager getInstance() {
        if (instance == null) {
            instance = new ActivityManager();
        }
        return instance;
    }

    /**
     * 向栈中添加指定的activity
     *
     * @param activity 要添加的activity
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.push(activity);
    }

    /**
     * 移除指定的activity(仅从栈中移除,不调用activity自身的finish方法)
     *
     * @param activity
     */
    public void removeActivity(Activity activity) {
        if (activityStack != null) {
            activityStack.remove(activity);
        }
    }

    /**
     * 获取栈顶的activity
     *
     * @return
     */
    public Activity currentActivity() {
        return activityStack.peek();
    }

    /**
     * 结束栈顶的activity
     */
    public void finishActivity() {
        Activity activity = activityStack.pop();
        finishActivity(activity);
    }

    /**
     * 结束指定的activity
     *
     * @param activity 要结束的activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束所有的activity
     */
    public void finishAllActivity() {
        for (Activity activity : activityStack) {
            if (activity != null)
                activity.finish();
        }
        activityStack.clear();
    }

    /**
     * 退出
     * @param context context
     */
    public void exit(Context context){
        exit(context,true);
    }

    /**
     * 退出
     * @param context
     * @param icClearCache
     */
    public void exit(Context context, boolean icClearCache) {
        finishAllActivity();
        //// TODO: 16/9/22 缓存清理以及其他待定事项
    }

    /**
     * 添加fragment
     * @param fragmentManager fragmentManager
     * @param fragment fragment
     * @param frameId
     */
    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

}
