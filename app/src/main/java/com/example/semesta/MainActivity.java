package com.example.semesta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends BaseActivity {

    ActionBarDrawerToggle toggle;
    BottomNavigationView bottomNavigation;
    private static final int TIME_DELAY = 2000;
    private static long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_navigasi);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DashboardFragment()).commit();
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.item_dashboard:
                        selectedFragment = new DashboardFragment();
                        break;
                    case R.id.item_ajuan:
                        selectedFragment = new AjuanFragment();
                        break;
                    case R.id.item_penempatan:
                        selectedFragment = new PenempatanFragment();
                        break;
                    case R.id.item_isidentil:
                        selectedFragment = new IsidentilFragment();
                        break;
                    case R.id.item_alat:
                        selectedFragment = new AlatFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });
    }

    @Override
    public boolean setOnItemSelectedListener(MenuItem item) {
        return false;
    }

    @Override
    public void onBackPressed() {

        if (backPressed + TIME_DELAY > System.currentTimeMillis()) {

            finishAffinity();

        } else {
            Toast.makeText(this, "press once again to exit",
                    Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
////        if(toggle.onOptionsItemSelected(item)){
////            return false;
////        }
////        switch (item.getItemId()){
////            case R.menu.menu_main:
////                Intent intentku = new Intent(MainActivity.this, Profile.class);
////                startActivity(intentku);
////                break;
////        }
////        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu);
//        return true;
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
    return true;

}

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.profile){
            startActivity(new Intent(this, Profile.class));
        }
        return true;
    }
}