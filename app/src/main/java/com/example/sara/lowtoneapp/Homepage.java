package com.example.sara.lowtoneapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Homepage extends AppCompatActivity {

    Button play;
    ImageView profilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle("Homepage"); // set the top title
        String title = actionBar.getTitle().toString(); // get the title

        play = (Button) findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSchermataGioco();
            }
        });
    }

    public void openSchermataGioco()    {
        Intent intent = new Intent(this, SchermataGioco.class);
        startActivity(intent);
    }

}
