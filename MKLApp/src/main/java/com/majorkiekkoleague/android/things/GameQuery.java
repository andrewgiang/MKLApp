package com.majorkiekkoleague.android.things;

import java.util.List;

/**
 * Created by Andrew on 8/17/13.
 */
public class GameQuery {
    public MklGame game;
    public List<GoalData> goal_data;
    public List<PlayerGameStats> home_stats;
    public List<PlayerGameStats> away_stats;


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
