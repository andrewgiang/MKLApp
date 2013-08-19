package com.majorkiekkoleague.android.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.majorkiekkoleague.android.Constants;
import com.majorkiekkoleague.android.GsonRequest;
import com.majorkiekkoleague.android.R;
import com.majorkiekkoleague.android.activities.DrawerActivity;
import com.majorkiekkoleague.android.mkl.requests.GameQuery;

/**
 * Created by Andrew on 8/19/13.
 */

//TODO Activity?
public class GameFragment extends Fragment {

    private RequestQueue mRequestQueue;

    public static GameFragment getInstance(long game_id) {
        GameFragment fragment = new GameFragment();
        Bundle args = new Bundle();
        args.putLong("game_id", game_id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final DrawerActivity activity = (DrawerActivity) getActivity();
        mRequestQueue = activity.getRequestQueue();
        final View root = inflater.inflate(R.layout.fragment_game, container, false);
        final TextView mGameScore = (TextView) root.findViewById(R.id.game_score);
        final Bundle arguments = getArguments();
        if (arguments != null) {
            final long game_id = arguments.getLong("game_id");
            String url = Constants.MKL.getUrl(Constants.MKL.GAME + game_id);

            final GsonRequest<GameQuery> gameQueryGsonRequest = new GsonRequest<GameQuery>(url, GameQuery.class, null, new Response.Listener<GameQuery>() {
                @Override
                public void onResponse(GameQuery response) {
                    Log.w("RESPONSE_GAME" + game_id, response.toString());
                    final String score = response.game.home_score + " - " + response.game.away_score;
                    mGameScore.setText(score);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            );
            mRequestQueue.add(gameQueryGsonRequest);


        }
        return root;

    }
}
