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
import com.example.david.isquare.Fragments.ShopFragments.ShopDetailsTwoHandFragment;
import com.example.david.isquare.Fragments.ShopFragments.ShopMemberItemsFragment;
import com.example.david.isquare.Objects.Shop;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/11/2017.
 */

public class ShopMemberItemsListAdapter extends ArrayAdapter {

    private final Context context;
    private List<Shop> lists = new ArrayList<>();

    private TextView txtMark;
    private TextView txtComments;
    private LinearLayout layoutOneShop;
    private ImageView imgShop;

    private ShopMemberItemsFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(ShopMemberItemsFragment myFragment) {
        this.myFragment = myFragment;
    }

    public ShopMemberItemsListAdapter(@NonNull Context context, @LayoutRes int resource) {
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
        txtComments = rowView.findViewById(R.id.txtComments_OneShop);
        txtMark.setTypeface(iconFont);
        layoutOneShop = rowView.findViewById(R.id.layoutOneShop_OneShop);
        if (lists.get(position).isSecond_handed()){
            txtMark.setText(context.getResources().getString(R.string.fa_handshake_o));
            txtMark.setTextColor(context.getResources().getColor(R.color.colorMyDarkBlue));
            txtComments.setVisibility(View.GONE);

            layoutOneShop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ShopDetailsTwoHandFragment shopDetailsTwoHandFragment = myFragment.getMyActivity().shopDetailsTwoHandFragment;
                    myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, shopDetailsTwoHandFragment).commit();
                }
            });
        }
        else {
            layoutOneShop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ShopDetailsNewFragment shopDetailsNewFragment = myFragment.getMyActivity().shopDetailsNewFragment;
                    myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, shopDetailsNewFragment).commit();
                }
            });
        }




        imgShop = rowView.findViewById(R.id.imgShop_OneShop);
        switch (position){
            case 0:
                imgShop.setImageDrawable(context.getResources().getDrawable(R.drawable.raw_1505556544));
                break;
            case 1:
                imgShop.setImageDrawable(context.getResources().getDrawable(R.drawable.raw_1505561088));
                break;
            case 3:
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