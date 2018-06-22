package com.example.david.isquare.Objects;

import com.example.david.isquare.Adapters.ContactListAdapter;

/**
 * Created by David on 10/13/2017.
 */

public class GroupChatMember implements ContactItem {

    private boolean baned;
    private boolean checked;

    public boolean isBaned() {
        return baned;
    }

    public void setBaned(boolean baned) {
        this.baned = baned;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public GroupChatMember(boolean baned, boolean checked) {
        this.baned = baned;
        this.checked = checked;
    }

    @Override
    public int getViewType() {
        return 1;
    }
}
