package com.quintaooh.thegamereminder.broadcast_receiver;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.quintaooh.thegamereminder.R;
import com.quintaooh.thegamereminder.helper.SchedulerHelper;
import com.quintaooh.thegamereminder.view.activity.SplashActivity;

/**
 * Created by riccardo on 22/10/2018.
 */

public class GameReminderBroadcastReceiver extends BroadcastReceiver {
    public static final String TAG = GameReminderBroadcastReceiver.class.getSimpleName();
    private String CHANNEL_ID = "the_game_channel";

    @Override
    public void onReceive(Context context, Intent intent) {
        SchedulerHelper.scheduleNextAlarm(context);
        sendANiceNotification(context);
    }

    private void sendANiceNotification(Context context) {
        Log.d(TAG, "sendANiceNotification");

        Intent intent = new Intent(context, SplashActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (notificationManager != null) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = context.getString(R.string.channel_name);
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
                notificationManager.createNotificationChannel(channel);
            }

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setContentTitle(context.getString(R.string.the_game))
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setColor(context.getResources().getColor(R.color.colorPrimary))
                    .setContentText(context.getString(R.string.lost_something))
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText(context.getString(R.string.lost_something)))
                    .setColorized(true)
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent);

            notificationManager.notify(0, notificationBuilder.build());
        }
    }
}
