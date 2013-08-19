package com.majorkiekkoleague.android.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.majorkiekkoleague.android.Constants;
import com.majorkiekkoleague.android.GsonRequest;
import com.majorkiekkoleague.android.R;
import com.majorkiekkoleague.android.StatsAdapter;
import com.majorkiekkoleague.android.activities.DrawerActivity;
import com.majorkiekkoleague.android.mkl.requests.SeasonStatQuery;

import java.util.ArrayList;

/**
 * Created by Andrew on 8/18/13.
 */
public class StatsListFragment extends ListFragment implements AdapterView.OnItemSelectedListener {

    private int currentSeason;
    private Spinner mSeasonSpinner;
    public StatsListFragment() {
    }

    ;

    public static StatsListFragment getInstance(int season) {
        StatsListFragment statsListFragment = new StatsListFragment();
        Bundle args = new Bundle();
        args.putInt("season", season);
        statsListFragment.setArguments(args);

        return statsListFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final DrawerActivity activity = (DrawerActivity) getActivity();
        final RequestQueue requestQueue = activity.getRequestQueue();
        Bundle arguments = this.getArguments();

        final View root = inflater.inflate(R.layout.stats_list, container, false);
        mSeasonSpinner = (Spinner) root.findViewById(R.id.season_spinner);
        ArrayList<String> spinnerArray = new ArrayList<String>();

        populateSpinner(spinnerArray);

        if (arguments != null) {
            currentSeason = arguments.getInt("season");
            final String url = Constants.MKL.getUrl(Constants.MKL.SEASON + currentSeason);

            GsonRequest request = new GsonRequest(url, SeasonStatQuery.class, null, new Response.Listener<SeasonStatQuery>() {
                @Override
                public void onResponse(SeasonStatQuery response) {
                    setListAdapter(new StatsAdapter(getActivity(), response.stats));
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            );
            mSeasonSpinner.setSelection(currentSeason - 1);

            requestQueue.add(request);
        }

        mSeasonSpinner.setOnItemSelectedListener(this);

        return root;
    }

    private void populateSpinner(ArrayList<String> spinnerArray) {
        for (int i = 1; i < 20; i++) {
            spinnerArray.add(Integer.toString(i));
        }
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        mSeasonSpinner.setAdapter(spinnerArrayAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Fragment fragment;
        final String season = (String) mSeasonSpinner.getItemAtPosition(position);
        final int intSsn = Integer.parseInt(season);
        if (intSsn != currentSeason) {
            fragment = getInstance(intSsn);

            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
        mSeasonSpinner.setSelection(position);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
