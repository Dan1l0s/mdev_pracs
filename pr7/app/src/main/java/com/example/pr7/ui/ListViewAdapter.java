package com.example.pr7.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pr7.R;
import com.example.pr7.data.Item;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Item> {
    private LayoutInflater inflater;
    private int layout;
    private List<Item> items;
    public ListViewAdapter(Context context, int resource,
                           List<Item> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        TextView textView = view.findViewById(R.id.item_text);
        Item item = items.get(position);
        textView.setText(item.getName());
        return view;
    }
}