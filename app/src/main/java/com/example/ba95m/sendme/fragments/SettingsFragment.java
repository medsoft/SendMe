package com.example.ba95m.sendme.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.ba95m.sendme.R;
import com.example.ba95m.sendme.activities.CompleteProfileActivity;
import com.example.ba95m.sendme.activities.LoginActivity;
import com.example.ba95m.sendme.activities.NewContratActivity;
import com.example.ba95m.sendme.activities.NewExpActivity;
import com.example.ba95m.sendme.activities.ProfileActivity;
import com.example.ba95m.sendme.activities.SignupActivity;
import com.example.ba95m.sendme.storage.SharedPrefManager;

public class SettingsFragment extends Fragment   {
    Toolbar toolbar ;
    Button buttonLogout ;
    ImageView imageView  , imageView2 , imageView3  ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_settings , container , false)  ;

    }

    private void logout ()
    {
        SharedPrefManager.getmInstance(getActivity()).clear();
        Intent i  =  new Intent(getActivity() , LoginActivity.class)  ;
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK) ;
        startActivity(i);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView  textviewUsername =  (TextView) view.findViewById(R.id.textviewUsername) ;
        TextView  textviewEmail =  (TextView) view.findViewById(R.id.textviewEmail) ;
        TextView  textviewAdresse =  (TextView) view.findViewById(R.id.textviewAdresse) ;
        Button buttonDeconnect = (Button) view.findViewById(R.id.buttonDeconnect) ;
        textviewUsername.setText(SharedPrefManager.getmInstance(getActivity()).getUser().getUsername());
        textviewEmail.setText(SharedPrefManager.getmInstance(getActivity()).getUser().getEmail());
        textviewAdresse.setText(SharedPrefManager.getmInstance(getActivity()).getUser().getAdresse());

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        buttonDeconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }



}
