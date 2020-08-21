package com.example.ba95m.sendme.activities;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ba95m.sendme.R;
import com.example.ba95m.sendme.api.RetrofitClient;
import com.example.ba95m.sendme.storage.SharedPrefManager;

import org.aviran.cookiebar2.CookieBar;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextUsername  , editTextEmail  , editTextAdresse  , editTextPassword  ;
    Button buttonSignup   , buttonLogin ;
    Dialog myDialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextUsername  =  (EditText) findViewById(R.id.editTextUsername) ;
        editTextEmail  =  (EditText) findViewById(R.id.editTextEmail) ;
        editTextAdresse  =  (EditText) findViewById(R.id.editTextAdresse) ;
        editTextPassword  =  (EditText) findViewById(R.id.editTextPassword) ;

        buttonSignup =  (Button) findViewById(R.id.buttonSignup) ;
        buttonSignup.setOnClickListener(this);
        myDialog =  new Dialog(this) ;

    }

    @Override
    protected void onStart() {

        super.onStart();
        if (SharedPrefManager.getmInstance(this).isLoggedIn()){
            Intent i  =  new Intent(SignupActivity.this , ProfileActivity.class)  ;
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK) ;
            startActivity(i);
        }
    }

    public  void showPopup ()
    {
        TextView textclose  ;
        Button buttonFollow  ;
        myDialog.setContentView(R.layout.custompopupsignup) ;
        textclose =  (TextView) myDialog.findViewById(R.id.textclose) ;
        buttonLogin =  (Button) myDialog.findViewById(R.id.buttonLogin) ;

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignupActivity.this  , LoginActivity.class) ;
                startActivity(i);
            }
        });

        textclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

    private void userSignup ()
    {
        String username  =  editTextUsername.getText().toString().trim()  ;
        String email  =  editTextEmail.getText().toString().trim()  ;
        String adresse  =  editTextAdresse.getText().toString().trim()  ;
        String password   =  editTextPassword.getText().toString().trim()  ;

        if (username.isEmpty()){
            editTextUsername.setError("Le nom d'utilisateur est vide ");
            editTextUsername.requestFocus() ;
            return;
        }
        if (email.isEmpty()){
            editTextEmail.setError("cet email n' est pas valide  ");
            editTextEmail.requestFocus() ;
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editTextEmail.setError("Cet email n'est pas valide ");
            editTextEmail.requestFocus() ;
            return;
        }
        if (adresse.isEmpty()){
            editTextAdresse.setError("Cette adresse n'est pas valide  ");
            editTextAdresse.requestFocus() ;
            return;
        }
        if (password.isEmpty()){
            editTextPassword.setError(" ce mot de passe n'est pas valide  ");
            editTextPassword.requestFocus() ;
            return;
        }
       Call<ResponseBody> call =  RetrofitClient.getmInstance().getApi().createUser(username, email , adresse , password);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    if (response.code() == 201) {
                      String  s = response.body().string();
                        try {
                            JSONObject jsonObject = jsonObject = new JSONObject(s);
                            CookieBar.build(SignupActivity.this)
                                    .setTitle(jsonObject.getString("message"))
                                    .setIcon(R.mipmap.staff)
                                    .setTitleColor(R.color.colorWhite)
                                    .setMessageColor(R.color.colorWhite)
                                    .setMessage("Connectez-vous des maintenant pour commencer a travailler ")
                                    .setDuration(5000)
                                    .setBackgroundColor(R.color.vert5)
                                    .show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }else {
                      String  s = response.errorBody().string();
                        try {
                            JSONObject jsonObject = jsonObject = new JSONObject(s);

                            CookieBar.build(SignupActivity.this)
                                    .setTitle(jsonObject.getString("message"))
                                    .setIcon(R.mipmap.staff)
                                    .setTitleColor(R.color.colorWhite)
                                    .setMessageColor(R.color.colorWhite)
                                    .setMessage("Une erreur est survenue veuillez revoir les donnes saisies")
                                    .setDuration(5000)
                                    .setBackgroundColor(R.color.red)
                                    .show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                CookieBar.build(SignupActivity.this)
                        .setTitle("Connexion")
                        .setIcon(R.mipmap.staff)
                        .setTitleColor(R.color.colorWhite)
                        .setMessageColor(R.color.colorWhite)
                        .setMessage("Une erreur est survenue veuillez revoir vos identifiants de connexion")
                        .setDuration(5000)
                        .setBackgroundColor(R.color.red)
                        .show();
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.buttonSignup :
                userSignup () ;
                break;
        }
    }
}