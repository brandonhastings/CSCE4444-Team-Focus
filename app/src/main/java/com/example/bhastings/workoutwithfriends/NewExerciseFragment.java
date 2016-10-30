package com.example.bhastings.workoutwithfriends;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewExerciseFragment extends Fragment {


    public NewExerciseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_exercise, container, false);

        Button bSaveExercise = (Button) view.findViewById(R.id.bSaveNewExercise);
        bSaveExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment vActivityScreen = new ActivitiesFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, vActivityScreen);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
