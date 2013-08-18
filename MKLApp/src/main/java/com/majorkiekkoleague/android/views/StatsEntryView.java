package com.majorkiekkoleague.android.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.majorkiekkoleague.android.things.PlayerSeasonStats;

/**
 * Created by Andrew on 8/18/13.
 */
public class StatsEntryView extends LinearLayout {

    private TextView mName, mTeamName;

    public StatsEntryView(Context context, PlayerSeasonStats seasonStats) {
        super(context);
        this.setOrientation(VERTICAL);
        mName = new TextView(context);
        mTeamName = new TextView(context);

        String name = seasonStats.player_name;
        mName.setText(name);
        mName.setTextSize(19);
        mName.setTextColor(Color.BLACK);
        mName.setTypeface(Typeface.SANS_SERIF);

        String teamName = seasonStats.team_name;
        mTeamName.setText("Team: " + teamName);
        mTeamName.setTextSize(14);
        mTeamName.setTypeface(Typeface.SANS_SERIF);

        addView(mName, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(mTeamName, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
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
