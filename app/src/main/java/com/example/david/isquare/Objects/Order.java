package com.example.david.isquare.Objects;

/**
 * Created by David on 9/28/2017.
 */

public class Order {
    private String date;
    private int status;

    public Order() {
        this.date = "";
        this.status = 0;
    }

    public Order(String date, int status) {
        this.date = date;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
