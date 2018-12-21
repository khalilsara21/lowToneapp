package com.example.sara.lowtoneapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class RegOwner extends AppCompatActivity implements View.OnClickListener{

    EditText local, vat, address, n, cap, city, country, owner, username, email, password;
    Button BtnReq;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_owner);

        //TOOLBAR
        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle("SIGN-IN OWNER"); // set the top title
        String title = actionBar.getTitle().toString(); // get the title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        local = (EditText) findViewById(R.id.LocalName);
        vat = (EditText) findViewById(R.id.VATNumber);
        address = (EditText) findViewById(R.id.LocalAddress);
        n = (EditText) findViewById(R.id.NLocal);
        cap = (EditText) findViewById(R.id.LocalCAP);
        city = (EditText) findViewById(R.id.CityLocal);
        country = (EditText) findViewById(R.id.CountryLocal);
        owner = (EditText) findViewById(R.id.Owner);
        username = (EditText) findViewById(R.id.UsernameOwner);
        email = (EditText) findViewById(R.id.EmailOwner);
        password = (EditText) findViewById(R.id.PassOwner);
        //confpassword = (EditText) findViewById(R.id.ConfPassOwner);

        progressDialog = new ProgressDialog(this);

        BtnReq.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==BtnReq)
            registerOwner();
    }

    private void registerOwner() {
        final String local_o = local.getText().toString().trim();
        final String vat_o = vat.getText().toString().trim();
        final String address_o = address.getText().toString().trim();
        final String n_o = n.getText().toString().trim();
        final String cap_o = cap.getText().toString().trim();
        final String city_o = city.getText().toString().trim();
        final String country_o = country.getText().toString().trim();
        final String owner_o = owner.getText().toString().trim();
        final String username_o = username.getText().toString().trim();
        final String email_o = email.getText().toString().trim();
        final String pass = password.getText().toString().trim();
        //final String confpass = confpassword.getText().toString().trim();

        progressDialog.setMessage("Registering owner...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_REGISTER_OWNER, new Response.Listener<String>() {
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
                params.put("local",local_o);
                params.put("vat",vat_o);
                params.put("address",address_o);
                params.put("n",n_o);
                params.put("cap",cap_o);
                params.put("city",city_o);
                params.put("country",country_o);
                params.put("owner",owner_o);
                params.put("username",username_o);
                params.put("email",email_o);
                params.put("password",pass);
                return params;
            }
        };


        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }
}
