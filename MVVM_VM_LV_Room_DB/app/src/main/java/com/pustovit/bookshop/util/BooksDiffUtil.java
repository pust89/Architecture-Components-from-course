package com.pustovit.bookshop.util;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.pustovit.bookshop.model.Book;

import java.util.List;

/**
 * Created by Pustovit Vladimir on 21.01.2020.
 * vovapust1989@gmail.com
 */

public class BooksDiffUtil extends DiffUtil.Callback {
    private List<Book> oldList;
    private List<Book> newList;

    public BooksDiffUtil(List<Book> oldList, List<Book> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList == null ? 0 : oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList == null ? 0 : newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldBookPosition, int newBookPosition) {
//        int oldId = 0;
//        int newId = 0;
//        if (oldBookPosition < getOldListSize()) {
//            oldId = oldList.get(oldBookPosition).getId();
//        }
//        if (newBookPosition < getNewListSize()) {
//            newId = newList.get(newBookPosition).getId();
//        }
//        if (oldId == 0 || newId == 0) {
//            return false;
//        }
//        return oldId == newId;
        return oldList.get(oldBookPosition).getId()==newList.get(newBookPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldBookPosition, int newBookPosition) {
//        Book oldBook = null;
//        Book newBook = null;
//        if (oldBookPosition < getOldListSize()) {
//            oldBook = oldList.get(oldBookPosition);
//        }
//        if (newBookPosition < getNewListSize()) {
//            newBook = newList.get(newBookPosition);
//        }
//        if (oldBook == null || newBook == null) {
//            return false;
//        }
//        return oldBook.equals(newBook);
        return oldList.get(oldBookPosition).equals(newList.get(newBookPosition));

    }

    @Nullable
    @Override
    public Object getChangePayload(int oldBookPosition, int newBookPosition) {
        return super.getChangePayload(oldBookPosition, newBookPosition);
    }
}
