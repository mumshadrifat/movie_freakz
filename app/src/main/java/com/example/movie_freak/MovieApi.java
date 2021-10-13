package com.example.movie_freak;

import com.example.movie_freak.Models.MovieModel;
import com.example.movie_freak.Response.MovieSearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {


    @GET("search/movie")
    Call<MovieSearch> searchmovies(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") int page

    );
    @GET("movie/{movie_id}?")
    Call<MovieModel> getMOvie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String key
    );
}
