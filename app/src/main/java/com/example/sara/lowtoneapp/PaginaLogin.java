package com.example.sara.lowtoneapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PaginaLogin extends AppCompatActivity {
    private Button ButtonLogin;
    private TextView registrati;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_login);

        ButtonLogin =(Button) findViewById(R.id.login);
        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomepage();
            }
        });

        registrati = (TextView) findViewById(R.id.registrati);

        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistrazione();
            }
        });
    }

    public void openHomepage() {
        Intent intent = new Intent(this, ProvaBD.class);
        startActivity(intent);
    }

    public void openRegistrazione() {
        Intent intent = new Intent(this, Reg.class);
        startActivity(intent);
    }
}
