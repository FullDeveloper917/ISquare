package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Fragments.AdminFragments.AdminShopsFragments.AdminShopsDesignChooseProductFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminShopsFragments.AdminShopsDesignFragment;
import com.example.david.isquare.Objects.Shop;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 9/26/2017.
 */

public class AdminShopsDesignListAdapter extends ArrayAdapter{

    private final Context context;
    private List<Shop> lists = new ArrayList<>();

    private TextView txtMark;
    private LinearLayout layoutOneShop;

    private AdminShopsDesignFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(AdminShopsDesignFragment myFragment) {
        this.myFragment = myFragment;
    }

    public AdminShopsDesignListAdapter(@NonNull Context context, @LayoutRes int resource) {
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
                AdminShopsDesignChooseProductFragment adminShopsDesignChooseProductFragment = myFragment.getMyActivity().adminShopsDesignChooseProductFragment;
                myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, adminShopsDesignChooseProductFragment).commit();
            }
        });

        return rowView;
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
