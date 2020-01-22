package com.pustovit.countryapp.view.adapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.pustovit.countryapp.model.Result;

import java.util.List;

/**
 * Created by Pustovit Vladimir on 21.01.2020.
 * vovapust1989@gmail.com
 */

 class CountryDiffUtil extends DiffUtil.Callback {
    private List<Result> oldList;
    private List<Result> newList;

    public CountryDiffUtil(List<Result> oldList, List<Result> newList) {
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
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getName().equals(newList.get(newItemPosition).getName());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getName().equals(newList.get(newItemPosition).getName());

    }


    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
    /*
Когда areItemsTheSame (int, int) возвращает true для двух элементов и areContentsTheSame (int, int)
возвращает false для них, DiffUtil вызывает этот метод, чтобы получить полезную информацию об изменении.
Например, если вы используете DiffUtil с RecyclerView, вы можете вернуть конкретное поле, которое изменилось
в элементе, и ваш ItemAnimator может использовать эту информацию для запуска правильной анимации.
Реализация по умолчанию возвращает ноль.
     */
}
