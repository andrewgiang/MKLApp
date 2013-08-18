package com.majorkiekkoleague.android;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.majorkiekkoleague.android.things.PlayerSeasonStats;
import com.majorkiekkoleague.android.views.StatsEntryView;

import java.util.ArrayList;

/**
 * Created by Andrew on 8/18/13.
 */
public class StatsAdapter extends BaseAdapter {
    private Context mContext;
    private final ArrayList<PlayerSeasonStats> mPlayerStats;

    public StatsAdapter(Context context, ArrayList<PlayerSeasonStats> stats) {
        this.mContext = context;
        this.mPlayerStats = stats;
    }

    @Override
    public int getCount() {
        return mPlayerStats.size();
    }

    @Override
    public Object getItem(int position) {
        return mPlayerStats.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StatsEntryView statsEntryView;
        PlayerSeasonStats stats = mPlayerStats.get(position);
  /*      if(convertView == null){
            ;
        }else{
            statsEntryView = (StatsEntryView) convertView;
            String name = stats.player_name;
            statsEntryView.setNameText(name);
            String teamName = stats.team_name;
            if (teamName != null) {
                statsEntryView.setTeamNameText(teamName);
            }
        }*/
        return new StatsEntryView(mContext, stats);
    }
}
