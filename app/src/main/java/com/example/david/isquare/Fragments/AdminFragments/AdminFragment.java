package com.example.david.isquare.Fragments.AdminFragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

public class AdminFragment extends Fragment {

    private LinearLayout layoutGoUsers;
    private TextView txtIconUsers;
    private TextView txtIconAdmin;
    private TextView txtIconTotal;
    private TextView txtIconCommission;
    private TextView txtIconBalance;
    private TextView txtIconThisMonth;
    private TextView txtIconWithdrawal;
    private TextView txtIconMemberNumber;
    private TextView txtIconMomentsNumber;
    private TextView txtIconAllMembers;
    private TextView txtIconBanedMembers;
    private TextView txtIconMoments;
    private TextView txtIconShopsNumber;
    private TextView txtIconProductsNumber;
    private TextView txtIconShops;
    private TextView txtIconProducts;
    private TextView txtIconShopsPageDesign;
    private TextView txtIconPlacesNumber;
    private TextView txtIconCitiesNumber;
    private TextView txtIconPlaces;
    private TextView txtIconDirectoriesPageDesign;

    private LinearLayout layoutWithdrawal;
    private LinearLayout layoutAllMembers;
    private LinearLayout layoutBanedMembers;
    private LinearLayout layoutMoments;
    private LinearLayout layoutShops;
    private LinearLayout layoutProducts;
    private LinearLayout layoutShopsPageDesign;
    private LinearLayout layoutPlaces;
    private LinearLayout layoutDirectoriesPageDesign;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
    }

    private void findViews(View view){

        txtIconUsers = view.findViewById(R.id.txtIconUsers_AdminFrg);
        txtIconAdmin = view.findViewById(R.id.txtIconAdmin_AdminFrg);
        txtIconTotal = view.findViewById(R.id.txtIconTotal_AdminFrg);
        txtIconCommission = view.findViewById(R.id.txtIconCommission_AdminFrg);
        txtIconBalance = view.findViewById(R.id.txtIconBalance_AdminFrg);
        txtIconThisMonth = view.findViewById(R.id.txtIconThisMonth_AdminFrg);
        txtIconWithdrawal = view.findViewById(R.id.txtIconWithdrawal_AdminFrg);
        txtIconMemberNumber = view.findViewById(R.id.txtIconMembersNumber_AdminFrg);
        txtIconMomentsNumber = view.findViewById(R.id.txtIconMomentsNumber_AdminFrg);
        txtIconAllMembers = view.findViewById(R.id.txtIconAllMembers_AdminFrg);
        txtIconBanedMembers = view.findViewById(R.id.txtIconBanedMembers_AdminFrg);
        txtIconMoments = view.findViewById(R.id.txtIconMoments_AdminFrg);
        txtIconShopsNumber = view.findViewById(R.id.txtIconShopsNumber_AdminFrg);
        txtIconProductsNumber = view.findViewById(R.id.txtIconProductsNumber_AdminFrg);
        txtIconShops = view.findViewById(R.id.txtIconShops_AdminFrg);
        txtIconProducts = view.findViewById(R.id.txtIconProducts_AdminFrg);
        txtIconShopsPageDesign = view.findViewById(R.id.txtIconShopPageDesign_AdminFrg);
        txtIconPlacesNumber = view.findViewById(R.id.txtIconPlacesNumber_AdminFrg);
        txtIconCitiesNumber = view.findViewById(R.id.txtIconCitiesNumber_AdminFrg);
        txtIconPlaces = view.findViewById(R.id.txtIconPlaces_AdminFrg);
        txtIconDirectoriesPageDesign = view.findViewById(R.id.txtIconDirectoriesPageDesign_AdminFrg);

        layoutGoUsers = view.findViewById(R.id.layoutGoUsers_AdminFrg);
        layoutWithdrawal = view.findViewById(R.id.layoutWithdrawal_AdminFrg);
        layoutAllMembers = view.findViewById(R.id.layoutAllMembers_AdminFrg);
        layoutBanedMembers = view.findViewById(R.id.layoutBanedMembers_AdminFrg);
        layoutMoments = view.findViewById(R.id.layoutMoments_AdminFrg);
        layoutShops = view.findViewById(R.id.layoutShops_AdminFrg);
        layoutProducts = view.findViewById(R.id.layoutProducts_AdminFrg);
        layoutShopsPageDesign = view.findViewById(R.id.layoutShopPageDesign_AdminFrg);
        layoutPlaces = view.findViewById(R.id.layoutPlaces_AdminFrg);
        layoutDirectoriesPageDesign = view.findViewById(R.id.layoutDirectoriesPageDesign_AdminFrg);
    }

    private void setFormula(){
        txtIconUsers.setTypeface(iconFont);
        txtIconAdmin.setTypeface(iconFont);
        txtIconTotal.setTypeface(iconFont);
        txtIconCommission.setTypeface(iconFont);
        txtIconBalance.setTypeface(iconFont);
        txtIconThisMonth.setTypeface(iconFont);
        txtIconWithdrawal.setTypeface(iconFont);
        txtIconMemberNumber.setTypeface(iconFont);
        txtIconMomentsNumber.setTypeface(iconFont);
        txtIconAllMembers.setTypeface(iconFont);
        txtIconBanedMembers.setTypeface(iconFont);
        txtIconMoments.setTypeface(iconFont);
        txtIconShopsNumber.setTypeface(iconFont);
        txtIconProductsNumber.setTypeface(iconFont);
        txtIconShops.setTypeface(iconFont);
        txtIconProducts.setTypeface(iconFont);
        txtIconShopsPageDesign.setTypeface(iconFont);
        txtIconPlacesNumber.setTypeface(iconFont);
        txtIconCitiesNumber.setTypeface(iconFont);
        txtIconPlaces.setTypeface(iconFont);
        txtIconDirectoriesPageDesign.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutGoUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.usersFragment).commit();
            }
        });

        layoutAllMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminAllMembersFragment).commit();
            }
        });

        layoutBanedMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminBanedMembersFragment).commit();
            }
        });

        layoutShops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminShopsFragment).commit();
            }
        });

        layoutProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminProductsFragment).commit();
            }
        });

        layoutPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminPlacesFragment).commit();
            }
        });

        layoutMoments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminMomentsFragment).commit();
            }
        });

        layoutDirectoriesPageDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminDirectoriesFragment).commit();
            }
        });

        layoutWithdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminWithdrawalFragment).commit();
            }
        });

        layoutShopsPageDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminShopsDesignFragment).commit();
            }
        });
    }
}