package com.example.pr8;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Text {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo(name = "word")
    private String text;

    public Text(@NonNull String text) {this.text = text;}

    public String getText(){return this.text;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}
}
