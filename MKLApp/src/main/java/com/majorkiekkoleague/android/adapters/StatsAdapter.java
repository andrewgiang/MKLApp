package com.majorkiekkoleague.android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.majorkiekkoleague.android.R;
import com.majorkiekkoleague.android.mkl.things.PlayerSeasonStats;
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

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.stat_entry, parent, false);
        }
        TextView rankTv = (TextView) convertView.findViewById(R.id.rank);
        TextView nameTv = (TextView) convertView.findViewById(R.id.player_name);
        TextView positionTv = (TextView) convertView.findViewById(R.id.position);
        TextView gpTv = (TextView) convertView.findViewById(R.id.stat_gp);
        TextView goalsTv = (TextView) convertView.findViewById(R.id.stat_goals);
        TextView assistTv = (TextView) convertView.findViewById(R.id.stat_assists);
        TextView ptsTv = (TextView) convertView.findViewById(R.id.stat_pts);

        rankTv.setText(Integer.toString(position));
        nameTv.setText(stats.player_name);
        positionTv.setText(stats.position);
        gpTv.setText(Integer.toString(stats.games_played));
        goalsTv.setText(Integer.toString(stats.goals));
        assistTv.setText(Integer.toString(stats.assists));
        ptsTv.setText(Integer.toString(stats.pts));
        return convertView;
    }
}
