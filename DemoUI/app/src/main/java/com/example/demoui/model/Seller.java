package com.example.demoui.model;

public class Seller {
    private String Number;
    private int Rank;
    private String Name;
    private String Category;
    private int Image;

    public Seller(String number, int rank, String name, String category, int image) {
        Number = number;
        Rank = rank;
        Name = name;
        Category = category;
        Image = image;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
