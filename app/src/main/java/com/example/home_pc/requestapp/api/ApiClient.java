package com.example.home_pc.requestapp.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

   public static Api getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        RxJavaCallAdapterFactory callAdapterFactory = RxJavaCallAdapterFactory.create();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://gorest.co.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(callAdapterFactory)
                .client(client)
                .build();

        return retrofit.create(Api.class);
    }

}
