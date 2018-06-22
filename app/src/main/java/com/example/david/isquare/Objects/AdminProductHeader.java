package com.example.david.isquare.Objects;

/**
 * Created by David on 10/12/2017.
 */

public class AdminProductHeader implements AdminProductInterface {
    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public AdminProductHeader(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public int getViewType() {
        return 1;
    }
}
