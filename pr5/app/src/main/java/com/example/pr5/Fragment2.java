package com.example.pr5;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.Objects;

public class Fragment2 extends Fragment {
    private final String TAG = this.getClass().getSimpleName();

    public Fragment2() {
        super(R.layout.fragment_2);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null && !Objects.equals(getArguments().getString("text"), ""))
            Log.i(TAG, getArguments().getString("text"));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        android.view.View rootView = inflater.inflate(R.layout.fragment_2, container, false);

        Button btn1 = rootView.findViewById(R.id.button_2_1);
        Button btn2 = rootView.findViewById(R.id.button_2_3);
        EditText editText = rootView.findViewById(R.id.edit_text2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("text", editText.getText().toString());
                Navigation.findNavController(view).navigate(R.id.fr2_fr1, bundle);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("text", editText.getText().toString());
                Navigation.findNavController(view).navigate(R.id.fr2_fr3, bundle);
            }
        });


        return rootView;
    }
}