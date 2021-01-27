package com.pokidin.eyestrainer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ExerciseFragment extends Fragment {
    static final String EXERC_NAMES = "exerc_names";
    static final String EXERC_DESCRIPTIONS = "exerc_descriptions";
    final static String TOP_IMAGE = "top image";

    public ExerciseFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            String exercName = arguments.getString(EXERC_NAMES);
            String exercDescription = arguments.getString(EXERC_DESCRIPTIONS);
            int topCardResourceId = arguments.getInt(TOP_IMAGE);

            displayValues(view, exercName, exercDescription, topCardResourceId);
        }
        return view;
    }

    private void displayValues(View v, String name,
                               String exercDescription, int topCardResourceId) {
        TextView exercNameTextView = v.findViewById(R.id.exercTitle);
        TextView exercDescriptionTextView = v.findViewById(R.id.exercDescription);
        ImageView cardImageView = v.findViewById(R.id.topImage);

        exercNameTextView.setText(name);
        exercDescriptionTextView.setText(exercDescription);

        cardImageView.setImageResource(topCardResourceId);
    }
}
