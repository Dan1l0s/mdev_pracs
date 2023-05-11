package com.example.pr2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);

        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("Hello").toString();

        ImageView image = findViewById(R.id.imageView3);
        image.setImageResource(R.drawable.anime_sky);



        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(0, getIntent());
                finish();
            }
        });

    }


}