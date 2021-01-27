package com.pokidin.eyestrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Animation logoAnim,buttonLogoAnim, buttonLogoAnimRight ;
    Button btnSet;
    Button buttonPicture;
    EditText etTime;
    private static final int NOTIFY_ID = 101;
    ImageView logoImage;


    // Идентификатор канала
    private static String CHANNEL_ID = "My channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "My channel",
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("My channel description");
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(false);
            notificationManager.createNotificationChannel(channel);
        }

        btnSet = findViewById(R.id.btnSet);

        int time = 60;
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Работа приложения начата", Toast.LENGTH_LONG).show();


                Intent i = new Intent(MainActivity.this, Alarm.class);
                PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(),1234567,i,0);
                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                am.setInexactRepeating(AlarmManager.RTC_WAKEUP,  SystemClock.currentThreadTimeMillis() +AlarmManager.INTERVAL_HOUR, AlarmManager.INTERVAL_HOUR, pi);
            }

        });



        buttonPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent exerciseintent = new Intent(MainActivity.this, Exercise.class);
                startActivity(exerciseintent);
            }
        });



    }
    private void init() {

        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo_anim);
        buttonLogoAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_anim);
        buttonLogoAnimRight = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_anim_right);

        logoImage = findViewById(R.id.imageViewLogo);
        btnSet = findViewById(R.id.btnSet);
        buttonPicture = findViewById(R.id.buttonPictures);

        logoImage.startAnimation(logoAnim);
        btnSet.startAnimation(buttonLogoAnim);
        buttonPicture.startAnimation(buttonLogoAnimRight);

    }
    public void Stop(){
        Intent intentstop = new Intent(MainActivity.this, Alarm.class);
        PendingIntent senderstop = PendingIntent.getBroadcast(getApplicationContext(),
                1234567, intentstop, 0);
        AlarmManager alarmManagerstop = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManagerstop.cancel(senderstop);
    }

}