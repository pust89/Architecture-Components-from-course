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
public interface BookDAO {

    @Insert
    void insert(Book book);

    @Update
    void update(Book book);

    @Delete
    void delete(Book book);

    @Query("SELECT * FROM books_table;")
    LiveData<List<Book>> getAllBooks();

    @Query("SELECT * FROM books_table WHERE book_category==:categoryId;")
    LiveData<List<Book>> getBooks(int categoryId);

}
