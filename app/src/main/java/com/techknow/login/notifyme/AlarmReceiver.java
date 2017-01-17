package com.techknow.login.notifyme;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by Krishna on 07-01-2017.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(context.NOTIFICATION_SERVICE);
        Intent repIntent = new Intent(context,MainActivity.class);
        repIntent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,123,repIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setTicker("DO It N0w");
        builder.setContentText("you need to complete the task");
        builder.setContentTitle("Just Move On You Need To Do It");
        builder.setAutoCancel(true);
        builder.setWhen(System.currentTimeMillis());
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        //MediaPlayer mp = MediaPlayer.create(context.getApplicationContext(), notification);
        //mp.start();
        builder.setSound(notification);


//        builder.setDefaults(Notification.DEFAULT_SOUND |
//                Notification.DEFAULT_VIBRATE)
//                .setSound(
//
//
//                        RingtoneManager.getDefaultUri(
//                                RingtoneManager.TYPE_ALARM)
//                        )
                builder.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });
                builder.setLights(16776961, 0, 1);//blue

        notificationManager.notify(123,builder.build());


        //Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        //MediaPlayer mp = MediaPlayer.create(context.getApplicationContext(), notification);
        //mp.start();

        // For our recurring task, we'll just display a message
        Toast.makeText(context, "I'm running", Toast.LENGTH_SHORT).show();
    }
}