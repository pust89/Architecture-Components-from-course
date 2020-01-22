package com.pustovit.countryapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pustovit Vladimir on 21.01.2020.
 * vovapust1989@gmail.com
 */

public class Info implements Parcelable {
    @SerializedName("RestResponse")
    @Expose
    private RestResponse restResponse;
    public final static Parcelable.Creator<Info> CREATOR = new Creator<Info>() {


        public Info createFromParcel(Parcel in) {
            return new Info(in);
        }

        public Info[] newArray(int size) {
            return (new Info[size]);
        }

    };

    protected Info(Parcel in) {
        this.restResponse = ((RestResponse) in.readValue((RestResponse.class.getClassLoader())));
    }

    public Info() {
    }

    public RestResponse getRestResponse() {
        return restResponse;
    }

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(restResponse);
    }

    public int describeContents() {
        return 0;
    }
}
