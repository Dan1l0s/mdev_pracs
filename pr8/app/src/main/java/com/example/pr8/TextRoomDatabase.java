package com.example.pr8;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Text.class}, version = 1)
public abstract class TextRoomDatabase extends RoomDatabase {
    public abstract TextDao textDao();
}