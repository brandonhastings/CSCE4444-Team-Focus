package com.example.bhastings.workoutwithfriends;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText etUsername, etFirstName, etLastName, etPassword, etReEnterPassword; //edit text fields
    Button bRegister; //register button
    String username, firstname, lastname, password, reEnterPassword; //returned from the getLoggedInUser function

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Workout With Friends");

        etUsername = (EditText) findViewById(R.id.etUsername);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etReEnterPassword = (EditText) findViewById(R.id.etReEnterPassword);
        bRegister = (Button) findViewById(R.id.bRegister);}

        public void userReg(View v){

        username = etUsername.getText().toString();
        firstname = etFirstName.getText().toString();
        lastname = etLastName.getText().toString();
        password = etPassword.getText().toString();
        reEnterPassword = etReEnterPassword.getText().toString();

            //if passwords match
        if(password.equals(reEnterPassword)) {

            String method = "register";
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method, username, password, firstname, lastname);
            finish();

            //show main screen
            Intent registerIntent = new Intent(RegisterActivity.this, UserAreaActivity.class);
            RegisterActivity.this.startActivity(registerIntent);

        }
        else{
            Toast.makeText(getApplicationContext(), "Error: Passwords to not match", Toast.LENGTH_LONG).show();
        }
    }

}
