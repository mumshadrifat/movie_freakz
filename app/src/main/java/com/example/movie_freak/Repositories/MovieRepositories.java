package com.example.movie_freak.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movie_freak.Models.MovieModel;
import com.example.movie_freak.Request.MovieApiClient;

import java.util.List;

public class MovieRepositories {
    private static  MovieRepositories instace;
    private MovieApiClient movieApiClient;

    public static MovieRepositories getInstace() {
        if(instace==null){
            instace=new MovieRepositories();
        }
        return instace;
    }

    public MovieRepositories() {

        movieApiClient=MovieApiClient.getInstance();
    }
    public LiveData<List<MovieModel>> getMovies() {
        return movieApiClient.getMovies();


    }

    public void searchMovieApi(String query,int page_number){
        movieApiClient.searchMoviesApi(query,page_number);

    }
}
