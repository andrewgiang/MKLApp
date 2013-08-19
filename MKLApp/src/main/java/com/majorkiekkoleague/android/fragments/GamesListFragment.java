package com.majorkiekkoleague.android.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.majorkiekkoleague.android.Constants;
import com.majorkiekkoleague.android.GsonRequest;
import com.majorkiekkoleague.android.R;
import com.majorkiekkoleague.android.activities.DrawerActivity;
import com.majorkiekkoleague.android.adapters.GamesAdapter;
import com.majorkiekkoleague.android.mkl.requests.AllGamesQuery;
import com.majorkiekkoleague.android.mkl.things.MklGame;

/**
 * Created by Andrew on 8/18/13.
 */
public class GamesListFragment extends ListFragment {


    private GamesAdapter listAdapter;
    private RequestQueue mRequestQueue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final DrawerActivity activity = (DrawerActivity) getActivity();
        mRequestQueue = activity.getRequestQueue();


        final String url = Constants.MKL.getUrl(Constants.MKL.GAMES);
        final GsonRequest<AllGamesQuery> response_game = new GsonRequest<AllGamesQuery>(url, AllGamesQuery.class, null, new Response.Listener<AllGamesQuery>() {
            @Override
            public void onResponse(AllGamesQuery response) {
                Log.w("RESPONSE_GAME", response.games.toString());
                listAdapter = new GamesAdapter(getActivity(), response.games);
                setListAdapter(listAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        mRequestQueue.add(response_game);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        final MklGame item = (MklGame) listAdapter.getItem(position);
        final long game_id = item.id;
        Fragment fragment;
        fragment = GameFragment.getInstance(game_id);
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment).commit();

        super.onListItemClick(l, v, position, id);
    }
}
