package com.example.ba95m.sendme.fragments;

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
import com.example.ba95m.sendme.adapters.FlightsAdapter;
import com.example.ba95m.sendme.api.RetrofitClient;
import com.example.ba95m.sendme.model.Flight;
import com.example.ba95m.sendme.model.PostsResponse;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlightsFragment extends Fragment {

    RecyclerView recyclerView ;
    private FlightsAdapter adapter ;
    private List<Flight>flightList ;
    Toolbar toolbar ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_flights , container , false)  ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView =  (RecyclerView) view.findViewById(R.id.recyclerView) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Call<PostsResponse> call  = RetrofitClient.getmInstance().getApi().getPosts() ;

        call.enqueue(new Callback<PostsResponse>() {
            @Override
            public void onResponse(Call<PostsResponse> call, Response<PostsResponse> response) {
                flightList =  response.body().getPosts() ;
                adapter = new FlightsAdapter(getActivity() , flightList) ;
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<PostsResponse> call, Throwable t) {

            }
        });
    }

}
