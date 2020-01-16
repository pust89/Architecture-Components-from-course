package com.pustovit.regstudents.db.enity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.android.material.snackbar.Snackbar;

/**
 * Created by Pustovit Vladimir on 16.01.2020.
 * vovapust1989@gmail.com
 */

@Entity(tableName = "students")
public class Student {

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

    public Student(long _id, String name, String email, String country, long regDate) {
        this._id = _id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.regDate = regDate;
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
    }


    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getRegDate() {
        return regDate;
    }

    public void setRegDate(long regDate) {
        this.regDate = regDate;
    }
}
