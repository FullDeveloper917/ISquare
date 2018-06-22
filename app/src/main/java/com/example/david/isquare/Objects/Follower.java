package com.example.david.isquare.Objects;

import com.example.david.isquare.Adapters.CartListAdapter;
import com.example.david.isquare.Adapters.ContactListAdapter;

/**
 * Created by David on 10/9/2017.
 */

public class Follower implements ContactItem {

    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Follower(String name) {
        Name = name;
    }

    @Override
    public int getViewType() {
        return ContactListAdapter.RowType.LIST_ITEM.ordinal();
    }
}
