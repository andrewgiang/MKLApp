package com.majorkiekkoleague.android.views;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.majorkiekkoleague.android.mkl.things.MklGame;

/**
 * Created by Andrew on 8/18/13.
 */
public class GamesEntryView extends LinearLayout {
    private MklGame mGame;
    private TextView mTitle;
    private TextView mScore;
    private TextView mHomeName, mAwayName, mHomeScore, mAwayScore;

    public GamesEntryView(Context context, MklGame game) {
        super(context);
        this.mGame = game;
        this.setOrientation(VERTICAL);
        mTitle = new TextView(context);
        mScore = new TextView(context);

        mTitle.setText(mGame.home_name + " Vs. " + mGame.away_name);
        mScore.setText(mGame.home_score + " - " + mGame.away_score);


        LinearLayout bottom = new LinearLayout(context);

        LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bottom.addView(mScore, params);


        addView(mTitle, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(bottom, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }
}
