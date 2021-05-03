package com.example.demoui.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demoui.R;
import com.example.demoui.adapter.CategoryAdapter;
import com.example.demoui.adapter.SellerAdapter;
import com.example.demoui.model.Category;
import com.example.demoui.viewmodel.CategoryViewModel;
import com.example.demoui.viewmodel.SellerViewModel;




public class SellerFragment extends Fragment implements CategoryAdapter.IItemClickListener {

    public RecyclerView rvSeller;
    public RecyclerView rvCategory;
    public SellerFragment() {}

    private CategoryAdapter categoryAdapter;
    private SellerAdapter sellerAdapter;

    private SellerViewModel sellerViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        rvSeller = view.findViewById(R.id.rv_seller);
        rvCategory = view.findViewById(R.id.rv_category);

        createSellersRecyclerView();
        createCategoryRecyclerView();
        return view;
    }


    @Override
    public void getDataItemClick(Category category) {
        sellerViewModel.SelectCategory(category);
    }

    private void createSellersRecyclerView() {
        rvSeller.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManagerCategory = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvSeller.setLayoutManager(linearLayoutManagerCategory);
        sellerViewModel = new ViewModelProvider(this).get(SellerViewModel.class);
        sellerViewModel.getSellerListLiveData().observe(getViewLifecycleOwner(),sellers->{
                sellerAdapter = new SellerAdapter(getContext(), sellers);
                rvSeller.setAdapter(sellerAdapter);
        });
    }

    private void createCategoryRecyclerView() {
        rvCategory.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManagerCategory = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvCategory.setLayoutManager(linearLayoutManagerCategory);
        CategoryViewModel categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        categoryViewModel.getListCategoryLiveData().observe(getViewLifecycleOwner(), categorys->{
            if(categoryAdapter==null) {
                categoryAdapter = new CategoryAdapter(categorys,this);
                rvCategory.setAdapter(categoryAdapter);
            }
            categoryAdapter.notifyDataSetChanged();
        });
    }
}