package com.example.dell.tablayout;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit =null;
    private final static String API_KEY = "d2614298ae33cbc7614bb8eee370a897";
    private RecyclerView recyclerView = null;
    //public MovieAdapter movieAdapter;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
//    private LinearLayout movies_layout;
    ViewPagerAdapter viewPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager)findViewById(R.id.container);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
       viewPagerAdapter.addFragments(new Tab1(),"popular");
        viewPagerAdapter.addFragments(new Tab2(), "Top Rated");
        viewPagerAdapter.addFragments(new Tab3(), "Upcoming");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

//        movies_layout = (LinearLayout)findViewById(R.id.movies_layout);
//        movies_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, ProjectDetailActivity.class);
//                startActivity(intent);
//            }
//        });



//        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        connectAndGetApiData();
    }
//
//    public void connectAndGetApiData() {
//
//        if (retrofit == null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//
//        }
//        final MovieService movieApiService = retrofit.create(MovieService.class);
//        Call<MovieResponse> call = movieApiService.getpopularmovies(API_KEY);
//        call.enqueue(new Callback<MovieResponse>() {
//
//            @Override
//            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                List<Movie> movies = response.body().getResults();
//                Log.d(TAG, "Number of movies received: " + movies.size());
//                movieAdapter = new MovieAdapter(movies, R.layout.fragment_main, getApplicationContext());
//                recyclerView.setAdapter(movieAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<MovieResponse> call, Throwable t) {
//                Log.e(TAG, t.toString());
//            }
//        });
//    }
}

