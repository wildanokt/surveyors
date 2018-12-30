package com.wildanokt.surveyors_testing;

import android.os.Parcel;
import android.os.Parcelable;

public class ulasan implements Parcelable {
    private String nama_user, isiUlasan, userFotoProfile;
    private int rating;

    // ---------------------------------------------
    public String getNama_user() {
        return nama_user;
    }
    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }
    public String getIsiUlasan() {
        return isiUlasan;
    }
    public void setIsiUlasan(String isiUlasan) {
        this.isiUlasan = isiUlasan;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getUserFotoProfile() {
        return userFotoProfile;
    }
    public void setUserFotoProfile(String userFotoProfile) {
        this.userFotoProfile = userFotoProfile;
    }

    // ---------------------------------------------

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama_user);
        dest.writeInt(this.rating);
        dest.writeString(this.isiUlasan);
    }

    // ---------------------------------------------

    public ulasan(){}
    protected ulasan(Parcel i){
        this.nama_user = i.readString();
        this.isiUlasan = i.readString();
        this.rating = i.readInt();
    }

    // ---------------------------------------------

    public static final Parcelable.Creator<ulasan> CREATOR = new Parcelable.Creator<ulasan>() {
        @Override
        public ulasan createFromParcel(Parcel source) {
            return new ulasan(source);
        }

        @Override
        public ulasan[] newArray(int size) {
            return new ulasan[size];
        }
    };

    // ---------------------------------------------
}
