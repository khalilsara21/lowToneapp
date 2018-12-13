package com.example.sara.lowtoneapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class SchermataGioco extends AppCompatActivity {

    Button giornaliero,settimanale,mensile,premio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schermata_gioco);
        giornaliero=findViewById(R.id.buttonGiornaliero);
        settimanale=findViewById(R.id.buttonSettimanale);
        mensile=findViewById(R.id.buttonMensile);
        premio=findViewById(R.id.buttonPremi);

        //creo la funzione che richiama il bottone daily per aprire l'activity della classifica

        giornaliero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                // passo all'attivazione dell'activity
                openGiornaliero();
            }
        });

        //creo la funzione che richiama il bottone weekly per aprire l'activity della classifica
        settimanale.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                openSettimanale();
            }
        });

        //creo la funzione che richiama il bottone monthly per aprire l'activity della classifica
        mensile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                openMensile();
            }
        });

        //creo la funzione che richiama il bottone GetReward per aprire l'activity della ricompensa
        premio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                openPremio();
            }
        });
    }


    public void openGiornaliero()   {

        Intent openPage = new Intent(this, SchermataDaily.class);
        startActivity(openPage);
    }

    public void openSettimanale()   {

        Intent openPage = new Intent(this, SchermataWeekly.class);
        startActivity(openPage);
    }

    public void openMensile()   {

        Intent openPage = new Intent(this, SchermataMensile.class);
        startActivity(openPage);
    }

    public void openPremio()   {

        Intent openPage = new Intent(this, GetReward.class);
        startActivity(openPage);
    }

}
