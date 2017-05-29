package com.example.samanthayao.canvasto;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Samantha Yao on 5/25/2017.
 */

public class GridViewAdapter extends BaseAdapter{
    private Context mContext;
    private int[] mimageIDs;

    public GridViewAdapter(Context c, int[] imageIDs) {
        mContext = c;
        mimageIDs = imageIDs;
    }

    public int getCount() {
        return mimageIDs.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView mImageView;

        if (convertView == null) {
            mImageView = new ImageView(mContext);
            mImageView.setLayoutParams(new GridView.LayoutParams(130, 130));
            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImageView.setPadding(5, 5, 5, 5);
        } else {
            mImageView = (ImageView) convertView;
        }
        mImageView.setImageResource(mimageIDs[position]);
        return mImageView;
    }
}
