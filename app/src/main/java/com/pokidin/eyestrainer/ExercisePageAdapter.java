package com.pokidin.eyestrainer;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ExercisePageAdapter extends FragmentPagerAdapter {

    private String[] mExercNames;
    private String[] mExercDescriptions;

    private final int[] mTopImageResourceIds = { R.drawable.tutorial3,
            R.drawable.first, R.drawable.second, R.drawable.crossup, R.drawable.crossdown, R.drawable.round, R.drawable.joke };


    ExercisePageAdapter(FragmentManager fm, Context context) {
        super(fm);

        Resources resources = context.getResources();
        mExercNames = resources.getStringArray(R.array.titles);
        mExercDescriptions = resources.getStringArray(R.array.descriptionsExercise);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle arguments = new Bundle();
        arguments.putString(ExerciseFragment.EXERC_NAMES, mExercNames[position]);
        arguments.putString(ExerciseFragment.EXERC_DESCRIPTIONS,
                mExercDescriptions[position]);
        arguments.putInt(ExerciseFragment.TOP_IMAGE, mTopImageResourceIds[position]);

        ExerciseFragment exerciseFragment = new ExerciseFragment();
        exerciseFragment.setArguments(arguments);

        return exerciseFragment;
    }

    @Override
    public int getCount() {
        return mExercNames.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mExercNames[position];
    }
}