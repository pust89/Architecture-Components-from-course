package com.pustovit.bookshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.pustovit.bookshop.R;
import com.pustovit.bookshop.databinding.SpinnerItemBinding;
import com.pustovit.bookshop.model.Category;

import java.util.List;

/**
 * Created by Pustovit Vladimir on 20.01.2020.
 * vovapust1989@gmail.com
 */

public class CategoriesSpinnerAdapter extends ArrayAdapter<Category> {
    private List<Category> categoryList;

    public CategoriesSpinnerAdapter(@NonNull Context context, @NonNull List<Category> categoryList) {
        super(context, R.layout.spinner_item, categoryList);
        this.categoryList = categoryList;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }


    public View getCustomView(int position, View convertView, ViewGroup parent) {
        SpinnerItemBinding itemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext())
                , R.layout.spinner_item
                , parent
                , false);
        itemBinding.setCategory(categoryList.get(position));

        return itemBinding.getRoot();
    }

}
