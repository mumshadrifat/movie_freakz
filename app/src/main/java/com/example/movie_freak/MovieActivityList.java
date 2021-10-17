package com.example.movie_freak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.Adapter;

import com.example.movie_freak.Adaptars.MovieRecyclerView;
import com.example.movie_freak.Adaptars.OnMovieListener;
import com.example.movie_freak.Models.MovieModel;
import com.example.movie_freak.Request.Servicy;
import com.example.movie_freak.Response.MovieSearch;
import com.example.movie_freak.ViewModel.MovieListViwModel;
import com.example.movie_freak.credential.Credential;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieActivityList extends AppCompatActivity {
   RecyclerView recyclerView;
  //view models:
    MovieListViwModel movieListViwModel;
    MovieRecyclerView movieRecyclerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        movieListViwModel = new ViewModelProvider(this).get(MovieListViwModel.class);

        configurationMovieRecylerView();

     /*   button.setOnClickListener(v -> {

            Log.v("tag ","button clicked");
            searchMovieApi("jack Racher",1);
        });*/
     //  Log.v("tag ","any data change");



        AnyDataChange();
        searchMovieApi("fast",1);

    }

    private void configurationMovieRecylerView() {

        movieRecyclerAdapter=new MovieRecyclerView();
        recyclerView.setAdapter(movieRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    //observing any data change
    public void AnyDataChange(){
        movieListViwModel.getMovies().observe(this, movieModels -> {
            //observing for data change ......
            if(movieModels != null){
              for(  MovieModel movieModel:movieModels){
                  Log.v("tag","Title names::"+movieModel.getTitle());



                  movieRecyclerAdapter.setmMovies(movieModels);
              }
            }



        });
    }



    public void getResponse() {
      MovieApi movieApi= Servicy.getMovie_api();
        Call<MovieSearch> responseCall=movieApi.searchmovies("7b4a111ce758e20da5a946cec677e036","Action",1);
        responseCall.enqueue(new Callback<MovieSearch>() {
            @Override
            public void onResponse(@NonNull Call<MovieSearch> call, @NonNull Response<MovieSearch> response) {
                if(response.code()==200){

               //    Log.v("tag","the response"+response.body().toString());


                    assert response.body() != null;
                    List<MovieModel>movies=new ArrayList<>(response.body().getMovies());
                for(MovieModel movi:movies){

                  Log.v("tag","title::"+movi.getTitle().toString());
                }

                 }
                else{
                    assert response.errorBody() != null;
                    Log.v("TAG","Error"+ response.errorBody().toString());
                }


            }

            @Override
            public void onFailure(@NonNull Call<MovieSearch> call, @NonNull Throwable t) {

            }
        });
    }

    public void getResponse_By_ID(){

        MovieApi movieApi_id=Servicy.getMovie_api();

        Call<MovieModel> movieResponse= movieApi_id.getMOvie(550, Credential.Api_Key);
   movieResponse.enqueue(new Callback<MovieModel>() {
       @Override
       public void onResponse(@NonNull Call<MovieModel> call, @NonNull Response<MovieModel> response) {

           if(response.code()==200){


               assert response.body() != null;
               Log.v("single movie","Movie_title::"+response.body().getTitle());
           }
           else{
               assert response.errorBody() != null;
               Log.v("TAG","Error"+ response.errorBody().toString());
           }


       }

       @Override
       public void onFailure(@NonNull Call<MovieModel> call, @NonNull Throwable t) {

       }
   });

   }




   //calling method in main acivity or ui .....MVVM
    public  void searchMovieApi(String query,int page_number){
  movieListViwModel.searchMovieApi(query,page_number);
    }
}


