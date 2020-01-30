package com.example.recyclerviewretrofit.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private static Retrofit retrofit;
    private static GithubClient client;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static GithubClient getClient() {
        if (client == null) {
            client = getRetrofitInstance().create(GithubClient.class);
        }
        return client;
    }
}
