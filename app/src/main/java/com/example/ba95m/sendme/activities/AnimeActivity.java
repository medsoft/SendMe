package com.example.ba95m.sendme.activities;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ba95m.sendme.R;
import com.example.ba95m.sendme.api.RetrofitClient;

import com.example.ba95m.sendme.model.Candidat;
import com.example.ba95m.sendme.storage.SharedPrefManager;


import org.aviran.cookiebar2.CookieBar;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AnimeActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonApply  ;
    Dialog myDialog ;
    Toolbar toolbar ;
    TextView detail   ;
    private int candidat = 2  ;
    private  int stat  =  2  ;
    EditText editTextStatut ,editTextcodeMission ,editTextUser_id  ,  editTextEntrepriseId    ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        buttonApply  =  (Button) findViewById(R.id.buttonApply) ;

        myDialog =  new Dialog(this) ;
        buttonApply.setOnClickListener(this);



        toolbar =  (Toolbar) findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        editTextStatut =  (EditText) findViewById(R.id.editTextStatut);
        editTextcodeMission =  (EditText) findViewById(R.id.editTextcodeMission);
        editTextUser_id =  (EditText) findViewById(R.id.editTextUser_id);
        editTextEntrepriseId =  (EditText) findViewById(R.id.editTextEntrepriseId);





        int mission =  getIntent().getExtras().getInt("id") ;
        String location =  getIntent().getExtras().getString("location") ;
        String title =  getIntent().getExtras().getString("title") ;
        String remuneration =  getIntent().getExtras().getString("remuneration") ;
        String role =  getIntent().getExtras().getString("role") ;
        String dress_code =  getIntent().getExtras().getString("dress_code") ;
        String description =  getIntent().getExtras().getString("description") ;
        String debut =  getIntent().getExtras().getString("debut") ;
        String fin =  getIntent().getExtras().getString("fin") ;
        String duree =  getIntent().getExtras().getString("duree") ;
        String logo =  getIntent().getExtras().getString("logo") ;
        int entreprise =  getIntent().getExtras().getInt("id_entreprise") ;




        TextView textViewLocation  =  findViewById(R.id.textviewLocation) ;
        TextView textViewTitle  =  findViewById(R.id.textviewTitle) ;
        TextView textviewRemuneration =  findViewById(R.id.textviewRemuneration) ;
        TextView textviewRole  =  findViewById(R.id.textviewRole) ;
        TextView textviewDress_code  =  findViewById(R.id.textviewDress_code) ;
        TextView textviewDescription  =  findViewById(R.id.textviewDescription) ;
        TextView textviewDebut  =  findViewById(R.id.textviewDebut) ;
        TextView textviewFin  =  findViewById(R.id.textviewFin) ;
        TextView textviewDuree  =  findViewById(R.id.textviewDuree) ;
        ImageView imageView   =  findViewById(R.id.logo) ;

        textViewLocation.setText(location);
        textViewTitle.setText(title);
        textviewRole.setText(role);
        textviewRemuneration.setText(remuneration);
        textviewDress_code.setText(dress_code);
        textviewDescription.setText(description);
        textviewDebut.setText(debut);
        textviewFin.setText(fin);
        textviewDuree.setText(duree);
        Glide.with(this)
                .load(logo)
                .into(imageView)  ;
              //  .placeholder(R.drawable.placeholder)
                //.error(R.drawable.imagenotfound)

            editTextcodeMission.setText(String.valueOf(mission));

            editTextStatut.setText(String.valueOf(stat));
            editTextUser_id.setText(String.valueOf(SharedPrefManager.getmInstance(getApplicationContext()).getUser().getId()));
            editTextEntrepriseId.setText(String.valueOf(entreprise));


        int user_id   =  SharedPrefManager.getmInstance(getApplicationContext()).getUser().getId() ;
        Call<Candidat> call =  RetrofitClient.getmInstance().getApi().getUser(user_id) ;
        call.enqueue(new Callback<Candidat>() {
            @Override
            public void onResponse(Call<Candidat> call, Response<Candidat> response) {

                Candidat c =  response.body() ;
                // detail.setText(String.valueOf(c));
            }

            @Override
            public void onFailure(Call<Candidat> call, Throwable t) {

            }
        });

    }

    private void apply (){


        final int id_mission  = Integer.parseInt(editTextcodeMission.getText().toString().trim());
        int statut  = Integer.parseInt(editTextStatut.getText().toString().trim());
        int user_id  = Integer.parseInt(editTextUser_id.getText().toString().trim());
        int entreprise_id = Integer.parseInt(editTextEntrepriseId.getText().toString().trim()) ;
        Call<ResponseBody> call =  RetrofitClient.getmInstance().getApi().applyMission(statut , user_id , id_mission,entreprise_id ) ;
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                CookieBar.build(AnimeActivity.this)
                        .setTitle("Candidature")
                        .setIcon(R.mipmap.staff)
                        .setTitleColor(R.color.colorWhite)
                        .setMessageColor(R.color.colorWhite)
                        .setMessage("Bravo Nous etudions votre candidature , nous revenons vers vous au plus vite  ")
                        .setDuration(5000)
                        .setBackgroundColor(R.color.vert5)
                        .show();
                buttonApply.setText("Vous etes candidat ");
                buttonApply.setBackgroundColor(Color.parseColor("#f79CA3"));
                buttonApply.setEnabled(false);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });





    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public  void showPopup ()
    {
        TextView textclose  ;
        Button buttonFollow  ;
        myDialog.setContentView(R.layout.custompopupsignup) ;
        textclose =  (TextView) myDialog.findViewById(R.id.textclose) ;
        // buttonLogin =  (Button) myDialog.findViewById(R.id.buttonLogin) ;

        textclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.buttonApply :
                apply();
                break;
        }
    }
}
