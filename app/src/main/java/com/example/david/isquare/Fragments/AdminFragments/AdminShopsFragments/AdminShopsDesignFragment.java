package com.example.david.isquare.Fragments.AdminFragments.AdminShopsFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Adapters.AdminShopsDesignListAdapter;
import com.example.david.isquare.Adapters.ShopListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Shop;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class AdminShopsDesignFragment  extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private TextView txtIconFirstLink;
    private TextView txtIconSecondLink;
    private ImageView imgFirst;
    private ImageView imgSecond;
    private LinearLayout layoutFirstLink;
    private LinearLayout layoutSecondLink;

    private ExpandedListView listViewLatestAdded;
    private ExpandedListView listViewBestSellers;

    private List<Shop> latestAddedList;
    private List<Shop> bestSellersList;

    private AdminShopsDesignListAdapter latestAddedListAdapter;
    private AdminShopsDesignListAdapter bestSellersListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_admin_shops_design, container, false);

        setInit();
        findViews(view);
        setFormula();
        setEvents();
        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        latestAddedList = new ArrayList<>();
        latestAddedList.add(new Shop());
        latestAddedList.add(new Shop());
        latestAddedList.add(new Shop());
        latestAddedList.add(new Shop());
        latestAddedList.add(new Shop());

        bestSellersList = new ArrayList<>();
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());

        latestAddedListAdapter = new AdminShopsDesignListAdapter(myActivity, R.layout.list_item_of_shop);
        latestAddedListAdapter.setList(latestAddedList);
        latestAddedListAdapter.setMyFragment(this);
        bestSellersListAdapter = new AdminShopsDesignListAdapter(myActivity, R.layout.list_item_of_shop);
        bestSellersListAdapter.setList(bestSellersList);
        bestSellersListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_AdminShopsDesignFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_AdminShopsDesignFrg);

        txtIconFirstLink = view.findViewById(R.id.txtIconFirstLink_AdminShopsDesignFrg);
        txtIconSecondLink = view.findViewById(R.id.txtIconSecondLink_AdminShopsDesignFrg);
        layoutFirstLink = view.findViewById(R.id.layoutFirstLink_AdminShopsDesignFrg);
        layoutSecondLink = view.findViewById(R.id.layoutSecondLink_AdminShopsDesignFrg);
        imgFirst = view.findViewById(R.id.imgFirst_AdminShopsDesignFrg);
        imgSecond = view.findViewById(R.id.imgSecond_AdminShopsDesignFrg);

        listViewLatestAdded = view.findViewById(R.id.listLatestAdded_AdminShopsDesignFrg);
        listViewBestSellers = view.findViewById(R.id.listBestSellers_AdminShopsDesignFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        txtIconFirstLink.setTypeface(iconFont);
        txtIconSecondLink.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminFragment).commit();
            }
        });

        imgFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminShopsDesignChoosePhotoFragment).commit();
            }
        });

        imgSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminShopsDesignChoosePhotoFragment).commit();
            }
        });

        layoutFirstLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminShopsDesignChooseProductFragment).commit();
            }
        });

        layoutSecondLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminShopsDesignChooseProductFragment).commit();
            }
        });

        listViewLatestAdded.setAdapter(latestAddedListAdapter);
        listViewBestSellers.setAdapter(bestSellersListAdapter);
    }

}