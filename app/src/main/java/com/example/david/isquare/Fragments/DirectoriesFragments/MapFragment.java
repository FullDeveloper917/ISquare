package com.example.david.isquare.Fragments.DirectoriesFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;
import com.google.android.gms.maps.SupportMapFragment;

public class MapFragment extends Fragment {
    private LinearLayout layoutRtn;
    private Typeface iconFont;
    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);

        layoutRtn = view.findViewById(R.id.layoutRtn_MapFrg);
        FontManager.setFontType(layoutRtn, iconFont);
        SupportMapFragment mapFragment = (SupportMapFragment) myActivity.getSupportFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync();

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.placeDetailsFragment).commit();
            }
        });

        return view;
    }

}
