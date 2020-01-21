package com.pustovit.bookshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pustovit.bookshop.databinding.ActivityAddEditBinding;
import com.pustovit.bookshop.model.Book;

public class AddEditActivity extends AppCompatActivity {

    private Book book;
    public static final String BOOK_ID = "bookId";
    public static final String BOOK_NAME = "bookName";
    public static final String UNIT_PRICE = "unitPrice";

    private ActivityAddEditBinding addEditBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        book = new Book();
        addEditBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_edit);
        addEditBinding.setClickHandler(new AddEditActivityClickHandler(this));
        addEditBinding.setBook(book);

        Intent intent = getIntent();
     if(intent.hasExtra(BOOK_ID)){
         setTitle("Update date");
         book.setBookName(intent.getStringExtra(BOOK_NAME));
         book.setUnitPrice(intent.getStringExtra(UNIT_PRICE));
     } else{
         setTitle("Add new book");

     }
    }


    public class AddEditActivityClickHandler {
        private Context context;

        public AddEditActivityClickHandler(Context context) {
            this.context = context;
        }

        public void onSubmitButtonClicked(View view) {
            if(book.getBookName()==null || book.getUnitPrice()==null){
                Toast.makeText(context,"Please fill in all fields!",Toast.LENGTH_LONG).show();
            } else{
                Intent intent = new Intent();
                intent.putExtra(BOOK_NAME, book.getBookName());
                intent.putExtra(UNIT_PRICE, book.getUnitPrice());
                setResult(RESULT_OK, intent);
                finish();
            }

        }
    }
}
