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
import com.example.ba95m.sendme.fragments.HomeFragment;
import com.example.ba95m.sendme.model.LoginResponse;
import com.example.ba95m.sendme.storage.SharedPrefManager;

import org.aviran.cookiebar2.CookieBar;
import org.aviran.cookiebar2.OnActionClickListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    EditText  editTextEmail    , editTextPassword  ;
    Button buttonLogin   ;
    Dialog myDialog  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail  =  (EditText) findViewById(R.id.editTextEmail) ;
        editTextPassword  =  (EditText) findViewById(R.id.editTextPassword) ;
        buttonLogin =  (Button) findViewById(R.id.buttonLogin) ;
        buttonLogin.setOnClickListener(this);
        myDialog =  new Dialog(this) ;


    }

    @Override
    protected void onStart() {

        super.onStart();
        if (SharedPrefManager.getmInstance(this).isLoggedIn()){
            Intent i  =  new Intent(LoginActivity.this , ProfileActivity.class)  ;
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK) ;
            startActivity(i);
        }
    }

    public  void showPopup ()
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

    private void userLogin()
    {

        String email  =  editTextEmail.getText().toString().trim()  ;
        String password   =  editTextPassword.getText().toString().trim()  ;

        if (email.isEmpty()){
            editTextEmail.setError("Le nom d'utilisateur est vide ");
            editTextEmail.requestFocus() ;
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editTextEmail.setError("Cet email n'est pas valide ");
            editTextEmail.requestFocus() ;
            return;
        }
        if (password.isEmpty()){
            editTextPassword.setError(" ce mot de passe n'est pas valide  ");
            editTextPassword.requestFocus() ;
            return;
        }
        Call<LoginResponse> call = RetrofitClient.getmInstance()
                .getApi().userLogin(email , password) ;
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body() ;
                if (!loginResponse.isError())
                {
                     SharedPrefManager.getmInstance(LoginActivity.this)
                            .saveUser(loginResponse.getUser());
                    Intent i  =  new Intent(LoginActivity.this , ProfileActivity.class)  ;
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK) ;
                    startActivity(i);
                }else {
                    //Toast.makeText(LoginActivity.this , loginResponse.getMessage(),Toast.LENGTH_LONG).show();
                    CookieBar.build(LoginActivity.this)
                            .setTitle("Connexion")
                            .setIcon(R.mipmap.staff)
                            .setTitleColor(R.color.colorWhite)
                            .setMessageColor(R.color.colorWhite)
                            .setMessage("Une erreur est survenue veuillez revoir vos identifiants de connexion")
                            .setDuration(5000)
                            .setBackgroundColor(R.color.red)
                            .show();
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.buttonLogin :
                userLogin() ;
                break;
        }
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
