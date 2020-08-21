package com.example.ba95m.sendme.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ba95m.sendme.R;
import com.example.ba95m.sendme.adapters.FlightsAdapter;
import com.example.ba95m.sendme.adapters.HorizontalAdapter;
import com.example.ba95m.sendme.api.RetrofitClient;
import com.example.ba95m.sendme.model.Flight;
import com.example.ba95m.sendme.model.PostsResponse;
import com.example.ba95m.sendme.storage.SharedPrefManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    TextView textViewUsername , textViewEmail , textViewAdresse;
    RecyclerView recyclerView ;
    private HorizontalAdapter adapter ;
    private List<Flight>flightList ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      return  inflater.inflate(R.layout.fragment_home , container , false)  ;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*
        textViewUsername = view.findViewById(R.id.textviewUsername) ;
        textViewEmail = view.findViewById(R.id.textviewEmail) ;
        textViewAdresse = view.findViewById(R.id.textviewAdresse) ;

        textViewUsername.setText(SharedPrefManager.getmInstance(getActivity()).getUser().getUsername());
        textViewEmail.setText(SharedPrefManager.getmInstance(getActivity()).getUser().getEmail());
        textViewAdresse.setText(SharedPrefManager.getmInstance(getActivity()).getUser().getAdresse());

*/
        recyclerView =  (RecyclerView) view.findViewById(R.id.recyclerView) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL,false));
        Call<PostsResponse> call  = RetrofitClient.getmInstance().getApi().getPosts() ;

        call.enqueue(new Callback<PostsResponse>() {
            @Override
            public void onResponse(Call<PostsResponse> call, Response<PostsResponse> response) {
                flightList =  response.body().getPosts() ;
                adapter = new HorizontalAdapter(getActivity() , flightList) ;
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<PostsResponse> call, Throwable t) {

            }
        });
    }
}
