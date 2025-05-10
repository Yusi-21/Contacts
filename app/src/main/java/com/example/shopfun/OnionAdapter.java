package com.example.shopfun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class OnionAdapter extends ArrayAdapter<String> {
    private Context context;
    private String[] item;

    public OnionAdapter(Context context, String[] item) {
        super(context, R.layout.item_content_onion, item);
        this.context = context;
        this.item = item;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_content_onion, parent, false);

        return rowView;
    }
}

