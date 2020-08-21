package com.example.ba95m.sendme.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ba95m.sendme.R;
import com.example.ba95m.sendme.fragments.FlightsFragment;
import com.example.ba95m.sendme.fragments.HomeFragment;
import com.example.ba95m.sendme.fragments.ListContratFragment;
import com.example.ba95m.sendme.fragments.MissionFragment;
import com.example.ba95m.sendme.fragments.SettingsFragment;
import com.example.ba95m.sendme.model.User;
import com.example.ba95m.sendme.storage.SharedPrefManager;

public class ProfileActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView ;
    Toolbar toolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        User user = SharedPrefManager.getmInstance(this).getUser();
        bottomNavigationView =  (BottomNavigationView) findViewById(R.id.bottomNavigation) ;
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        displayFragment(new HomeFragment());

        toolbar = (Toolbar) findViewById(R.id.toolbar) ;
        //setSupportActionBar(toolbar) ;
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void displayFragment (Fragment fragment)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.relativelayout , fragment)
                .commit() ;
    }
    @Override
    protected void onStart() {

        super.onStart();
        if (!SharedPrefManager.getmInstance(this).isLoggedIn()){
            Intent i  =  new Intent(this , ProfileActivity.class)  ;
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK) ;
            startActivity(i);
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null ;
        switch (item.getItemId())
        {
            case R.id.menu_home :
                fragment =  new HomeFragment() ;
                break;
            case R.id.menu_flight :
                fragment =  new FlightsFragment();
                break;
            case R.id.menu_missions :
                fragment =  new MissionFragment();
                break;
            case R.id.menu_contrat:
               fragment =  new ListContratFragment() ;
                break;
            case R.id.menu_settings:
             fragment = new  SettingsFragment() ;
                break;
        }
        if (fragment != null)
        {
            displayFragment(fragment);
        }
        return false;
    }


}
