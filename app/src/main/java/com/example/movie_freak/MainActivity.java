package com.example.movie_freak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.movie_freak.Models.MovieModel;
import com.example.movie_freak.Request.Servicy;
import com.example.movie_freak.Response.MovieResponse;
import com.example.movie_freak.Response.MovieSearch;
import com.example.movie_freak.ViewModel.MovieListViwModel;
import com.example.movie_freak.credential.Credential;
import androidx.lifecycle.ViewModelProvider;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
   Button button;
  //view models:
    MovieListViwModel movieListViwModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        movieListViwModel = new ViewModelProvider(this).get(MovieListViwModel.class);


    }

//observing any data change
    public void AnyDataChange(){
        movieListViwModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                //observing for data change ......



            }
        });
    }



    public void getResponse() {
      MovieApi movieApi= Servicy.getMovie_api();
        Call<MovieSearch> responseCall=movieApi.searchmovies("7b4a111ce758e20da5a946cec677e036","Action",1);
        responseCall.enqueue(new Callback<MovieSearch>() {
            @Override
            public void onResponse(Call<MovieSearch> call, Response<MovieSearch> response) {
                if(response.code()==200){

               //    Log.v("tag","the response"+response.body().toString());



                List<MovieModel>movies=new ArrayList<>(response.body().getMovies());
                for(MovieModel movi:movies){

                  Log.v("tag","title::"+movi.getTitle().toString());
                }

                 }
                else{
                    Log.v("TAG","Error"+ response.errorBody().toString());
                }


            }

            @Override
            public void onFailure(Call<MovieSearch> call, Throwable t) {

            }
        });
    }

    public void getResponse_By_ID(){

        MovieApi movieApi_id=Servicy.getMovie_api();

        Call<MovieModel> movieResponse= movieApi_id.getMOvie(550, Credential.Api_Key);
   movieResponse.enqueue(new Callback<MovieModel>() {
       @Override
       public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

           if(response.code()==200){


               Log.v("single movie","Movie_title::"+response.body().getTitle());
           }
           else{
               Log.v("TAG","Error"+ response.errorBody().toString());
           }


       }

       @Override
       public void onFailure(Call<MovieModel> call, Throwable t) {

       }
   });

   }
}


