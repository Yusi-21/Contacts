package com.example.shopfun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AnanasAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] items;

    public AnanasAdapter(Context context, String[] items) {
        super(context, R.layout.item_content_ananas, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_content_ananas, parent, false);

        return rowView;
    }
}
