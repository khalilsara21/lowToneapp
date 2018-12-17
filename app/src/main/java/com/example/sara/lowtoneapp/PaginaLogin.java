package com.example.sara.lowtoneapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PaginaLogin extends AppCompatActivity {

    private EditText userBox, passBox;
    private Button ButtonLogin;
    private TextView registrati;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_login);

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle("My new title"); // set the top title
        String title = actionBar.getTitle().toString(); // get the title
        actionBar.hide(); // or even hide the actionbar

        if(SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, profile.class));
            return;
        }
        userBox = (EditText) findViewById(R.id.userBox);
        passBox = (EditText) findViewById(R.id.passBox);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");

        ButtonLogin =(Button) findViewById(R.id.login);
        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
                //openHomepage;
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

    public void openRegistrazione() {
        Intent intent = new Intent(this, ProvaBD.class);
        startActivity(intent);
    }

    public void userLogin() {
        final String username = userBox.getText().toString().trim();
        final String password = passBox.getText().toString().trim();

        if (username.isEmpty()) {
            userBox.setError("Username is required");
            userBox.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passBox.setError("Password is required");
            passBox.requestFocus();
            return;
        }

        progressDialog.show();

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            if(!obj.getBoolean("error")) {
                                SharedPrefManager.getInstance(getApplicationContext())
                                        .userLogin(
                                            obj.getInt("id"),
                                            obj.getString("username"),
                                            obj.getString("email")
                                        );
                                startActivity(new Intent(getApplicationContext(), profile.class));
                                finish();
                            } else {
                                Toast.makeText(
                                        getApplicationContext(),
                                        obj.getString("message"),
                                        Toast.LENGTH_LONG
                                ).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();

                        Toast.makeText(
                                getApplicationContext(),
                                error.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }
}
