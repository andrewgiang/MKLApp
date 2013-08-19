package com.majorkiekkoleague.android.mkl.requests;

import com.majorkiekkoleague.android.mkl.things.MklGame;
import com.majorkiekkoleague.android.mkl.things.MklGameStats;
import com.majorkiekkoleague.android.mkl.things.MklGoal;

import java.util.List;

/**
 * Created by Andrew on 8/17/13.
 */
public class GameQuery {
    public MklGame game;
    public List<MklGoal> goal_data;
    public List<MklGameStats> home_stats;
    public List<MklGameStats> away_stats;


    @Override
    public String toString() {
        return "GameQuery{" +
                "game=" + game.toString() +
                ", goal_data=" + goal_data.toString() +
                ", home_stats=" + home_stats.toString() +
                ", away_stats=" + away_stats.toString() +
                '}';
    }
}
