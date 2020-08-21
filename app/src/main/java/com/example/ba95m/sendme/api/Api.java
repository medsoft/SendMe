package com.example.ba95m.sendme.api;

import com.example.ba95m.sendme.model.Candidat;
import com.example.ba95m.sendme.model.LoginResponse;
import com.example.ba95m.sendme.model.MissionsResponse;
import com.example.ba95m.sendme.model.PostsResponse;
import com.example.ba95m.sendme.model.Work;
import com.example.ba95m.sendme.model.WorkResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {



    @FormUrlEncoded
    @POST("createuser")
    Call<ResponseBody>createUser(
            @Field("username")String username ,
            @Field("email")String email ,
            @Field("adresse")String adresse ,
            @Field("password")String password
    ) ;
    @FormUrlEncoded
    @POST ("userlogin")
    Call<LoginResponse>userLogin(
            @Field("email") String email ,
            @Field("password") String password
    ) ;

    @GET("allposts")
    Call<PostsResponse>getPosts() ;




    @GET("allmissionapplyed/{user_id}")
    Call<MissionsResponse> getMissions(
            @Path("user_id") int user_id ) ;


    @GET("allacceptedmission/{user_id}")
    Call<WorkResponse> getWorks(
            @Path("user_id") int user_id ) ;


    @GET("getuser/{user_id}")
    Call<Candidat> getUser(
            @Path("user_id") int user_id ) ;

    @FormUrlEncoded
    @POST("apply")
    Call<ResponseBody>applyMission (
            @Field("statut") int statut,
            @Field("user_id") int user_id,
            @Field("id_mission") int id_mission,
            @Field("entreprise_id") int entreprise_id
    ) ;
    @FormUrlEncoded
    @POST("sendcontrat")
    Call<ResponseBody>sendingContrat (
            @Field("user_id") int user_id,
            @Field("entreprise_id") int entreprise_id,
            @Field("postulant_id") int postulant_id,
            @Field("mission_id") int mission_id,
            @Field("statut_contrat") int statut_contrat,
            @Field("solde") int solde
    ) ;
}
