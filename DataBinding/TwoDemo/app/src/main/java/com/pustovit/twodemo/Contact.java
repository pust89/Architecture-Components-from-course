package com.pustovit.twodemo;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

/**
 * Created by Pustovit Vladimir on 17.01.2020.
 * vovapust1989@gmail.com
 */

public class Contact extends BaseObservable {
    private long _id;
    private String name;
    private String email;

    public Contact(long _id, String name, String email) {
        this._id = _id;
        this.name = name;
        this.email = email;
    }

    @Bindable
    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
        notifyPropertyChanged(BR._id);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
       notifyPropertyChanged(BR.email);
    }
}
