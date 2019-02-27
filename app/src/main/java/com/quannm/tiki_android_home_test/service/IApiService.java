package com.quannm.tiki_android_home_test.service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IApiService {
    @GET("keywords.json")
    Call<ArrayList<String>> getKeywords();
}
