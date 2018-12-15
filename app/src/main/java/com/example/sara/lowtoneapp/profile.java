package com.example.sara.lowtoneapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    private TextView TextViewUsername, TextViewUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        if(!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, PaginaLogin.class));
        }

        TextViewUsername = (TextView) findViewById(R.id.textViewUsername);
        TextViewUserEmail = (TextView) findViewById(R.id.textViewEmail);

        TextViewUserEmail.setText(SharedPrefManager.getInstance(this).getUserEmail());
        TextViewUsername.setText(SharedPrefManager.getInstance(this).getUsername());
    }
}
