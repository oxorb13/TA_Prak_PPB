package com.example.ta_prakppb.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api/products/hg")
    Call<ListGundamResponse> getListHg();

    @GET("api/products/rg")
    Call<ListGundamResponse> getListRg();

    @GET("api/products/pg")
    Call<ListGundamResponse> getListPg();

    @GET("api/products/mg")
    Call<ListGundamResponse> getListMg();

    @GET("api/film")
    Call<ListMovieResponse> getListMovie();
}
