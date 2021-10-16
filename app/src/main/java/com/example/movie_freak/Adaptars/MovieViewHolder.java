package com.example.movie_freak.Adaptars;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_freak.R;

public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
   TextView title,release_date,duration;
   ImageView imageView;
   RatingBar ratingBar;
   //Listener use in recyle
   OnMovieListener onMovieListener;

    public MovieViewHolder(@NonNull View itemView, OnMovieListener onMovieListener) {
        super(itemView);


        title=itemView.findViewById(R.id.title);
        release_date=itemView.findViewById(R.id.movie_category);
        duration=itemView.findViewById(R.id.Movie_duration);
        imageView=itemView.findViewById(R.id.movie_image);
        ratingBar= itemView.findViewById(R.id.rating_bar);
        itemView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

onMovieListener.onMovieCLick(getAbsoluteAdapterPosition());


    }
}
