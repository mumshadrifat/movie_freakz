package com.example.movie_freak.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements  Parcelable  {
    public  String title;
    public  int id;
    public  String poster_path;
    public  String release_date;
    public  float vote_average;
    public  String overview;



    public MovieModel(String title, int id, String poster_path, String release_date, float vote_average, String overview) {
        this.title = title;
        this.id = id;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.vote_average = vote_average;
        this.overview = overview;
    }

    protected MovieModel(Parcel in) {
        title = in.readString();
        id = in.readInt();
        poster_path = in.readString();
        release_date = in.readString();
        vote_average = in.readFloat();
        overview = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public float getVote_average() {
        return vote_average;
    }

    public String getOverview() {
        return overview;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(id);
        dest.writeString(poster_path);
        dest.writeString(release_date);
        dest.writeFloat(vote_average);
        dest.writeString(overview);
    }
}



