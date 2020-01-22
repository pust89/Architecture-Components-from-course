package com.pustovit.countryapp.model;

import com.pustovit.countryapp.model.CountryDataService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pustovit Vladimir on 21.01.2020.
 * vovapust1989@gmail.com
 */

class RetrofitInstance {
    private static Retrofit instance = null;
    private static final String BASE_URL = "http://groupkt.com/";

    static synchronized CountryDataService getDataService() {
        if (instance == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(120, TimeUnit.SECONDS)
                    .readTimeout(120, TimeUnit.SECONDS)
                    .writeTimeout(120, TimeUnit.SECONDS)
                    .build();

            instance = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return instance.create(CountryDataService.class);

    }
}
