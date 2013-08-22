package com.majorkiekkoleague.android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.majorkiekkoleague.android.mkl.things.MklNews;

import java.util.List;

/**
 * Created by Andrew on 8/20/13.
 */
public class NewsAdapter extends BaseAdapter {
    private final List<MklNews> mNewsList;
    private final Context mContext;
    private final LayoutInflater mInflater;

    public NewsAdapter(Context context, List<MklNews> news) {
        this.mContext = context;
        this.mNewsList = news;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mNewsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mNewsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
