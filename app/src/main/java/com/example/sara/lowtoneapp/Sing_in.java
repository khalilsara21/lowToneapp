package com.example.sara.lowtoneapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Sing_in extends AppCompatActivity {

    TextView Citizen, Owner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);

        //TOOLBAR
        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle("Type of registration"); // set the top title
        String title = actionBar.getTitle().toString(); // get the title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Citizen = (TextView) findViewById(R.id.citizen);
        Owner = (TextView) findViewById(R.id.owner);

        Owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegOwner();
            }
        });

        Citizen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegCitizen();
            }
        });
    }

    public void openRegOwner() {
        Intent intent = new Intent(this, RegOwner.class);
        startActivity(intent);
    }

    public void openRegCitizen() {
        Intent intent = new Intent(this, RegCitizen.class);
        startActivity(intent);
    }

}
