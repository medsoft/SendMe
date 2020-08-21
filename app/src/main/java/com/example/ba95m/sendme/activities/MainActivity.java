package com.example.ba95m.sendme.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ba95m.sendme.R;

public class MainActivity extends AppCompatActivity {
    private final static  int   SPLASH_SPACE_TIME_OUT = 3000 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i  =  new Intent(MainActivity.this  ,  ChoiceActivity.class) ;
                startActivity(i);
                finish();
            }
        },SPLASH_SPACE_TIME_OUT) ;
    }
}
