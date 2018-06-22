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
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.PlaceMomentsListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Moment;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class PlaceLeaveReviewFragment extends Fragment {

    private LinearLayout layoutRtn;
    private Button btnPost;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_place_leave_review, container, false);

        setInit();

        findViews(view);

        setFormula(view);

        setEvents();

        return view;
    }

    private void setInit(){
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
    }

    private void findViews(View view){
        layoutRtn = view.findViewById(R.id.layoutRtn_PlaceLeaveReviewFrg);
        btnPost = view.findViewById(R.id.btnPost_PlaceLeaveReviewFrg);

    }

    private void setFormula(View view){
        FontManager.setFontType(view.findViewById(R.id.layoutMain_PlaceLeaveReviewFrg), iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.placeDetailsFragment).commit();
            }
        });


        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.placeReviewsFragment).commit();
            }
        });
    }
}
