package com.example.pr8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import android.Manifest;
import android.content.ClipData;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    private final int PERMISSION_REQUEST_CODE = 101;

    private TextRoomDatabase db;
    private TextDao textDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFileAppSpecificStorage();

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            requestPermissions();
        } else {
            createFileExternalStorage();
        }

        createSharedPreferences();

        db = Room.databaseBuilder(getApplicationContext(),
                TextRoomDatabase.class, "database-name").allowMainThreadQueries().build();
        textDao = db.textDao();

        Button b_add = findViewById(R.id.button_add);
        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_word();
            }
        });

        createListView();

    }

    private void createListView() {
        ListView itemsList = findViewById(R.id.list_view);

        List<ClipData.Item> items = new ArrayList<>();
        List<Text> words = textDao.getAlphabetizedWords();
        for (Text elem : words) {
            items.add(new ClipData.Item(elem.getText()));
        }

        ListAdapter adapter = new ListViewAdapter(this,
                R.layout.item, items);

        itemsList.setAdapter(adapter);

        itemsList.setOnItemClickListener(new
             AdapterView.OnItemClickListener() {
                 @Override
                 public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                     List<Text> words = textDao.getAlphabetizedWords();
                     int wordId = words.get(position).getId();
                     textDao.deleteById(wordId);
                     createListView();
                 }
             });
    }

    private void add_word() {
        EditText edit = findViewById(R.id.edit);
        String s = edit.getText().toString();
        if (!s.equals("")) {
            textDao.insert(new Text(s));
            edit.setText("");
        }
        createListView();
    }

    private void createFileAppSpecificStorage() {
        File dir = this.getFilesDir();
        File file = new File(dir, "some_data.txt");
        try {
            FileWriter writer = new FileWriter(file);
            writer.append("data");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String elem : this.fileList()) {
            Log.i(TAG, "app-specific storage: " + elem);
        }
    }

    private void createFileExternalStorage() {
        File dir = this.getExternalFilesDir(null);
        File file = new File(dir, "some_data.txt");
        try {
            FileWriter writer = new FileWriter(file);
            writer.append("data");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (File elem : Objects.requireNonNull(dir.listFiles())) {
            Log.i(TAG, "external storage: " + elem.getName());
        }
    }

    private void createSharedPreferences() {
        SharedPreferences sharedPref =
                this.getPreferences(MODE_PRIVATE);

        int default_value = 100;
        String key = "key_int";

        int value = sharedPref.getInt(key, default_value);
        Log.i(TAG, "sharedPref: " + value);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, 777);
        editor.apply();

        value = sharedPref.getInt(key, default_value);
        Log.i(TAG, "sharedPref: " + value);

        editor.remove(key);
        editor.apply();

        value = sharedPref.getInt(key, default_value);
        Log.i(TAG, "sharedPref: " + value);

    }

    public void requestPermissions() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                PERMISSION_REQUEST_CODE);
    }
}