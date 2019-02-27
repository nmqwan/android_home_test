package com.quannm.tiki_android_home_test.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quannm.tiki_android_home_test.R;
import com.quannm.tiki_android_home_test.model.Keyword;

import java.util.ArrayList;

public class KeywordAdapter extends RecyclerView.Adapter<KeywordAdapter.KeywordViewHolder> {
    private ArrayList<Keyword> datas;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private String TAG = KeywordAdapter.class.getSimpleName();


    public KeywordAdapter(ArrayList<Keyword> datas, Context mContext) {
        this.datas = datas;
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public KeywordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mLayoutInflater.inflate(R.layout.row_keyword, viewGroup, false);
        return new KeywordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull KeywordViewHolder keywordHolder, int i) {
        Keyword keyword = datas.get(i);
        keywordHolder.txtRowKeyword.setText(keyword.getText());
//        keywordHolder.cardContainer.setCardBackgroundColor(mContext.getResources().getColor(keyword.getColor()));
        keywordHolder.cardContainer.setCardBackgroundColor(keyword.getColor());
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class KeywordViewHolder extends RecyclerView.ViewHolder {
        TextView txtRowKeyword;
        CardView cardContainer;

        public KeywordViewHolder(View itemView) {
            super(itemView);
            txtRowKeyword = itemView.findViewById(R.id.txtRowKeyword);
            cardContainer = itemView.findViewById(R.id.cardRowKeywordContainer);
        }
    }


}
