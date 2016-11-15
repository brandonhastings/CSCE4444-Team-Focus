package com.example.bhastings.workoutwithfriends;


import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    String username;
    String editUsername, firstname, lastname, age, weight, height, bio;
    TextView tvName, tvAge, tvWeight, tvHeight, tvBio;
    Bundle bundle = new Bundle();

    public ProfileFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        username = this.getArguments().getString("username");
        bundle.putString("username", username);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        tvName = (TextView) view.findViewById(R.id.tvName);
        tvAge = (TextView) view.findViewById(R.id.tvAge);
        tvWeight = (TextView) view.findViewById(R.id.tvWeight);
        tvHeight = (TextView) view.findViewById(R.id.tvHeight);
        tvBio = (TextView) view.findViewById(R.id.tvBio);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success){
                        firstname = jsonResponse.getString("firstname");
                        lastname = jsonResponse.getString("lastname");
                        age = jsonResponse.getString("age");
                        weight = jsonResponse.getString("weight");
                        height = jsonResponse.getString("height");
                        bio = jsonResponse.getString("bio");

                        tvName.setText(firstname + " " + lastname);

                        if(age.equals(null)) {

                        }
                        else tvAge.setText(age);

                       if(height.equals(null)) {

                        }
                        else tvHeight.setText(height);

                        if(weight.equals(null)){

                        }
                        else tvWeight.setText(weight);

                        if(bio.equals(null)){

                        }
                        else tvBio.setText(bio);
                    }

                } catch (JSONException e) {
                    Log.e("log_tag", "Error converting result " + e.toString());
                    e.printStackTrace();
                }
            }
        };

        ProfileRequest profileRequest = new ProfileRequest(username, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(profileRequest);


        TextView tvEditProfile = (TextView) view.findViewById(R.id.tvEditProfile);
        tvEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment editProfile = new EditProfileFragment();


                editProfile.setArguments(bundle);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, editProfile);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
