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

//credo non funzioni per via del RequestHandler2
//decidere come gestire la BD
public class RegOwner extends AppCompatActivity implements View.OnClickListener{

    EditText local, vat, address, n, cap, city, country, owner_name, owner_surname, email, password, username, confpassword;
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
        owner_name = (EditText) findViewById(R.id.owner_name);
        owner_surname = (EditText) findViewById(R.id.owner_surname);
        email = (EditText) findViewById(R.id.EmailOwner);
        password = (EditText) findViewById(R.id.PassOwner);
        confpassword = (EditText) findViewById(R.id.ConfPassOwner);
        username = (EditText) findViewById(R.id.UsernameOwner);

        BtnReq = (Button) findViewById(R.id.btnReg);

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
        final String name_o = owner_name.getText().toString().trim();
        final String surname_o = owner_surname.getText().toString().trim();
        final String username_o = username.getText().toString().trim();
        final String email_o = email.getText().toString().trim();
        final String pass = password.getText().toString().trim();
        final String confpass = confpassword.getText().toString().trim();
        
        if (local_o.isEmpty()) {
            local.setError("Local name's is required");
            local.requestFocus();
            return;
        }

        if (vat_o.isEmpty()) {
            vat.setError("VAT is required");
            vat.requestFocus();
            return;
        }

        if (vat_o.length() == 11) {
            vat.setError("Lenght of VAT should be 11");
            vat.requestFocus();
            return;
        }

        if(!vat_o.matches("\\d+(?:\\.\\d+)?")){
            vat.setError("VAT is a number!");
            vat.requestFocus();
            return;
        }

        if (address_o.isEmpty()) {
            address.setError("Address is required");
            address.requestFocus();
            return;
        }

        if (n_o.isEmpty()) {
            n.setError("N° is required");
            n.requestFocus();
            return;
        }

        if (cap_o.isEmpty()) {
            cap.setError("CAP is required");
            cap.requestFocus();
            return;
        }

        if(!cap_o.matches("\\d+(?:\\.\\d+)?")){
            cap.setError("CAP is a number!");
            cap.requestFocus();
            return;
        }

        if (city_o.isEmpty()) {
            city.setError("City is required");
            city.requestFocus();
            return;
        }

        if (country_o.isEmpty()) {
            country.setError("Country is required");
            country.requestFocus();
            return;
        }

        if (name_o.isEmpty()) {
            owner_name.setError("Name is required");
            owner_name.requestFocus();
            return;
        }

        if (surname_o.isEmpty()) {
            owner_surname.setError("Surname is required");
            owner_surname.requestFocus();
            return;
        }

        if (email_o.isEmpty()) {
            email.setError("Email is required");
            email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email_o).matches()) {
            email.setError("Please enter a valid email!");
            email.requestFocus();
            return;
        }

        if (username_o.isEmpty()) {
            username.setError("Username is required");
            username.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            password.setError("Password is required");
            password.requestFocus();
            return;
        }

        if (pass.length()<6) {
            password.setError("Minimum lenght of password should be 6");
            password.requestFocus();
            return;
        }

        if (confpass.isEmpty()) {
            confpassword.setError("Confirm Password is required");
            confpassword.requestFocus();
            return;
        }

        if (!pass.equals(confpass)) {
            confpassword.setError("Password is different");
            confpassword.requestFocus();
            return;
        }

        progressDialog.setMessage("Registering owner...");
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

                params.put("nome",name_o);
                params.put("cognome",surname_o);
                params.put("email",email_o);
                params.put("username",username_o);
                params.put("password",pass);
                params.put("tipoutente", "O");

                params.put("l_name",local_o);
                params.put("l_address",address_o);
                params.put("l_n",n_o);
                params.put("l_cap",cap_o);
                params.put("l_country",country_o);
                params.put("l_city",city_o);
                params.put("l_vat",vat_o);
                return params;
            }
        };


        RequestHandler2.getInstance(this).addToRequestQueue(stringRequest);
    }
}

   