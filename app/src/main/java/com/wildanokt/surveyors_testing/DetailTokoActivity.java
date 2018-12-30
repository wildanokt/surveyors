package com.wildanokt.surveyors_testing;

import android.graphics.Color;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class DetailTokoActivity extends AppCompatActivity {
    CarouselView carouselView;

    //list foto toko
    private int[] img = new int[] {
            R.drawable.toko1,
            R.drawable.toko2,
            R.drawable.toko3,
            R.drawable.toko4
    };

    // ---------------------------------------------

    private RecyclerView rvUlasan;
    private ArrayList<ulasan> list;

    // ---------------------------------------------

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_toko);

        //carousel view
        carouselView = (CarouselView) findViewById(R.id.carousel);
        carouselView.setPageCount(img.length);
        carouselView.setImageListener(imageListener);

        //recycler view
        rvUlasan = findViewById(R.id.rv_ulasan);
        rvUlasan.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(ulasanData.getDataUlasan());
        showUlasanList();
    }

    // ---------------------------------------------

    //carousel view
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(img[position]);
        }
    };

    // ---------------------------------------------

    private void showUlasanList(){
        rvUlasan.setLayoutManager(new LinearLayoutManager(this));
        ulasanAdapter ulasanAdapter = new ulasanAdapter(this);
        ulasanAdapter.setUlasans(list);
        rvUlasan.setAdapter(ulasanAdapter);
    }
}
