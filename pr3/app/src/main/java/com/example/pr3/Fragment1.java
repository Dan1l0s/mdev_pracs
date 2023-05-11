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


public class Fragment1 extends Fragment {

    private final String TAG = this.getClass().getSimpleName();
    public void createToast(String text) {
        Toast toast = Toast.makeText(getContext(), text, Toast.LENGTH_SHORT);
        toast.show();
    }

    public Fragment1() {
        super(R.layout.fragment_1);
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createToast("onCreate");
        Log.i(TAG, "onCreate");


        getParentFragmentManager().setFragmentResultListener("requestKey",
                this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey,
                                                 @NonNull Bundle bundle) {
                        Log.v(TAG, bundle.getString("Key1"));
                        Log.v(TAG, bundle.getString("Key2"));
                    }
                });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //super.onCreateView(inflater, container, savedInstanceState);
        createToast("onCreateView");
        Log.i(TAG, "onCreateView");

        View rootView = inflater.inflate(R.layout.fragment_1, container, false);

        Button buttonSecondActivity = rootView.findViewById(R.id.button5);
        buttonSecondActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container_view_1,
                                Fragment2.class, null)
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