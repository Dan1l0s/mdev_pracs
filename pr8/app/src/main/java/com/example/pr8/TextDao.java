package com.example.pr8;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TextDao {

    @Insert()
    void insert(Text text);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("DELETE FROM word_table WHERE id = :id")
    void deleteById(int id);

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    List<Text> getAlphabetizedWords();
}