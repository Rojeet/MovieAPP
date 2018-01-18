package com.example.dell.tablayout;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Dell on 12/31/2017.
 */

public interface MovieService {
    @GET("3/movie/popular?api_key=d2614298ae33cbc7614bb8eee370a897&page=1")
    Call<MovieResponse> getpopularmovies(@Query("api_key") String apikey);

    @GET("3/movie/top_rated?api_key=d2614298ae33cbc7614bb8eee370a897&page=1")
    Call<MovieResponse> gettopratedmovies(@Query("api_key") String apikey);

    @GET("3/movie/upcoming?api_key=d2614298ae33cbc7614bb8eee370a897&page=1")
    Call<MovieResponse> getupcomingmovies(@Query("api_key") String apikey);
}
