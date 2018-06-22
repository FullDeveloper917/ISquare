package com.example.david.isquare.Fragments.ShopFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.SearchedShopListAdapter;
import com.example.david.isquare.Adapters.StaredShopListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Shop;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class StaredShopFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewStaredShops;

    private List<Shop> staredShopList;

    private StaredShopListAdapter staredShopListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_stared_shop, container, false);

        setInit();
        findViews(view);
        setFormula();
        setEvents();
        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        staredShopList = new ArrayList<>();
        staredShopList.add(new Shop());
        staredShopList.add(new Shop());
        staredShopList.add(new Shop());
        staredShopList.add(new Shop());

        staredShopListAdapter = new StaredShopListAdapter(myActivity, R.layout.list_item_of_shop);
        staredShopListAdapter.setList(staredShopList);
        staredShopListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_StaredShopFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_StaredShopFrg);

        listViewStaredShops = view.findViewById(R.id.listStaredShops_StaredShopFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.shopFragment).commit();
            }
        });

        listViewStaredShops.setAdapter(staredShopListAdapter);
    }
}
