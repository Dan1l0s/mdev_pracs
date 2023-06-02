package com.example.pr7.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pr7.R;
import com.example.pr7.data.Item;

public class MainActivity extends AppCompatActivity {

    public ListViewModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = new ViewModelProvider(this).get(ListViewModel.class);

        model.getUiState().observe(this, uiState -> {
            ListView itemsList = findViewById(R.id.list_view);
            ListAdapter adapter = new ListViewAdapter(this,
                    R.layout.item, model.getUiState().getValue().list);
            itemsList.setAdapter(adapter);
            itemsList.setOnItemClickListener(new
                 AdapterView.OnItemClickListener() {
                     @Override
                     public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                         Item item = model.getFromPosition(position);
                         String desc = item.getDescription();
                         Toast.makeText(getApplicationContext() ,"Description: "+desc, Toast.LENGTH_SHORT).show();
                     }
                 });
        });
        EditText name = findViewById(R.id.name);
        EditText description = findViewById(R.id.description);

        Button b_add = findViewById(R.id.button_add);
        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!name.getText().toString().equals("") && !description.getText().toString().equals(""))
                    model.add(new Item(name.getText().toString(), description.getText().toString()));
                else
                    Toast.makeText(getApplicationContext() ,"Both fields should content data", Toast.LENGTH_SHORT).show();

            }
        });

        Button b_repository = findViewById(R.id.repository);
        b_repository.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext() ,model.getRandomText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}