package com.example.dell.tablayout;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Dell on 12/31/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> movie;
    private Context context;
    private int  rowLayout;
    private static final String IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342/";

    public MovieAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movie = movies;
        this.context = context;
        this.rowLayout = rowLayout;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout movieslayout;
        TextView movietitle;
        TextView moviedescription;
        TextView date;
        TextView rating;
        ImageView movieimage;

        public MovieViewHolder(View itemView) {
            super(itemView);
            movieslayout = itemView.findViewById(R.id.movies_layout);
            movieslayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ProjectDetailActivity.class);
                   intent.putExtra("Title",movietitle.getText().toString());
                   intent.putExtra("Description",moviedescription.getText().toString());
                    context.startActivity(intent);
                }
            });
            movietitle = (TextView) itemView.findViewById(R.id.title);
          moviedescription = (TextView) itemView.findViewById(R.id.description);
            date = (TextView) itemView.findViewById(R.id.date);
//            rating = (TextView) itemView.findViewById(R.id.rating);
            movieimage = (ImageView) itemView.findViewById(R.id.movie_image);
        }
    }

    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        String image_url = IMAGE_URL_BASE_PATH + movie.get(position).getPoster_path();
        Picasso.with(context)
                .load(image_url)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.movieimage);

        holder.movietitle.setText(movie.get(position).getTitle());

        holder.date.setText(movie.get(position).getRelease_date());
       holder.moviedescription.setText(movie.get(position).getOverview());
    }

    @Override
    public int getItemCount() {
        return movie.size();
    }
}
