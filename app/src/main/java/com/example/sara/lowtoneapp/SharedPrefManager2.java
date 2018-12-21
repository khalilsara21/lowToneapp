package com.example.sara.lowtoneapp;


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager2 {
    private static SharedPrefManager2 mInstance;
    private static Context mCtx;
    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_USERNAME = "Username";
    private static final String KEY_USER_EMAIL = "Email";
    private static final String KEY_USER_ID = "userid";

    private SharedPrefManager2(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager2 getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager2(context);
        }
        return mInstance;
    }

    public boolean userLogin(int id, String username, String email) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USER_EMAIL, email);
        editor.putString(KEY_USERNAME, username);

        editor.apply();

        return true;
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USERNAME, null) != null){
            return true;
        }
        return false;
    }

    public boolean logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }

    //metodo che mi ritorna l'username se è disponibile oppure il valore null
    public String getUsername() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, null);
    }

    //metodo che mi ritorna l'email se è disponibile oppure il valore null
    public String getUserEmail() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_EMAIL, null);
    }

}


