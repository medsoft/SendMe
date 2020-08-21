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
import com.example.ba95m.sendme.activities.StartingMissionActivity;
import com.example.ba95m.sendme.model.Work;

import java.util.List;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkViewHolder> {

   private  List<Work>workList;
    private Context mCtx ;
    private int  acceptee  =  4   ;

    public WorkAdapter( Context mCtx , List<Work> workList ) {
        this.workList = workList;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public WorkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_work , parent , false) ;

        final  WorkViewHolder workViewHolder  = new WorkViewHolder(view) ;
            workViewHolder.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i  = new Intent(mCtx , StartingMissionActivity.class) ;
                    i.putExtra("id", workList.get(workViewHolder.getAdapterPosition()).getId()) ;
                    i.putExtra("statut", workList.get(workViewHolder.getAdapterPosition()).getStatut()) ;
                    i.putExtra("id_mission", workList.get(workViewHolder.getAdapterPosition()).getId_mission()) ;
                    i.putExtra("user_id", workList.get(workViewHolder.getAdapterPosition()).getUser_id()) ;

                    i.putExtra("location", workList.get(workViewHolder.getAdapterPosition()).getLocation()) ;
                    i.putExtra("title", workList.get(workViewHolder.getAdapterPosition()).getTitle()) ;
                    i.putExtra("debut", workList.get(workViewHolder.getAdapterPosition()).getDebut()) ;
                    i.putExtra("fin", workList.get(workViewHolder.getAdapterPosition()).getFin()) ;
                    i.putExtra("duree", workList.get(workViewHolder.getAdapterPosition()).getDuree()) ;
                    i.putExtra("heure_debut", workList.get(workViewHolder.getAdapterPosition()).getHeure_debut()) ;
                    i.putExtra("heure_fin", workList.get(workViewHolder.getAdapterPosition()).getHeure_fin()) ;
                    i.putExtra("remuneration", workList.get(workViewHolder.getAdapterPosition()).getRemuneration()) ;

                    i.putExtra("id_entreprise", workList.get(workViewHolder.getAdapterPosition()).getId_entreprise()) ;
                    i.putExtra("name_entreprise", workList.get(workViewHolder.getAdapterPosition()).getName_entreprise()) ;
                    i.putExtra("logo", workList.get(workViewHolder.getAdapterPosition()).getLogo()) ;
                    i.putExtra("manager", workList.get(workViewHolder.getAdapterPosition()).getManager()) ;
                    i.putExtra("telephone", workList.get(workViewHolder.getAdapterPosition()).getTelephone()) ;

                    mCtx.startActivity(i);
                }


            });
            return workViewHolder ;
    }
    @Override
    public void onBindViewHolder(@NonNull WorkViewHolder holder, int position) {
        Work work  =  workList.get(position) ;
        holder.textViewDebut.setText(work.getDebut());
        holder.textViewName.setText(work.getName_entreprise());
        holder.textViewTitle.setText(work.getTitle());
        Glide.with(mCtx)
                .load(work.getLogo())
                .into(holder.logo);

       /* if (String.valueOf(work.getStatut()) ==  String.valueOf(acceptee) ) {
            holder.textViewStatus.setText(" Acceptee ");
            holder.textViewStatus.setBackgroundResource(R.color.vert5);
        }
        */
    }

    @Override
    public int getItemCount() {
        return workList.size();
    }

    class WorkViewHolder extends RecyclerView.ViewHolder{
        TextView textViewDebut ,textViewStatus, textViewName , textViewTitle  ;
        ImageView logo ;
        LinearLayout container  ;
        public WorkViewHolder(@NonNull View itemView) {

            super(itemView);
            textViewDebut =  (TextView) itemView.findViewById(R.id.textViewDebut) ;
            textViewName=  (TextView) itemView.findViewById(R.id.textViewName) ;
            textViewTitle =  (TextView) itemView.findViewById(R.id.textViewTitle) ;
          //  textViewStatus =  (TextView) itemView.findViewById(R.id.textViewStatus) ;
            logo =  (ImageView)itemView.findViewById(R.id.logo) ;
            container   =  (LinearLayout) itemView.findViewById(R.id.view_container) ;
        }
    }
}
