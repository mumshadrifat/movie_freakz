package com.example.movie_freak.Response;

import com.example.movie_freak.Models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResponse {

    //requesting for single movie
 @SerializedName("results")
    @Expose private MovieModel movie;




 public MovieModel getMovie(){

     return movie;
 }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movie=" + movie +
                '}';
    }
}
