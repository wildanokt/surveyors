package com.wildanokt.surveyors_testing;

import android.graphics.Color;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class DetailTokoActivity extends AppCompatActivity {
    CarouselView carouselView;

    private int[] img = new int[] {
            R.drawable.toko1,
            R.drawable.toko2,
            R.drawable.toko3,
            R.drawable.toko4
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_toko);

        carouselView = (CarouselView) findViewById(R.id.carousel);
        carouselView.setPageCount(img.length);

        carouselView.setImageListener(imageListener);

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(img[position]);
        }
    };
}
