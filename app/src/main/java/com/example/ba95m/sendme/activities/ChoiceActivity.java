package com.example.ba95m.sendme.activities;

import android.app.Notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ba95m.sendme.R;


public class ChoiceActivity extends AppCompatActivity {
    Button signup , login  ;
    TextView textviewStatus  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        signup =  (Button) findViewById(R.id.signup) ;
        login =  (Button) findViewById(R.id.login) ;

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(ChoiceActivity.this , SignupActivity.class) ;
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(ChoiceActivity.this , LoginActivity.class) ;
                startActivity(intent);
            }
        });







    }



}
