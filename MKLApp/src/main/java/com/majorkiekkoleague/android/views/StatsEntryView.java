package com.majorkiekkoleague.android.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.majorkiekkoleague.android.mkl.things.PlayerSeasonStats;

/**
 * Created by Andrew on 8/18/13.
 */
public class StatsEntryView extends LinearLayout {

    private TextView mName, mTeamName;
    private TextView mPosition, mGP, mGoals, mAssists, mPts;

    public StatsEntryView(Context context, PlayerSeasonStats seasonStats) {
        super(context);
        this.setOrientation(VERTICAL);
        mName = new TextView(context);

        mTeamName = new TextView(context);
        mPosition = new TextView(context);
        mGP = new TextView(context);
        mGoals = new TextView(context);
        mAssists = new TextView(context);
        mPts = new TextView(context);

        String name = seasonStats.player_name;
        mName.setText(name);
        mName.setTextSize(19);
        mName.setTextColor(Color.BLACK);
        mName.setTypeface(Typeface.SANS_SERIF);

        mTeamName.setText(seasonStats.team_name);
        mTeamName.setTextSize(15);
        mTeamName.setTypeface(Typeface.SANS_SERIF);

        mPosition.setText(" Pos:" + seasonStats.position);
        mPosition.setTextSize(9);
        mGP.setText(" GP:" + Integer.toString(seasonStats.games_played));
        mGP.setTextSize(9);
        mAssists.setText(" A:" + Integer.toString(seasonStats.assists));
        mAssists.setTextSize(9);
        mGoals.setText(" G:" + Integer.toString(seasonStats.goals));
        mGoals.setTextSize(9);
        mPts.setText(" P:" + Integer.toString(seasonStats.pts));
        mPts.setTextSize(9);


        LinearLayout bottom = new LinearLayout(context);

        LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bottom.addView(mTeamName, params);
        bottom.addView(mPosition, params);
        bottom.addView(mGP, params);
        bottom.addView(mGoals, params);
        bottom.addView(mAssists, params);
        bottom.addView(mPts, params);


        addView(mName, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(bottom, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }

    public String getNameText() {
        return mName.getText().toString();
    }

    public String getTeamNameText() {
        return mTeamName.getText().toString();
    }

    public void setNameText(String name) {
        mName.setText(name);
    }

    public void setTeamNameText(String number) {
        mTeamName.setText(number);
    }


}
