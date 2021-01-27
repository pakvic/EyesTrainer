package com.pokidin.eyestrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class Exercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        ExercisePageAdapter exercPagerAdapter = new ExercisePageAdapter(getSupportFragmentManager(), this);

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(exercPagerAdapter);

    }
}