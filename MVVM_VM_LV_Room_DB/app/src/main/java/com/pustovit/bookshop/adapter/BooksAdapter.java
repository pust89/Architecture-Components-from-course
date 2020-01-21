package com.pustovit.bookshop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.pustovit.bookshop.R;
import com.pustovit.bookshop.databinding.BookListItemBinding;
import com.pustovit.bookshop.model.Book;
import com.pustovit.bookshop.util.BooksDiffUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pustovit Vladimir on 20.01.2020.
 * vovapust1989@gmail.com
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookVH> {
    private OnItemClickListener listener;
    private List<Book> bookList;


    public BooksAdapter(OnItemClickListener listener) {
        this.listener = listener;
        this.bookList =  new ArrayList<>();
    }

    public void setBookList(List<Book> newBookList) {
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new BooksDiffUtil(bookList, newBookList), false);
        bookList = newBookList;
        diffResult.dispatchUpdatesTo(BooksAdapter.this);


    }

    @NonNull
    @Override
    public BookVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BookListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.book_list_item,
                parent,
                false);

        return new BookVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookVH holder, int position) {
        holder.bookListItemBinding.setBook(bookList.get(position));
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    class BookVH extends RecyclerView.ViewHolder {
        private BookListItemBinding bookListItemBinding;


        public BookVH(@NonNull BookListItemBinding bookListItemBinding) {
            super(bookListItemBinding.getRoot());
            this.bookListItemBinding = bookListItemBinding;

            bookListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickedPosition = getAdapterPosition();

                    if (listener != null && clickedPosition != RecyclerView.NO_POSITION) {
                        listener.onItemClick(bookList.get(clickedPosition));
                    }
                }
            });


        }
    }

    public interface OnItemClickListener {
        void onItemClick(Book book);
    }
}
