package com.example.bhastings.workoutwithfriends;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.bhastings.workoutwithfriends.DatabaseRequests.NewWorkoutRequest;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewWorkoutFragment extends Fragment {

    String username;
    Bundle bundle = new Bundle();

    String name, exercise1, exercise2, exercise3, exercise4, exercise5, exercise6;

    public NewWorkoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        username = this.getArguments().getString("username");
        bundle.putString("username", username);

        View view = inflater.inflate(R.layout.fragment_new_workout, container, false);

        final Spinner sExercise1 = (Spinner) view.findViewById(R.id.sExercise1);
        final Spinner sExercise2 = (Spinner) view.findViewById(R.id.sExercise2);
        final Spinner sExercise3 = (Spinner) view.findViewById(R.id.sExercise3);
        final Spinner sExercise4 = (Spinner) view.findViewById(R.id.sExercise4);
        final Spinner sExercise5 = (Spinner) view.findViewById(R.id.sExercise5);
        final Spinner sExercise6 = (Spinner) view.findViewById(R.id.sExercise6);
        final EditText etWorkoutName = (EditText) view.findViewById(R.id.etWorkoutName);

        Button bSaveNewWorkout = (Button) view.findViewById(R.id.bSaveNewWorkout);
        bSaveNewWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = etWorkoutName.getText().toString();
                exercise1 = sExercise1.getSelectedItem().toString();
                exercise2 = sExercise2.getSelectedItem().toString();
                exercise3 = sExercise3.getSelectedItem().toString();
                exercise4 = sExercise4.getSelectedItem().toString();
                exercise5 = sExercise5.getSelectedItem().toString();
                exercise6 = sExercise6.getSelectedItem().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                Toast.makeText(getActivity(), "Workout has been created.", Toast.LENGTH_LONG).show();

                                Fragment vActivitiesScreen2 = new ActivitiesFragment();
                                vActivitiesScreen2.setArguments(bundle);
                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.content_user_area, vActivitiesScreen2);
                                fragmentTransaction.commit();
                            }

                        } catch (JSONException e) {
                            Log.e("log_tag", "Error converting result " + e.toString());
                            e.printStackTrace();
                        }
                    }
                };

                NewWorkoutRequest newWorkoutRequest = new NewWorkoutRequest(username, name, exercise1, exercise2, exercise3, exercise4, exercise5, exercise6, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getContext());
                queue.add(newWorkoutRequest);

            }
        });



        Button bCancel = (Button) view.findViewById(R.id.bNewWorkoutCancel);
        bCancel.setOnClickListener(new View.OnClickListener() {
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
