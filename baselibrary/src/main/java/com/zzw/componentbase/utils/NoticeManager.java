package com.zzw.componentbase.utils;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import com.zzw.componentbase.R;

/**
 * 创建人: xieyushang
 * 时间: 2017-12-29 13:45
 */

public class NoticeManager {

    public static void create(Context context, String text){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentText("验证码: "+text);
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());
    }
}
