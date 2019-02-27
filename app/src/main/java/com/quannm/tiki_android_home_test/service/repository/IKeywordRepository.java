package com.quannm.tiki_android_home_test.service.repository;


import java.util.ArrayList;

public interface IKeywordRepository {

    interface IGetKeywordCallback {
        void onGetKeywordSuccess(ArrayList<String> keywords);

        void onGetKeywordFail();

        void onGetKeywordError(String msg);
    }
}
