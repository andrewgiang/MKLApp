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
import android.widget.Toast;

import com.google.gson.Gson;
import com.majorkiekkoleague.android.NetworkUtils;
import com.majorkiekkoleague.android.R;
import com.majorkiekkoleague.android.StatsAdapter;
import com.majorkiekkoleague.android.mkl.SeasonStatQuery;
import com.majorkiekkoleague.android.mkl.things.PlayerSeasonStats;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/**
 * Created by Andrew on 8/18/13.
 */
public class StatsListFragment extends ListFragment {

    private int currentSeason;
    private Spinner mSeasonSpinner;

    public StatsListFragment() {
    }

    ;

    public static StatsListFragment getInstance(int season) {

        ArrayList<PlayerSeasonStats> stats;
        // update the main content by replacing fragments
        InputStream source = NetworkUtils.retrieveStream("http://www.majorkiekkoleague.com/index.php/api/season/id/" + season);
        Gson gson = new Gson();
        Reader reader = new InputStreamReader(source);
        SeasonStatQuery response = gson.fromJson(reader, SeasonStatQuery.class);
        stats = response.stats;
        StatsListFragment statsListFragment = new StatsListFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("stats", stats);
        args.putInt("season", season);
        statsListFragment.setArguments(args);

        return statsListFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle arguments = this.getArguments();

        final View root = inflater.inflate(R.layout.stats_list, container, false);
        mSeasonSpinner = (Spinner) root.findViewById(R.id.season_spinner);
        ArrayList<String> spinnerArray = new ArrayList<String>();

        for (int i = 1; i < 20; i++) {
            spinnerArray.add(Integer.toString(i));
        }
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        mSeasonSpinner.setAdapter(spinnerArrayAdapter);
        if (arguments != null) {
            ArrayList<PlayerSeasonStats> stats = arguments.getParcelableArrayList("stats");
            currentSeason = arguments.getInt("season");
            mSeasonSpinner.setSelection(currentSeason - 1);
            this.setListAdapter(new StatsAdapter(getActivity(), stats));
        }

        mSeasonSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment;
                final String season = (String) mSeasonSpinner.getItemAtPosition(position);
                final int intSsn = Integer.parseInt(season);
                if (intSsn != currentSeason) {
                    Toast.makeText(getActivity(), season, Toast.LENGTH_SHORT).show();

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
        });

        return root;
    }


}
