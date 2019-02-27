package com.quannm.tiki_android_home_test.presenter.main;

import android.content.Context;

import com.quannm.tiki_android_home_test.model.Keyword;
import com.quannm.tiki_android_home_test.service.ApiKeywordService;
import com.quannm.tiki_android_home_test.service.repository.IKeywordRepository;

import java.util.ArrayList;

public class MainPresenter implements IMainPresenter {
    private ApiKeywordService keywordService;
    private IKeywordRepository.IGetKeywordCallback keywordCallback;
    private SetOnMainListener listener;

    public MainPresenter(Context mContext) {
        keywordService = new ApiKeywordService(mContext);
        listener = (SetOnMainListener) mContext;
    }


    @Override
    public void subscribeCallbacks() {
        keywordCallback = new IKeywordRepository.IGetKeywordCallback() {
            @Override
            public void onGetKeywordSuccess(ArrayList<String> keywords) {
                listener.onKeywordData(convertToKeywords(keywords));
            }

            @Override
            public void onGetKeywordFail() {
                listener.onKeywordsIsEmpty();
            }

            @Override
            public void onGetKeywordError(String msg) {
                // TODO: 2/27/2019 handle Error
                listener.onKeywordsIsEmpty();
            }
        };
    }

    @Override
    public void unSubscribeCallbacks() {
        keywordCallback = null;
    }

    @Override
    public void getKeywords() {
        keywordService.getKeywords(keywordCallback);
    }


    /**
     * Convert list string to list keyword convert mutilline
     *
     * @param strings
     * @return Arraylist keyword
     */
    private ArrayList<Keyword> convertToKeywords(ArrayList<String> strings) {
        ArrayList<Keyword> result = new ArrayList<>();
        if (strings != null || strings.size() > 0) {
            for (String s : strings) {
//                Keyword keyword = new Keyword(s).mutilLineConverter().randomBackgroundDefinedColor();
                Keyword keyword = new Keyword(s).mutilLineConverter().randomBackgroundArgbColor();
                result.add(keyword);
            }
        }
        return result;
    }

    public interface SetOnMainListener {
        void onKeywordData(ArrayList<Keyword> datas);

        void onKeywordsIsEmpty();
    }
}
