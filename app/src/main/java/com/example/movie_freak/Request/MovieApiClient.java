package com.example.movie_freak.Request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movie_freak.Models.MovieModel;
import com.example.movie_freak.MovieApi;

import java.util.List;

public class MovieApiClient {

    public MutableLiveData<List<MovieModel>> movies;
    private  static MovieApiClient instance;

    public static MovieApiClient getInstance() {
        if(instance==null){
            instance=new MovieApiClient();
        }

        return instance;
    }


    public MovieApiClient() {
        movies=new MutableLiveData<>();

    }
    public LiveData<List<MovieModel>>getMovies(){
        return  movies;
    }
}
