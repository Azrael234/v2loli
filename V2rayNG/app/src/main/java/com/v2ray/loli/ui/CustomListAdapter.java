package com.v2ray.loli.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.v2ray.loli.R;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] mItems;
    private View rowView;
    private LayoutInflater inflater;
    private int selectPosition;

    public CustomListAdapter(Context context, String[] items) {
        super(context, R.layout.custom_listview_layout, items);
        this.context = context;
        this.mItems = items;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View view, ViewGroup parent) {
        rowView = inflater.inflate(R.layout.custom_listview_layout, null, true);
        TextView textView = rowView.findViewById(R.id.text_item);

        textView.setText(mItems[position]);

        if (selectPosition == position) {
            rowView.setBackgroundResource(R.color.background_color);
        } else {
            rowView.setBackgroundColor(0);
        }

        return rowView;
    }

    public void setSelect(int position) {
        selectPosition = position;
    }
}