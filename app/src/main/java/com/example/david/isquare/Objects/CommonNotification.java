package com.example.david.isquare.Objects;

import com.example.david.isquare.Adapters.NotificationListAdapter;

/**
 * Created by David on 10/9/2017.
 */

public class CommonNotification implements Notification {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CommonNotification(String description) {
        this.description = description;
    }

    @Override
    public int getViewType() {
        return NotificationListAdapter.RowType.COMMON_ITEM.ordinal();
    }
}
