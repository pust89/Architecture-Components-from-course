package com.pustovit.countryapp.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Pustovit Vladimir on 21.01.2020.
 * vovapust1989@gmail.com
 */

public class AppRepository {
    private CountryDataService countryDataService;
    private MutableLiveData<List<Result>> mutableLiveData;

    public AppRepository() {
        this.countryDataService = RetrofitInstance.getDataService();
        mutableLiveData = new MutableLiveData<>();
    }

    public LiveData<List<Result>> getAllCountries() {
        countryDataService.getAllCountries().enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                Info info = response.body();
                if (info != null) {
                    mutableLiveData.postValue(info.getRestResponse().getResult());
                }
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }


}
