package com.majorkiekkoleague.android.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.majorkiekkoleague.android.mkl.things.MklGame;
import com.majorkiekkoleague.android.views.GamesEntryView;

import java.util.List;

/**
 * Created by Andrew on 8/18/13.
 */
public class GamesAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<MklGame> mGames;

    public GamesAdapter(Context context, List<MklGame> games) {
        this.mContext = context;
        this.mGames = games;

    }

    @Override
    public int getCount() {
        return mGames.size();
    }

    @Override
    public Object getItem(int position) {
        return mGames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final MklGame mklGame = mGames.get(position);
        return new GamesEntryView(mContext, mklGame);
    }
}
