package com.majorkiekkoleague.android.mkl.requests;

import com.majorkiekkoleague.android.mkl.things.MklGame;

import java.util.List;

/**
 * Created by Andrew on 8/18/13.
 */
public class AllGamesQuery {
    public List<MklGame> games;

    @Override
    public String toString() {
        return "AllGamesQuery{" +
                "games=" + games +
                '}';
    }
}
