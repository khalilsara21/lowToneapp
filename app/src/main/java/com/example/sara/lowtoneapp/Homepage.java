package com.example.sara.lowtoneapp;

import android.content.Intent;
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

        play = (Button) findViewById(R.id.play);

        profilo = (ImageView) findViewById(R.id.profilo);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSchermataGioco();
            }
        });

        profilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfilo();
            }
        });
    }

    public void openSchermataGioco()    {
        Intent intent = new Intent(this, SchermataGioco.class);
        startActivity(intent);
    }

    public void openProfilo()    {
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }
}
