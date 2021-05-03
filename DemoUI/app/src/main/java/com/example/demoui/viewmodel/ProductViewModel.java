package com.example.demoui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demoui.R;
import com.example.demoui.model.Category;
import com.example.demoui.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductViewModel extends ViewModel {
    private final MutableLiveData<List<Product>>  listProductLiveData;
    private final MutableLiveData<Product> productLiveData;
    private final List<Product> productList;

    public ProductViewModel() {
        productLiveData = new MutableLiveData<>();
        listProductLiveData = new MutableLiveData<>();
        productList = new ArrayList<>();
        productList.add(new Product(1, R.drawable.product_1, "[Woman] Trouser short","1.700.000 ₫", null,null,null,false, "Jacket"));
        productList.add(new Product(2, R.drawable.product_2, "[Code FASHIONHOT27 reduc 10K] Freeship 50K- Trousers...","1.700.000 ₫", "1.900.000 ₫", null,"12%",false, "Sweater"));
        productList.add(new Product(3, R.drawable.product_3, "[Woman] Trouser short","240.000 ₫","1.900.000 ₫", "New","12%",false,"Skinny pants"));
        productList.add(new Product(4, R.drawable.product_4, "[Code FASHIONHOT27 reduc 10K] Freeship 50K- Trousers...","1.700.000 ₫",null, "New",null,false,"Jacket"));
        productList.add(new Product(5, R.drawable.product_2, "[Woman] Trouser short","1.700.000 ₫","1.900.000 ₫", null,null,false,"Jean"));
        productList.add(new Product(6, R.drawable.product_4, "[Woman] Trouser short","1.700.000đ", null,"New",null,false,"Sweater"));
        productList.add(new Product(7, R.drawable.product_3, "[Woman] Trouser short","1.700.000đ",null, null,null,false,"Jacket"));
        listProductLiveData.setValue(productList);
    }

    public MutableLiveData<List<Product>> getListProductLiveData() {
        return listProductLiveData;
    }

    public MutableLiveData<Product> getProductLiveData() {
        return productLiveData;
    }

    public void selectCategory(Category category) {
        String tittle = category.getTittle();
        if(tittle.equals("All")) {
            listProductLiveData.postValue(productList);
        }
        else {
            ArrayList<Product> productList2 = new ArrayList<>();
            for(int i=0; i<productList.size(); i++) {
                if(tittle.equals(productList.get(i).getCategory())) {
                    productList2.add(productList.get(i));
                }
            }
            listProductLiveData.postValue(productList2);
        }
    }

    public void updateProductItem(Product product) {
        for(Product item: productList) {
            if(item.getId()==product.getId()) {
                if(item.isFavorite()) {
                    item.setFavorite(false);
                }
                else {
                    item.setFavorite(true);
                }
                productLiveData.setValue(item);
            }
        }
    }
}
