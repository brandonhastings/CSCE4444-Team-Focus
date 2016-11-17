package com.example.bhastings.workoutwithfriends;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bhastings on 11/16/2016.
 */

public class NewWorkoutRequest extends StringRequest {
private static final String NEW_WORKOUT_REQUEST_URL = "http://172.27.35.133/workoutwfriends/NewWorkout.php";
    private Map<String, String> params;

    public NewWorkoutRequest(String username, String name, String exercise1, String exercise2, String exercise3, String exercise4, String exercise5, String exercise6, Response.Listener listener){
        super(Method.POST, NEW_WORKOUT_REQUEST_URL, listener, null);
        params = new HashMap<>();

        params.put("username", username);
        params.put("name", name);
        params.put("exercise1", exercise1);
        params.put("exercise2", exercise2);
        params.put("exercise3", exercise3);
        params.put("exercise4", exercise4);
        params.put("exercise5", exercise5);
        params.put("exercise6", exercise6);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
