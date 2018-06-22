package com.example.david.isquare.Fragments.AdminFragments.AdminShopsFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Adapters.AdminChoosePlaceListAdapter;
import com.example.david.isquare.Adapters.AdminChooseProductListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.AdminPlace;
import com.example.david.isquare.Objects.AdminProduct;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class AdminShopsDesignChooseProductFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;
    private TextView txtIconSearch;

    private ExpandedListView listViewProducts;
    private AdminChooseProductListAdapter adminChooseProductListAdapter;
    private List<AdminProduct> productList;

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

        View view = inflater.inflate(R.layout.fragment_admin_shops_design_choose_product, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        productList = new ArrayList<>();
        productList.add(new AdminProduct(""));
        productList.add(new AdminProduct(""));
        productList.add(new AdminProduct(""));
        adminChooseProductListAdapter = new AdminChooseProductListAdapter(myActivity, R.layout.list_item_of_admin_products);
        adminChooseProductListAdapter.setMyFragment(this);
        adminChooseProductListAdapter.setList(productList);
    }

    private void findViews(View view){
        txtIconRtn = view.findViewById(R.id.txtIconRtn_AdminShopsDesignChooseProductFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_AdminShopsDesignChooseProductFrg);
        txtIconSearch = view.findViewById(R.id.txtIconSearch_AdminShopsDesignChooseProductFrg);
        listViewProducts = view.findViewById(R.id.listPlaces_AdminShopsDesignChooseProductFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        txtIconSearch.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminShopsDesignFragment).commit();
            }
        });

        listViewProducts.setAdapter(adminChooseProductListAdapter);
    }
}

