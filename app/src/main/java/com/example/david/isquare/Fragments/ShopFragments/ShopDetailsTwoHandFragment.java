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

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

public class ShopDetailsTwoHandFragment extends Fragment {

    private Button btnGoCart;
    private Button btnGoStared;
    private LinearLayout layoutGoMemberItems;

    private TextView txtIconSecondHand;

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
        View view = inflater.inflate(R.layout.fragment_shop_details_two_hand, container, false);

        setInit();
        findViews(view);
        setFormula(view);
        setEvents();
        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_ShopDetailsTwoHandFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_ShopDetailsTwoHandFrg);

        btnGoCart = view.findViewById(R.id.btnGoCart_ShopDetailsTwoHandFrg);
        btnGoStared = view.findViewById(R.id.btnGoStared_ShopDetailsTwoHandFrg);
        layoutGoMemberItems = view.findViewById(R.id.layoutGoMemberItems_ShopDetailsTwoHandFrg);

        txtIconAddress = view.findViewById(R.id.txtIconAddress_ShopDetailsTwoHandFrg);
        txtIconStared = view.findViewById(R.id.txtIconStared_ShopDetailsTwoHandFrg);
        txtIconAddCart = view.findViewById(R.id.txtIconAddCart_ShopDetailsTwoHandFrg);
        txtIconInfo = view.findViewById(R.id.txtIconInfo_ShopDetailsTwoHandFrg);
        btnGoComments = view.findViewById(R.id.btnGoComments_ShopDetailsTwoHandFrg);
        txtIconSecondHand = view.findViewById(R.id.txtIconSecondHand_ShopDetailsTwoHandFrg);

    }

    private void setFormula(View view){
        FontManager.setFontType(view.findViewById(R.id.layoutMain_ShopDetailsTwoHandFrg), iconFont);
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
