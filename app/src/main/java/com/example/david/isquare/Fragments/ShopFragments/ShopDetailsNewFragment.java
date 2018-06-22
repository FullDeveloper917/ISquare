package com.example.david.isquare.Fragments.ShopFragments;

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

public class ShopDetailsNewFragment extends Fragment {

    private Button btnGoCart;
    private Button btnGoStared;
    private LinearLayout layoutGoMemberItems;
    
    private LinearLayout layoutGoDetails;

    private TextView txtIconGoReviews;
    private TextView txtMark;
    private TextView txtIconNew;

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private TextView txtIconStared;
    private boolean stared;
    private TextView txtIconAddCart;

    private TextView txtIconAddress;
    private TextView txtIconInfo;
    private Button btnGoComments;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop_details_new, container, false);

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

        txtIconRtn = view.findViewById(R.id.txtIconRtn_ShopDetailsNewFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_ShopDetailsNewFrg);

        btnGoCart = view.findViewById(R.id.btnGoCart_ShopDetailsNewFrg);
        btnGoStared = view.findViewById(R.id.btnGoStared_ShopDetailsNewFrg);
        layoutGoMemberItems = view.findViewById(R.id.layoutGoMemberItems_ShopDetailsNewFrg);

        txtIconAddress = view.findViewById(R.id.txtIconAddress_ShopDetailsNewFrg);
        txtIconStared = view.findViewById(R.id.txtIconStared_ShopDetailsNewFrg);
        txtIconAddCart = view.findViewById(R.id.txtIconAddCart_ShopDetailsNewFrg);
        txtIconInfo = view.findViewById(R.id.txtIconInfo_ShopDetailsNewFrg);
        btnGoComments = view.findViewById(R.id.btnGoComments_ShopDetailsNewFrg);

        layoutGoDetails = view.findViewById(R.id.layoutGoDetails_ShopDetailsNewFrg);

        txtMark = view.findViewById(R.id.txtMark_ShopDetailsNewFrg);
        txtIconGoReviews = view.findViewById(R.id.txtIconGoReview_ShopDetailsNewFrg);
        txtIconNew = view.findViewById(R.id.txtIconNew_ShopDetailsNewFrg);

    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        btnGoCart.setTypeface(iconFont);
        btnGoStared.setTypeface(iconFont);
        txtIconAddress.setTypeface(iconFont);
        txtIconStared.setTypeface(iconFont);
        txtIconAddCart.setTypeface(iconFont);
        txtIconInfo.setTypeface(iconFont);
        btnGoComments.setTypeface(iconFont);

        txtMark.setTypeface(iconFont);
        txtIconGoReviews.setTypeface(iconFont);
        txtIconNew.setTypeface(iconFont);
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

        btnGoComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.singleChatFragment).commit();
            }
        });

        layoutGoMemberItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.shopMemberItemsFragment).commit();
            }
        });

        layoutGoDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.shopDetailsReviewFragment).commit();
            }
        });

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.shopFragment).commit();
            }
        });

        txtIconStared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stared) {
                    txtIconStared.setText(myActivity.getResources().getString(R.string.fa_star_o));
                    txtIconStared.setTextColor(myActivity.getResources().getColor(R.color.colorMyGray_10));
                }
                else{
                    txtIconStared.setText(myActivity.getResources().getString(R.string.fa_star));
                    txtIconStared.setTextColor(myActivity.getResources().getColor(R.color.colorMyRed));
                }
                stared = !stared;
            }
        });

        txtIconAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtIconAddCart.setTextColor(myActivity.getResources().getColor(R.color.colorMyRed));
            }
        });
    }

}
