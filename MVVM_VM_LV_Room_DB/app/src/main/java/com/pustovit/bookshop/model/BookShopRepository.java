package com.pustovit.bookshop.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Pustovit Vladimir on 20.01.2020.
 * vovapust1989@gmail.com
 */

public class BookShopRepository {
    private CategoryDAO categoryDAO;
    private BookDAO bookDAO;

    private LiveData<List<Category>> categories;
    private LiveData<List<Book>> books;

    public BookShopRepository(Application application) {
        BooksDatabase booksDatabase = BooksDatabase.getInstance(application);
        categoryDAO = booksDatabase.categoryDAO();
        bookDAO = booksDatabase.bookDAO();
    }

    public LiveData<List<Category>> getCategories() {
        return categoryDAO.getAllCategories();
    }

    public LiveData<List<Book>> getBooks(int categoryId) {
        return bookDAO.getBooks(categoryId);
    }

    public void insertCategory(final Category category){

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDAO.insert(category);
            }
        });
    }


    public void deleteCategory(final Category category){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDAO.delete(category);
            }
        });
    }



    public void updateCategory(final Category category){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDAO.update(category);
            }
        });
    }

    public void insertBook(final Book book){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                bookDAO.insert(book);
            }
        });
    }


    public void deleteBook(final Book book){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                bookDAO.delete(book);
            }
        });
    }

    public void updateBook(final Book book){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                bookDAO.update(book);
            }
        });
    }

}
