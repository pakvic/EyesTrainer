package com.pokidin.eyestrainer;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Button;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Alarm extends BroadcastReceiver {
    public static final String WAKE = "Wake up";
    private static final int NOTIFY_ID = 101;
    MainActivity main = new MainActivity();
      private static String CHANNEL_ID = "My channel";
    Button buttonStop;
    String string;



    @Override
    public void onReceive(Context context, Intent intent) {
        Intent exersIntent = new Intent(context, Exercise.class);
        PendingIntent fullScreenPendingIntent = PendingIntent.getActivity(context, 0,
                exersIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        Intent stop = new Intent(context,Stop.class);
        PendingIntent stopPending = PendingIntent.getActivity(context,0,stop,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setSmallIcon(R.drawable.icon)
                        .setContentTitle("Alarm!!!!")
                        .setContentText("Пора отдохнуть. Нажми для продолжения")
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setDefaults(Notification.DEFAULT_LIGHTS)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setContentIntent(fullScreenPendingIntent)
                        .addAction(0,"Остановить приложение",stopPending);




        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(context);
        notificationManager.notify(NOTIFY_ID, builder.build());




        Vibrator v = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        v.vibrate(1000);
}




    }

