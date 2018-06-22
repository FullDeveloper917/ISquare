package com.example.david.isquare.Objects;

/**
 * Created by David on 9/26/2017.
 */

public class Shop {
    private String title;
    private int comments;
    private String city;
    private double price;
    private String imgUrl;
    private boolean second_handed;
    private boolean stared;

    public Shop() {
        this.title = "";
        this.comments = 0;
        this.city = "";
        this.price = 0.0;
        this.imgUrl = "";
        this.stared = true;
        this.second_handed = false;
    }

    public Shop(boolean second_handed) {
        this.title = "";
        this.comments = 0;
        this.city = "";
        this.price = 0.0;
        this.imgUrl = "";
        this.stared = true;
        this.second_handed = second_handed;
    }

    public Shop(String title, int comments, String city, double price, String imgUrl) {
        this.title = title;
        this.comments = comments;
        this.city = city;
        this.price = price;
        this.imgUrl = imgUrl;
        this.stared = true;
        this.second_handed = false;
    }

    public boolean isStared() {
        return stared;
    }

    public void setStared(boolean stared) {
        this.stared = stared;
    }

    public boolean isSecond_handed() {
        return second_handed;
    }

    public void setSecond_handed(boolean second_handed) {
        this.second_handed = second_handed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
