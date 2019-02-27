package com.quannm.tiki_android_home_test.service;

import android.content.Context;

import com.quannm.tiki_android_home_test.service.repository.IKeywordRepository;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiKeywordService extends BaseApiService {
    public ApiKeywordService(Context mContext) {
        super(mContext);
    }


    /**
     * Get keywords data from api
     *
     * @param callback
     */
    public void getKeywords(final IKeywordRepository.IGetKeywordCallback callback) {
        iService = getClient().create(IApiService.class);
        Call<ArrayList<String>> call = iService.getKeywords();
        call.enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                if (response.body() instanceof ArrayList)
                    callback.onGetKeywordSuccess(response.body());
                else callback.onGetKeywordFail();
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                callback.onGetKeywordError(t.toString());
            }
        });
    }

}
