package com.quannm.tiki_android_home_test.model;

import android.graphics.Color;
import android.text.TextUtils;

import com.quannm.tiki_android_home_test.R;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Keyword {
    private String text;
    private int color;

    public Keyword(String text) {
        this.text = text;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Keyword keyword = (Keyword) o;
        return text.equals(keyword.text);
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "text='" + text + '\'' +
                '}';
    }

    /**
     *
     */
    public Keyword mutilLineConverter() {
        StringBuilder textMutilLine = new StringBuilder();
        if (!TextUtils.isEmpty(getText())) {
            String[] keywords = getText().split(" ");
            int midLength = keywords.length / 2;
            if (keywords.length != 1) {
                for (int i = 0; i < keywords.length; i++) {
                    if (i != midLength - 1) textMutilLine.append(keywords[i]).append(" ");
                    else textMutilLine.append(keywords[i]).append("\n");
                }
                setText(textMutilLine.toString().trim());
            }
        }
        return this;
    }

    /**
     * I dont want use this function because it maybe return white color
     * It's same text color
     */
    public Keyword randomBackgroundArgbColor() {
        Random rnd = new Random();
        setColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
        return this;
    }


    /**
     *
     * @return
     */
    public Keyword randomBackgroundDefinedColor() {
        List<Integer> colors = Arrays.asList(R.color.purple, R.color.blue, R.color.green, R.color.darkpurple, R.color.red, R.color.orange, R.color.darkorange, R.color.darkgreen, R.color.darkred);
        setColor(colors.get(new Random().nextInt(colors.size())));
        return this;
    }
}
