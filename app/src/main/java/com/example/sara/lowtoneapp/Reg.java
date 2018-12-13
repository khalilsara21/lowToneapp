package com.example.sara.lowtoneapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Reg extends AppCompatActivity {

    Button BtnNext;
    Button BtnBack;

    CheckBox btnCheckCittadino, btnCheckProprietario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        BtnNext =(Button) findViewById(R.id.next);
        BtnBack =(Button) findViewById(R.id.back);

        //richiamo il checkbox per il profilo cittadino
        btnCheckCittadino=(CheckBox) findViewById(R.id.CitizenCheckBox);

        //richiamo il checkbox per il profilo del Locale
        btnCheckProprietario=(CheckBox) findViewById(R.id.OwnerCheckBox);

        //dichiaro che quando il checkbox del cittadino è spuntato la view si vede
        btnCheckCittadino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnCheckCittadino.isChecked()) {
                    btnCheckProprietario.setChecked(false);
                    BtnNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            openReg1Citizen();
                        }
                    });
                }
            }
        });

        //dichiaro che quando il checkbox del proprietario è spuntato la view si vede
        btnCheckProprietario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnCheckProprietario.isChecked()) {
                    btnCheckCittadino.setChecked(false);
                    BtnNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            openReg1Local();
                        }
                    });
                }
            }
        });

        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
                /* da modificare*/
            }
        });

        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }

    public void openReg1Citizen() {
        Intent intent = new Intent(this, Reg1Citizen.class);
        startActivity(intent);
    }

    public void openLogin() {
        Intent intent = new Intent(this, PaginaLogin.class);
        startActivity(intent);
    }

    public void openReg1Local() {
        Intent intent = new Intent(this, Reg1Local.class);
        startActivity(intent);
    }
}
