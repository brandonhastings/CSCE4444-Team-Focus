package com.example.bhastings.workoutwithfriends;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecordMealFragment extends Fragment {


    public RecordMealFragment() {
        // Required empty public constructor
    }

    //check to see if fields are empty
    public boolean isEmpty(EditText etText){
        return etText.getText().toString().length() == 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_record_meal, container, false);

        //XML declarations
       final Spinner mealSpinner = (Spinner) view.findViewById(R.id.mealSpinner);
       final EditText calories = (EditText) view.findViewById(R.id.etCaloriesEntered);

        //Save data from user after Submit button is presssed
        Button bSubmit = (Button) view.findViewById(R.id.bSubmitMeal);
        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check to make sure values are not null
                if(isEmpty(calories)){
                    Toast.makeText(getActivity(), "You did not enter any calories", Toast.LENGTH_SHORT).show();
                }
                else {
                    //store values from user
                    String meal = (String) mealSpinner.getSelectedItem().toString();
                    int caloriesEntered = Integer.parseInt(calories.getText().toString());

                    //send data to database

                    //display confirmation screen
                    Fragment vConfirmation = new MealSubmissionConformationFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content_user_area, vConfirmation);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });

        return view;
    }

}
