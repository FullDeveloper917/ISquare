package com.example.david.isquare.Objects;

import com.example.david.isquare.Adapters.ContactListAdapter;

/**
 * Created by David on 10/9/2017.
 */

public class ContactButton implements ContactItem {
    @Override
    public int getViewType() {
        return ContactListAdapter.RowType.EXTRA_ITEM.ordinal();
    }
}
