package com.example.demoui.view;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.demoui.R;
import com.example.demoui.adapter.CategoryAdapter;
import com.example.demoui.adapter.ProductAdapter;
import com.example.demoui.adapter.TagAdapter;
import com.example.demoui.model.Category;
import com.example.demoui.model.Product;
import com.example.demoui.viewmodel.CategoryViewModel;
import com.example.demoui.viewmodel.ProductViewModel;
import com.example.demoui.viewmodel.TagViewModel;




public class ProductFragment extends Fragment implements CategoryAdapter.IItemClickListener, ProductAdapter.IItemClickListener {
    String selectedFilter = "price";
    String getSelectedDateFilter = "day";

    private RecyclerView rvProduct;
    private RecyclerView rvCategory;
    private RecyclerView rvTag;
    private CategoryAdapter categoryAdapter;
    private ProductAdapter productAdapter;
    private TagAdapter tagAdapter;

    private ProductViewModel productViewModel;

    public ProductFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_1, container, false);

        rvCategory = view.findViewById(R.id.rv_category);
        rvProduct = view.findViewById(R.id.rv_product);
        rvTag = view.findViewById(R.id.rv_tag);
        createCategoryRecyclerView();
        createProductRecyclerView();
        createTagRecyclerView();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView ivFilter = view.findViewById(R.id.iv_filter);
        ImageView ivDateFilter = view.findViewById(R.id.iv_date_filter);

        ivFilter.setOnClickListener(v -> showOptionDialog());
        ivDateFilter.setOnClickListener(v -> showDateFilterDialog());
    }

    private void showDateFilterDialog() {
        String[] filter = {"Day", "Month", "Year"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Date Filter");
        builder.setSingleChoiceItems(filter, 0, (dialog, which) -> {
            getSelectedDateFilter = filter[which];
            Toast.makeText(getContext(),"You just clicked: "+ selectedFilter, Toast.LENGTH_LONG).show();
        });
        builder.setPositiveButton("Accept", (dialog, which) -> dialog.dismiss());
        builder.setNegativeButton("Exit", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private void showOptionDialog() {
        String[] filter = {"Price", "Vote", "Style"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Filter");
        builder.setSingleChoiceItems(filter, 0, (dialog, which) -> {
            selectedFilter = filter[which];
            Toast.makeText(getContext(),"You just clicked: "+ selectedFilter, Toast.LENGTH_LONG).show();
        });
        builder.setPositiveButton("Accept", (dialog, which) -> dialog.dismiss());
        builder.setNegativeButton("Exit", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private void createProductRecyclerView() {
        rvProduct.setHasFixedSize(true);
        GridLayoutManager gridLayoutManagerProduct =new GridLayoutManager(getContext(),2);
        rvProduct.setLayoutManager(gridLayoutManagerProduct);
        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        productViewModel.getListProductLiveData().observe(getViewLifecycleOwner(),products -> {
            productAdapter = new ProductAdapter(getContext(), products, this);
            rvProduct.setAdapter(productAdapter);
        });

        productViewModel.getProductLiveData().observe(getViewLifecycleOwner(), product -> productAdapter.updateUIposition(product));

    }

    private void createCategoryRecyclerView() {
        rvCategory.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManagerCategory = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvCategory.setLayoutManager(linearLayoutManagerCategory);
        CategoryViewModel categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        categoryViewModel.getListCategoryLiveData().observe(getViewLifecycleOwner(),categorys->{
            if(categoryAdapter==null) {
                categoryAdapter = new CategoryAdapter(categorys,this);
                rvCategory.setAdapter(categoryAdapter);
            }
            categoryAdapter.notifyDataSetChanged();
        });
    }

    public void createTagRecyclerView() {
        rvTag.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvTag.setLayoutManager(linearLayoutManager);
        TagViewModel tagViewModel = new ViewModelProvider(this).get(TagViewModel.class);
        tagViewModel.getListTagLiveData().observe(getViewLifecycleOwner(), tags -> {
            if(tagAdapter == null) {
                tagAdapter = new TagAdapter(getContext(), tags);
                rvTag.setAdapter(tagAdapter);
            }
        });
    }
    @Override
    public void getDataItemClick(Category category) {
        productViewModel.selectCategory(category);
    }

    @Override
    public void onClick(Product product) {
        productViewModel.updateProductItem(product);
    }
}
