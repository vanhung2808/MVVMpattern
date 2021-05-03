package com.example.demoui.model;

public class Product {
    private int Image;
    private String ProductInfo;
    private String Price;
    private String OldPrice;
    private String NewProduct;
    private String Percent;
    private boolean Favorite;
    private String Category;

    public Product(int image, String productInfo, String price,String oldPrice, String newproduct,String percent, boolean favorite, String category) {
        Image = image;
        ProductInfo = productInfo;
        Price = price;
        OldPrice = oldPrice;
        NewProduct = newproduct;
        Percent = percent;
        Favorite = favorite;
        Category = category;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getProductInfo() {
        return ProductInfo;
    }

    public void setProductInfo(String productInfo) {
        ProductInfo = productInfo;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getNewProduct() {
        return NewProduct;
    }

    public void setNewProduct(String newProduct) {
        NewProduct = newProduct;
    }

    public boolean isFavorite() {
        return Favorite;
    }

    public void setFavorite(boolean favorite) {
        Favorite = favorite;
    }

    public String getPercent() {
        return Percent;
    }

    public void setPercent(String percent) {
        Percent = percent;
    }

    public String getOldPrice() {
        return OldPrice;
    }

    public void setOldPrice(String oldPrice) {
        OldPrice = oldPrice;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
