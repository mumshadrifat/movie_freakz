package com.example.movie_freak.Request;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movie_freak.AppExecutors;
import com.example.movie_freak.Models.MovieModel;
import com.example.movie_freak.MovieApi;
import com.example.movie_freak.Response.MovieResponse;
import com.example.movie_freak.Response.MovieSearch;
import com.example.movie_freak.credential.Credential;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class MovieApiClient {

    public MutableLiveData<List<MovieModel>> movies;
    private  static MovieApiClient instance;
   private RetriveMovieRunnable retriveMovieRunnable;

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



    public void searchMoviesApi(String query,int pageNumber ){

     if(retriveMovieRunnable!=null){
         retriveMovieRunnable=null;
     }
      retriveMovieRunnable=new RetriveMovieRunnable(query,pageNumber);

        final Future myHandler=AppExecutors.getInstance().getNetworkIO().submit(retriveMovieRunnable);

        AppExecutors.getInstance().getNetworkIO().schedule(new Runnable() {
            @Override
            public void run() {
                //cancel retrofit for issues such as low memory,crashes etc
            myHandler.cancel(true);
            }
        },500, TimeUnit.MICROSECONDS);
    }



     //Retrieveing data from rest api by runnable class
     //two request 1.Movie list Search
       //           2. Single Movie search by id

  private  class RetriveMovieRunnable implements  Runnable{

      private String query;
      private int page_number;
      boolean cancel_request;

      public RetriveMovieRunnable(String query, int page_number) {
          this.query = query;
          this.page_number = page_number;
          cancel_request=false;
      }

      @Override
      public void run() {
          try {
                  //Getting response object
                 Response response = getMovies(query, page_number).execute();


                 if (cancel_request) {
                    return;
                    }
                 if (response.code() == 200) {
                  // List<MovieModel>movies=new ArrayList<>(response.body().getMovies());
                  List<MovieModel> list = new ArrayList<>(((MovieSearch) response.body()).getMovies());


                  //Sending data to live data
                  //Post Value: used for background thread
                  //Set Value:NOt for background
                  if (page_number == 1) {
                      movies.postValue(list);
                  } else {
                      List<MovieModel> currentMovieList = movies.getValue();
                      currentMovieList.addAll(list);
                      movies.postValue(currentMovieList);


                  }

              }
                 else {
                     String error=response.errorBody().string();
                     Log.v("tag","Eror"+error);
                 }


          }


    catch (IOException e) {
        e.printStackTrace();
        movies.postValue(null);
    }


      }



      //Search method query
      private Call<MovieSearch> getMovies(String query, int page_number){
          return Servicy.getMovie_api().searchmovies(
                  Credential.Api_Key,
                  query,
                  page_number    //Note: int  but string taken
          );



      }
    public  void setCancel_request(){

        Log.v("canceling -----","cancel request");
        cancel_request=true;
    }



  }
}

