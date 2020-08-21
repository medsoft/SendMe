package com.example.ba95m.sendme.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ba95m.sendme.R;
import com.example.ba95m.sendme.api.RetrofitClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StartingMissionActivity extends AppCompatActivity {
    int   gain      , heureDeb , heurefin ;
    TextView textviewTitle  , textviewDuree, textviewGain,   textviewManager, textviewTelephone ,textviewLocation ,textviewEntreprise , textviewHeureDebut ,textviewHeureFin , textviewRemuneration ;
    ImageView imageView  ;
    EditText editTextUser_id ,editTextSoldeContrat, editTextEntreprise_id , editTextPostulant_id,editTextMission_id,editTextStatutContrat ;
    Button buttonValiderContrat  ;
    Dialog myDialog ;
    Toolbar toolbar ;
    private int statutContrat  =  1   ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_mission);




        myDialog =  new Dialog(this) ;
        int identifiant_postulant = getIntent().getExtras().getInt("id") ;
        int utilisateur_id = getIntent().getExtras().getInt("user_id") ;
        int statut = getIntent().getExtras().getInt("statut") ;
        int identifiant_mission = getIntent().getExtras().getInt("id_mission") ;
        int identifiant_entreprise =  getIntent().getExtras().getInt("id_entreprise") ;


        String username =  getIntent().getExtras().getString("username") ;
        String email =  getIntent().getExtras().getString("email") ;
        String location =  getIntent().getExtras().getString("location") ;
        String title =  getIntent().getExtras().getString("title") ;
        String remuneration =  getIntent().getExtras().getString("remuneration") ;
        String debut =  getIntent().getExtras().getString("debut") ;
        String fin =  getIntent().getExtras().getString("fin") ;
        String heureDeDebut =  getIntent().getExtras().getString("heure_debut") ;
        String heureDeFin =  getIntent().getExtras().getString("heure_fin") ;
        String duree =  getIntent().getExtras().getString("duree") ;


        String name_enreprise =  getIntent().getExtras().getString("name_entreprise") ;
        String logo =  getIntent().getExtras().getString("logo") ;
        String manager =  getIntent().getExtras().getString("manager") ;
        String telephone =  getIntent().getExtras().getString("telephone") ;



        textviewTitle =  (TextView) findViewById(R.id.textviewTitle) ;
        textviewLocation =  (TextView) findViewById(R.id.textviewLocation) ;
        textviewEntreprise =  (TextView) findViewById(R.id.textviewEntreprise) ;
        textviewHeureDebut =  (TextView) findViewById(R.id.textviewHeureDebut) ;
        textviewHeureFin =  (TextView) findViewById(R.id.textviewHeureFin) ;
        textviewRemuneration =  (TextView) findViewById(R.id.textviewRemuneration) ;
        textviewDuree =  (TextView) findViewById(R.id.textviewDuree) ;
        textviewGain =  (TextView) findViewById(R.id.textviewGain) ;
        buttonValiderContrat =  (Button) findViewById(R.id.buttonValiderContrat) ;
        textviewManager =   (TextView) findViewById(R.id.textviewManager) ;
        textviewTelephone =  (TextView) findViewById(R.id.textviewTelephone) ;
        imageView = (ImageView) findViewById(R.id.logo) ;

        textviewTitle.setText(title);
        textviewLocation.setText(location);
        textviewEntreprise.setText(name_enreprise);
        textviewHeureDebut.setText(heureDeDebut);
        textviewHeureFin.setText(heureDeFin);
        textviewRemuneration.setText(remuneration);
        textviewManager.setText(manager);
        textviewTelephone.setText(telephone);
        textviewDuree.setText(duree);
        Glide.with(this)
                .load(logo)
                .into(imageView)  ;

            gain =  Integer.parseInt(duree) * Integer.parseInt(remuneration) ;
        textviewGain.setText(String.valueOf(gain));

        editTextUser_id =  (EditText) findViewById(R.id.editTextUser_id) ;
        editTextEntreprise_id =  (EditText) findViewById(R.id.editTextEntreprise_id) ;
        editTextPostulant_id =  (EditText) findViewById(R.id.editTextPostulant_id) ;
        editTextMission_id =  (EditText) findViewById(R.id.editTextMission_id) ;
        editTextStatutContrat =  (EditText) findViewById(R.id.editTextStatutContrat) ;
        editTextSoldeContrat =  (EditText) findViewById(R.id.editTextSoldeContrat) ;

        editTextUser_id.setText(String.valueOf(utilisateur_id));
        editTextEntreprise_id.setText(String.valueOf(identifiant_entreprise));
        editTextPostulant_id.setText(String.valueOf(identifiant_postulant));
        editTextMission_id.setText(String.valueOf(identifiant_mission));
        editTextStatutContrat.setText(String.valueOf(statutContrat));
        editTextSoldeContrat.setText(String.valueOf(gain));

        toolbar =  (Toolbar) findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        buttonValiderContrat.setOnClickListener(new View.OnClickListener() {

            int user_id  =  Integer.parseInt(editTextUser_id.getText().toString().trim()) ;
            int entreprise_id  =  Integer.parseInt(editTextEntreprise_id.getText().toString().trim()) ;
            int postulant_id  =  Integer.parseInt(editTextPostulant_id.getText().toString().trim()) ;
            int mission_id  =  Integer.parseInt(editTextMission_id.getText().toString().trim()) ;
            int statut_contrat  =  Integer.parseInt(editTextStatutContrat.getText().toString().trim()) ;
            int solde = Integer.parseInt(editTextSoldeContrat.getText().toString().trim());
            @Override
            public void onClick(View view) {
                Call<ResponseBody> call = RetrofitClient.getmInstance().getApi().sendingContrat(user_id  ,entreprise_id,postulant_id,mission_id,statut_contrat , solde) ;
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        /*
                        CookieBar.build(StartingMissionActivity.this)
                                .setTitle("Contrat")
                                .setIcon(R.mipmap.staff)
                                .setTitleColor(R.color.colorWhite)
                                .setMessageColor(R.color.colorWhite)
                                .setMessage("Votre contrat a bien été envoyé a l'entreprise")
                                .setDuration(5000)
                                .setBackgroundColor(R.color.vert5)
                                .show();
                        buttonValiderContrat.setText("Contrat envoyé ");
                        buttonValiderContrat.setBackgroundColor(Color.parseColor("#f79CA3"));
                        buttonValiderContrat.setEnabled(false);
                        */
                        showPopup();
                        buttonValiderContrat.setText("Contrat envoyé ");
                        buttonValiderContrat.setBackgroundColor(Color.parseColor("#f79CA3"));
                        buttonValiderContrat.setEnabled(false);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }

        });
        if (statut == 1){
            buttonValiderContrat.setText("Deja envoyé");
            buttonValiderContrat.setBackgroundColor(Color.parseColor("#f79CA3"));
            buttonValiderContrat.setEnabled(false);
        }else {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater  =  getMenuInflater() ;
        menuInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id  =  item.getItemId();
        if (item_id ==  R.id.money_item)
        {
            Intent intent  = new Intent(StartingMissionActivity.this , PaymentActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public  void showPopup ()
    {
        TextView textclose  ;
        Button buttonFollow  ;
        myDialog.setContentView(R.layout.popupmission) ;
        textclose =  (TextView) myDialog.findViewById(R.id.textclose) ;
        textclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



}
