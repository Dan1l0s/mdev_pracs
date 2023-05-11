package com.example.pr1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    public void createToast(String text) {
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createToast("onCreate");

        Log.e(TAG, "onCreate - Error");
    }

    @Override
    public void onStart() {
        super.onStart();
        createToast("onStart");

        Log.i(TAG, "onStart - Info");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        createToast("onRestart");

        Log.w(TAG, "onRestart - Warning");
    }

    @Override
    public void onResume() {
        super.onResume();
        createToast("onResume");

        Log.v(TAG, "onResume - Verbose");
    }

    @Override
    public void onPause() {
        super.onPause();
        createToast("onPause");

        Log.wtf(TAG, "onResume - WTF");
    }

    @Override
    public void onStop() {
        super.onStop();
        createToast("onStop");

        Log.i(TAG, "onStop - Info");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        createToast("onDestroy");

        Log.i(TAG, "onDestroy - Info");
    }

}
