package com.pustovit.regstudents.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.pustovit.regstudents.db.enity.Student;

import java.util.List;

/**
 * Created by Pustovit Vladimir on 16.01.2020.
 * vovapust1989@gmail.com
 */

@Dao
public interface StudentsDAO {

    @Query("SELECT * FROM students;")
    List<Student> getAllStudents();

    @Query("SELECT * FROM students WHERE student_id ==:studentId;")
    Student getStudent(long studentId);

    @Insert
    long addNewStudent(Student student);

    @Delete
    void deleteStudent(Student student);


}
