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
public class NewWorkoutFragment extends Fragment {

    String username;
    Bundle bundle = new Bundle();

    public NewWorkoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        username = this.getArguments().getString("username");

        View view = inflater.inflate(R.layout.fragment_new_workout, container, false);

        Button bSaveNewWorkout = (Button) view.findViewById(R.id.bSaveNewWorkout);
        bSaveNewWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment vActivitiesScreen2 = new ActivitiesFragment();
                vActivitiesScreen2.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, vActivitiesScreen2);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
