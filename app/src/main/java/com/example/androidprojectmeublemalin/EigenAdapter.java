package com.example.androidprojectmeublemalin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class EigenAdapter extends RecyclerView.Adapter<EigenAdapter.MyViewHolder> {
    Context context;
    ArrayList<Meuble> list;

    public EigenAdapter(Context context, ArrayList<Meuble> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Meuble meuble = list.get(position);
        holder.titel.setText(meuble.getTitel());
        holder.prijs.setText(meuble.getPrijs());
        holder.beschrijving.setText(meuble.getBeschrijving());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static  class  MyViewHolder extends RecyclerView.ViewHolder{
        TextView titel,prijs,beschrijving;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titel = itemView.findViewById(R.id.showtitel);
            prijs = itemView.findViewById(R.id.showprijs);
            beschrijving = itemView.findViewById(R.id.showbeschrijving);

           }
    }
}
