package com.pustovit.countryapp.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.pustovit.countryapp.R;
import com.pustovit.countryapp.databinding.ResultItemListBinding;
import com.pustovit.countryapp.model.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pustovit Vladimir on 21.01.2020.
 * vovapust1989@gmail.com
 */

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.CountryVH> {
    private List<Result> resultList;

    public ResultsAdapter() {
        resultList = new ArrayList<>();
    }

    public void setNewData(List<Result> newtList){
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new CountryDiffUtil(resultList, newtList), false);
        resultList = newtList;
        diffResult.dispatchUpdatesTo(ResultsAdapter.this);
    }

    @NonNull
    @Override
    public CountryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ResultItemListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.result_item_list,
                parent,
                false);

        return new CountryVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryVH holder, int position) {

        holder.binding.setResult(resultList.get(position));

    }

    @Override
    public int getItemCount() {
        return resultList == null ? 0 : resultList.size();
    }

    class CountryVH extends RecyclerView.ViewHolder {
        private ResultItemListBinding binding;

        public CountryVH(@NonNull ResultItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
