package com.example.pr7.data;

import java.util.Random;

public class Repository {

    ListUiState listUiState= new ListUiState();
    TextDataSource textDataSource = new TextDataSource();

    public Repository(){}

    public ListUiState getListUiState() {
        return listUiState;
    }

    public void add(Item item){
        listUiState.list.add(item);
    }
    public void clear() {
        listUiState = new ListUiState();
    }
    public Item getFromPosition(int position) {
        return listUiState.list.get(position);
    }

    public String getRandomText() {
        Random rand = new Random();
        return textDataSource.list.get(rand.nextInt(textDataSource.list.size()));
    }

}
