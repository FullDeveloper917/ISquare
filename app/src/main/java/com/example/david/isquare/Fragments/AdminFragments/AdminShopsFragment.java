package com.example.david.isquare.Fragments.AdminFragments;

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

import com.example.david.isquare.Adapters.AdminAllMemberListAdapter;
import com.example.david.isquare.Adapters.AdminShopListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.ContactHeader;
import com.example.david.isquare.Objects.ContactItem;
import com.example.david.isquare.Objects.Follower;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class AdminShopsFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewShops;
    private AdminShopListAdapter adminShopListAdapter;
    private List<ContactItem> shopList;

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

        View view = inflater.inflate(R.layout.fragment_admin_shops, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        shopList = new ArrayList<>();
        shopList.add(new ContactHeader("Today (2)"));
        shopList.add(new Follower("Anna Klein"));
        shopList.add(new Follower("Anna Brown"));
        shopList.add(new ContactHeader("Yesterday (2)"));
        shopList.add(new Follower("Anna Klein"));
        shopList.add(new Follower("Anna Brown"));
        shopList.add(new ContactHeader("Last week (4)"));
        shopList.add(new Follower("Anna Klein"));
        shopList.add(new Follower("Anna Brown"));
        shopList.add(new ContactHeader("Latest"));
        shopList.add(new Follower("Anna Klein"));
        shopList.add(new Follower("Anna Brown"));
        adminShopListAdapter = new AdminShopListAdapter(myActivity, shopList);
        adminShopListAdapter.setMyFragment(this);
    }

    private void findViews(View view){
        txtIconRtn = view.findViewById(R.id.txtIconRtn_AdminShopsFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_AdminShopsFrg);
        listViewShops = view.findViewById(R.id.listShops_AdminShopsFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminFragment).commit();
            }
        });

        listViewShops.setAdapter(adminShopListAdapter);

    }
}
