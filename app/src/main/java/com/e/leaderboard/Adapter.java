package com.e.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    List<LeaderBoardresult> leaderBoardresultList;
    public Adapter(Context ctx, List<LeaderBoardresult>leaderBoardresultList){
    this.inflater=LayoutInflater.from(ctx);
    this.leaderBoardresultList=leaderBoardresultList;
    };



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutleaderboad,parent,false);
        ViewHolder myviewholder=new ViewHolder(v);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     holder.name.setText(leaderBoardresultList.get(position).getName());
     holder.hours.setText(leaderBoardresultList.get(position).getHours());
        Picasso.get().load(leaderBoardresultList.get(position).getImagecover()).into(holder.imagecover);

    }

    @Override
    public int getItemCount(){   if(leaderBoardresultList!=null&& !leaderBoardresultList.isEmpty()){
        return leaderBoardresultList.size();}else {
        return 0;
    }}


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView  name,hours;
        ImageView imagecover;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.nom);
            hours =itemView.findViewById(R.id.hours);
            imagecover=itemView.findViewById(R.id.coverimage);

        }
    }
}
