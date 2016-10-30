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
public class DietViewFragment extends Fragment {


    public DietViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diet_view, container, false);

        Button bTodaysCalories = (Button) view.findViewById(R.id.bTodayCalories);
        bTodaysCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment vTodaysCalories = new DietFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, vTodaysCalories);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        Button bRecordMeal = (Button) view.findViewById(R.id.bRecordMeal);
        bRecordMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment vRecordMeal = new RecordMealFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, vRecordMeal);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        Button bUpdateWeight = (Button) view.findViewById(R.id.bUpdateWeight);
        bUpdateWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment vUpdateWeight = new UpdateWeightFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, vUpdateWeight);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return view;
    }

}
