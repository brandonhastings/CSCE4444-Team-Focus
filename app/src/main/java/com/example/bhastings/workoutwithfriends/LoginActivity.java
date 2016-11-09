package com.example.bhastings.workoutwithfriends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

//WHEN TESTING, BLOCK OUT FROM HERE:
///*

            String method = "login";
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method, username, password);
//*/
            Intent registerIntent = new Intent(LoginActivity.this, UserAreaActivity.class);
            LoginActivity.this.startActivity(registerIntent);

        }


   }

