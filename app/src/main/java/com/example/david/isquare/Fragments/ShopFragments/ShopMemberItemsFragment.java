package com.example.david.isquare.Fragments.ShopFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.ShopListAdapter;
import com.example.david.isquare.Adapters.ShopMemberItemsListAdapter;
import com.example.david.isquare.Adapters.StaredShopListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Shop;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class ShopMemberItemsFragment  extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private Button btnGoComments;

    private ExpandedListView listViewShops;

    private List<Shop> shopList;

    private ShopMemberItemsListAdapter shopMemberItemsListAdapter;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    public MainActivity getMyActivity() {
        return myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop_member_items, container, false);

        setInit();
        findViews(view);
        setFormula();
        setEvents();
        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        shopList = new ArrayList<>();
        shopList.add(new Shop(false));
        shopList.add(new Shop(true));
        shopList.add(new Shop(false));
        shopList.add(new Shop(true));

        shopMemberItemsListAdapter = new ShopMemberItemsListAdapter(myActivity, R.layout.list_item_of_shop);
        shopMemberItemsListAdapter.setList(shopList);
        shopMemberItemsListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_ShopMemberItemsFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_ShopMemberItemsFrg);
        btnGoComments = view.findViewById(R.id.btnGoComments_ShopMemberItemsFrg);
        listViewShops = view.findViewById(R.id.listShops_ShopMemberItemsFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        btnGoComments.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.shopDetailsNewFragment).commit();
            }
        });

        listViewShops.setAdapter(shopMemberItemsListAdapter);
    }
}
