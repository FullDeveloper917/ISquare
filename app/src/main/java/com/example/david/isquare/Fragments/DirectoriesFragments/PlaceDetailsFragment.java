package com.example.david.isquare.Fragments.DirectoriesFragments;

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

public class PlaceDetailsFragment extends Fragment {


    private LinearLayout layoutRtn;
    private boolean stared;
    private Button btnStared;
    private Button btnGoComments;
    private Button btnGoMap;
    
    private LinearLayout layoutGoReviews;
    private LinearLayout layoutGoMoments;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_place_details, container, false);

        setInit();
        findViews(view);
        setFormula(view);
        setEvents();
        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        stared = false;
    }

    private void findViews(View view){

        layoutRtn = view.findViewById(R.id.layoutRtn_PlaceDetailsFrg);
        btnStared = view.findViewById(R.id.btnStared_PlaceDetailsFrg);
        btnGoComments = view.findViewById(R.id.btnGoComments_PlaceDetailsFrg);
        btnGoMap = view.findViewById(R.id.btnGoMap_PlaceDetailsFrg);
        layoutGoMoments = view.findViewById(R.id.layoutGoMoments_PlaceDetailsFrg);
        layoutGoReviews = view.findViewById(R.id.layoutGoReviews_PlaceDetailsFrg);

    }

    private void setFormula(View view){
        FontManager.setFontType(view.findViewById(R.id.layoutMain_PlaceDetailsFrag), iconFont);
    }

    private void setEvents(){

        btnGoComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        layoutGoMoments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.placeMomentsFragment).commit();
            }
        });

        layoutGoReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.placeReviewsFragment).commit();
            }
        });

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.directoriesFragment).commit();
            }
        });

        btnGoMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.mapFragment).commit();
            }
        });

        btnStared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stared){
                    btnStared.setText(myActivity.getResources().getString(R.string.fa_star_o));
                    btnStared.setTextColor(myActivity.getResources().getColor(R.color.colorMyGray_9));
                }
                else {
                    btnStared.setText(myActivity.getResources().getString(R.string.fa_star));
                    btnStared.setTextColor(myActivity.getResources().getColor(R.color.colorMyRed));
                }
                stared = !stared;
            }
        });

    }

}
