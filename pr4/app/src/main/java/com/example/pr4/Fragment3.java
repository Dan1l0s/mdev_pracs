package com.example.pr4;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment3 extends Fragment {
    private final String TAG = this.getClass().getSimpleName();

    public void createToast(String text) {
        Toast toast = Toast.makeText(getContext(), text, Toast.LENGTH_SHORT);
        toast.show();
    }

    public Fragment3() {
        super(R.layout.fragment_3);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        android.view.View rootView = inflater.inflate(R.layout.fragment_3, container, false);

        RecyclerView itemsList = rootView.findViewById(R.id.recycler_view);

        List<ClipData.Item> items = new ArrayList<>();
        for (int i = 1; i < 201; ++i) {
            String text = "TextView №" + i;
            items.add(new ClipData.Item(text));
        }



        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), items);

        itemsList.setAdapter(adapter);

        RecyclerViewAdapter.OnItemClickListener onItemClicked = (position) -> {
            String s = items.get(position).getText().toString();
            Log.i(TAG, s);
            createToast(s);
        };
        adapter.setOnItemClickListener(onItemClicked);

        Button button = rootView.findViewById(R.id.button_back);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container_view_1,
                                Fragment1.class, null)
                        .commit();
            }
        });

        return rootView;
    }
}



