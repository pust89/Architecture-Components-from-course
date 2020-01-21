package com.pustovit.bookshop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.pustovit.bookshop.adapter.BooksAdapter;
import com.pustovit.bookshop.adapter.CategoriesSpinnerAdapter;
import com.pustovit.bookshop.databinding.ActivityMainBinding;
import com.pustovit.bookshop.databinding.BookListItemBinding;
import com.pustovit.bookshop.databinding.SpinnerItemBinding;
import com.pustovit.bookshop.model.Book;
import com.pustovit.bookshop.model.Category;
import com.pustovit.bookshop.viewmodel.MainActivityViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BooksAdapter.OnItemClickListener {
    private static final String TAG = "myTag";
    private final String SELECTED_CATEGORY_ID = "selectedCategoryId";
    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding activityMainBinding;

    private List<Category> categoryList;
    private Category selectedCategory;

    private MainActivityClickHandler handler;


    private Spinner categoriesSpinner;
    private CategoriesSpinnerAdapter spinnerAdapter;

    private List<Book> booksList;
    private RecyclerView rvBooks;
    private BooksAdapter booksAdapter;

    public static final int ADD_BOOK_REQUEST_CODE = 100;
    public static final int EDIT_BOOK_REQUEST_CODE = 101;

    private int selectedBookId;
    private int selectedCategoryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        booksList = new ArrayList<>();
        handler = new MainActivityClickHandler();
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setClickHandler(handler);

        setupRecycleView();
        setupSpinner();

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mainActivityViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                categoryList.clear();
                categoryList.addAll(categories);
                spinnerAdapter.notifyDataSetChanged();
            }
        });
    }

    private void setupSpinner() {
        /*Spinner*/
        categoriesSpinner = activityMainBinding.layoutContentMain.spinner;
        categoryList = new ArrayList<>();
        spinnerAdapter = new CategoriesSpinnerAdapter(this, categoryList);
        categoriesSpinner.setAdapter(spinnerAdapter);
        categoriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerItemBinding spinnerItemBinding = (SpinnerItemBinding) DataBindingUtil.getBinding(view);
                selectedCategory = spinnerItemBinding.getCategory();
                selectedCategoryId = selectedCategory.getId();
                loadBooksList(selectedCategoryId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setupRecycleView() {


        rvBooks = activityMainBinding.layoutContentMain.rvBooks;
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
        rvBooks.addItemDecoration(new DividerItemDecoration(rvBooks.getContext(), DividerItemDecoration.VERTICAL));

        booksAdapter = new BooksAdapter(this);
        rvBooks.setAdapter(booksAdapter);


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Book book = booksList.get(viewHolder.getAdapterPosition());
                mainActivityViewModel.deleteBook(book);
                Toast.makeText(MainActivity.this, book.toString(),Toast.LENGTH_LONG).show();
            }
        }).attachToRecyclerView(rvBooks);


    }

    @Override
    public void onItemClick(Book book) {

        selectedBookId = book.getId();

        Intent intent = new Intent(this, AddEditActivity.class);
        intent.putExtra(AddEditActivity.BOOK_ID, selectedBookId);
        intent.putExtra(AddEditActivity.BOOK_NAME, book.getBookName());
        intent.putExtra(AddEditActivity.UNIT_PRICE, book.getUnitPrice());
        startActivityForResult(intent, EDIT_BOOK_REQUEST_CODE);

    }

    public class MainActivityClickHandler {
        public void onClickFaB(View view) {
            Intent intent = new Intent(MainActivity.this, AddEditActivity.class);
            startActivityForResult(intent, ADD_BOOK_REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_BOOK_REQUEST_CODE && resultCode == RESULT_OK) {

            Book book = new Book();
            book.setBookName(data.getStringExtra(AddEditActivity.BOOK_NAME));
            book.setUnitPrice(data.getStringExtra(AddEditActivity.UNIT_PRICE));
            book.setCategoryId(selectedCategory.getId());
            mainActivityViewModel.addNewBook(book);

            loadBooksList(selectedCategoryId);
        }

        if (requestCode == EDIT_BOOK_REQUEST_CODE && resultCode == RESULT_OK) {

            Book book = new Book();
            book.setId(selectedBookId);
            book.setBookName(data.getStringExtra(AddEditActivity.BOOK_NAME));
            book.setUnitPrice(data.getStringExtra(AddEditActivity.UNIT_PRICE));
            book.setCategoryId(selectedCategory.getId());
            mainActivityViewModel.updateBook(book);

            loadBooksList(selectedCategoryId);
        }
    }

    private void loadBooksList(int categoryId) {
       LiveData<List<Book>> booksLiveData = mainActivityViewModel.getBooksOfASelectedCategory(categoryId);

       booksLiveData.observe(this, new Observer<List<Book>>() {
           @Override
           public void onChanged(List<Book> books) {
               booksList.clear();
               booksList.addAll(books);
               booksAdapter.setBookList(books);
           }
       });
    }

}
