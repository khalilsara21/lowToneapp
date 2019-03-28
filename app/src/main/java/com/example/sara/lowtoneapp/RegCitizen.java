package com.example.sara.lowtoneapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegCitizen extends AppCompatActivity implements View.OnClickListener{

    EditText nome, cognome, email, username, password, confpassword;
    Button btnReg;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_citizen);

        //TOOLBAR
        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle("SIGN-IN CITIZEN"); // set the top title
        String title = actionBar.getTitle().toString(); // get the title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*
        if(SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, profile.class));
            return;
        } */

        nome = (EditText) findViewById(R.id.nome_bd);
        cognome = (EditText) findViewById(R.id.cognome);
        email = (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        confpassword = (EditText) findViewById(R.id.confpassword);
        btnReg = (Button) findViewById(R.id.btnReg);

        progressDialog = new ProgressDialog(this);

        btnReg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==btnReg)
            registerUser();
    }

    public void registerUser() {
        final String nome2 = nome.getText().toString().trim();
        final String cognome2 = cognome.getText().toString().trim();
        final String email2 = email.getText().toString().trim();
        final String username2 = username.getText().toString().trim();
        final String password2 = password.getText().toString().trim();
        final String confpassword2 = confpassword.getText().toString().trim();

        if (nome2.isEmpty()) {
            nome.setError("Name is required");
            nome.requestFocus();
            return;
        }

        if (cognome2.isEmpty()) {
            cognome.setError("Surname is required");
            cognome.requestFocus();
            return;
        }

        if (email2.isEmpty()) {
            email.setError("Email is required");
            email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email2).matches()) {
            email.setError("Please enter a valid email!");
            email.requestFocus();
            return;
        }

        if (username2.isEmpty()) {
            username.setError("Username is required");
            username.requestFocus();
            return;
        }

        if (password2.isEmpty()) {
            password.setError("Password is required");
            password.requestFocus();
            return;
        }

        if (password2.length()<6) {
            password.setError("Minimum lenght of password should be 6");
            password.requestFocus();
            return;
        }

        if (confpassword2.isEmpty()) {
            confpassword.setError("Confirm Password is required");
            confpassword.requestFocus();
            return;
        }

        if (!password2.equals(confpassword2)) {
            confpassword.setError("Password is different");
            confpassword.requestFocus();
            return;
        }

        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                    startActivity(new Intent(getApplicationContext(), PaginaLogin.class));
                    finish();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nome",nome2);
                params.put("cognome",cognome2);
                params.put("email",email2);
                params.put("username",username2);
                params.put("password",password2);
                params.put("tipoutente","C");
                return params;
            }
        };


        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }
}
