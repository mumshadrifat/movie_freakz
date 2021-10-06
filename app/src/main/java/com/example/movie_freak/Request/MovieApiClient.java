package com.example.movie_freak.Request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movie_freak.AppExecutors;
import com.example.movie_freak.Models.MovieModel;
import com.example.movie_freak.MovieApi;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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

    public void searchMovies(){

        final Future myHandler=AppExecutors.getInstance().getNetworkIO().submit(new Runnable() {
            @Override
            public void run() {

            }
        });

        AppExecutors.getInstance().getNetworkIO().schedule(new Runnable() {
            @Override
            public void run() {
                //cancel retrofit for issues such as low memory,crashes etc
            myHandler.cancel(true);
            }
        },500, TimeUnit.MICROSECONDS);
    }

}
