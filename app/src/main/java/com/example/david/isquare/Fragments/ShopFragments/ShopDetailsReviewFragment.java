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

import com.example.david.isquare.Adapters.ShopDetailsReviewListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Review;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class ShopDetailsReviewFragment extends Fragment {

    private Button btnGoCart;
    private Button btnGoStared;
    private LinearLayout layoutReviewDetails;

    private TextView txtIconDetailInfo;
    private TextView txtIconGoDetails;

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private TextView txtIconStared;
    private TextView txtIconAddCart;
    private TextView txtIconAddress;

    private ExpandedListView listViewReviews;
    private List<Review> reviewList;
    private ShopDetailsReviewListAdapter shopDetailsReviewListAdapter;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop_details_review, container, false);

        setInit();
        findViews(view);
        setFormula();
        setEvents();
        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        reviewList = new ArrayList<>();
        reviewList.add(new Review());
        reviewList.add(new Review());
        reviewList.add(new Review());
        reviewList.add(new Review());
        reviewList.add(new Review());
        reviewList.add(new Review());
        shopDetailsReviewListAdapter = new ShopDetailsReviewListAdapter(myActivity, R.layout.list_item_of_reviews);
        shopDetailsReviewListAdapter.setMyFragment(this);
        shopDetailsReviewListAdapter.setList(reviewList);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_ShopDetailsReviewFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_ShopDetailsReviewFrg);

        btnGoCart = view.findViewById(R.id.btnGoCart_ShopDetailsReviewFrg);
        btnGoStared = view.findViewById(R.id.btnGoStared_ShopDetailsReviewFrg);

        txtIconAddress = view.findViewById(R.id.txtIconAddress_ShopDetailsReviewFrg);
        txtIconStared = view.findViewById(R.id.txtIconStared_ShopDetailsReviewFrg);
        txtIconAddCart = view.findViewById(R.id.txtIconAddCart_ShopDetailsReviewFrg);

        layoutReviewDetails = view.findViewById(R.id.layoutReviewDetails_ShopDetailsReviewFrg);

        txtIconGoDetails = view.findViewById(R.id.txtIconGoDetails_ShopDetailsReviewFrg);
        txtIconDetailInfo = view.findViewById(R.id.txtIconDetailInfo_ShopDetailsReviewFrg);
        listViewReviews = view.findViewById(R.id.listReviews_ShopDetailsReviewFrg);

    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        btnGoCart.setTypeface(iconFont);
        btnGoStared.setTypeface(iconFont);
        txtIconAddress.setTypeface(iconFont);
        txtIconStared.setTypeface(iconFont);
        txtIconAddCart.setTypeface(iconFont);
        txtIconGoDetails.setTypeface(iconFont);
        txtIconDetailInfo.setTypeface(iconFont);
    }

    private void setEvents(){

        btnGoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myCartFragment).commit();
            }
        });

        btnGoStared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.staredShopFragment).commit();
            }
        });

        layoutReviewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.shopDetailsNewFragment).commit();
            }
        });

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.shopFragment).commit();
            }
        });

        listViewReviews.setAdapter(shopDetailsReviewListAdapter);
    }

}