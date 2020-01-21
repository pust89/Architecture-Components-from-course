package com.pustovit.bookshop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

import static androidx.room.ForeignKey.CASCADE;

/**
 * Created by Pustovit Vladimir on 20.01.2020.
 * vovapust1989@gmail.com
 */

@Entity(tableName = "books_table", foreignKeys = @ForeignKey(entity = Category.class,
        parentColumns = "categories_id",childColumns = "book_category", onDelete = CASCADE ))
public class Book extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_id")
    private int id;

    @ColumnInfo(name = "book_name")
    private String bookName;

    @ColumnInfo(name = "unit_price")
    private String unitPrice;

    @ColumnInfo(name = "book_category")
    private int categoryId;

    public Book(int id, String bookName, String unitPrice, int categoryId) {
        this.id = id;
        this.bookName = bookName;
        this.unitPrice = unitPrice;
        this.categoryId = categoryId;
    }

    @Ignore
    public Book() {
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }
    @Bindable
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
        notifyPropertyChanged(BR.bookName);
    }

    @Bindable
    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
        notifyPropertyChanged(BR.unitPrice);
    }


    @Bindable
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        notifyPropertyChanged(BR.categoryId);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getId() == book.getId() &&
                getCategoryId() == book.getCategoryId() &&
                getBookName().equals(book.getBookName()) &&
                getUnitPrice().equals(book.getUnitPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBookName(), getUnitPrice(), getCategoryId());
    }
}
