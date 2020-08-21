package com.example.ba95m.sendme.fragments;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ba95m.sendme.R;
import com.example.ba95m.sendme.adapters.WorkAdapter;
import com.example.ba95m.sendme.api.RetrofitClient;

import com.example.ba95m.sendme.model.Work;
import com.example.ba95m.sendme.model.WorkResponse;
import com.example.ba95m.sendme.storage.SharedPrefManager;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListContratFragment extends Fragment {
    Toolbar toolbar ;
  private List<Work> workList  ;
  private  RecyclerView recyclerView  ;
  private  WorkAdapter adapter  ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_listcontrat , container , false)  ;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView =  view.findViewById(R.id.recyclerView) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        int user_id  = SharedPrefManager.getmInstance(getActivity()).getUser().getId()  ;
      Call<WorkResponse> call =  RetrofitClient.getmInstance().getApi().getWorks(user_id) ;
      call.enqueue(new Callback<WorkResponse>() {
          @Override
          public void onResponse(Call<WorkResponse> call, Response<WorkResponse> response) {
                    workList =  response.body().getWorks() ;
                    adapter =  new WorkAdapter(getActivity() , workList) ;
                    recyclerView.setAdapter(adapter);



          }

          @Override
          public void onFailure(Call<WorkResponse> call, Throwable t) {

          }
      });

    }


}
