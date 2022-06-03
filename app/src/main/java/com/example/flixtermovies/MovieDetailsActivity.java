package com.example.flixtermovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flixtermovies.models.Movie;

import org.parceler.Parcels;

public class MovieDetailsActivity extends AppCompatActivity {

    Movie movie;

    TextView detailsTitle;
    TextView detailsOverview;
    RatingBar rbVoteAverage;
    ImageView detailsPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        detailsTitle = (TextView) findViewById(R.id.detailsTitle);
        detailsOverview = (TextView) findViewById(R.id.detailsOverview);
        rbVoteAverage = (RatingBar) findViewById(R.id.rbVoteAverage);
        detailsPoster = (ImageView) findViewById(R.id.detailsPoster);

        Context context = detailsPoster.getContext();

        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s", movie.getTitle()));

        detailsTitle.setText(movie.getTitle());
        detailsOverview.setText(movie.getOverview());
        Glide.with(context).load(movie.getPosterPath()).into(detailsPoster);

        float voteAverage = movie.getVoteAverage().floatValue();
        rbVoteAverage.setRating(voteAverage/2.0f);
    }
}