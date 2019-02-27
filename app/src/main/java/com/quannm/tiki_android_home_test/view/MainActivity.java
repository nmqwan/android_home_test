package com.quannm.tiki_android_home_test.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.quannm.tiki_android_home_test.R;
import com.quannm.tiki_android_home_test.adapter.KeywordAdapter;
import com.quannm.tiki_android_home_test.model.Keyword;
import com.quannm.tiki_android_home_test.presenter.main.MainPresenter;

import java.util.ArrayList;


public class MainActivity extends BaseActivity implements MainPresenter.SetOnMainListener {

    private RecyclerView rvKeywords;
    private LinearLayout lineProgressBar;
    private LinearLayoutManager layoutManager;
    private String TAG = MainActivity.class.getSimpleName();
    private ArrayList<Keyword> keywords;
    private KeywordAdapter adapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        setEvent();
    }

    @Override
    protected void initData() {

        keywords = new ArrayList<>();
        lineProgressBar = findViewById(R.id.lineMainProgress);

        // TODO: 2/27/2019
        presenter = new MainPresenter(MainActivity.this);
        presenter.subscribeCallbacks();
        presenter.getKeywords();

        // TODO: 2/27/2019 setup recyclerview
        rvKeywords = findViewById(R.id.rvKeywords);
        layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        rvKeywords.setLayoutManager(layoutManager);
        rvKeywords.setNestedScrollingEnabled(false);
        adapter = new KeywordAdapter(keywords, MainActivity.this);
        rvKeywords.setAdapter(adapter);
    }

    @Override
    protected void setEvent() {
    }

    @Override
    public void onKeywordData(ArrayList<Keyword> datas) {
        lineProgressBar.setVisibility(View.GONE);
        if (keywords != null) keywords.clear();
        keywords.addAll(datas);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onKeywordsIsEmpty() {
        lineProgressBar.setVisibility(View.GONE);
        // TODO: 2/27/2019 handle empty data
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unSubscribeCallbacks();
    }

}
