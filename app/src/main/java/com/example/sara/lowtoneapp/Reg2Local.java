package com.example.sara.lowtoneapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reg2Local extends AppCompatActivity {

    Button Btnsubscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg2_local);

        Btnsubscribe =(Button) findViewById(R.id.subscribe);

        Btnsubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }

    public void openLogin() {
        Intent intent = new Intent(this, PaginaLogin.class);
        startActivity(intent);
    }
}
