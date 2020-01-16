package com.pustovit.regstudents.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.pustovit.regstudents.R;
import com.pustovit.regstudents.db.enity.Student;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by Pustovit Vladimir on 16.01.2020.
 * vovapust1989@gmail.com
 */

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentVH> {
    private List<Student> students;

    // Создаем Шаблон вывода Даты
    DateFormat TIMESTAMP = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public StudentsAdapter(List<Student> students) {
        this.students = students;

    }

    @NonNull
    @Override
    public StudentVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new StudentVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentVH holder, int position) {
       Student student = students.get(position);
       holder.tvName.setText(student.getName());
       holder.tvEmail.setText(student.getEmail());
       holder.tvCountry.setText(student.getCountry());
       holder.tvDate.setText(TIMESTAMP.format(new Date(student.getRegDate())));

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentVH extends RecyclerView.ViewHolder {
        final TextView tvName;
        final TextView tvEmail;
        final TextView tvCountry;
        final TextView tvDate;

        public StudentVH(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvCountry = itemView.findViewById(R.id.tvCountry);
            tvDate = itemView.findViewById(R.id.tvDate);
        }

        void deleteStudent(int position){

        }
    }
}
