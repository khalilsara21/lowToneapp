package com.example.sara.lowtoneapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reg1Citizen extends AppCompatActivity {

    Button BtnNext;
    Button BtnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg1_citizen);

        BtnNext =(Button) findViewById(R.id.next);
        BtnBack =(Button) findViewById(R.id.back);

        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReg2Citizen();
            }
        });

        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReg();
            }
        });
    }


    public void openReg() {
        Intent intent = new Intent(this, Reg.class);
        startActivity(intent);
    }

    public void openReg2Citizen() {
        Intent intent = new Intent(this, Reg2Citizen.class);
        startActivity(intent);
    }
}
