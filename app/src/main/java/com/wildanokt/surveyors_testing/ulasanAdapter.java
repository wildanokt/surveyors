package com.wildanokt.surveyors_testing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ulasanAdapter extends RecyclerView.Adapter<ulasanAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ulasan> ulasans;

    // ---------------------------------------------
    public ulasanAdapter(Context context) {
        this.context = context;
    }
    public ArrayList<ulasan> getUlasans() {
        return ulasans;
    }
    public void setUlasans(ArrayList<ulasan> ulasans) {
        this.ulasans = ulasans;
    }
    // ---------------------------------------------

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ulasan,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvNamaUser.setText(getUlasans().get(i).getNama_user());
        viewHolder.rbUlasan.setNumStars(getUlasans().get(i).getRating());
        viewHolder.tvUlasan.setText(getUlasans().get(i).getIsiUlasan());
        Glide.with(context)
                .load(getUlasans().get(i).getUserFotoProfile())
                .apply(new RequestOptions().override(55,55))
                .into(viewHolder.imgUserProfile);
    }

    @Override
    public int getItemCount() {
        return getUlasans().size();
    }

    // ---------------------------------------------
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaUser,tvUlasan;
        RatingBar rbUlasan;
        ImageView imgUserProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaUser = itemView.findViewById(R.id.ulasan_namaUser);
            tvUlasan = itemView.findViewById(R.id.ulasan_isi);
            rbUlasan = itemView.findViewById(R.id.ulasan_rating);
            imgUserProfile = itemView.findViewById(R.id.fotoUser);
        }
    }
}
