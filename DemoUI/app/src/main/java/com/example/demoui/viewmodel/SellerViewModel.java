package com.example.demoui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demoui.R;
import com.example.demoui.model.Category;
import com.example.demoui.model.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellerViewModel extends ViewModel {
    private final MutableLiveData<List<Seller>> sellerListLiveData;

    private final List<Seller> sellerList;

    public SellerViewModel() {
        sellerListLiveData = new MutableLiveData<>();
        sellerList = new ArrayList<>();
        sellerList.add(new Seller("1", R.drawable.ic_up, "Person Mandaley", "#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16", R.drawable.profile));
        sellerList.add(new Seller("2", R.drawable.ic_down, "Tuyen Nguyen Kim", "#Jacket #Sweater", R.drawable.profile_2));
        sellerList.add(new Seller("3", R.drawable.ic_up, "Veray Rose", "#Jacket #Skinny pants#<16", R.drawable.profile_3));
        sellerList.add(new Seller("4", R.drawable.ic_down, "Angel Angel", "#<16", R.drawable.profile_4));
        sellerList.add(new Seller("5", R.drawable.ic_down, "Person Mandaley", "#Jacket #Sweater #Blouse #Jeans #<16", R.drawable.profile));
        sellerList.add(new Seller("6", R.drawable.ic_up, "Person Mandaley", "#Skinny pants #Blouse #Jeans #<16", R.drawable.profile_3));
        sellerListLiveData.setValue(sellerList);
    }

    public MutableLiveData<List<Seller>> getSellerListLiveData() {
        return sellerListLiveData;
    }

    public void SelectCategory(Category category) {
        String tittle = category.getTittle();
        if(tittle.equals("All")) {
            sellerListLiveData.setValue(sellerList);
        }
        else {
            ArrayList<Seller> sellerList2 = new ArrayList<>();
            for(int i=0; i<sellerList.size(); i++) {
                if(sellerList.get(i).getCategory().contains(tittle)) {
                    sellerList2.add(sellerList.get(i));
                }
            }
            sellerListLiveData.setValue(sellerList2);
        }
    }
}
