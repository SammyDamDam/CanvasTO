package com.example.samanthayao.canvasto;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Samantha Yao on 6/2/2017.
 */

public class CustomList extends ArrayAdapter<String> {

    private String[] orgTypes;

    private Activity context;

    public CustomList(Activity context, String[] orgTypes) {
        super(context, R.layout.calendar_layout, orgTypes);
        this.context = context;
        this.orgTypes = orgTypes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.calendar_layout, null, true);
        TextView morgType = (TextView) listViewItem.findViewById(R.id.orgTypeText);
        TextView mstartDate = (TextView) listViewItem.findViewById(R.id.startDateText);
        TextView morgAddress = (TextView) listViewItem.findViewById(R.id.orgAddressText);
        TextView mendDate = (TextView) listViewItem.findViewById(R.id.endDateText);
        TextView meventWebsite = (TextView) listViewItem.findViewById(R.id.eventWebsiteText);
        TextView mdescription = (TextView) listViewItem.findViewById(R.id.descriptionText);
        TextView meventNameText = (TextView) listViewItem.findViewById(R.id.eventNameText);

        morgType.setText(orgTypes[position]);

        return listViewItem;
    }
}
