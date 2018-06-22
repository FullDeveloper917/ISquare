package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.isquare.Fragments.MeFragments.MyCartFragments.CheckOutFragment;
import com.example.david.isquare.Fragments.MeFragments.MyCartFragments.MyCartFragment;
import com.example.david.isquare.Objects.CartUnitItem;
import com.example.david.isquare.Objects.ChatBlock;
import com.example.david.isquare.Objects.Moment;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/6/2017.
 */

public class CartListAdapter extends ArrayAdapter<CartUnitItem> {

    private final Context context;

    private TextView txtStarMark;
    private TextView btnDelete;
    private ImageView imgProduct;

    private Typeface iconFont;

    public enum RowType {
        LIST_ITEM, HEADER_ITEM, FOOTER_ITEM
    }

    private MyCartFragment myFragment;

    public void setMyFragment(MyCartFragment myFragment) {
        this.myFragment = myFragment;
    }

    public CartListAdapter(Context context, List<CartUnitItem> items) {
        super(context, 0, items);
        this.context = context;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);

        switch (getItem(position).getViewType()) {
            case 0:
                view = inflater.inflate(R.layout.list_item_of_one_cart_product, null);
                txtStarMark = view.findViewById(R.id.txtStarMark_OneCartProduct);
                btnDelete = view.findViewById(R.id.btnTrash_OneCartProduct);
                txtStarMark.setTypeface(iconFont);
                btnDelete.setTypeface(iconFont);

                imgProduct = view.findViewById(R.id.imgProduct_OneCartProduct);

                switch (position){
                    case 0:
                    case 5:
                    case 9:
                        imgProduct.setImageDrawable(context.getResources().getDrawable(R.drawable.raw_1505669195));
                        break;
                    case 1:
                    case 6:
                    case 10:
                        imgProduct.setImageDrawable(context.getResources().getDrawable(R.drawable.raw_1505829966));
                        break;
                    case 2:
                    case 7:
                    case 11:
                        imgProduct.setImageDrawable(context.getResources().getDrawable(R.drawable.raw_1505669212));
                        break;
                    default:
                        break;
                }

                break;
            case 1:
                view = inflater.inflate(R.layout.list_item_of_my_cart_header, null);
                break;
            case 2:
                view = inflater.inflate(R.layout.list_item_of_my_cart_footer, null);
                Button btnCheckOut = view.findViewById(R.id.btnCheckOut_MyCartFrg);
                btnCheckOut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CheckOutFragment checkOutFragment = myFragment.getMyActivity().checkOutFragment;
                        myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, checkOutFragment).commit();
                    }
                });
                break;
        }

        return view;
    }
}
