package com.example.semesta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Objects;

public class Profile extends BaseActivity {

    SharedPrefManager spm;
    WebView webView;
    WebSettings webSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true); //for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//for back button

        //webview
        webView = findViewById(R.id.webVIewProfile);
        webSetting = webView.getSettings();
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://jasatirta.icass.tech/mobilebackend/profile");
    }

    @Override
    public boolean setOnItemSelectedListener(MenuItem item) {
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout, menu);
        return true;

    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            return true;
        } else if (id == android.R.id.home) {
            this.finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void clickLogout(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout: {
                spm.saveSPString(SharedPrefManager.SP_TOKEN, "");
                spm.saveSPString(SharedPrefManager.SP_UNAME, "");
                spm.saveSPString(SharedPrefManager.SP_GID, "");
                spm.saveSPString(SharedPrefManager.SP_UID, "");
                spm.saveSPString(SharedPrefManager.SP_EID, "");
                spm.saveSPString(SharedPrefManager.SP_AVATAR, "");

                startActivity(new Intent(Profile.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        }
    }
}