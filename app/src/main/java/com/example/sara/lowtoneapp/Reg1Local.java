package com.example.sara.lowtoneapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reg1Local extends AppCompatActivity {

    Button BtnNext;
    Button BtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg1_local);

        BtnNext =(Button) findViewById(R.id.next);
        BtnBack =(Button) findViewById(R.id.back);

        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReg2Local();
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
        Intent intent = new Intent(this, PaginaLogin.class);
        startActivity(intent);
    }

    public void openReg2Local() {
        Intent intent = new Intent(this, Reg2Local.class);
        startActivity(intent);
    }
}
