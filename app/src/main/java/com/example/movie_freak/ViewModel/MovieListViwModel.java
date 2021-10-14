package com.example.movie_freak.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.movie_freak.Models.MovieModel;
import com.example.movie_freak.Repositories.MovieRepositories;

import java.lang.invoke.MutableCallSite;
import java.util.List;



public class MovieListViwModel extends ViewModel {

//liva data

  private MovieRepositories movieRepositorie;



    public MovieListViwModel() {

        movieRepositorie=MovieRepositories.getInstace();

    }

    public LiveData<List<MovieModel>> getMovies(){
        return  movieRepositorie.getMovies();
    }


    public  void searchMovieApi(String query,int page_number){
         movieRepositorie.searchMovieApi(query,page_number);

    }




}
