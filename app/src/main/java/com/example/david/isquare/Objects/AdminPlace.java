package com.example.david.isquare.Objects;

/**
 * Created by David on 10/12/2017.
 */

public class AdminPlace implements AdminPlaceInterface {
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public AdminPlace(boolean checked) {
        this.checked = checked;
    }

    @Override
    public int getViewType() {
        return 0;
    }
}
