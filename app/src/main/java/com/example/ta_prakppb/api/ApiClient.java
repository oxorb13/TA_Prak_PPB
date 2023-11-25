package com.example.ta_prakppb.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static ApiInterface service;

    public static ApiInterface getService() {

        if (service == null) {
            // Membuat base URL
            // TODO
            //base url diganti dengan IP
            String BASE_URL = "http://192.168.1.27:8080";

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.client(httpClient.build()).build();

            service = retrofit.create(ApiInterface.class);
        }
        return service;
    }
}
