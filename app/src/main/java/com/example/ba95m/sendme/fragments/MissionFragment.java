package com.example.ba95m.sendme.fragments;

import android.graphics.Color;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ba95m.sendme.R;
import com.example.ba95m.sendme.adapters.MissionAdapter;
import com.example.ba95m.sendme.api.RetrofitClient;
import com.example.ba95m.sendme.model.Mission;
import com.example.ba95m.sendme.model.MissionsResponse;
import com.example.ba95m.sendme.model.User;
import com.example.ba95m.sendme.storage.SharedPrefManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MissionFragment extends Fragment  {
    Toolbar toolbar ;
    private List<Mission>missionList  ;
    private RecyclerView recyclerView ;
    private MissionAdapter adapter ;
    ImageView info ;
    TextView text  ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_mission , container , false)  ;

    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        info = view.findViewById(R.id.info) ;
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        text  =  view.findViewById(R.id.text) ;
        recyclerView =  view.findViewById(R.id.recyclerView) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        int user_id  =  SharedPrefManager.getmInstance(getActivity()).getUser().getId() ;

        Call<MissionsResponse> call  = RetrofitClient.getmInstance().getApi().getMissions(user_id) ;
        call.enqueue(new Callback<MissionsResponse>() {
            @Override
            public void onResponse(Call<MissionsResponse> call, Response<MissionsResponse> response) {
                missionList  = response.body().getMissions() ;
                adapter = new MissionAdapter(getActivity() , missionList) ;
                recyclerView.setAdapter(adapter);

                if (missionList.isEmpty()){
                    info.setImageResource(R.drawable.missionn);
                    info.setVisibility(View.VISIBLE);
                    text.setText("Aucune mission postulée");
                    text.setVisibility(View.VISIBLE);
                    text.setTextColor(Color.parseColor("#ef5350"));
                }
            }
            @Override
            public void onFailure(Call<MissionsResponse> call, Throwable t) {

            }
        });

    }
}
