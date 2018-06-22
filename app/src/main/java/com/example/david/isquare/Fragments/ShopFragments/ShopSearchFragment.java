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
import android.widget.TextView;

import com.example.david.isquare.Adapters.SearchedShopListAdapter;
import com.example.david.isquare.Adapters.ShopListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Shop;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class ShopSearchFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;
    private TextView txtIconSearch;

    private ExpandedListView listViewSearchedShops;

    private List<Shop> searchedShopList;

    private SearchedShopListAdapter searchedShopListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_shop_search, container, false);

        setInit();
        findViews(view);
        setFormula();
        setEvents();
        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        searchedShopList = new ArrayList<>();
        searchedShopList.add(new Shop(false));
        searchedShopList.add(new Shop(true));
        searchedShopList.add(new Shop(false));
        searchedShopList.add(new Shop(true));

        searchedShopListAdapter = new SearchedShopListAdapter(myActivity, R.layout.list_item_of_shop);
        searchedShopListAdapter.setList(searchedShopList);
        searchedShopListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_ShopSearchFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_ShopSearchFrg);
        txtIconSearch = view.findViewById(R.id.txtIconSearch_ShopSearchFrg);

        listViewSearchedShops = view.findViewById(R.id.listSearchedShops_ShopSearchFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        txtIconSearch.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.shopFragment).commit();
            }
        });

        listViewSearchedShops.setAdapter(searchedShopListAdapter);
    }
}
