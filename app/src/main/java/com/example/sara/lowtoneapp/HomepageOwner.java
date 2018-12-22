package com.example.sara.lowtoneapp;

import android.service.media.MediaBrowserService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.xml.transform.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class HomepageOwner extends AppCompatActivity {

    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_owner);
    }

    public void scanCode(View view) {
        scannerView = new ZXingScannerView(this);
        scannerView.setResultHandler(new ZXingScannerResultHandler());

        setContentView(scannerView);
        scannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

     class ZXingScannerResultHandler  implements ZXingScannerView.ResultHandler{

        public void handleResult(com.google.zxing.Result result) {
            String resultCode = result.getText();
            Toast.makeText(HomepageOwner.this, resultCode, Toast.LENGTH_SHORT).show();

            setContentView(R.layout.activity_homepage_owner);
            scannerView.stopCamera();
        }
    }
}
