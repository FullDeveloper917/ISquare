package com.example.david.isquare.Objects;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.david.isquare.Adapters.CartListAdapter;
import com.example.david.isquare.Fragments.MeFragments.MyCartFragments.MyCartFragment;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

/**
 * Created by David on 10/7/2017.
 */

public class CartHeaderItem implements CartUnitItem {

    public CartHeaderItem() {

    }

    @Override
    public int getViewType() {
        return CartListAdapter.RowType.HEADER_ITEM.ordinal();
    }

}
