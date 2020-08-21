package com.example.ba95m.sendme.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static  final String BASE_URL   =  "http://172.20.10.3/nawanam/public/" ;
    private static  RetrofitClient mInstance  ;
    private Retrofit retrofit ;

    private RetrofitClient(){
        retrofit  =  new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build() ;
    }

    public static synchronized  RetrofitClient getmInstance(){
        if (mInstance == null ) {
            mInstance =  new RetrofitClient() ;
        }
        return  mInstance ;
    }
    public Api getApi () {
        return  retrofit.create(Api.class) ;
    }
}
