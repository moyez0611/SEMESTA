package com.example.semesta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Profile extends BaseActivity {

    SharedPrefManager spm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
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

    private void logout(){
        spm.saveSPString(SharedPrefManager.SP_TOKEN, "");
        spm.saveSPString(SharedPrefManager.SP_UNAME, "");
        spm.saveSPString(SharedPrefManager.SP_GID, "");
        spm.saveSPString(SharedPrefManager.SP_UID, "");
        spm.saveSPString(SharedPrefManager.SP_EID, "");
        spm.saveSPString(SharedPrefManager.SP_AVATAR, "");

        Intent loginscreen=new Intent(this,LoginActivity.class);
        loginscreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(loginscreen);
        finish();


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout: {
                logout();
            }
        }
        return true;
    }
}