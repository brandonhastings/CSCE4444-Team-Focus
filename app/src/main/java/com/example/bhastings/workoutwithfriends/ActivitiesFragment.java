package com.example.bhastings.workoutwithfriends;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActivitiesFragment extends Fragment {


    public ActivitiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activities, container, false);

        TextView tvWorkout1 = (TextView) view.findViewById(R.id.tvWorkoutTest);
        tvWorkout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment Workout1 = new WorkoutViewFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, Workout1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        TextView tvExercise1 = (TextView) view.findViewById(R.id.tvExerciseTest);
        tvExercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment Exercise1 = new ExerciseViewFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, Exercise1);
                fragmentTransaction.commit();
            }
        });

        Button bNewWorkout = (Button) view.findViewById(R.id.bNewWorkout);
        bNewWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment vNewWorkout = new NewWorkoutFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, vNewWorkout);
                fragmentTransaction.commit();
            }
        });

        Button bNewExercise = (Button) view.findViewById(R.id.bNewExercise);
        bNewExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment vNewExercise = new NewExerciseFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, vNewExercise);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
