package com.e.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterSkill extends RecyclerView.Adapter<AdapterSkill.ViewHolder>{
    Context context;
    LayoutInflater inflater;
    List<SkillboardResult> skillboardResultList;
    public AdapterSkill(Context ctx, List<SkillboardResult>skillboardResultList){
        this.inflater=LayoutInflater.from(ctx);
        this.skillboardResultList=skillboardResultList;
    };


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutskill,parent,false);
        ViewHolder myviewholder=new ViewHolder(v);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(skillboardResultList.get(position).getName());
        holder.skillpoints.setText(skillboardResultList.get(position).getSkill());
        Picasso.get().load(skillboardResultList.get(position).getImagecover()).into(holder.imagecover);

    }

    @Override
    public int getItemCount() {
        if(skillboardResultList!=null&& !skillboardResultList.isEmpty()){
            return skillboardResultList.size();}else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView  name,skillpoints;
        ImageView imagecover;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.noms);
            skillpoints =itemView.findViewById(R.id.skillpoint);
            imagecover=itemView.findViewById(R.id.coverimages);

        }
    }
}
