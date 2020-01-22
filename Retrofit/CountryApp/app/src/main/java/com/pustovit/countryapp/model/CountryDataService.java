package com.pustovit.countryapp.model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Pustovit Vladimir on 21.01.2020.
 * vovapust1989@gmail.com
 */

interface CountryDataService {

    @GET("country/get/all")
    Call<Info> getAllCountries();
}
