package com.example.ba95m.sendme.activities;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ba95m.sendme.R;

public class ContactActivity extends AppCompatActivity {

    Button popup   ;
    Dialog myDialog  ;
    TextView affiche  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        affiche =  (TextView) findViewById(R.id.affiche) ;
        myDialog =  new Dialog(this) ;

        String missionId = getIntent().getStringExtra("id");
        affiche.setText(missionId);
    }

    public  void showPopup (View v)
    {
        TextView textclose  ;
        Button buttonFollow  ;
        myDialog.setContentView(R.layout.custompopup) ;
        textclose =  (TextView) myDialog.findViewById(R.id.textclose) ;
        buttonFollow =  (Button) myDialog.findViewById(R.id.buttonFollow) ;
        textclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }


}
