package com.example.david.isquare.Objects;

import com.example.david.isquare.Adapters.NotificationListAdapter;

/**
 * Created by David on 10/9/2017.
 */

public class MomentNotification implements Notification {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public MomentNotification(int state) {
        this.state = state;
    }

    @Override
    public int getViewType() {
        return NotificationListAdapter.RowType.MOMENT_ITEM.ordinal();
    }
}
