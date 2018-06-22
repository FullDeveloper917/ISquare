package com.example.david.isquare.Objects;

/**
 * Created by David on 10/12/2017.
 */

public class AdminProduct implements AdminProductInterface {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdminProduct(String name) {
        this.name = name;
    }

    @Override
    public int getViewType() {
        return 0;
    }
}
