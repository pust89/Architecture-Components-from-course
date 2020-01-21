package com.pustovit.bookshop.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by Pustovit Vladimir on 20.01.2020.
 * vovapust1989@gmail.com
 */

@Dao
public interface CategoryDAO {

    @Insert
    void insert(Category category);

    @Update
    void update(Category category);

    @Delete
    void delete(Category category);

    @Query("SELECT * FROM categories_table;")
    LiveData<List<Category>> getAllCategories();
}
