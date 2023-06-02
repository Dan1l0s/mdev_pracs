package com.example.pr7.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pr7.data.Item;
import com.example.pr7.data.ListUiState;
import com.example.pr7.data.Repository;

public class ListViewModel extends ViewModel {
    private Repository repository = new Repository();

    private  final MutableLiveData<ListUiState> uiState =
            new MutableLiveData(repository.getListUiState());

    public LiveData<ListUiState> getUiState() {
        return  uiState;
    }

    public void add(Item item){
        repository.add(item);
        uiState.setValue(repository.getListUiState());
    }
    public Item getFromPosition(int position) {
        return repository.getFromPosition(position);
    }

    public String getRandomText() {
        return repository.getRandomText();
    }
}

