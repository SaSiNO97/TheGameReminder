package com.quintaooh.thegamereminder.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.quintaooh.thegamereminder.helper.SchedulerHelper;

/**
 * Created by riccardo on 22/10/2018.
 */

public class BootBroadcastReceiver extends BroadcastReceiver {
    public static final String TAG = BootBroadcastReceiver.class.getSimpleName();
    public static final String BOOT_ACTION = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals(BOOT_ACTION)) {
            initJobDispatcher(context);
        }
    }

    private void initJobDispatcher(Context context) {
        Log.d(TAG, "initJobDispatcher");

        SchedulerHelper.startRemindingJob(context);
    }
}
