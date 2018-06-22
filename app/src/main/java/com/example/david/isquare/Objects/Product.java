package com.example.david.isquare.Objects;

/**
 * Created by David on 9/27/2017.
 */

public class Product {
    private String name;
    private int stock;
    private double price;
    private String imgUrl;

    public Product() {
        this.name = "";
        this.stock = 0;
        this.price = 0.0;
        this.imgUrl = "";
    }

    public Product(String name, int stock, double price, String imgUrl) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
