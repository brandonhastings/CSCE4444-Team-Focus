package com.example.bhastings.workoutwithfriends;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity{



    EditText etUsername, etPassword;
    String username, password;
    String output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Workout With Friends");

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

    }


        public void registerHere(View v) {
            Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            LoginActivity.this.startActivity(registerIntent);
        }


        public void userLogin(View v){
            username = etUsername.getText().toString();
            password = etPassword.getText().toString();

            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");

                        if(success){
                            Intent registerIntent = new Intent(LoginActivity.this, UserAreaActivity.class);
                            LoginActivity.this.startActivity(registerIntent);
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                        }
                        else{
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginActivity.this);
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("Login Failed. Please try again.").setNegativeButton("Retry", null).create().show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };

            LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
            RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
            queue.add(loginRequest);


        }


   }

