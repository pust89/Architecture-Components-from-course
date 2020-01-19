package com.pustovit.regstudents;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.pustovit.regstudents.adapter.StudentsAdapter;

import com.pustovit.regstudents.databinding.ActivityMainBinding;
import com.pustovit.regstudents.db.AppDatabase;
import com.pustovit.regstudents.db.enity.Student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import android.text.TextUtils;
import android.view.LayoutInflater;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Student> studentsList;
    private RecyclerView recyclerView;
    private StudentsAdapter studentsAdapter;
    private AppDatabase database;

    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        studentsList = new ArrayList<>();

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setFabClickHandler(new FABClickHandler());



        recyclerView = activityMainBinding.layoutContentMain.rvStudents;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        studentsAdapter = new StudentsAdapter(studentsList);
        recyclerView.setAdapter(studentsAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

                Student studentToDelete = studentsList.get(viewHolder.getAdapterPosition());
                deleteStudent(studentToDelete);


            }
        }).attachToRecyclerView(recyclerView);

        RoomDatabase.Callback callback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                Calendar calendar = new GregorianCalendar(2007, 11, 28);

                addNewStudent(new Student("Ivan1", "ivan@ivan.ru", "Russia", calendar.getTimeInMillis()));
                addNewStudent(new Student("Ivan2", "ivan@ivan.ru", "Russia", calendar.getTimeInMillis()));
                addNewStudent(new Student("Ivan3", "ivan@ivan.ru", "Russia", calendar.getTimeInMillis()));
                addNewStudent(new Student("Ivan4", "ivan@ivan.ru", "Russia", calendar.getTimeInMillis()));
                addNewStudent(new Student("Ivan5", "ivan@ivan.ru", "Russia", calendar.getTimeInMillis()));
                addNewStudent(new Student("Ivan6", "ivan@ivan.ru", "Russia", calendar.getTimeInMillis()));
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };

        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME)
                .addCallback(callback)
                .build();

        loadData();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAddNewStudentDialog();
            }
        });
    }

    public class FABClickHandler{

        public void clickOnFAB(View view){
            createAddNewStudentDialog();
        }
    }

    private void createAddNewStudentDialog() {
        @SuppressLint("InflateParams") final View view = LayoutInflater.from(this).inflate(R.layout.add_new_student, null);
        final EditText etName = view.findViewById(R.id.etName);
        final EditText etEmail = view.findViewById(R.id.etEmail);
        final EditText etCountry = view.findViewById(R.id.etCountry);



        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(view)
                .setCancelable(false)
                .setPositiveButton("Save", null)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


        AlertDialog addNewStudentDialog = alertDialogBuilder.create();
        addNewStudentDialog.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(final DialogInterface dialog) {
                Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = etName.getText().toString();
                        String email = etEmail.getText().toString();
                        String country = etCountry.getText().toString();

                        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(country)) {
                            Snackbar.make(view, "Fill in all the fields", Snackbar.LENGTH_LONG).show();
                        } else {


                            Student student = new Student(name, email, country, new Date().getTime());
                            addNewStudent(student);

                            dialog.dismiss();
                        }
                    }
                });


            }
        });
        addNewStudentDialog.show();
    }

    private void loadData() {
        new GetStudentsAsync().execute();
    }

    private void addNewStudent(Student student) {
        new AddStudentAsync().execute(student);
    }

    private void deleteStudent(Student student) {
        new DeleteStudentAsync().execute(student);
    }

    @SuppressLint("StaticFieldLeak")
    private class GetStudentsAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            studentsList.addAll(database.getStudentsDAO().getAllStudents());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            studentsAdapter.notifyDataSetChanged();
        }

    }


    @SuppressLint("StaticFieldLeak")
    private class AddStudentAsync extends AsyncTask<Student, Void, Void> {

        @Override
        protected Void doInBackground(Student... students) {
            long id = database.getStudentsDAO().addNewStudent(students[0]);
            Student student = database.getStudentsDAO().getStudent(id);

            if (student != null) {
                studentsList.add(0, student);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            studentsAdapter.notifyDataSetChanged();
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class DeleteStudentAsync extends AsyncTask<Student, Void, Void> {

        @Override
        protected Void doInBackground(Student... students) {
            database.getStudentsDAO().deleteStudent(students[0]);
            studentsList.remove(students[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            studentsAdapter.notifyDataSetChanged();
        }
    }
}
