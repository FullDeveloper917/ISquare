package com.example.david.isquare.Fragments.MeFragments;

import android.content.Intent;
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

public class UsersFragment extends Fragment {

    private Button btnSetting;

    private TextView txtIconMe;
    private TextView txtIconAdmin;
    private TextView txtIconBalance;
    private TextView txtIconCommission;
    private TextView txtIconMyMoments;
    private TextView txtIconNotifications;
    private TextView txtIconMyContacts;
    private TextView txtIconMyCart;
    private TextView txtIconOrders;
    private TextView txtIconAddress;
    private TextView txtIconStared;
    private TextView txtIconMyWallet;
    private TextView txtIconMyShop;
    private TextView txtIconMyPlaces;

    private LinearLayout layoutMomentsNumber;
    private LinearLayout layoutFollowersNumber;
    private LinearLayout layoutFollowingNumber;
    private LinearLayout layoutBalance;
    private LinearLayout layoutCommission;

    private LinearLayout layoutGoAdmin;
    private LinearLayout layoutMyMoments;
    private LinearLayout layoutNotifications;
    private LinearLayout layoutMyContacts;
    private LinearLayout layoutMyCart;
    private LinearLayout layoutOrders;
    private LinearLayout layoutAddress;
    private LinearLayout layoutStared;
    private LinearLayout layoutMyWallet;
    private LinearLayout layoutMyShop;
    private LinearLayout layoutMyPlaces;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users, container, false);

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

        btnSetting = view.findViewById(R.id.btnSettings_UserFrg);

        txtIconMe = view.findViewById(R.id.txtIconMe_UserFrg);
        txtIconAdmin = view.findViewById(R.id.txtIconAdmin_UserFrg);
        txtIconBalance = view.findViewById(R.id.txtIconBalance_UsersFrg);
        txtIconCommission = view.findViewById(R.id.txtIconCommission_UsersFrg);
        txtIconMyMoments = view.findViewById(R.id.txtIconMyMoments_UsersFrg);
        txtIconNotifications = view.findViewById(R.id.txtIconNotifications_UsersFrg);
        txtIconMyContacts = view.findViewById(R.id.txtIconMyContacts_UsersFrg);
        txtIconMyCart = view.findViewById(R.id.txtIconMyCart_UsersFrg);
        txtIconOrders = view.findViewById(R.id.txtIconOrders_UsersFrg);
        txtIconAddress = view.findViewById(R.id.txtIconAddress_UsersFrg);
        txtIconStared = view.findViewById(R.id.txtIconStared_UsersFrg);
        txtIconMyWallet = view.findViewById(R.id.txtIconMyWallet_UsersFrg);
        txtIconMyShop = view.findViewById(R.id.txtIconMyShop_UsersFrg);
        txtIconMyPlaces = view.findViewById(R.id.txtIconMyPlaces_UsersFrg);

        layoutMomentsNumber = view.findViewById(R.id.layoutMomentsNumber_UsersFrg);
        layoutFollowersNumber = view.findViewById(R.id.layoutFollowersNumber_UsersFrg);
        layoutFollowingNumber = view.findViewById(R.id.layoutFollowingNumber_UsersFrg);
        layoutBalance = view.findViewById(R.id.layoutBalance_UsersFrg);
        layoutCommission = view.findViewById(R.id.layoutCommission_UsersFrg);
        layoutGoAdmin = view.findViewById(R.id.layoutGoAdmin_UsersFrg);
        layoutMyMoments = view.findViewById(R.id.layoutMyMoments_UsersFrg);
        layoutNotifications = view.findViewById(R.id.layoutNotifications_UsersFrg);
        layoutMyContacts = view.findViewById(R.id.layoutMyContacts_UsersFrg);
        layoutMyCart = view.findViewById(R.id.layoutMyCart_UsersFrg);
        layoutOrders = view.findViewById(R.id.layoutOrders_UsersFrg);
        layoutAddress = view.findViewById(R.id.layoutAddress_UsersFrg);
        layoutStared = view.findViewById(R.id.layoutStared_UsersFrg);
        layoutMyWallet = view.findViewById(R.id.layoutMyWallet_UsersFrg);
        layoutMyShop = view.findViewById(R.id.layoutMyShop_UsersFrg);
        layoutMyPlaces = view.findViewById(R.id.layoutMyPlaces_UsersFrg);
    }

    private void setFormula(){

        btnSetting.setTypeface(iconFont);

        txtIconMe.setTypeface(iconFont);
        txtIconAdmin.setTypeface(iconFont);
        txtIconBalance.setTypeface(iconFont);
        txtIconCommission.setTypeface(iconFont);
        txtIconMyMoments.setTypeface(iconFont);
        txtIconNotifications.setTypeface(iconFont);
        txtIconMyContacts.setTypeface(iconFont);
        txtIconMyCart.setTypeface(iconFont);
        txtIconOrders.setTypeface(iconFont);
        txtIconAddress.setTypeface(iconFont);
        txtIconStared.setTypeface(iconFont);
        txtIconMyWallet.setTypeface(iconFont);
        txtIconMyShop.setTypeface(iconFont);
        txtIconMyPlaces.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutGoAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminFragment).commit();
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.settingsFragment).commit();
            }
        });

        layoutMomentsNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myMomentsFragment).commit();
            }
        });

        layoutFollowersNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.followersFragment).commit();
            }
        });

        layoutFollowingNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.contactsFragment).commit();
            }
        });

        layoutBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myWalletFragment).commit();
            }
        });

        layoutCommission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myWalletFragment).commit();
            }
        });

        layoutMyMoments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myMomentsFragment).commit();
            }
        });

        layoutNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.notificationsFragment).commit();
            }
        });

        layoutMyContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.contactsFragment).commit();
            }
        });

        layoutMyCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myCartFragment).commit();
            }
        });

        layoutOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myOrdersFragment).commit();
            }
        });

        layoutAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.addressFragment).commit();
            }
        });

        layoutStared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.staredShopFragment).commit();
            }
        });

        layoutMyWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myWalletFragment).commit();
            }
        });

        layoutMyShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.newShopFragment).commit();
            }
        });

        layoutMyPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myPlacesFragment).commit();
            }
        });

    }
}
