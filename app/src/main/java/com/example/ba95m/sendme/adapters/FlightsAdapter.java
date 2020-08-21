package com.example.ba95m.sendme.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ba95m.sendme.activities.AnimeActivity;
import com.example.ba95m.sendme.R;
import com.example.ba95m.sendme.model.Flight;

import java.util.List;

public class FlightsAdapter extends RecyclerView.Adapter<FlightsAdapter.FlightsViewHolder> {
    private Context mCtx ;
    private List<Flight>flightList  ;

    public FlightsAdapter(Context mCtx, List<Flight> flightList) {
        this.mCtx = mCtx;
        this.flightList = flightList;
    }

    @NonNull
    @Override
    public FlightsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view   = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_flight ,  parent  , false);


        final FlightsViewHolder flightsViewHolder =  new FlightsViewHolder(view) ;
        flightsViewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent  i  = new Intent(mCtx , AnimeActivity.class) ;
                i.putExtra("id", flightList.get(flightsViewHolder.getAdapterPosition()).getId()) ;
                i.putExtra("location", flightList.get(flightsViewHolder.getAdapterPosition()).getLocation()) ;
                i.putExtra("title", flightList.get(flightsViewHolder.getAdapterPosition()).getTitle()) ;
                i.putExtra("role", flightList.get(flightsViewHolder.getAdapterPosition()).getRole()) ;
                i.putExtra("dress_code", flightList.get(flightsViewHolder.getAdapterPosition()).getDress_code()) ;
                i.putExtra("description", flightList.get(flightsViewHolder.getAdapterPosition()).getDescription()) ;
                i.putExtra("duree", flightList.get(flightsViewHolder.getAdapterPosition()).getDuree()) ;
                i.putExtra("debut", flightList.get(flightsViewHolder.getAdapterPosition()).getDebut()) ;
                i.putExtra("fin", flightList.get(flightsViewHolder.getAdapterPosition()).getFin()) ;
                i.putExtra("remuneration", flightList.get(flightsViewHolder.getAdapterPosition()).getRemuneration()) ;
                i.putExtra("logo", flightList.get(flightsViewHolder.getAdapterPosition()).getLogo().toString()) ;
                i.putExtra("id_entreprise", flightList.get(flightsViewHolder.getAdapterPosition()).getId_entreprise()) ;


                mCtx.startActivity(i);
            }
        });
        return flightsViewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull FlightsViewHolder holder, int position ) {
        Flight flight  =  flightList.get(position)  ;
        holder.textViewLocation.setText(flight.getLocation());
        holder.textViewTitle.setText(flight.getTitle());
        holder.textViewRemuneration.setText(flight.getRemuneration());
        holder.textviewEntreprise.setText(flight.getName_entreprise().toString());
        holder.textviewDateDebut.setText(flight.getDebut().toString());


        Glide.with(mCtx)
                .load(flight.getLogo())
                .into(holder.logo);


    }

    @Override
    public int getItemCount() {
        return  flightList.size();
    }

    class FlightsViewHolder extends  RecyclerView.ViewHolder{
        TextView textViewLocation   ,textviewDateDebut, textviewEntreprise ,  textViewTitle , textViewRemuneration , textViewRole   , textviewDescription ;
        ImageView logo ;

        LinearLayout container  ;


        public FlightsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewLocation =  itemView.findViewById(R.id.textviewLocation)  ;
            textViewTitle =  itemView.findViewById(R.id.textviewTitle)  ;
            textViewRemuneration =  itemView.findViewById(R.id.textviewRemuneration)  ;
            textviewDescription =  itemView.findViewById(R.id.textviewDescription)  ;
            textviewEntreprise =  itemView.findViewById(R.id.textviewEntreprise)  ;
            textviewDateDebut =  itemView.findViewById(R.id.textviewDateDebut)  ;
            logo = itemView.findViewById(R.id.logo) ;
            container =  itemView.findViewById(R.id.view_container) ;



        }
    }
}
