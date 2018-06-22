package com.example.david.isquare.Objects;

import com.example.david.isquare.Adapters.CartListAdapter;

/**
 * Created by David on 10/7/2017.
 */

public class CartFooterItem implements CartUnitItem {
    public CartFooterItem() {

    }

    @Override
    public int getViewType() {
        return CartListAdapter.RowType.FOOTER_ITEM.ordinal();
    }
}
