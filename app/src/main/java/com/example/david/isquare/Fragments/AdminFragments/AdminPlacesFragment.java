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

import com.example.david.isquare.Adapters.AdminPlaceListAdapter;
import com.example.david.isquare.Adapters.AdminProductListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.AdminPlace;
import com.example.david.isquare.Objects.AdminPlaceHeader;
import com.example.david.isquare.Objects.AdminPlaceInterface;
import com.example.david.isquare.Objects.AdminProduct;
import com.example.david.isquare.Objects.AdminProductHeader;
import com.example.david.isquare.Objects.AdminProductInterface;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class AdminPlacesFragment  extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewPlaces;
    private AdminPlaceListAdapter adminPlaceListAdapter;
    private List<AdminPlaceInterface> placeList;

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

        View view = inflater.inflate(R.layout.fragment_admin_places, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        placeList = new ArrayList<>();
        placeList.add(new AdminPlaceHeader("Today (2)"));
        placeList.add(new AdminPlace(false));
        placeList.add(new AdminPlace(false));
        placeList.add(new AdminPlaceHeader("Yesterday (2)"));
        placeList.add(new AdminPlace(false));
        placeList.add(new AdminPlace(true));
        placeList.add(new AdminPlaceHeader("Last week (2)"));
        placeList.add(new AdminPlace(false));
        placeList.add(new AdminPlace(true));
        adminPlaceListAdapter = new AdminPlaceListAdapter(myActivity, placeList);
        adminPlaceListAdapter.setMyFragment(this);
    }

    private void findViews(View view){
        txtIconRtn = view.findViewById(R.id.txtIconRtn_AdminPlacesFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_AdminPlacesFrg);
        listViewPlaces = view.findViewById(R.id.listPlaces_AdminPlacesFrg);
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

        listViewPlaces.setAdapter(adminPlaceListAdapter);
    }
}
