package com.example.movie_freak.Response;

import com.example.movie_freak.Models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieSearch {

    @SerializedName("total_results")
    @Expose private int total_result;



    @SerializedName("results")
    @Expose public List<MovieModel>movies;


    public int getTotal_result(){
        return  total_result;
    }

    public  List<MovieModel> getMovies(){
        return movies;
    }


    @Override
    public String toString() {
        return "MovieSearch{" +
                "total_result=" + total_result +
                ", movies=" + movies +
                '}';
    }
}
