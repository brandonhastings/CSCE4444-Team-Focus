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

    String username;
    Bundle bundle = new Bundle();

    public ActivitiesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        username = this.getArguments().getString("username");
        bundle.putString("username", username);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activities, container, false);

        TextView tvWorkout1 = (TextView) view.findViewById(R.id.tvWorkoutTest);
        tvWorkout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment Workout1 = new WorkoutViewFragment();
                Workout1.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, Workout1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });



        Button bNewWorkout = (Button) view.findViewById(R.id.bNewWorkout);
        bNewWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment vNewWorkout = new NewWorkoutFragment();
                vNewWorkout.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, vNewWorkout);
                fragmentTransaction.commit();
            }
        });

        Button bNewExercise = (Button) view.findViewById(R.id.bViewExerciseDetails);
        bNewExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment vExerciseView = new ExerciseViewFragment();
                vExerciseView.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, vExerciseView);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
