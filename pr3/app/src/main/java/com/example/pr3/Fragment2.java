package com.example.pr3;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class Fragment2 extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    public void createToast(String text) {
        Toast toast = Toast.makeText(getContext(), text, Toast.LENGTH_SHORT);
        toast.show();
    }

    public Fragment2() {
        super(R.layout.fragment_2);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createToast("onCreate");
        Log.i(TAG, "onCreate");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //super.onCreateView(inflater, container, savedInstanceState);
        createToast("onCreateView");
        Log.i(TAG, "onCreateView");

        View rootView = inflater.inflate(R.layout.fragment_2, container, false);

        Button buttonSecondFragment = rootView.findViewById(R.id.button);
        buttonSecondFragment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Bundle result = new Bundle();
                result.putString("Key1", "Message1");
                result.putString("Key2", "Message2");
                getParentFragmentManager().setFragmentResult(
                        "requestKey", result);

                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container_view_1,
                                Fragment1.class, null)
                        .commit();
            }
        });
        return rootView;
    }

    public void onStart() {
        super.onStart();
        createToast("onStart");
        Log.i(TAG, "onStart");
    }

    public void onResume() {
        super.onResume();
        createToast("onResume");
        Log.i(TAG, "onResume");
    }

    public void onPause() {
        super.onPause();
        createToast("onPause");
        Log.i(TAG, "onPause");
    }

    public void onDestroy() {
        super.onDestroy();
        createToast("onDestroy");
        Log.i(TAG, "onDestroy");
    }


}