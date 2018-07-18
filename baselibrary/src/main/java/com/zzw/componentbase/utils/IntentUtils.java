package com.zzw.componentbase.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


/**
 * 创建人: xieyushang
 * 时间: 2018-01-06 17:23
 */

public class IntentUtils {


    /**
     * 界面跳转
     *
     * @param cls 目标Activity
     */
    public static void startActivity(Activity context, Class<?> cls) {
        startActivity(context,cls, null);
    }

    /**
     * 跳转界面，传参
     *
     * @param cls    目标Activity
     * @param bundle 数据
     */
    public static void startActivity(Activity context, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(context, cls);
        if (null != bundle)
            intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 跳转界面并关闭当前界面
     *
     * @param cls 目标Activity
     */
    public static void startActivityAndFinish(Activity context, Class<?> cls) {
        startActivityAndFinish(context,cls, null);
    }

    /**
     * @param cls    目标Activity
     * @param bundle 数据
     */
    public static void startActivityAndFinish(Activity context, Class<?> cls, Bundle bundle) {
        startActivity(context,cls, bundle);
        context.finish();
    }

}
