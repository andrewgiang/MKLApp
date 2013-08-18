package com.majorkiekkoleague.android.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.majorkiekkoleague.android.StatsAdapter;
import com.majorkiekkoleague.android.things.PlayerSeasonStats;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 8/18/13.
 */
public class StatsListFragment extends ListFragment {

    public StatsListFragment(){};
    public static StatsListFragment getInstance(ArrayList<PlayerSeasonStats> statsList){

        StatsListFragment statsListFragment = new StatsListFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("stats", statsList);
        statsListFragment.setArguments(args);
        return statsListFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle arguments = this.getArguments();
        if(arguments!=null){
            ArrayList<PlayerSeasonStats> stats = arguments.getParcelableArrayList("stats");
            this.setListAdapter(new StatsAdapter(getActivity(), stats));
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
