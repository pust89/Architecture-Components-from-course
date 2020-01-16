package com.pustovit.regstudents.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.pustovit.regstudents.db.enity.Student;

/**
 * Created by Pustovit Vladimir on 16.01.2020.
 * vovapust1989@gmail.com
 */
@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public final static String DATABASE_NAME = "students_db";

    public abstract StudentsDAO getStudentsDAO();


}
