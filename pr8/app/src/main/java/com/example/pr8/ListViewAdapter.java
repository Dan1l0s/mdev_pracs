package com.example.pr8;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ClipData.Item> {
    private LayoutInflater inflater;
    private int layout;
    private List<ClipData.Item> items;
    public ListViewAdapter(Context context, int resource,
                           List<ClipData.Item> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        TextView textView = view.findViewById(R.id.item_text);
        ClipData.Item item = items.get(position);
        textView.setText(item.getText());
        return view;
    }
}