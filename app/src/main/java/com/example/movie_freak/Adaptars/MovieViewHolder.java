package com.example.movie_freak.Adaptars;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
   TextView title,category,duration;
   ImageView imageView;
   RatingBar ratingBar;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);


        title=itemView.findViewById(R.id.movie);

    }

    @Override
    public void onClick(View v) {

    }
}
