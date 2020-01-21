package com.pustovit.bookshop.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.pustovit.bookshop.model.Book;
import com.pustovit.bookshop.model.BookShopRepository;
import com.pustovit.bookshop.model.Category;

import java.util.List;

/**
 * Created by Pustovit Vladimir on 20.01.2020.
 * vovapust1989@gmail.com
 */

public class MainActivityViewModel extends AndroidViewModel {

    private BookShopRepository repository;
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Book>> booksOfASelectedCategory;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        repository = new BookShopRepository(application);
    }

    public LiveData<List<Category>> getAllCategories() {
        allCategories = repository.getCategories();
        return allCategories;
    }

    public LiveData<List<Book>> getBooksOfASelectedCategory(int categoryId) {
        booksOfASelectedCategory = repository.getBooks(categoryId);
        return booksOfASelectedCategory;
    }

    public void addNewBook(Book book){
        repository.insertBook(book);
    }

    public void deleteBook(Book book){
        repository.deleteBook(book);
    }

    public void updateBook(Book book){
        repository.updateBook(book);
    }
}
