package com.example.pr7.data;

import com.example.pr7.data.Item;

import java.util.ArrayList;

public class ListUiState {
    public ArrayList<Item> list;

    public ListUiState() {
        list = new ArrayList<Item>(0);
    }

    public ListUiState (ArrayList<Item> list) {
        this.list = list;
    }
}

