package com.pustovit.bindingdemo;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.pustovit.bindingdemo.databinding.ActivityMainBinding;
import com.pustovit.bindingdemo.databinding.ContentMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        clickHandler = new MainActivityClickHandler();
        Student student = getCurrentStudent();
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.setStudent(student);
        activityMainBinding.setClickHandler(clickHandler);

    }

    private Student getCurrentStudent() {
        Student student = new Student();
        student.setStudentName("Alex");
        student.setStudentEmail("alex@gmail.com");
        return student;

    }

    public class MainActivityClickHandler{


        public void onEnrollButtonClick(View view){
            Toast.makeText(MainActivity.this,"Enroll clicked", Toast.LENGTH_SHORT).show();
        }

        public void onCancelButtonClick(View view){
            Toast.makeText(MainActivity.this,"Cancel clicked", Toast.LENGTH_SHORT).show();
        }
    }

}
/*
    <androidx.coordinatorlayout.widget.CoordinatorLayout

        xmlns:bind="http://schemas.android.com/apk/res-auto"
        .
        .
        .


             <include
            layout="@layout/content_main"
            bind:clickHandler="@{clickHandler}"
            bind:student="@{student}" />
            //////////////////////////////////////////////


             <TextView
            android:id="@+id/tvStudentName"
            android:text="@{student.studentName}"



              <Button
            android:id="@+id/button2"
            android:onClick="@{clickHandler::onCancelButtonClick}"

 */
