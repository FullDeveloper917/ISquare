package com.example.david.isquare.Objects;

import com.example.david.isquare.Adapters.NotificationListAdapter;

/**
 * Created by David on 10/9/2017.
 */

public class FollowNotification implements Notification {
    private boolean followed;

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public FollowNotification(boolean followed) {
        this.followed = followed;
    }

    @Override
    public int getViewType() {
        return NotificationListAdapter.RowType.FOLLOW_ITEM.ordinal();
    }
}
