package com.example.demoui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demoui.model.Tag;

import java.util.ArrayList;
import java.util.List;

public class TagViewModel extends ViewModel {
    private final MutableLiveData<List<Tag>> listTagLiveData;

    public TagViewModel() {
        listTagLiveData = new MutableLiveData<>();
        List<Tag> tagList = new ArrayList<>();
        tagList.add(new Tag("#happy"));
        tagList.add(new Tag("#clothes"));
        listTagLiveData.setValue(tagList);
    }

    public MutableLiveData<List<Tag>> getListTagLiveData() {
        return listTagLiveData;
    }
}
