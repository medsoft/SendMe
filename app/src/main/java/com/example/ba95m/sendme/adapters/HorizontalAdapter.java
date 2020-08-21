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
import com.example.ba95m.sendme.R;
import com.example.ba95m.sendme.activities.AnimeActivity;
import com.example.ba95m.sendme.model.Flight;

import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.FlightsViewHolder> {
    private Context mCtx ;
    private List<Flight> flightList  ;

    public HorizontalAdapter(Context mCtx, List<Flight> flightList) {
        this.mCtx = mCtx;
        this.flightList = flightList;
    }

    @NonNull
    @Override
    public FlightsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view   = LayoutInflater.from(mCtx).inflate(R.layout.horizontal_display ,  parent  , false);


        final FlightsViewHolder flightsViewHolder =  new FlightsViewHolder(view) ;
        flightsViewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i  = new Intent(mCtx , AnimeActivity.class) ;
                i.putExtra("id", flightList.get(flightsViewHolder.getAdapterPosition()).getId()) ;
                i.putExtra("location", flightList.get(flightsViewHolder.getAdapterPosition()).getLocation()) ;
                i.putExtra("title", flightList.get(flightsViewHolder.getAdapterPosition()).getTitle()) ;
                i.putExtra("role", flightList.get(flightsViewHolder.getAdapterPosition()).getRole()) ;
                i.putExtra("dress_code", flightList.get(flightsViewHolder.getAdapterPosition()).getDress_code()) ;
                i.putExtra("description", flightList.get(flightsViewHolder.getAdapterPosition()).getDescription()) ;
                i.putExtra("debut", flightList.get(flightsViewHolder.getAdapterPosition()).getDebut()) ;
                i.putExtra("fin", flightList.get(flightsViewHolder.getAdapterPosition()).getFin()) ;
                i.putExtra("duree", flightList.get(flightsViewHolder.getAdapterPosition()).getDuree()) ;
                i.putExtra("remuneration", flightList.get(flightsViewHolder.getAdapterPosition()).getRemuneration()) ;
                i.putExtra("logo", flightList.get(flightsViewHolder.getAdapterPosition()).getLogo()) ;
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
        holder.textviewEntreprise.setText(flight.getName_entreprise().toString());
        holder.textviewDebut.setText(flight.getDebut());
        holder.textviewFin.setText(flight.getFin());
        holder.textviewRemuneration.setText(flight.getRemuneration());
        holder.textviewEntreprise.setText(flight.getName_entreprise().toString());
        holder.textviewDescription.setText(flight.getDescription());
        holder.textviewDuree.setText(flight.getDuree());
        Glide.with(mCtx)
                .load(flight.getLogo())
                .into(holder.imageView);

    }
    @Override
    public int getItemCount() {
        return  flightList.size();
    }

    class FlightsViewHolder extends  RecyclerView.ViewHolder{
        TextView textViewLocation ,textviewDescription,textviewDuree ,textviewEntreprise,textviewDebut , textviewFin ,textviewRemuneration, textViewTitle , textViewRole , textViewDress_code   ;
        ImageView imageView ;

        LinearLayout container  ;


        public FlightsViewHolder(@NonNull View itemView) {
            super(itemView);

            textviewEntreprise =  itemView.findViewById(R.id.textviewEntreprise)  ;
            textviewDebut =  itemView.findViewById(R.id.textviewDebut)  ;
            textviewFin =  itemView.findViewById(R.id.textviewFin)  ;
            textviewRemuneration =  itemView.findViewById(R.id.textviewRemuneration)  ;
            textViewLocation =  itemView.findViewById(R.id.textviewLocation)  ;
            textViewTitle =  itemView.findViewById(R.id.textviewTitle)  ;
            textViewDress_code =  itemView.findViewById(R.id.textviewDress_code)  ;
            textviewDescription =  itemView.findViewById(R.id.textviewDescription)  ;
            textviewDuree =  itemView.findViewById(R.id.textviewDuree)  ;
            textviewDescription =  itemView.findViewById(R.id.textviewDescription)  ;
            imageView = itemView.findViewById(R.id.logo) ;
            container =  itemView.findViewById(R.id.view_container) ;

        }
    }
}

