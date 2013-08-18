package com.majorkiekkoleague.android.mkl;

import com.majorkiekkoleague.android.mkl.things.PlayerSeasonStats;

import java.util.ArrayList;

/**
 * Created by Andrew on 8/17/13.
 */
public class SeasonStatQuery {
    public ArrayList<PlayerSeasonStats> stats;

    @Override
    public String toString() {
        return "SeasonStatQuery{" +
                "stats=" + stats +
                '}';
    }
}
