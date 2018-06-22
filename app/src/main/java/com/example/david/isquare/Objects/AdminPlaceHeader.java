package com.example.david.isquare.Objects;

/**
 * Created by David on 10/12/2017.
 */

public class AdminPlaceHeader implements AdminPlaceInterface {
    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public AdminPlaceHeader(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public int getViewType() {
        return 1;
    }
}