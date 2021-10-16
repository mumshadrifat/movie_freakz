package com.example.movie_freak.Adaptars;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_freak.Models.MovieModel;
import com.example.movie_freak.R;

import java.util.List;

public class MovieRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
 private   List<MovieModel>mMovies;
 private OnMovieListener onMovieListener;



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item,parent,false);
        return new MovieViewHolder(view,onMovieListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MovieViewHolder)holder).title.setText(mMovies.get(position).getTitle());
        ((MovieViewHolder)holder).release_date.setText(mMovies.get(position).getRelease_date());

        ((MovieViewHolder)holder).duration.setText(mMovies.get(position).getRuntime());
       //Using glind library for image
        Glide.with(holder.itemView.getContext())
                .load(mMovies.get(position))
                .into(((MovieViewHolder)holder).imageView);

    }

    @Override
    public int getItemCount() {
    return mMovies.size();
    }


    public  void setmMovies(){
        notifyDataSetChanged();
    }
}
