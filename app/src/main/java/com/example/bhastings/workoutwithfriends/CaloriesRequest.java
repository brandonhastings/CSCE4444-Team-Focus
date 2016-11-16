package com.example.bhastings.workoutwithfriends;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bhastings on 11/14/2016.
 */

public class CaloriesRequest extends StringRequest {
    private static final String CALORIES_REQUEST_URL = "http://192.168.43.72/workoutwfriends/Calories.php";
    private Map<String, String> params;

    public CaloriesRequest(String breakfastCalories, String lunchCalories, String dinnerCalories, String snackCalories, Response.Listener<String> listener){
        super (Method.POST, CALORIES_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("breakfastCalories", breakfastCalories);
        params.put("lunchCalories", lunchCalories);
        params.put("dinnerCalories", dinnerCalories);
        params.put("snackCalories", snackCalories);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
