package com.example.demoui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class Fragment2 extends Fragment {

    public Fragment2() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvSeller = view.findViewById(R.id.rv_seller);
        ImageView ivFilter = view.findViewById(R.id.iv_filter);
        ImageView ivDateFilter = view.findViewById(R.id.iv_date_filter);

        List<Seller> sellerList = new ArrayList<>();
        sellerList.add(new Seller(1, R.drawable.up, "Person Mandaley", "#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16", R.drawable.profile));
        sellerList.add(new Seller(1, R.drawable.up, "Person Mandaley", "#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16", R.drawable.profile));
        sellerList.add(new Seller(1, R.drawable.up, "Person Mandaley", "#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16", R.drawable.profile));
        sellerList.add(new Seller(1, R.drawable.up, "Person Mandaley", "#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16", R.drawable.profile));
        sellerList.add(new Seller(1, R.drawable.up, "Person Mandaley", "#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16", R.drawable.profile));
        sellerList.add(new Seller(1, R.drawable.up, "Person Mandaley", "#Jacket #Sweater #Skinny pants #Blouse #Jeans #<16", R.drawable.profile));

        SellerAdapter sellerAdapter = new SellerAdapter(getContext(), sellerList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),2);
        rvProduct.setHasFixedSize(true);
        rvProduct.setLayoutManager(gridLayoutManager);
        rvProduct.setAdapter(productAdapter);

        ivFilter.setOnClickListener(v -> showOptionDialog());
        ivDateFilter.setOnClickListener(v -> showDateFilterDialog());
    }

}