package com.example.demoui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demoui.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryViewModel extends ViewModel {
    private final MutableLiveData<List<Category>> listCategoryLiveData;

    public CategoryViewModel() {
        listCategoryLiveData = new MutableLiveData<>();
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("All"));
        categoryList.add(new Category("Jacket"));
        categoryList.add(new Category("Sweater"));
        categoryList.add(new Category("Skinny pants"));
        categoryList.add(new Category("Jean"));
        categoryList.add(new Category("Sort"));
        listCategoryLiveData.setValue(categoryList);
    }

    public MutableLiveData<List<Category>> getListCategoryLiveData() {
        return listCategoryLiveData;
    }
}
