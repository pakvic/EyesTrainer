package com.pokidin.eyestrainer;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Stop extends AppCompatActivity {

    ImageButton buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);
        buttonStop = findViewById(R.id.buttonStop);
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Приложение остановлено",Toast.LENGTH_LONG).show();
                Intent intentstop = new Intent(Stop.this, Alarm.class);
                PendingIntent senderstop = PendingIntent.getBroadcast(getApplicationContext(),
                        1234567, intentstop, 0);
                AlarmManager alarmManagerstop = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManagerstop.cancel(senderstop);
                Intent intentMainMenu = new Intent(Stop.this, MainActivity.class);
                startActivity(intentMainMenu);
            }
        });

    }
}