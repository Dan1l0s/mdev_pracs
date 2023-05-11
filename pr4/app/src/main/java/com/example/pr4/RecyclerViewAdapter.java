package com.example.pr4;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<ClipData.Item> items;
    private OnItemClickListener onItemClickListener;

    RecyclerViewAdapter(Context context, List<ClipData.Item> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(itemView);
        holder.itemView.setOnClickListener(v -> {
            int position = holder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClicked(position);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        ClipData.Item item = items.get(position);
        holder.textView.setText(item.getText());
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.item_text);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClicked(int position);
    }
}
