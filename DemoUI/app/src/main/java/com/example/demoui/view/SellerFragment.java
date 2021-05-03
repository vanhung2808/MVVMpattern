package com.example.demoui.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demoui.R;
import com.example.demoui.adapter.CategoryAdapter;
import com.example.demoui.adapter.SellerAdapter;
import com.example.demoui.model.Category;
import com.example.demoui.model.Seller;

import java.util.ArrayList;
import java.util.List;


public class Fragment2 extends Fragment implements CategoryAdapter.ItemClickListener {

    public RecyclerView rvSeller;
    public RecyclerView rvCategory;
    public Fragment2() {}
    private List<Seller> sellerList;
    private List<Seller> sellerList2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvSeller = view.findViewById(R.id.rv_seller);
        rvCategory = view.findViewById(R.id.rv_category);

        createSellers();
        createCategory();
    }

    @Override
    public void getDataItemClick(Category category) {
        String tittle = category.getTittle();
        sellerList2 = new ArrayList<>();
        if(tittle.equals("All")) {
            sellerList2 = sellerList;
        }
        else {
            for(int i=0; i<sellerList.size();i++) {
                if (sellerList.get(i).getCategory().contains(tittle)) {
                    Seller seller = sellerList.get(i);
                    sellerList2.add(seller);
                }
            }
        }
        SellerAdapter sellerAdapter = new SellerAdapter(getContext(), sellerList2);
        sellerAdapter.notifyDataSetChanged();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvSeller.setHasFixedSize(true);
        rvSeller.setLayoutManager(linearLayoutManager);
        rvSeller.setAdapter(sellerAdapter);
    }

    public void createSellers() {
        sellerList = new ArrayList<>();
        sellerList.add(new Seller("1", R.drawable.ic_up, "Person Mandaley", "#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16", R.drawable.profile));
        sellerList.add(new Seller("2", R.drawable.ic_down, "Tuyen Nguyen Kim", "#Jacket #Sweater", R.drawable.profile_2));
        sellerList.add(new Seller("3", R.drawable.ic_up, "Veray Rose", "#Jacket #Skinny pants#<16", R.drawable.profile_3));
        sellerList.add(new Seller("4", R.drawable.ic_down, "Angel Angel", "#<16", R.drawable.profile_4));
        sellerList.add(new Seller("5", R.drawable.ic_down, "Person Mandaley", "#Jacket #Sweater #Blouse #Jeans #<16", R.drawable.profile));
        sellerList.add(new Seller("6", R.drawable.ic_up, "Person Mandaley", "#Skinny pants #Blouse #Jeans #<16", R.drawable.profile_3));

        SellerAdapter sellerAdapter = new SellerAdapter(getContext(), sellerList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvSeller.setHasFixedSize(true);
        rvSeller.setLayoutManager(linearLayoutManager);
        rvSeller.setAdapter(sellerAdapter);
    }

    public void createCategory() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("All"));
        categoryList.add(new Category("Jacket"));
        categoryList.add(new Category("Sweater"));
        categoryList.add(new Category("Skinny pants"));
        categoryList.add(new Category("Jean"));
        categoryList.add(new Category("Sort"));

        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryList,this);
        LinearLayoutManager linearLayoutManager2 =  new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvCategory.setHasFixedSize(true);
        rvCategory.setLayoutManager(linearLayoutManager2);
        rvCategory.setAdapter(categoryAdapter);
    }
}