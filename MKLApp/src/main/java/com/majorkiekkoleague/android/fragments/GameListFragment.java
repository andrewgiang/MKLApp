package com.majorkiekkoleague.android.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.majorkiekkoleague.android.activities.DrawerActivity;

/**
 * Created by Andrew on 8/18/13.
 */
public class GameListFragment extends ListFragment {

    public static GameListFragment getInstance(int game_id) {
        GameListFragment gameListFragment = new GameListFragment();
        Bundle args = new Bundle();
        args.putInt("game_id", game_id);
        gameListFragment.setArguments(args);

        return gameListFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final DrawerActivity activity = (DrawerActivity) getActivity();
        final RequestQueue requestQueue = activity.getRequestQueue();

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
