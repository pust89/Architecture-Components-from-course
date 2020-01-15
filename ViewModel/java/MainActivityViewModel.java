package com.pustovit.viewmodel;

import androidx.lifecycle.ViewModel;

/**
 * Created by Pustovit Vladimir on 15.01.2020.
 * vovapust1989@gmail.com
 */

public class MainActivityViewModel extends ViewModel {
    private int count;

    public MainActivityViewModel() {
        super();
    }

    public int getInitialCount() {
    return count;
    }

    public int getCurrentCount() {
        return ++count;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
