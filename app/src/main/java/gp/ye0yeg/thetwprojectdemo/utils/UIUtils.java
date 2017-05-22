package gp.ye0yeg.thetwprojectdemo.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;

import gp.ye0yeg.thetwprojectdemo.base.BaseApplication;


/**
 * Created by Administrator on 4/26/2017.
 */

public class UIUtils {
    /**得到上下文*/
    public static Context getContext() {
        return BaseApplication.getContext();
    }

    /**得到Resouce对象*/
    public static Resources getResource() {
        return getContext().getResources();
    }

    /**得到String.xml中的字符串*/
    public static String getString(int resId) {
        return getResource().getString(resId);
    }

    /**得到String.xml中的字符串数组*/
    public static String[] getStringArr(int resId) {
        return getResource().getStringArray(resId);
    }

    /**得到colors.xml中的颜色*/
    public static int getColor(int colorId) {
        return getResource().getColor(colorId);
    }

    /**得到应用程序的包名*/
    public static String getPackageName() {
        return getContext().getPackageName();
    }

    /**得到主线程id*/
    public static long getMainThreadid() {
        return BaseApplication.getMainThredId();
    }

    /**得到主线程Handler*/
    public static Handler getMainThreadHandler() {
        return BaseApplication.getHandler();
    }

    /**安全的执行一个任务*/
    public static void postTaskSafely(Runnable task) {
        int curThreadId = android.os.Process.myTid();

        if (curThreadId == getMainThreadid()) {// 如果当前线程是主线程
            task.run();
        } else {// 如果当前线程不是主线程
            getMainThreadHandler().post(task);
        }

    }

}
