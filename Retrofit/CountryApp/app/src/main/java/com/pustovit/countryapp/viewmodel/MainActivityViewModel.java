package com.pustovit.countryapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.pustovit.countryapp.model.AppRepository;
import com.pustovit.countryapp.model.Result;

import java.util.List;

/**
 * Created by Pustovit Vladimir on 21.01.2020.
 * vovapust1989@gmail.com
 */

public class MainActivityViewModel extends ViewModel {
    private AppRepository repository;

    public MainActivityViewModel() {
        repository = new AppRepository();
    }

    public LiveData<List<Result>> getAllCountries(){
        return repository.getAllCountries();
    }
}
