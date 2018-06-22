package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Fragments.ShopFragments.ShopDetailsNewFragment;
import com.example.david.isquare.Fragments.ShopFragments.ShopFragment;
import com.example.david.isquare.Objects.Shop;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 9/26/2017.
 */

public class ShopListAdapter extends ArrayAdapter{

    private final Context context;
    private List<Shop> lists = new ArrayList<>();

    private TextView txtMark;
    private LinearLayout layoutOneShop;

    private ShopFragment myFragment;
    private ImageView imgShop;

    private Typeface iconFont;

    public void setMyFragment(ShopFragment myFragment) {
        this.myFragment = myFragment;
    }

    public ShopListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<Shop> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_shop, parent, false);

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);

        txtMark = rowView.findViewById(R.id.txtMark_OneShop);
        txtMark.setTypeface(iconFont);
        layoutOneShop = rowView.findViewById(R.id.layoutOneShop_OneShop);
        layoutOneShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopDetailsNewFragment shopDetailFragment = myFragment.getMyActivity().shopDetailsNewFragment;
                myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, shopDetailFragment).commit();
            }
        });

        imgShop = rowView.findViewById(R.id.imgShop_OneShop);

        switch (position){
            case 0:
                imgShop.setImageDrawable(context.getResources().getDrawable(R.drawable.raw_1505556544));
                break;
            case 1:
                imgShop.setImageDrawable(context.getResources().getDrawable(R.drawable.raw_1505561088));
                break;
            default:
                break;
        }

        return rowView;
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
