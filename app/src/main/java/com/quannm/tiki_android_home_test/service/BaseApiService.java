package com.quannm.tiki_android_home_test.service;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.quannm.tiki_android_home_test.utils.Config;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

abstract class BaseApiService {
    IApiService iService;
    private Retrofit retrofit;
    private Context mContext;
    private OkHttpClient okHttpClient;

    BaseApiService(Context mContext) {
        this.mContext = mContext;
    }

    Retrofit getClient() {
        Gson gson = new GsonBuilder().create();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        okHttpClient = httpClient.readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS).build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Config.apiUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }

}
