package com.quintaooh.thegamereminder.helper;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import com.quintaooh.thegamereminder.broadcast_receiver.GameReminderBroadcastReceiver;

/**
 * Created by riccardo on 22/10/2018.
 */

public class SchedulerHelper {

    private final static int DEFAULT_ALARM_DELAY = 1000 * 60 * 30;
    private final static int DEFAULT_ALARM_DELAY_WINDOW = 1000 * 60;

    public static void startRemindingJob(Context context) {
        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        if (alarmMgr != null) {
            alarmMgr.setWindow(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime(),
                    DEFAULT_ALARM_DELAY,
                    getRemindingPendingIntent(context));
        }
    }

    public static void scheduleNextAlarm(Context context) {

        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        if (alarmMgr != null) {
            alarmMgr.setWindow(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + DEFAULT_ALARM_DELAY, DEFAULT_ALARM_DELAY_WINDOW,
                    getRemindingPendingIntent(context));
        }
    }

    public static void stopRemindingJob(Context context) {

        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        PendingIntent pendingIntent = getRemindingPendingIntent(context);

        if (alarmMgr != null) {
            alarmMgr.cancel(pendingIntent);
        }

        pendingIntent.cancel();
    }

    private static PendingIntent getRemindingPendingIntent(Context context) {

        Intent intent = new Intent(context, GameReminderBroadcastReceiver.class);
        return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
