package com.pustovit.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Pustovit Vladimir on 15.01.2020.
 * vovapust1989@gmail.com
 */

public class MainActivityViewModel extends ViewModel {
    private int count;
    private MutableLiveData<Integer> countLiveData;

    public MainActivityViewModel() {
        super();
    }

    public MutableLiveData<Integer> getInitialCount() {
        if (countLiveData == null) {
            countLiveData = new MutableLiveData<>();
        }
        countLiveData.setValue(count);
        return countLiveData;
    }

    public void getCurrentCount() {
        count += 1;
        countLiveData.setValue(count);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
