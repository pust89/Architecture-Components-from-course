package com.pustovit.twodemo;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.pustovit.twodemo.databinding.ActivityMainBinding;
import com.pustovit.twodemo.databinding.ActivityMainBindingImpl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setContact(new Contact(0,"Ivan", "ivan@yandex.ru"));
    }


}
/*
<EditText
        android:id="@+id/etName"
        android:text="@={contact.email}"
        .
        .
        .
        />


    REBUILD THE PROJECT!
Note: The Data Binding Library generates a class named BR in the module package which contains the
IDs of the resources used for data binding.

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

 */