package com.example.ba95m.sendme.adapters;

import android.animation.Animator;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;


import android.app.PendingIntent;
import android.content.Context;


import android.content.Intent;
import android.support.annotation.NonNull;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ba95m.sendme.R;

import com.example.ba95m.sendme.activities.SignupActivity;
import com.example.ba95m.sendme.fragments.MissionFragment;
import com.example.ba95m.sendme.model.Mission;


import org.aviran.cookiebar2.CookieBar;
import org.aviran.cookiebar2.OnActionClickListener;

import java.util.List;

import zemin.notification.NotificationBuilder;

import static android.content.Context.NOTIFICATION_SERVICE;


public class MissionAdapter extends RecyclerView.Adapter<MissionAdapter.MissionVieHolder>  {

    private Context mCtx  ;
    public int  attente  =  2 ;
    public int  refus  =  3 ;

    private List<Mission> missionList ;

    public MissionAdapter(Context mCtx, List<Mission> missionList) {
        this.mCtx = mCtx;
        this.missionList = missionList;
    }

    @NonNull
    @Override
    public MissionVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_missions , parent , false) ;


        return new MissionVieHolder(view)  ;
    }

    @Override
    public void onBindViewHolder(@NonNull MissionVieHolder holder, int position ) {
        Mission mission  =  missionList.get(position) ;
        holder.textViewDebut.setText(mission.getDebut());
        holder.textViewName.setText(mission.getName_entreprise());
        holder.textViewRemuneration.setText(mission.getRemuneration());
        holder.textViewTitle.setText(mission.getTitle());
        Glide.with(mCtx)
                .load(mission.getLogo())
                .into(holder.logo);
        if (String.valueOf(mission.getStatut()) ==  String.valueOf(attente) )
        {
            holder.textViewStatus.setText("En Attente");
            holder.textViewStatus.setBackgroundResource(R.color.rose_clair);
        }else if (String.valueOf(mission.getStatut()) ==  String.valueOf(refus)){
            holder.textViewStatus.setText(" Refusée  ");
            holder.textViewStatus.setBackgroundResource(R.color.red);
        }



    }
    @Override
    public int getItemCount() {
        return missionList.size();
    }

    class MissionVieHolder  extends  RecyclerView.ViewHolder{
        TextView textViewDebut ,textViewStatus, textViewName , textViewTitle,textViewRemuneration ;
        ImageView logo  ;
        public MissionVieHolder(@NonNull View itemView) {
            super(itemView);
            textViewDebut =  (TextView) itemView.findViewById(R.id.textViewDebut) ;
            textViewName =  (TextView) itemView.findViewById(R.id.textViewName) ;
            textViewTitle =  (TextView) itemView.findViewById(R.id.textViewTitle) ;
            textViewRemuneration =  (TextView) itemView.findViewById(R.id.textViewRemuneration) ;
            textViewStatus =  (TextView) itemView.findViewById(R.id.textViewStatus) ;
            logo  =  (ImageView) itemView.findViewById(R.id.logo);
        }
    }

}
