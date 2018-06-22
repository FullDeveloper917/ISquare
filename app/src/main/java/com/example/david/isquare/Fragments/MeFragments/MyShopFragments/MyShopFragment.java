package com.example.david.isquare.Fragments.MeFragments.MyShopFragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

public class MyShopFragment extends Fragment {

    private Button btnGoEdit;
    private LinearLayout layoutRtn;
    private TextView txtIconRtn;
    private TextView txtIconAll;
    private TextView txtIconThisMonth;
    private TextView txtIconProducts;
    private TextView txtIconOrders;
    private TextView txtIconReviews;

    private LinearLayout layoutProducts;
    private LinearLayout layoutOrders;
    private LinearLayout layoutReviews;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_shop, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
    }

    private void findViews(View view){

        btnGoEdit = view.findViewById(R.id.btnGoEdit_MyShopFrg);
        txtIconRtn = view.findViewById(R.id.txtIconRtn_MyShopFrg);
        txtIconAll = view.findViewById(R.id.txtIconAll_MyShopFrg);
        txtIconThisMonth = view.findViewById(R.id.txtIconThisMonth_MyShopFrg);
        txtIconProducts = view.findViewById(R.id.txtIconProducts_MyShopFrg);
        txtIconOrders = view.findViewById(R.id.txtIconOrders_MyShopFrg);
        txtIconReviews = view.findViewById(R.id.txtIconReviews_MyShopFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_MyShopFrg);
        layoutProducts = view.findViewById(R.id.layoutProducts_MyShopFrg);
        layoutOrders = view.findViewById(R.id.layoutOrders_MyShopFrg);
        layoutReviews = view.findViewById(R.id.layoutReviews_MyShopFrg);
    }

    private void setFormula(){
        btnGoEdit.setTypeface(iconFont);
        txtIconRtn.setTypeface(iconFont);
        txtIconAll.setTypeface(iconFont);
        txtIconThisMonth.setTypeface(iconFont);
        txtIconProducts.setTypeface(iconFont);
        txtIconOrders.setTypeface(iconFont);
        txtIconReviews.setTypeface(iconFont);
    }

    private void setEvents(){
        btnGoEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.editShopFragment).commit();
            }
        });

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.usersFragment).commit();
            }
        });

        layoutProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.productsFragment).commit();
            }
        });

        layoutOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.ordersFragment).commit();
            }
        });

        layoutReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.reviewsFragment).commit();
            }
        });
    }
}
