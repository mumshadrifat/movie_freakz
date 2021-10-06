package com.example.movie_freak.Request;

import com.example.movie_freak.MovieApi;
import com.example.movie_freak.credential.Credential;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servicy {
    private static Retrofit.Builder retrofitBuilder=new Retrofit.Builder()
            .baseUrl(Credential.Base__url)
            .addConverterFactory(GsonConverterFactory.create());



    public static  Retrofit retrofit=retrofitBuilder.build();
    public static  MovieApi movie_api=retrofit.create(MovieApi.class);


    public static MovieApi getMovie_api(){
     return  movie_api;
    }



}
