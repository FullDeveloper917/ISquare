package com.example.david.isquare.Objects;

import com.example.david.isquare.Adapters.ContactListAdapter;

/**
 * Created by David on 10/9/2017.
 */

public class ContactHeader implements ContactItem{
    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public ContactHeader(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public int getViewType() {
        return ContactListAdapter.RowType.HEADER_ITEM.ordinal();
    }
}
