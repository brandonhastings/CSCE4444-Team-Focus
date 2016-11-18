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
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.bhastings.workoutwithfriends.DatabaseRequests.ViewWorkoutRequest;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutViewFragment extends Fragment {

    Bundle bundle = new Bundle();
    String username, name;

    String exercise1, exercise2, exercise3, exercise4, exercise5, exercise6;
    TextView tvExercise1, tvExercise2, tvExercise3, tvExercise4, tvExercise5, tvExercise6, tvOwner, tvWorkoutName;



    public WorkoutViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        username = this.getArguments().getString("username");
        name = this.getArguments().getString("name");
        bundle.putString("username", username);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout_view, container, false);

        tvExercise1 = (TextView) view.findViewById(R.id.tvViewExercise1);
        tvExercise2 = (TextView) view.findViewById(R.id.tvViewExercise2);
        tvExercise3 = (TextView) view.findViewById(R.id.tvViewExercise3);
        tvExercise4 = (TextView) view.findViewById(R.id.tvViewExercise4);
        tvExercise5 = (TextView) view.findViewById(R.id.tvViewExercise5);
        tvExercise6 = (TextView) view.findViewById(R.id.tvViewExercise6);
        tvWorkoutName = (TextView) view.findViewById(R.id.tvWorkoutName);
        tvOwner = (TextView) view.findViewById(R.id.tvOwner);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success){
                        exercise1 = jsonResponse.getString("exercise1");
                        exercise2 = jsonResponse.getString("exercise2");
                        exercise3 = jsonResponse.getString("exercise3");
                        exercise4 = jsonResponse.getString("exercise4");
                        exercise5 = jsonResponse.getString("exercise5");
                        exercise6 = jsonResponse.getString("exercise6");

                        //set values
                        tvExercise1.setText(exercise1);
                        tvExercise2.setText(exercise2);
                        tvExercise3.setText(exercise3);
                        tvExercise4.setText(exercise4);
                        tvExercise5.setText(exercise5);
                        tvExercise6.setText(exercise6);
                        tvOwner.setText(username);
                        tvWorkoutName.setText(name);

                    }
                    else{
                        Toast.makeText(getContext(), "Error: could not find workout", Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        ViewWorkoutRequest workoutRequest = new ViewWorkoutRequest(username, name, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(workoutRequest);



        Button backButton = (Button) view.findViewById(R.id.bWorkoutViewBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment vActivities = new ActivitiesFragment();
                vActivities.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, vActivities);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        TextView tvEditWorkout = (TextView) view.findViewById(R.id.tvEditWorkout);
        tvEditWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment editWorkout = new EditWorkoutFragment();
                bundle.putString("name", name);
                editWorkout.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, editWorkout);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
