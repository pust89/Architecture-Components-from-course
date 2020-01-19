package com.pustovit.regstudents.db.enity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Pustovit Vladimir on 16.01.2020.
 * vovapust1989@gmail.com
 */

@Entity(tableName = "students")
public class Student extends BaseObservable {
    private static final DateFormat TIMESTAMP = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    private long _id;

    @ColumnInfo(name = "student_name")
    private String name;

    @ColumnInfo(name = "student_email")
    private String email;

    @ColumnInfo(name = "student_country")
    private String country;

    @ColumnInfo(name = "student_reg_date")
    private long regDate;

    @ColumnInfo(name = "student_reg_date_str")
    private String regDateStr;

    public Student(long _id, String name, String email, String country, long regDate, String regDateStr) {
        this._id = _id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.regDate = regDate;
        this.regDateStr = regDateStr;
    }

    @Ignore
    public Student() {
    }

    @Ignore
    public Student(String name, String email, String country, long regDate) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.regDate = regDate;
        this.regDateStr = TIMESTAMP.format(new Date(regDate));


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

    @Bindable
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
        notifyPropertyChanged(BR.country);

    }

    @Bindable
    public long getRegDate() {
        return regDate;
    }

    public void setRegDate(long regDate) {
        this.regDate = regDate;
        notifyPropertyChanged(BR.regDate);
    }

    @Bindable
    public String getRegDateStr() {
        return regDateStr;
    }

    public void setRegDateStr(String regDateStr) {
        this.regDateStr = regDateStr;
        notifyPropertyChanged(BR.regDateStr);
    }
}
